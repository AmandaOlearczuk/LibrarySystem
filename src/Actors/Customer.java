package Actors;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import Media.PhysicalMedia;
import Utilities.*;

/**
 * This class is responsible for keeping information about a customer
 */

public class Customer implements Serializable {

	private static final long serialVersionUID = -8857768574176880879L;
	private String ID;
	private String FirstName;
	private String LastName;
	private Calendar birthDate;
	private Address Address;
	private String password;

	private Map<PhysicalMedia, Calendar> mediaOwned; //should be returned on date
	private Map<PhysicalMedia,CalendarPeriod> mediaOnHold; //held from: to: , is filtered to remove expired holds with each load/store in Database class.
	private String phoneNumber;
	private Double feesOwned;
	private Boolean IsBlackListed;


	/**
	 * Constructor
	 */
	public Customer(String id,String fn,String ln,Calendar bd, Address address,String phonenum,
			Map<PhysicalMedia, Calendar> mediaOwned,Map<PhysicalMedia, CalendarPeriod> mediaOnHold,
			Map<PhysicalMedia, Calendar> mediaReturned,Double feesOwned) {
		this.ID = id;
		this.FirstName =fn;
		this.LastName = ln;
		this.birthDate = bd;
		this.Address = address;
		this.phoneNumber = phonenum;
		this.password = fn+ln;
		
		if (mediaOwned == null) {this.mediaOwned = new HashMap<PhysicalMedia,Calendar>();}
		else {this.mediaOwned = mediaOwned;}
		
		if (mediaOnHold == null) {this.mediaOnHold = new HashMap<PhysicalMedia,CalendarPeriod>();}
		else {this.mediaOnHold = mediaOnHold;}

		this.setFeesOwned(feesOwned);
		
		if(feesOwned >= 50.0) {this.setIsBlackListed(true);}else {this.setIsBlackListed(false);}
		
		
		
	}
	
	/**Getters & setters*/
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String temp) {
		this.password = temp;
	}
	public String getID() {
		return this.ID;
	}
	
	public Boolean getIsBlackListed() {
		return this.IsBlackListed;
	}
	
	
	public Double getFeesOwned() {
		return this.feesOwned;
	}
	
	public void setIsBlackListed(Boolean b) {
		this.IsBlackListed = b;
	}
	
	/**
	 * Owned fee must be in range 0.0-50.0
	 * @param fees - Double which is a fee to be set
	 */
	public void setFeesOwned(Double fees) {
		if(fees <= 50.0 && fees >= 0.0) {this.feesOwned = fees;}
		else {this.feesOwned = 0.0;}
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Calendar getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Calendar bd) {
		this.birthDate = bd;
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}

	public Map<PhysicalMedia,Calendar> getMediaOwned() {
		return mediaOwned;
	}
	public Map<PhysicalMedia, CalendarPeriod> getMediaOnHold() {
		return mediaOnHold;
	}

	public void setMediaOwned(Map<PhysicalMedia,Calendar> mediaOwned) {
		this.mediaOwned = mediaOwned;
	}
	
	public void addMediaOwned(PhysicalMedia media,Calendar d) {
		this.mediaOwned.put(media,d);
		
	}

	/**
	 * Removed media from customer's account (media owned array).
	 * Postcondition : Sets status of media to available, media's customer is set to null, 
	 * @param media - media to be removed
	 */
	public void removeMediaOwned(PhysicalMedia media) {

		media.setCustomer(null);
		media.getStatus().setAvailable();
		
		mediaOwned.remove(media);	
		
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * This function prints customer as a string
	 * @return String - string with a nice format
	 */
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.getBirthDate().getTime());
		return "Name: " + this.getFirstName() + " " + this.getLastName() + " | Birthdate: " 
	+ formatted + " | Address:  " + this.getAddress().toString()
	+ " | Phone #: " + this.getPhoneNumber() + " | Fees Owned: " + this.getFeesOwned() + " | Black Listed: "
	+ Boolean.toString(this.IsBlackListed) + this.showMedia();
	}
	
	/**
	 * This function prints current media involved with a person
	 * @return String - media owned and on hold
	 */
	public String showMedia() {
		
		return "\nOwned media : \n" + this.showMediaOwned() + "\nMedia on hold: \n" + this.showMediaOnHold();
	}
	
	/**
	 * This function returns a string with a nice format for printing the information about media owned
	 * @return String - nice format 
	 */
	public String showMediaOwned() {
		String owned = "";
		//Media owned
			if (this.mediaOwned.size() != 0 ) {
				for(Map.Entry<PhysicalMedia, Calendar> e : mediaOwned.entrySet())
				{
					owned = owned + (e.getKey().toString() +" ; Return Date: "+e.getValue().getTime()) + "\n";
				}
			} else {
				owned = "No media is owned by " + this.FirstName + " " + this.LastName;
			}
		return owned;
	}
	
	/**
	 * This function returns a string with a nice format for printing the information about media on hold
	 * @return String - nice format 
	 */
	public String showMediaOnHold() {
		String onHold = "";
		//Media on hold
		if (this.mediaOnHold.size() != 0 ) {
			for(Map.Entry<PhysicalMedia, CalendarPeriod> e : mediaOnHold.entrySet())
			{
				onHold = onHold + (e.getKey().toString() +" ; Hold from : "+e.getValue().getFrom().getTime()
						+" Hold until : "+ e.getValue().getTo().getTime() + "\n");
			}
		} else {
			onHold = "No media is hold by " + this.FirstName + " " + this.LastName;
		}
		return onHold;
		
	}
	

	/**
	 * Does nothing - is here so the children can overload it
	 */
	public void updateBlackListStatus() {

    }

	/**
	 * This function counts number of media currently in possession of a customer
	 * @return int - num of media owned
	 */
	public int getNumMediaOwned() {
		
		return this.getMediaOwned().size();
	}

	/**
	 * Does nothing. Is an overridden method by children classes
	 * @return int 
	 */
	public int getMaxMedia() {
		
		return 0;
	}

	
	/**
	 * Adds media for customer with date one week from now
	 * @param media - media to be added
	 */
	public void addMediaOnHold(PhysicalMedia media) {
		
		if (this.getIsBlackListed() == false) {
			Calendar now = Calendar.getInstance();
			Calendar oneWeekFromNow = Calculations.getOneWeekFrom(now);
		
			CalendarPeriod calendarP = new CalendarPeriod(Calendar.getInstance(),oneWeekFromNow);
			this.getMediaOnHold().put(media, calendarP); //add media to customer's holds & period
			media.getStatus().setInUse();
			media.setCustomer(this);
		}
	}
	
	/** 
	 * Move media from hold to owned items
	 * Precondition: media is on hold list
	 * @param media - media to be moved
	 * @return String - message to display
	 */
	public String moveFromHoldToOwned(PhysicalMedia media) {
		
		//Here, it will make sure customer doesn't own max num of media already, is not blacklisted, and media statuses and active customer will be all changed. 
		
		if(this.getIsBlackListed() == true) {
			return "Customer is blacklisted";
		}
		else if(this.getMediaOwned().size() >= this.getMaxMedia()) { //If customer has 5 media already..
			return "Customer can't borrow any more media";
		} else {
			this.addMediaOwned(media, media.calcReturnDate());
			this.removeMediaFromHold(media);
		}
		
		return "Customer was issued the media";
		
	}
	
	/**
	 * Removes media from hold but doesn't do any condition checking.
	 * Used for moveFromHoldToOwned() function in this class.
	 * @param media - media to be removed
	 */
	private void removeMediaFromHold(PhysicalMedia media) {
		
		for(Map.Entry<PhysicalMedia, CalendarPeriod> entry : mediaOnHold.entrySet())
		{
			if (entry.getKey() == media) {
				
				mediaOnHold.entrySet().remove(entry);
			}
		}
	}
	


	/**
	 * Removes expired holds from user's account & moves queue if there is one
	 */
	public void removeExpiredHolds() {
		for (Map.Entry<PhysicalMedia, CalendarPeriod> entry : this.getMediaOnHold().entrySet())
		{
		    Calendar heldUntil = entry.getValue().getTo();
		    if(Calculations.checkExpired(heldUntil)) {
		    	entry.getKey().moveQueue();
		    	this.getMediaOnHold().remove(entry.getKey());
		    	
		    }
		}
		
		
	}
	

}

	
	
	
	
	
	

