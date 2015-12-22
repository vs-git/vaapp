package org.rm.genie.vaapp.converter;


import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.DateField;
import org.rm.genie.vaapp.genie.shared.entity.RMDate;

import java.util.Date;
import java.util.Locale;

public class DateField2RMDateConverter implements Converter<Date, RMDate>
{
    @Override
    public RMDate convertToModel(Date value, Class<? extends RMDate> targetType, Locale locale) throws ConversionException {
      if (value == null)
        return null;
      else
        return new RMDate(value.getTime(), RMDate.GMT_TZ.getID());
    }

    @Override
    public Date convertToPresentation(RMDate value, Class<? extends Date> targetType, Locale locale) throws ConversionException
    {
      if (value == null)
        return null;
      return new Date(value.toMillis());
    }

    @Override
    public Class<RMDate> getModelType() {
      return RMDate.class;
    }

    @Override
    public Class<Date> getPresentationType() {
      return Date.class;
    }
  }