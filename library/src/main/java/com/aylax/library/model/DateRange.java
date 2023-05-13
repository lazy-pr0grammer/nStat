package com.aylax.library.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateRange {
  private Calendar start, end;

  public DateRange(Calendar start, Calendar end) {
    this.start = start;
    this.end = end;
  }

  public DateRange(long start, long end) {
    this.start = asCalendar(start);
    this.end = asCalendar(end);
  }

  public DateRange() {}

  public Calendar asCalendar(long mills) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(mills);
    return calendar;
  }

  public String getDateAsString(Calendar calendar, String format) {
    SimpleDateFormat formatter = new SimpleDateFormat(format);
    formatter.setTimeZone(TimeZone.getDefault());
    return formatter.format(calendar.getTime());
  }

  public String getDateAsString(long mills, String format) {
    return getDateAsString(asCalendar(mills), format);
  }
}
