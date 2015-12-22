package org.rm.genie.vaapp.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.SerializationConfig;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;



public class VHttpRequest
{
  public static final int GET = 1;
  public static final int POST = 2;
  private static final String HOST = "http://vstebakov.rmcity.net:8080";

  private static CookieStore httpCookieStore = new BasicCookieStore();

  public static Cookie getCookie(String name)
  {
    for (Cookie c : httpCookieStore.getCookies())
    {
      if (name.equals(c.getName()))
        return c;
    }
    return null;
  }

  public static void resetCookie()
  {
    httpCookieStore = new BasicCookieStore();
  }
  
  public static HashMap<String, Object> call(int method, String url, Object requestData)
  {
    /*
    System.out.println("CLIENT:  Cookies:");
    for (Cookie c : httpCookieStore.getCookies())
    {
      System.out.println(c.getName()+" => "+c.getValue());
    }*/
    //clear cookie
    //httpCookieStore = new BasicCookieStore();
    try
    {
      //System.out.println("call, requestData: " + requestData);

      String req = requestData == null ? null : new ObjectMapper().writer().writeValueAsString(requestData);
      System.out.println("CLIENT: call, requestJSON: " + req);

      Map<String, Object> dataMap = null;

      try(CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCookieStore(httpCookieStore).build())
      {
        HttpResponse response = null;

        if (method == POST)
        {
          HttpPost httpReq = new HttpPost(HOST + url);
          if (req != null)
          {
            StringEntity reqBody = new StringEntity(req);
            reqBody.setContentType("application/json");
            httpReq.setEntity(reqBody);
          }
          response = httpClient.execute(httpReq);
        }
        else
        {
          HttpGet httpReq = new HttpGet(HOST + url);
          response = httpClient.execute(httpReq);
        }

        if (response == null)
        {
          System.out.println("CLIENT: Response IS NULL !!!!!");
        }
        else
        {
          //System.out.println("Response status: "+response.getStatusLine().getStatusCode());
          /*
          System.out.println("AFTER httpCookieStore.getCookies():");
          for (Cookie c : httpCookieStore.getCookies())
          {
            System.out.println(c.getName()+" => "+c.getValue());
          }*/

          try (InputStream inputStream = response.getEntity().getContent())
          {
            dataMap = new ObjectMapper().readValue(inputStream, new TypeReference<Map<String, Object>>()
            {
            });
            System.out.println("CLIENT: VHttpRequest inputData: " + dataMap);

            return (HashMap<String, Object>)dataMap;
          }
        }
      }
    }
    catch (Exception e)
    {
      //lgr.warn(e.getMessage(), e);
      //throw new ExceptionAdapter(e);
      e.printStackTrace();
    }
    return null;
  }

/*
  private static HttpResponse sendPost(String url, String requestBody) throws Exception
  {
    try(CloseableHttpClient httpClient = HttpClientBuilder.create().build())
    {
      HttpPost httpReq = new HttpPost(HOST + url);

      //httpReq.addHeader(new BasicHeader("Content-type", "application/json"));

      StringEntity reqBody = new StringEntity(requestBody);
      reqBody.setContentType("application/json");
      httpReq.setEntity(reqBody);

      return httpClient.execute(httpReq);
    }
  }

  private static HttpResponse sendGet(String url) throws Exception
  {
    try(CloseableHttpClient httpClient = HttpClientBuilder.create().build())
    {
      HttpGet httpReq = new HttpGet(HOST + url);
      return httpClient.execute(httpReq);
    }
  }
*/
}

