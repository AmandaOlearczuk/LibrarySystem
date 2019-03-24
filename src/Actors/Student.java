package Actors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import Media.PaperMedia;
import Media.PhysicalMedia;
import Utilities.*;

/**
 * This class is responsible for the student
Student: 

-Each student will have a unique ID  
-Log in with student credentials  
-Students may request media from the library if the library does not have the media in the database 
-Students may have a maximum of 5 pieces of media rented at a time. 
-Student borrows media for 2 weeks 
-Student can renew media borrow time for another 2 weeks if there’s no queue 
-Student can place max 5 media on hold for 1 week (hold is for books that are available) 
-Student can request an item someone else has to enter a queue & has 1 week to pick it up (it’s put on hold automatically)
 
*/
public class Student extends Customer{

	private int maxMedia;
	/**
	 * Constructor
	 * @param id
	 * @param fn
	 * @param ln
	 * @param bd
	 * @param address
	 * @param phonenum
	 * @param mediaOwned
	 * @param mediaonHold
	 * @param mediaReturned
	 * @param feesOwned
	 * @param isBL
	 */
	public Student(String id, String fn, String ln, Calendar bd, Utilities.Address address, String phonenum,
			Map<PhysicalMedia, Calendar> mediaOwned, Map<PhysicalMedia, CalendarPeriod> mediaonHold,
			Map<PhysicalMedia, Calendar> mediaReturned, Double feesOwned) {
		super(id, fn, ln, bd, address, phonenum, mediaOwned, mediaonHold, mediaReturned, feesOwned);
		this.setMaxMedia(5);
	}

	/**
	 * This function updates black list status for student considering the overdue fees
	 */
	public void updateBlackListStatus() {
		if (this.getFeesOwned() >= 50.0) {
			super.setIsBlackListed(true);
		} else {
			super.setIsBlackListed(false);
		}
		
	}

	/**
	 * Getters & setters
	 */
	public int getMaxMedia() {
		return maxMedia;
	}

	public void setMaxMedia(int maxMedia) {
		this.maxMedia = maxMedia;
	}


	
		
}
	
	
	


