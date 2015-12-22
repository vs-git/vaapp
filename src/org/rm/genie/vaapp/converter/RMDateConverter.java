package org.rm.genie.vaapp.converter;


import com.vaadin.data.util.converter.Converter;
import org.rm.genie.vaapp.genie.shared.entity.RMDate;

import java.util.Locale;

public class RMDateConverter implements Converter<String, RMDate>
{
    @Override
    public RMDate convertToModel(String value, Class<? extends RMDate> targetType, Locale locale) throws ConversionException {
      if (value == null)
        return null;
      String parts[] = value.trim().split("\\D+");
      if (parts.length == 3)
        return new RMDate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])-1, Integer.parseInt(parts[2]), 0, 0);
      else if (parts.length == 5)
        return new RMDate(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])-1, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
      else
        throw new ConversionException("Unable to parse String to RMDate");
    }

    @Override
    public String convertToPresentation(RMDate value, Class<? extends String> targetType, Locale locale) throws ConversionException
    {
      if (value == null)
        return "";
      return value.toString();
    }

    @Override
    public Class<RMDate> getModelType() {
      return RMDate.class;
    }

    @Override
    public Class<String> getPresentationType() {
      return String.class;
    }
  }