package Utilities;

import java.util.Calendar;

public class Calculations {

	public static Calendar getOneWeekFrom(Calendar d) {
		
		Calendar date = d;

		date.add(Calendar.DAY_OF_YEAR, 7);
		
		return date;
	}
}
