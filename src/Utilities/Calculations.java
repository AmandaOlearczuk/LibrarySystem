package Utilities;

import java.util.Calendar;

public class Calculations {

	/**
	 * returns a date one week from some date
	 * @param d
	 * @return date -which is a Calendar one week from d
	 */
	public static Calendar getOneWeekFrom(Calendar d) {
		
		Calendar date = d;

		date.add(Calendar.DAY_OF_YEAR, 7);
		
		return date;
	}
	
	
	/**
	 * Checks if date is expired based on date right now 
	 */
	public static Boolean checkExpired(Calendar date) {
		
		Calendar now = Calendar.getInstance();
		Calendar retDate = date;
		
		return (now.after(retDate));
	}
	
	
	
		
		
}
