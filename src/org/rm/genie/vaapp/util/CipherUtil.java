package org.rm.genie.vaapp.util;

import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class CipherUtil
{
  public static final String SF_AUTH_KEY = "961573bc78aef3aef50237850a5fac65";
  private static final String key = "240e007c29a3f07e";

  public static String decipher(byte[] data)
  {
    try
    {
      Cipher rc4 = Cipher.getInstance("RC4");
      rc4.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "RC4"));
      byte [] deciphered = rc4.doFinal(data);
      return new String(deciphered);
    }
    catch (Exception e)
    {
      return null;
    }
  }

  public static byte[] cipher(String data)
  {
    try
    {
      Cipher rc4 = Cipher.getInstance("RC4");
      rc4.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "RC4"));
      return rc4.doFinal(data.getBytes());
    }
    catch (Exception e)
    {
      return null;
    }
  }

  public static String getMD5(String input)
  {
    try
    {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageDigest = md.digest(input.getBytes());
      BigInteger number = new BigInteger(1, messageDigest);
      String hashtext = number.toString(16);
      while (hashtext.length() < 32)
      {
        hashtext = "0" + hashtext;
      }
      return hashtext;
    }
    catch (NoSuchAlgorithmException e)
    {
      return null;
    }
  }
/*
  public static boolean authByToken(String login, String psw, long timeFromRequest, String sign, String privateToken) throws Exception
  {
    Logger lgr = LoggerFactory.getLogger();
    lgr.debug("AuthByToken: login = " + login + "; timeFromRequest = " + timeFromRequest + "; sign = " + sign);
    boolean authSuccess = false;

    if (psw != null)
    {
      long currTime = System.currentTimeMillis();
      String calcHexSign = DigestUtils.shaHex(login + timeFromRequest + psw + privateToken);
      if (calcHexSign.compareTo(sign) == 0)
      {
        if (Math.abs(currTime - timeFromRequest) < 60 * 1000)
          authSuccess = true;
        else
          lgr.warn("AuthByToken: login = " + login + ": delay more then 1 minute: curr time " + currTime + ", request time " + timeFromRequest);
      }
      else
        lgr.warn("AuthByToken: login = " + login + ": calculated sign " + calcHexSign + " not equal to request sign " + sign);
    }
    else
      lgr.warn("AuthByToken: authentication by empty password is not allowed");

    if (authSuccess)
      lgr.debug("AuthByToken: successful login as " + login);
    return authSuccess;
  }*/

}
