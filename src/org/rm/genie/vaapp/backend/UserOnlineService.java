package org.rm.genie.vaapp.backend;

import org.rm.genie.vaapp.util.VHttpRequest;

import java.util.HashMap;

public class UserOnlineService
{

  public static HashMap<String, Object> userOnline()
  {
    String url = "/genie2-web/prekserv/systemservice/getPopulation";
    return VHttpRequest.call(VHttpRequest.GET, url, null);
  }
}

