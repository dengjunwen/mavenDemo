package com.cgq.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * date基本操作
 * 
 */
public class DateProcess {

	/**
	 * 得到当前系统时间yyyy-MM-dd hh:mm:ss字符串
	 * 
	 * @return
	 */
	public static String getSysTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyy-MM字符串
	 * 
	 * @return
	 */
	public static String getSysYYMMTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyyMM字符串
	 * 
	 * @return
	 */
	public static String getSysyyyyMMTime() {
		DateFormat df = new SimpleDateFormat("yyyyMM");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyy/MM/dd hh:mm:ss字符串
	 * 
	 * @return
	 */
	public static String getSysTime1() {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyy-MM-dd hh:mm:ss.S字符串
	 * 
	 * @return
	 */
	public static String getSysMilTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyyMMddhhmmssS字符串
	 * 
	 * @return
	 */
	public static String getSystemMilTime() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssS");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyy-MM-dd字符串
	 * 
	 * @return
	 */
	public static String getSysDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyy/MM/dd字符串
	 * 
	 * @return
	 */
	public static String getSysDate1() {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 得到当前系统时间yyyyMMdd字符串
	 * 
	 * @return
	 */
	public static String getDate() {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	public static String getNum() {
		DateFormat df = new SimpleDateFormat("HH:mm:ss.S");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 获取当前时分秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getNum2() {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String date = df.format(java.util.Calendar.getInstance().getTime());
		return date;
	}

	/**
	 * 计算当前日期前几天或是后几天
	 */
	public static String afterNDay(int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);

		return s;
	}

	/**
	 * 计算当前日期前几天或是后几天 yyyy-mm
	 */
	public static String afterNDayYYYYMM(int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		c.setTime(new Date());
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);

		return s;
	}

	/**
	 * 计算当前日期前几月或是后几月
	 */
	public static String afterMon(int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		c.setTime(new Date());
		c.add(Calendar.MONTH, n);
		Date d2 = c.getTime();
		String s = df.format(d2);

		return s;
	}

	/**
	 * 计算某一天的下一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date afterDay(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}

	/**
	 * 计算某一天的前几天，或是后几天
	 * 
	 * @param d
	 * @param n
	 * @return
	 */
	public static String afterOrBeforeDay(String date, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(toDate(date));
		c.add(Calendar.DATE, n);
		DateFormat df = new SimpleDateFormat("yyyyMM");
		return df.format(c.getTime());
	}

	/**
	 * 计算过多少分钟后的时间
	 * 
	 * @param currentDate
	 *            yyyy-MM-dd HH:mm:ss
	 * @param n
	 *            正数表示多少分钟后，负数表示多少分钟前
	 * @return
	 */
	public static String afterMintue(String currentDate, int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		c.setTime(toDate(currentDate));
		c.add(Calendar.MINUTE, n);
		Date d2 = c.getTime();
		return df.format(d2);
	}

	public static String changeFormat(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat(format);
		return df.format(d);
	}

	public static String changeFormatWithYYYYMM(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat(format);
		return df.format(d);
	}

	/**
	 * 计算两天的时间差
	 * 
	 * @param beforeTime
	 * @param endTime
	 * @return
	 */
	public static String timeDiffrence(String beforeTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d = null;
		try {
			d = sdf.parse(beforeTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date d1 = null;
		try {
			d1 = sdf.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		long timethis = calendar.getTimeInMillis();
		calendar.setTime(d1);
		long timeend = calendar.getTimeInMillis();
		long theday = (timeend - timethis) / (1000 * 60 * 60 * 24);
		return theday + "";
	}

	/**
	 * 计算两天的时间差，返回相差的秒数。
	 * 
	 * @param beforeTime
	 * @param endTime
	 * @return
	 */
	public static String timeDiffrenceToSec(String beforeTime, String endTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date d = null;
		try {
			d = sdf.parse(beforeTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date d1 = null;
		try {
			d1 = sdf.parse(endTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		long timethis = calendar.getTimeInMillis();
		calendar.setTime(d1);
		long timeend = calendar.getTimeInMillis();
		long theday = (timeend - timethis) / 1000;
		return theday + "";
	}

	/**
	 * 将一个格式为yyyy-MM-dd HH:mm:ss的String类型的时间转换成Date对象。
	 * 
	 * @param sysTime
	 * @return
	 */
	public static Date toDate(String sysTime) {
		try {
			String timePattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
			Date date = sdf.parse(sysTime);
			return date;
		} catch (ParseException e) {
			System.out.println("format error!");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将时间转换成一个格式为yyyy-MM-dd HH:mm:ss的String
	 * 
	 * @param sysTime
	 * @return
	 */
	public static String toYMdHmsStr(Date sysTime) {
		String timePattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
		return sdf.format(sysTime);
	}

	/**
	 * 将时间转换成一个格式为yyyy-MM-dd的String
	 * 
	 * @param sysTime
	 * @return
	 */
	public static String toYMdStr(Date sysTime) {
		String timePattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
		return sdf.format(sysTime);
	}
	
	/**
	 * 获取下周一的日期 如果是参数周一则放回原参数
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		/*
		 * 周日是一周的开始 if(week>2){ cal.add(Calendar.DAY_OF_MONTH,-(week-2)+7);
		 * }else{ cal.add(Calendar.DAY_OF_MONTH,2-week+7); }
		 */

		// 周一是一周的开始
		if (week == 1) {
			cal.add(Calendar.DAY_OF_MONTH, 1);
		} else if (week == 2) {
			return date;
		} else if (week > 2) {
			cal.add(Calendar.DAY_OF_MONTH, -(week - 2) + 7);
		}
		return cal.getTime();
	}

	public static void main(String[] args) throws Exception {
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, -2);
		System.out.println((getMonday(cal.getTime())));
	}

}
