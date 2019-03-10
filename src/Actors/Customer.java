package Actors;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import Media.PhysicalMedia;
import Utilities.*;


/**
 * Constructor
 *
 */
public class Customer implements Serializable {
	private String ID;
	private String FirstName;
	private String LastName;
	private Calendar birthDate;
	private Address Address;

	private Map<PhysicalMedia, Calendar> mediaOwned; //should be returned on date
	private Map<PhysicalMedia,Calendar> mediaReturned; //returned on date
	private Map<PhysicalMedia,CalendarPeriod> mediaOnHold; //held from: to:
	private String phoneNumber;
	private Double feesOwned;
	private Boolean IsBlackListed;


	public Customer(String id,String fn,String ln,Calendar bd, Address address,String phonenum,
			Map<PhysicalMedia, Calendar> mediaOwned,Map<PhysicalMedia, CalendarPeriod> mediaonHold,
			Map<PhysicalMedia, Calendar> mediaReturned,Double feesOwned) {
		this.ID = id;
		this.FirstName =fn;
		this.LastName = ln;
		this.birthDate = bd;
		this.Address = address;
		this.phoneNumber = phonenum;
		
		if (mediaOwned == null) {this.mediaOwned = new HashMap<PhysicalMedia,Calendar>();}
		else {this.mediaOwned = mediaOwned;}
		
		if (mediaOnHold == null) {this.mediaOnHold = new HashMap<PhysicalMedia,CalendarPeriod>();}
		else {this.mediaOnHold = mediaOnHold;}
		
		if (mediaReturned == null) {this.mediaReturned = new HashMap<PhysicalMedia,Calendar>();}
		else {this.mediaReturned = mediaReturned;}
		
		this.setFeesOwned(feesOwned);
		
		if(feesOwned >= 50.0) {this.setIsBlackListed(true);}else {this.setIsBlackListed(false);}
		
		
		
	}
	
	/**Getters & setters*/
	public String getID() {
		return this.ID;
	}
	
	public void setIsBlackListed(Boolean b) {
		this.IsBlackListed = b;
	}
	
	public Boolean getIsBlackListed() {
		return this.IsBlackListed;
	}
	
	
	public Double getFeesOwned() {
		return this.feesOwned;
	}
	
	/**
	 * Owned fee must be in range 0.0-50.0
	 * @param fees
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
	public Map<PhysicalMedia,Calendar> getMediaReturned() {
		return mediaReturned;
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
	 * @param media
	 */
	public void removeMediaOwned(PhysicalMedia media) {

		media.setCustomer(null);
		media.getStatus().setStatus("available");
		
		mediaOwned.remove(media);	
		
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
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
	 * @return String - media owned
	 */
	public String showMedia() {
		
		return "\nOwned media : \n" + this.showMediaOwned() + "\nMedia on hold: \n" + this.showMediaOnHold()
		+ "\nReturned media: \n" + this.showMediaReturned();
	}
	
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
	
	public String showMediaReturned() {
		String returned = "";
		
		//Media returned
		if (this.mediaReturned.size() != 0 ) {
			for(Map.Entry<PhysicalMedia, Calendar> e : mediaReturned.entrySet())
			{
				returned = returned + (e.getKey().toString() +" ; Returned on : "+e.getValue().getTime()) + "\n";
			}
		} else {
			returned = "No media was returned by " + this.FirstName + " " + this.LastName;
		}
		return returned;
	}

	/**
	 * Does nothing - is here just for customer.updateBlackListStatus() function that's needed for FeeChargeSystem
	 */
	public void updateBlackListStatus() {

	}

	/**
	 * This function counts number of media currently in possession of a customer
	 * @return
	 */
	public int getNumMediaOwned() {
		
		return this.getMediaOwned().size();
	}

	/**
	 * Does nothing. Is an overridden method by children classes
	 * @return
	 */
	public int getMaxMedia() {
		
		return 0;
	}

	
	/**
	 * Adds media for customer with date one week from now
	 * @param media
	 */
	public void addMediaOnHold(PhysicalMedia media) {
		
		if (this.getIsBlackListed() == false) {
			Calendar now = Calendar.getInstance();
			Calendar oneWeekFromNow = Calculations.getOneWeekFrom(now);
		
			CalendarPeriod calendarP = new CalendarPeriod(now,oneWeekFromNow);
			this.getMediaOnHold().put(media, calendarP); //add media to customer's holds & period
			media.setStatus(new Status("in use"));
			media.setCustomer(this);
		}
	}
	
	
	/** TODO
	 * Move media from hold to owned items
	 * Precondition: media is on hold list
	 */
	public String moveFromHoldToOwned(PhysicalMedia media) {
		return "Not implemented yet";
		//Here, it will make sure customer doeen't own max num of media already, is not blacklisted, and media statuses and active customer will be all changed. 
		//TODO
	}


	/**
	 * Removes expired holds from user's account
	 */
	public void removeExpiredHolds() {
		//TODO
	}
	

	
	
	
	
	
	
}
