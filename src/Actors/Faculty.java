package Actors;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import Media.PhysicalMedia;
import Utilities.*;

/** 
 * This class is responsible for the faculty
Faculty: 

Each faculty member will have a unique ID 
Faculty status will be placed on the account on creation 
May ask librarian to put a certain book on the restricted list
May have maximum of 8 pieces of media rented at a single time 

*/ 


public class Faculty extends Customer {

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
	public Faculty(String id, String fn, String ln, Calendar bd, Utilities.Address address, String phonenum,
			Map<PhysicalMedia, Calendar> mediaOwned, Map<PhysicalMedia, CalendarPeriod> mediaonHold,
			Map<PhysicalMedia, Calendar> mediaReturned, Double feesOwned) {
		super(id, fn, ln, bd, address, phonenum, mediaOwned, mediaonHold, mediaReturned, feesOwned);
		this.setMaxMedia(8);
	}

	/**
	 * This function takes off black list status off faculty but doesn't set black list status automatically
	 * because librarian needs to do it manually.
	 */
	public void updateBlackListStatus() {
		if (this.getFeesOwned() < FeeChargeSystem.maxFee ) {
			this.setIsBlackListed(false);
			};
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
