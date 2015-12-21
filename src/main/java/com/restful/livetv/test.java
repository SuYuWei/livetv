package com.restful.livetv;

import java.util.Calendar;
import java.util.Locale;

import org.joda.time.DateTime;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTime dt = new DateTime();
		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(dt.getMillis());
		Calendar c2 = dt.toCalendar(Locale.getDefault());
		  System.out.println(c1.getTime());
		  System.out.println(c2.getTime());
	}

}
