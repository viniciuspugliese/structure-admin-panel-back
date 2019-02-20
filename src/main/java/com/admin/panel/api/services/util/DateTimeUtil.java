package com.admin.panel.api.services.util;

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
}
