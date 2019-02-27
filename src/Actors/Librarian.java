package Actors;

import java.util.Calendar;

import Media.PhysicalMedia;
import Utilities.*;


public class Librarian {

	private String ID;
	private String FirstName;
	private String LastName;
	private Calendar birthDate;
	private Address Address;
	private String phoneNumber;
	
	/**
	 * Constructor
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param address
	 * @param phoneNumber
	 */
	public Librarian(String iD, String firstName, String lastName, Calendar birthDate, Utilities.Address address,
			String phoneNumber) {
		super();
		ID = iD;
		FirstName = firstName;
		LastName = lastName;
		this.birthDate = birthDate;
		Address = address;
		this.phoneNumber = phoneNumber;
	}


	/**
	 * Getters & setters
	 */
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


	/**
	 * This function returns media for customer
	 * @param media
	 * @param customer
	 */
	public void returnMedia(PhysicalMedia media , Customer customer) {

			customer.removeMediaOwned(media);

	}
	
	/**
	 * This function adds media to customers account or places book on hold for them
	 * @param media
	 * @param currentDate
	 * @param holdOrTake - String that is either "hold" or "take" depends what student wants if book is available now
	 */
	public void addMediaOwned(Customer customer,PhysicalMedia media,String holdOrTake) {
		if (customer.getIsBlackListed() == false && customer.getNumMediaOwned() < customer.getMaxMedia()
				&& !media.getStatus().toString().equals("unavailable")) {
			
			//No one has the media on hold (and obviously no one has it because customer just took it from shelf)
			if (media.getCustomer() == null && media.getLineUp().size() == 0) {
				
				media.setCustomer(customer); //set media to customer that will take it or hold it
				
				if (holdOrTake.equals("take")) {
					Calendar retDate = media.calcReturnDate(); //either 2 wks or 2h
					customer.addMediaOwned(media, retDate); //add media to customer account & ret date
					media.setStatus(new Status("in use")); //set new status to media
				}
				
				if (holdOrTake.equals("hold")) {
					Calendar now = Calendar.getInstance();
					Calendar oneWeekFromNow = Calendar.getInstance();
					oneWeekFromNow.add(Calendar.DAY_OF_YEAR, 7);	
					CalendarPeriod calendarP = new CalendarPeriod(now,oneWeekFromNow);
					customer.addMediaOnHold(media, calendarP); //add media to customer's holds & period
					media.setStatus(new Status("in use"));
				}
				
			}
			
			//If media is held by some other customer (& there's a possible queue or no queue)
			else if (media.getCustomer() != null) {
				
				media.getLineUp().addToLine(customer); //customer added to queue for media

			}
			
		}
		
	}
	
	/**
	 * This function is for librarian to set faculty blacklisted (allows to do it only if overdue fees are 50.0)
	 * @param faculty
	 */
	public void makeBlackListed(Faculty faculty) {
		if (faculty.getFeesOwned() == 50.0) {faculty.setIsBlackListed(true);}
	}
	
	
	
}
