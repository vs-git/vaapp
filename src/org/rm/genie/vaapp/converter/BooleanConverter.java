package org.rm.genie.vaapp.converter;


import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.StringToBooleanConverter;
import org.rm.genie.vaapp.genie.shared.entity.RMDate;

import java.util.Locale;

public class BooleanConverter implements Converter<String, Boolean>
{
    @Override
    public Boolean convertToModel(String value, Class<? extends Boolean> targetType, Locale locale) throws ConversionException {
      if ("true".equals(value) || "TRUE".equals(value))
        return true;
      int i = Integer.parseInt(value);
      if (i > 0)
        return true;

      throw new ConversionException("Unable to parse String to Boolean");
    }

    @Override
    public String convertToPresentation(Boolean value, Class<? extends String> targetType, Locale locale) throws ConversionException
    {
      if (value)
        return "true";
      else
        return "false";
    }

    @Override
    public Class<Boolean> getModelType() {
      return Boolean.class;
    }

    @Override
    public Class<String> getPresentationType() {
      return String.class;
    }
  }