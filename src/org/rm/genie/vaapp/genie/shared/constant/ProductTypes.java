package org.rm.genie.vaapp.genie.shared.constant;


import java.util.HashSet;
import java.util.Set;

/*
 * Created by ssokolov on 01.06.2015.
 */
public class ProductTypes
{
  public static final int FOUNDATIONS_G2 = 1;
  public static final int STAAR_INTEGRATED = 2;
  public static final int STAAR_STANDALONE = 3;
  public static final int SMARTER_SOLVING_INTEGRATED = 4;
  public static final int SMARTER_SOLVING_STANDALONE = 5;
  public static final int TEKS_ELEMENTS = 6;
  public static final int FOUNDATIONS_G3 = 7;

  public static final Set<Integer> STAAR = new HashSet<>();
  static
  {
    STAAR.add(STAAR_INTEGRATED);
    STAAR.add(STAAR_STANDALONE);
    STAAR.add(TEKS_ELEMENTS);
  }

  public static final Set<Integer> SBRC = new HashSet<>();
  static
  {
    SBRC.add(SMARTER_SOLVING_STANDALONE);
    SBRC.add(SMARTER_SOLVING_INTEGRATED);
  }

  public static boolean isStaar(int productType)
  {
    return STAAR.contains(productType);
  }

  public static short getTestType(int productType)
  {
    if (isStaar(productType))
      return TestTypes.STAAR;
    else if (isSmarterSolving(productType))
      return TestTypes.SBRC;
    else return 0;
  }

  public static Set<Integer> getProductTypes(int testType)
  {
    if (TestTypes.STAAR == testType)
      return STAAR;
    else if (TestTypes.SBRC == testType)
      return SBRC;
    else return new HashSet<>();
  }

  public static boolean isIncludesG2Foundations(int productType)
  {
    return productType == FOUNDATIONS_G2 || productType == STAAR_INTEGRATED || productType == SMARTER_SOLVING_INTEGRATED;
  }

  public static boolean isSmarterSolving(int productType)
  {
    return productType == SMARTER_SOLVING_STANDALONE || productType == SMARTER_SOLVING_INTEGRATED;
  }

  public static boolean isG3(int productType)
  {
    return productType == TEKS_ELEMENTS || productType == FOUNDATIONS_G3;
  }

  public static boolean isG2(int productType)
  {
    return !isG3(productType);
  }

  public static boolean isStandalone(int productType)
  {
    return productType == SMARTER_SOLVING_STANDALONE || productType == STAAR_STANDALONE;
  }

}

