package org.rm.genie.vaapp.model;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import org.rm.genie.vaapp.util.CipherUtil;

import java.io.Serializable;

public class LoginForm  implements Serializable
{
  private String loginName = "";
  private String password = "";

  public String getLoginName()
  {
    return loginName;
  }

  public void setLoginName(String loginName)
  {
    this.loginName = loginName;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = CipherUtil.getMD5(password);
  }

  @Override
  public String toString()
  {
    return "loginName="+loginName+"; password="+password;
  }


}
