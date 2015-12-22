package org.rm.genie.vaapp.backend;

import com.vaadin.ui.Notification;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestPrepReportRequest;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestPrepReportResponse;
import org.rm.genie.vaapp.util.DataMapping;
import org.rm.genie.vaapp.util.VHttpRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class TestPrepReportService
{

  public static void getReport(TestPrepReportRequest requestData, TestPrepReportResponse response)
  {
    String url = "/genie2-web/prekserv/report/buildTestPrepReport";

    List<TestPrepReportRequest> l = new ArrayList<>();
    l.add(requestData);

    HashMap<String, Object> data = VHttpRequest.call(VHttpRequest.POST, url, l);

    if (data == null)
    {
      VHttpRequest.resetCookie();
      Notification.show("Incorrect login or password", Notification.Type.ERROR_MESSAGE);
    }
    else
    {
      try {
        //System.out.println("1111111111111111 " + o.getClass().getDeclaredFields());
        DataMapping.mapObject(response, (LinkedHashMap) data);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
}

