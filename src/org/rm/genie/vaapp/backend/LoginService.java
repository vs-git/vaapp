package org.rm.genie.vaapp.backend;

import com.vaadin.ui.Notification;
import org.rm.genie.vaapp.genie.shared.entity.um.Adult;
import org.rm.genie.vaapp.util.DataMapping;
import org.rm.genie.vaapp.util.VHttpRequest;

import java.util.*;

public class LoginService
{

  public static Adult login(Object requestData)
  {
    String url = "/genie2-web/prekserv/um/loginHTTP";

    HashMap<String, Object> data = VHttpRequest.call(VHttpRequest.POST, url, requestData);

    Adult user = new Adult();
    if (data == null || (int)data.get("code") > 0)
    {
      Notification.show("Incorrect login or password", Notification.Type.ERROR_MESSAGE);
    }
    else
    {
      try {
        //System.out.println("1111111111111111 " + o.getClass().getDeclaredFields());
        DataMapping.mapObject(user, (LinkedHashMap) data.get("data"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return user;
  }




  public static Adult loginFromSession(Adult user)
  {
    String url = "/genie2-web/prekserv/um/loginFromSessionHTTP";
    HashMap<String, Object> data = VHttpRequest.call(VHttpRequest.POST, url, null);

    System.out.println("loginFromSession datata=> ");
    System.out.println(data);

    if (data == null )
    {
      VHttpRequest.resetCookie();
      Notification.show("It's strange!!!!!!!", Notification.Type.ERROR_MESSAGE);
    }
    else
    {
      try {
        //System.out.println("1111111111111111 " + o.getClass().getDeclaredFields());
        DataMapping.mapObject(user, (LinkedHashMap) data.get("user"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return user;
  }


}

