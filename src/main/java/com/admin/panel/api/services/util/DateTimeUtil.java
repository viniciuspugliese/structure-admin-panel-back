package com.admin.panel.api.services.util;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	public static Date getDateWithAddMonth(Integer months) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
}
