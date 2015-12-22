package org.rm.genie.vaapp.genie.shared.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.rm.genie.vaapp.genie.shared.exception.GenieException;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;


import static org.rm.genie.vaapp.genie.shared.exception.GenieException.ID_BAD_CALENDAR_DATE;

public class RMDate implements java.io.Serializable, Comparable
{
  private int year;
  private int month;
  private int day;
  private int hour;
  private int minute;

  public static final TimeZone GMT_TZ = TimeZone.getTimeZone("GMT");

  public boolean isTheSameDay(RMDate o)
  {
    return year == o.getYear() && month == o.getMonth() && day == o.getDay();
  }

  public void check() throws GenieException
  {
    if (year < 0)
    {
      throw new GenieException(ID_BAD_CALENDAR_DATE);
    }
    if ((month < 0) || (month > 11))
    {
      throw new GenieException(ID_BAD_CALENDAR_DATE);
    }
    if ((day < 1) || (day > 31))
    {
      throw new GenieException(ID_BAD_CALENDAR_DATE);
    }
    if ((hour < 0) || (hour > 24))
    {
      throw new GenieException(ID_BAD_CALENDAR_DATE);
    }
    if ((minute < 0) || (minute > 60))
    {
      throw new GenieException(ID_BAD_CALENDAR_DATE);
    }
  }

  public int compareTo(Object o)
  {
    RMDate od = (RMDate)o;
    int diff;
    if ((diff = year - od.getYear()) != 0)
    {
      return diff;
    }
    if ((diff = month - od.getMonth()) != 0)
    {
      return diff;
    }
    if ((diff = day - od.getDay()) != 0)
    {
      return diff;
    }
    if ((diff = hour - od.getHour()) != 0)
    {
      return diff;
    }
    if ((diff = minute - od.getMinute()) != 0)
    {
      return diff;
    }
    return 0;
  }

  public boolean equals(Object o)
  {
    if (!(o instanceof RMDate))
    {
      return false;
    }
    RMDate od = (RMDate)o;
    return (year == od.getYear()) && (month == od.getMonth()) && (day == od.getDay()) &&
      (hour == od.getHour()) && (minute == od.getMinute());
  }

  public int hashCode()
  {
    return toString().hashCode();
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public int getHour()
  {
    return hour;
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public int getMinute()
  {
    return minute;
  }

  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  public RMDate()
  {
  }

  public RMDate(long ms, String tzID)
  {
    initFromMillis(ms, tzID);
  }

  public RMDate(String tzID)
  {
    Calendar cl = new GregorianCalendar(TimeZone.getTimeZone(tzID));
    cl.setTimeInMillis(System.currentTimeMillis());
    setYear(cl.get(Calendar.YEAR));
    setMonth(cl.get(Calendar.MONTH));
    setDay(cl.get(Calendar.DATE));
    setHour(cl.get(Calendar.HOUR_OF_DAY));
    setMinute(cl.get(Calendar.MINUTE));
  }

  public RMDate(int year, int month, int day, int hour, int minute)
  {
    setYear(year);
    setMonth(month);
    setDay(day);
    setMinute(minute);
    setHour(hour);
  }

  //get date without time
  public RMDate obtainDate()
  {
    return new RMDate(this.year, this.month, this.day, 0, 0);
  }

  //get date without time
  public void applyDate(RMDate dt)
  {
    year = dt.getYear(); month = dt.getMonth(); day = dt.getDay();
  }

  private void initFromMillis(long ms, String schoolTimeZoneID)
  {
    TimeZone schoolTimeZone = TimeZone.getTimeZone(schoolTimeZoneID);
    Calendar cl = new GregorianCalendar(GMT_TZ);
    int offset = schoolTimeZone.getOffset(ms);
    cl.setTimeInMillis(ms + offset);
    setYear(cl.get(Calendar.YEAR));
    setMonth(cl.get(Calendar.MONTH));
    setDay(cl.get(Calendar.DATE));
    setHour(cl.get(Calendar.HOUR_OF_DAY));
    setMinute(cl.get(Calendar.MINUTE));
  }

  public long toMillis()
  {
    Calendar cl = new GregorianCalendar(GMT_TZ);
    cl.clear();
    cl.set(year, month, day, hour, minute);
    return cl.getTimeInMillis();
  }

  public long toMillis(String schoolTimeZoneID)
  {
    long millis = toMillis();
    return millis - TimeZone.getTimeZone(schoolTimeZoneID).getOffset(millis);
  }

  @Override
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append(year).append(".").append(month < 9 ? "0" + (month + 1) : month + 1).append(".").append(day < 10 ? "0" + day : day);
    sb.append(" ").append(hour < 10 ? "0" + hour : hour).append(":").append(minute < 10 ? "0" + minute : minute);
    return sb.toString();
  }

  public long convertToMillis(String timeZoneID)
  {
    Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(timeZoneID));
    cal.set(Calendar.YEAR, getYear());
    cal.set(Calendar.MONTH, getMonth());
    cal.set(Calendar.DAY_OF_MONTH, getDay());
    cal.set(Calendar.HOUR_OF_DAY, getHour());
    cal.set(Calendar.MINUTE, getMinute());
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTimeInMillis();
  }

  public RMDate endOfDay()
  {
    RMDate endOfDay = new RMDate();
    endOfDay.setYear(getYear());
    endOfDay.setMonth(getMonth());
    endOfDay.setDay(getDay());
    endOfDay.setHour(23);
    endOfDay.setMinute(59);
    return endOfDay;
  }

  public RMDate startOfDay()
  {
    RMDate endOfDay = new RMDate();
    endOfDay.setYear(getYear());
    endOfDay.setMonth(getMonth());
    endOfDay.setDay(getDay());
    endOfDay.setHour(0);
    endOfDay.setMinute(0);
    return endOfDay;
  }

  @JsonIgnore
  public Timestamp getTimestamp()
  {
    return new Timestamp(toMillis());
  }
}
