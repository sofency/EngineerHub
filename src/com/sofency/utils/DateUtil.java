package com.sofency.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static String getCurrentTime() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat simple = new SimpleDateFormat("YYYY:MM:dd HH:mm:ss");
		return simple.format(date);
	}

}
