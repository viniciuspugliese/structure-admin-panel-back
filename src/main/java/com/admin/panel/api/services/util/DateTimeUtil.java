package com.admin.panel.api.services.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	public static Date getDateWithAddMonth(Integer months) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	public static Date getDateWithAddDays(Integer days) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}

	public static Date getDate() {
		return Calendar.getInstance().getTime();
	}

	public static Date createFromFormat(String format, String dateFormat) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

		Date date = simpleDateFormat.parse(dateFormat);
		calendar.setTime(date);

		return calendar.getTime();
	}

	public static String createFromFormatWithFormat(String format, String dateFormat, String display) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(display);
		Date date = createFromFormat(format, dateFormat);

		return simpleDateFormat.format(date);
	}
}
