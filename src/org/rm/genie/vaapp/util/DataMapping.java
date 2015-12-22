package org.rm.genie.vaapp.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.rm.genie.vaapp.genie.shared.entity.report2.TestPrepReportResponse;

import java.lang.reflect.*;
import java.util.*;

public class DataMapping
{
  public static void mapObject(Object obj, Map<String, Object> map) throws Exception
  {
    LinkedHashMap<String, Field> objFields = getAllFields(new LinkedHashMap<String, Field>(), obj.getClass());

    //System.out.println("map.keySet() "+map.keySet());
    for(String fieldName : map.keySet())
    {
      // System.out.println(fieldName);
      Object property = map.get(fieldName);

      Field field = objFields.get(fieldName);//obj.getClass().getDeclaredField(fieldName);


      if (obj.getClass() != LinkedHashMap.class)
      {
        if (field == null)
        {
          System.out.println("NULL: "+fieldName.getClass());
          continue;
        }

        if (Modifier.isFinal(field.getModifiers()))
          continue;

        if (!field.isAccessible())
          field.setAccessible(true);
      }

      if (property == null)
        field.set(obj, null);
      else if (isSimpleType(property))
      {
        if (obj.getClass() == LinkedHashMap.class)
          ((LinkedHashMap) obj).put(fieldName, property);
        else
          setSimpleField(obj, field, property.toString());
      }
      else if (property.getClass() == LinkedHashMap.class)
      {
        //System.out.println("fieldName: "+field.getName()+"; field.getType(): "+field.getType());
        Object child = LinkedHashMap.class.newInstance();
        mapObject(child, (LinkedHashMap) property);
        field.set(obj, child);
      }
      else if (field.getType().isArray())
      {
        System.out.println(
          Double[].class + " : "
            + field.getType() + " : "
            + field.getType().getCanonicalName() + " : "
            + Array.newInstance(Double[].class, 0).getClass().getComponentType().getCanonicalName());

        //System.out.println(  field.getType().isAssignableFrom(float[].class)   );
        //System.out.println(  field.getType() ==  float[].class  );

        float[] child = (float[])Array.newInstance(/*field.getType().getComponentType()*/float.class, ((ArrayList) property).size());

        for (int i = 0; i < ((ArrayList) property).size(); i++)
        {
          child[i] = Float.parseFloat(((ArrayList) property).get(i).toString());
        }

        field.set(obj, child);
      }
      else if (property.getClass() == ArrayList.class)
      {
        //String fieldName  - имя поля (как во входящей мапе так и в классе, куда биндим)
        //Field field - поле класса куда биндим
        //Object property - значение поля из входящей мапы

        List<Object> child = ArrayList.class.newInstance();//ArrayList который забиндим в поле field

        for (int i = 0; i < ((ArrayList) property).size(); i++)
        {
          Object item = ((ArrayList) property).get(i);//
          if (!isSimpleType(item) )
          {
            Type type = getParameterClass(field);
            Object childItem = ((Class)type).newInstance();
            mapObject(childItem, (LinkedHashMap) item);
            child.add(childItem);
          }
          else
          {
            child.add(item);
          }
        }
        field.set(obj, child);
      }
      else
      {
        field.set(obj, property);
      }
    }
  }

  public void main(String args)
  {
    Map<Integer, String> obj = new LinkedHashMap<>();

    LinkedHashMap<String, Field> objFields = getAllFields(new LinkedHashMap<String, Field>(), obj.getClass());

    //obj.put("1", "qqq");

   /*
    Field field = objFields.get(fieldName);

    Type type = field.getGenericType();
    if (type instanceof ParameterizedType)
    {
      ParameterizedType pt = (ParameterizedType) type;
      Object o = pt.getActualTypeArguments()[0];
    }*/
  }

  public static TestPrepReportResponse getFakeTPResponse() throws Exception
  {
    String data = "{\"students\":[{\"firstName\":\"vs15p42s1\",\"lastName\":\"vs15p42s1\",\"studentID\":40140731,\"cells\":[{\"solved\":14,\"given\":15,\"ratio\":0.93333334,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":4,\"given\":5,\"ratio\":0.8,\"status\":1,\"assigned\":0,\"objectiveID\":64562},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64563},{\"solved\":5,\"given\":5,\"ratio\":1.0,\"status\":2,\"assigned\":0,\"objectiveID\":64564},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64565},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112965},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112981},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112980},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112994},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64566},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64567},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":113000},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112967},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112998},{\"solved\":9,\"given\":10,\"ratio\":0.9,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112991},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112982},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64568},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64569},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64570},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64571},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64572},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112997},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112974},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112996},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64573},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64574},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112948},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64575},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64576},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112943},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112975},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112947},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112985},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112964},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":113408},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64580},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112954},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64581},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64583},{\"solved\":5,\"given\":5,\"ratio\":1.0,\"status\":2,\"assigned\":0,\"objectiveID\":112977},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112953},{\"solved\":5,\"given\":5,\"ratio\":1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0}],\"cmgAsnmtID\":0,\"testAsnmtID\":0,\"testPrepAsnmID\":0,\"amts\":[]},{\"firstName\":\"vs15p42s2\",\"lastName\":\"vs15p42s2\",\"studentID\":40140732,\"cells\":[{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64562},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64563},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64564},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64565},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112965},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112981},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112980},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112994},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64566},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64567},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":113000},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112967},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112998},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112991},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112982},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64568},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64569},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64570},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64571},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64572},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112997},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112974},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112996},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64573},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64574},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112948},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64575},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64576},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112943},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112975},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112947},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112985},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112964},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":113408},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64580},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112954},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64581},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":64583},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112977},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":112953},{\"solved\":0,\"given\":0,\"ratio\":-1.0,\"status\":-1,\"assigned\":0,\"objectiveID\":0}],\"cmgAsnmtID\":0,\"testAsnmtID\":0,\"testPrepAsnmID\":0,\"amts\":[]}],\"total\":[0.93333334,0.8,-1.0,1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,0.9,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,-1.0,1.0,-1.0,1.0],\"reportID\":-1,\"categories\":{\"1\":\"Numerical Representations and Relationships\",\"2\":\"Computations and Algebraic Relationships\",\"3\":\"Geometry and Measurement\",\"4\":\"Data Analysis and Personal Financial Literacy \",\"5\":\"Probability and Statistics\"},\"tpStandards\":[{\"objectiveID\":64562,\"oindex\":45,\"std\":\"4.2A\",\"categoryID\":1,\"shortDescription\":\"Interpret place values\",\"type\":\"S\"},{\"objectiveID\":64563,\"oindex\":46,\"std\":\"4.2B\",\"categoryID\":1,\"shortDescription\":\"Represent the values of digits\",\"type\":\"R\"},{\"objectiveID\":64564,\"oindex\":47,\"std\":\"4.2C\",\"categoryID\":1,\"shortDescription\":\"Compare and order whole numbers\",\"type\":\"S\"},{\"objectiveID\":64565,\"oindex\":48,\"std\":\"4.2D\",\"categoryID\":1,\"shortDescription\":\"Round whole numbers\",\"type\":\"S\"},{\"objectiveID\":112965,\"oindex\":49,\"std\":\"4.2E\",\"categoryID\":1,\"shortDescription\":\"Represent decimals\",\"type\":\"S\"},{\"objectiveID\":112981,\"oindex\":50,\"std\":\"4.2F\",\"categoryID\":1,\"shortDescription\":\"Compare and order decimals\",\"type\":\"S\"},{\"objectiveID\":112980,\"oindex\":51,\"std\":\"4.2G\",\"categoryID\":1,\"shortDescription\":\"Relate decimals to fractions\",\"type\":\"R\"},{\"objectiveID\":112994,\"oindex\":52,\"std\":\"4.2H\",\"categoryID\":1,\"shortDescription\":\"Determine decimal corresponding to a point on a number line\",\"type\":\"S\"},{\"objectiveID\":64566,\"oindex\":53,\"std\":\"4.3A\",\"categoryID\":1,\"shortDescription\":\"Represent a fraction as a sum of fractions\",\"type\":\"S\"},{\"objectiveID\":64567,\"oindex\":54,\"std\":\"4.3B\",\"categoryID\":1,\"shortDescription\":\"Decompose a fraction into a sum of fractions\",\"type\":\"S\"},{\"objectiveID\":113000,\"oindex\":55,\"std\":\"4.3C\",\"categoryID\":1,\"shortDescription\":\"Determine if fractions are equivalent\",\"type\":\"S\"},{\"objectiveID\":112967,\"oindex\":56,\"std\":\"4.3D\",\"categoryID\":1,\"shortDescription\":\"Compare fractions\",\"type\":\"R\"},{\"objectiveID\":112998,\"oindex\":59,\"std\":\"4.3G\",\"categoryID\":1,\"shortDescription\":\"Represent fractions and decimals on a number line\",\"type\":\"S\"},{\"objectiveID\":112991,\"oindex\":57,\"std\":\"4.3E\",\"categoryID\":2,\"shortDescription\":\"Represent and solve addition and subtractions of fractions\",\"type\":\"R\"},{\"objectiveID\":112982,\"oindex\":58,\"std\":\"4.3F\",\"categoryID\":2,\"shortDescription\":\"Evaluate reasonableness of sums and differences of fractions\",\"type\":\"S\"},{\"objectiveID\":64568,\"oindex\":60,\"std\":\"4.4A\",\"categoryID\":2,\"shortDescription\":\"Add and subtract whole numbers and decimals\",\"type\":\"R\"},{\"objectiveID\":64569,\"oindex\":61,\"std\":\"4.4B\",\"categoryID\":2,\"shortDescription\":\"Determine products of a number and 10 or 100\",\"type\":\"S\"},{\"objectiveID\":64570,\"oindex\":62,\"std\":\"4.4C\",\"categoryID\":2,\"shortDescription\":\"Represent products\",\"type\":\"S\"},{\"objectiveID\":64571,\"oindex\":63,\"std\":\"4.4D\",\"categoryID\":2,\"shortDescription\":\"Multiply whole numbers\",\"type\":\"S\"},{\"objectiveID\":64572,\"oindex\":64,\"std\":\"4.4E\",\"categoryID\":2,\"shortDescription\":\"Represent quotients\",\"type\":\"S\"},{\"objectiveID\":112997,\"oindex\":65,\"std\":\"4.4F\",\"categoryID\":2,\"shortDescription\":\"Divide whole numbers\",\"type\":\"S\"},{\"objectiveID\":112974,\"oindex\":66,\"std\":\"4.4G\",\"categoryID\":2,\"shortDescription\":\"Round to estimate solutions\",\"type\":\"S\"},{\"objectiveID\":112996,\"oindex\":67,\"std\":\"4.4H\",\"categoryID\":2,\"shortDescription\":\"Solve problems using multiplication and division\",\"type\":\"R\"},{\"objectiveID\":64573,\"oindex\":68,\"std\":\"4.5A\",\"categoryID\":2,\"shortDescription\":\"Represent problems involving whole numbers\",\"type\":\"R\"},{\"objectiveID\":64574,\"oindex\":69,\"std\":\"4.5B\",\"categoryID\":2,\"shortDescription\":\"Generate number patterns\",\"type\":\"R\"},{\"objectiveID\":112948,\"oindex\":70,\"std\":\"4.5D\",\"categoryID\":3,\"shortDescription\":\"Solve problems of perimeter and area\",\"type\":\"R\"},{\"objectiveID\":64575,\"oindex\":71,\"std\":\"4.6A\",\"categoryID\":3,\"shortDescription\":\"Identify points and lines\",\"type\":\"S\"},{\"objectiveID\":64576,\"oindex\":72,\"std\":\"4.6B\",\"categoryID\":3,\"shortDescription\":\"Identify and draw lines of symmetry\",\"type\":\"S\"},{\"objectiveID\":112943,\"oindex\":73,\"std\":\"4.6C\",\"categoryID\":3,\"shortDescription\":\"Identify acute, right, and obtuse triangles\",\"type\":\"S\"},{\"objectiveID\":112975,\"oindex\":74,\"std\":\"4.6D\",\"categoryID\":3,\"shortDescription\":\"Classify two-dimensional figures\",\"type\":\"R\"},{\"objectiveID\":112947,\"oindex\":75,\"std\":\"4.7C\",\"categoryID\":3,\"shortDescription\":\"Approximate measures of angles\",\"type\":\"R\"},{\"objectiveID\":112985,\"oindex\":76,\"std\":\"4.7D\",\"categoryID\":3,\"shortDescription\":\"Draw an angle\",\"type\":\"S\"},{\"objectiveID\":112964,\"oindex\":77,\"std\":\"4.7E\",\"categoryID\":3,\"shortDescription\":\"Determine the measure of an angle\",\"type\":\"S\"},{\"objectiveID\":113408,\"oindex\":78,\"std\":\"4.8AB\",\"categoryID\":3,\"shortDescription\":\"Identify relative sizes. Convert measurements.\",\"type\":\"S\"},{\"objectiveID\":64580,\"oindex\":79,\"std\":\"4.8C\",\"categoryID\":3,\"shortDescription\":\"Solve problems with measurements\",\"type\":\"R\"},{\"objectiveID\":112954,\"oindex\":80,\"std\":\"4.9A\",\"categoryID\":4,\"shortDescription\":\"Represent data\",\"type\":\"R\"},{\"objectiveID\":64581,\"oindex\":81,\"std\":\"4.9B\",\"categoryID\":4,\"shortDescription\":\"Solve problems using data\",\"type\":\"S\"},{\"objectiveID\":64583,\"oindex\":82,\"std\":\"4.10A\",\"categoryID\":4,\"shortDescription\":\"Distinguish between fixed and variable expenses\",\"type\":\"S\"},{\"objectiveID\":112977,\"oindex\":83,\"std\":\"4.10B\",\"categoryID\":4,\"shortDescription\":\"Calculate profit\",\"type\":\"S\"},{\"objectiveID\":112953,\"oindex\":84,\"std\":\"4.10E\",\"categoryID\":4,\"shortDescription\":\"Describe financial institutions\",\"type\":\"S\"}]}";
    Map<String, Object> dataMap = new ObjectMapper().readValue(data, new TypeReference<Map<String, Object>>(){});
    TestPrepReportResponse TPResponse = new TestPrepReportResponse();
    mapObject(TPResponse, dataMap);
    return TPResponse;
  }

  private static Boolean isSimpleType(Object property)
  {
    return property.getClass() == Double.class
      || property.getClass() == Integer.class
      || property.getClass() == Long.class
      || property.getClass() == Boolean.class
      || property.getClass() == String.class;
  }

  private static Type getParameterClass(Field field) throws RuntimeException
  {
    Type type = field.getGenericType();
    if (type instanceof ParameterizedType)
    {
      ParameterizedType pt = (ParameterizedType) type;
      return pt.getActualTypeArguments()[0];
    }
    throw new RuntimeException("Parameter type of field '"  + field.getName() + "' is not instanceof ParameterizedType");
  }

  private static void setSimpleField(Object obj, Field field, String value) throws IllegalAccessException
  {
    if (field.getType() == int.class || field.getType() == Integer.class)
      field.setInt(obj, (int) Double.parseDouble(value));
    else if (field.getType() == float.class || field.getType() == Float.class)
      field.setFloat(obj, (float) Double.parseDouble(value));
    else if (field.getType() == double.class || field.getType() == Double.class)
      field.setDouble(obj, Double.parseDouble(value));
    else if (field.getType() == long.class || field.getType() == Long.class)
      field.setLong(obj, (long)Double.parseDouble(value));
    else if (field.getType() == boolean.class || field.getType() == Boolean.class)
      field.setBoolean(obj, Boolean.parseBoolean(value));
    else if (field.getType() == String.class)
      field.set(obj, value);
  }

  public static LinkedHashMap<String, Field> getAllFields(LinkedHashMap<String, Field> fields, Class<?> type)
  {
    for (Field f : type.getDeclaredFields())
      fields.put(f.getName(), f);

    if (type.getSuperclass() != null)
      fields = getAllFields(fields, type.getSuperclass());

    return fields;
  }

  public static List<Field> getAllFields(List<Field> fields, Class<?> type)
  {
    fields.addAll(Arrays.asList(type.getDeclaredFields()));

    if (type.getSuperclass() != null)
      fields = getAllFields(fields, type.getSuperclass());

    return fields;
  }
}
