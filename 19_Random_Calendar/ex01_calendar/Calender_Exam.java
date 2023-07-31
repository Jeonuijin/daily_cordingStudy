package com.mystudy.ex01_calendar;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Calender_Exam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new Date() : " + date);
		
		// 월 : 0~11 - 0 : 1월, 1 : 2월, ..., 11 : 12월
		date = new Date(2023 - 1900 , 6, 31);
		System.out.println("new Date() : " + date);
		System.out.println("=================");
		
		System.out.println("---- Calendar -------------");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		//년월일
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		System.out.println("월 : " + cal.get(Calendar.MONTH) + 1);
		System.out.println("일 : " + cal.get(Calendar.DATE));
		
		//시분초
		System.out.println("오전오후 : " + cal.get(Calendar.AM_PM));
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR));
		System.out.println("시(24시간) : " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("밀리초 : " + cal.get(Calendar.MILLISECOND));
		
		//년-월-일 시:분:초
		String dateTime = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1)
						+ "-" + cal.get(Calendar.DATE) + " " + cal.get(Calendar.HOUR_OF_DAY)
						+ ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		System.out.println(">>년-월-일 시:분:초" + dateTime);
		
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
		date = new Date();
		System.out.println("new Date() :" + date);
		System.out.println("y-M-d H:m:s : " + sdf.format(date));
		
		sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		cal.set(Calendar.YEAR, 2000);
		date = cal.getTime();
		System.out.println(sdf.format(date));
	}

}
