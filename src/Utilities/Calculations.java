package Utilities;

import java.util.Calendar;

/**
 * This class is responsible for calculating dates such as calculating date one week from now or checking if
 * date is expired based on provided date.
 *
 */
public class Calculations {

	/**
	 * returns a date one week from some date
	 * @param d - Calendar date provided
	 * @return Calendar -which is a date one week from d
	 */
	public static Calendar getOneWeekFrom(Calendar d) {
		
		Calendar date = d;

		date.add(Calendar.DAY_OF_YEAR, 7);
		
		return date;
	}
	
	
	/**
	 * Checks if date is expired based on date right now 
	 * @param d - Calendar date
	 * @return Boolean - if the date is expired or not based on d
	 */
	public static Boolean checkExpired(Calendar d) {
		
		Calendar now = Calendar.getInstance();
		Calendar retDate = d;
		
		return (now.after(retDate));
	}
	
	
	
		
		
}
