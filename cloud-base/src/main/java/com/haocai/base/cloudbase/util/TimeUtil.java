package com.haocai.base.cloudbase.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 日期相关工具类
 *
 */
public class TimeUtil {
	
	/**
	 * 获取当前时间精确到天的日期字符串yyyy-MM-dd
	 * @return
	 */
	public static String getDayStr() {
		Date date = new Date();
		return formatDateToDay(date);
	}

	/**
	 * 获取当前时间精确到天的日期字符串yyyyMMdd
	 * @return
	 */
	public static String getDayStrNoSeparator() {
		Date date = new Date();
		return formatDateToDayNoSeparator(date);
	}

	/**
	 * 获取当前时间精确到秒的字符串yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateStr() {
		Date date = new Date();
		return formatDateToSecond(date);
	}
	
	/**
	 * 获取当前时间精确到秒的字符串yyyyMMddHHmmss
	 * @return
	 */
	public static String getDateStrToSecNoSeparator() {
		Date date = new Date();
		return formatDateToSecNoSeparator(date);
	}
	
	/**
	 * 获取当前时间精确到毫秒的字符串yyyy-MM-dd HH:mm:ss.sss
	 * @return
	 */
	public static String getDateStrToMill() {
		Date date = new Date();
		return formatDateToMill(date);
	}
	
	/**
	 * 获取当前时间精确到毫秒的字符串yyyyMMddHHmmsssss
	 * @return
	 */
	public static String getDateStrToMillNoSeparator() {
		Date date = new Date();
		return formatDateToMillNoSeparator(date);
	}

	/**
	 * 格式化日期yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String formatDateToDay(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	

	/**
	 * 格式化日期yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String formatDateToDayNoSeparator(Date date) {
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(date);
	}
	
	/**
	 * 
	 * @Title: formatDate 
	 * @Description: 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 * @param @param date
	 * @param @param pattern 格式
	 * @param @return    
	 * @return String    
	 * @throws 
	 *
	 */
	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (pattern != null && !pattern.equals("")) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 格式化日期yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String formatDateToSecond(Object date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	/**
	 * 格式化日期yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Date formatStringToDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if (ValidUtil.isNotEmpty(date)) {
				return sdf.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 格式化日期yyyyMMddHHmmss
	 * @param date
	 * @return
	 */
	public static String formatDateToSecNoSeparator(Date date) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		return format.format(date);
	}
	
	/**
	 * 格式化日期yyyy-MM-dd HH:mm:ss.sss
	 * @param date
	 * @return
	 */
	public static String formatDateToMill(Date date) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		return format.format(date);
	}
	
	/**
	 * 格式化日期yyyyMMddHHmmsssss
	 * @param date
	 * @return
	 */
	public static String formatDateToMillNoSeparator(Date date) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmsssss");
		return format.format(date);
	}
	
	// 距离指定日期n天的Calendar日期（n<0表示在指定日期之前）
	public static Calendar getOtherDay(Calendar calendar, Integer n) {
		calendar.add(Calendar.DAY_OF_MONTH, n);// 此处参数用Calendar中的DAY_OF_MONTH或DAY_OF_YEAR或DAY_OF_WEEK效果等同
		return calendar;
	}
		
	// 将Date转换为Calendar
	public static Calendar parseDate2Calendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
		
		// 距离指定日期n天的Date日期（n<0表示在指定日期之前）
		public static Date getOtherDay(Date date, Integer n) {
			return getOtherDay(parseDate2Calendar(date), n).getTime();
		}
		
		/**
		 * @Description: 获取本月第一天
		 * @param @return
		 * @author wuchao 
		 * @date 2016-8-25 下午2:41:45 
		 */
		public static Date getFirstDayOfThisMonth(){
		     Calendar c=Calendar.getInstance();//获取当前日期 
		     c.add(Calendar.MONTH,0);
		     c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		     return c.getTime();
		}
		
		/**
		  * 获取当年的第一天
		  * @return
		*/
		public static Date getCurrYearFirst(){
		    Calendar currCal=Calendar.getInstance();  
		    int currentYear = currCal.get(Calendar.YEAR);
		    return getYearFirst(currentYear);
		}
		
	    /**
	     * 获取某年第一天日期
	     * @param year 年份
	     * @return Date
	     */
	    public static Date getYearFirst(int year){
	        Calendar calendar = Calendar.getInstance();
	        calendar.clear();
	        calendar.set(Calendar.YEAR, year);
	        Date currYearFirst = calendar.getTime();
	        return currYearFirst;
	    }
	    
	    /** 
	     * @Title: 获取今天几号 
	     * @Description: TODO
	     * @param @return    
	     * @return int    
	     * @throws 
	     *
	     */
	    public static int getDateNum(){
	    	Calendar c=Calendar.getInstance();
	    	int datenum=c.get(Calendar.DATE);
	    	return datenum;
	    }
	    
	    /** 
	     * @Title: 获取现在几月 
	     * @Description: TODO
	     * @param @return    
	     * @return int    
	     * @throws 
	     *
	     */
	    public static int getMonthNum(){
	    	Calendar cal=Calendar.getInstance();
	        int month=cal.get(Calendar.MONTH)+1;
	        return month;
	    }
	    
	    /** 
	     * @Title: 获取当前年 
	     * @Description: TODO
	     * @param @return    
	     * @return int    
	     * @throws 
	     *
	     */
	    public static int getYearNum(){
	    	Calendar cal=Calendar.getInstance();
	    	int year=cal.get(Calendar.YEAR);
	        return year;
	    }
	    
	    public static String getDateApartYear(int year){
	    	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(new Date().getTime());
			c.add(Calendar.YEAR,3);
			Date d= new Date(c.getTimeInMillis());
			return date.format(d);
		}
	    
	    /**
	     * // 获得两个时间的毫秒时间差异
	     * @param startDate
	     * @param endDate
	     * @return
	     */
	    public static int getDatePoor(Date startDate, Date endDate) {
	        long diff = endDate.getTime() - startDate.getTime();
	        return (int)diff/1000;
	    }
	    
	    /**
	     * @Description: 返回两个日期的小时数
	     * @param @param endDate
	     * @param @param nowDate
	     * @param @return
	     * @author wuchao 
	     * @date 2017-6-9 下午6:04:28 
	     */
	    public static long getDatePoorHour(Date endDate, Date nowDate) {
	    	long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
			long nh = 1000 * 60 * 60;// 一小时的毫秒数
			long diff;
			long day = 0;
			long hour = 0;
			// 获得两个时间的毫秒时间差异
			diff = endDate.getTime() - nowDate.getTime();
			day = diff / nd;// 计算差多少天
			hour = diff % nd / nh + day * 24;// 计算差多少小时
			return hour;
	    }
}
