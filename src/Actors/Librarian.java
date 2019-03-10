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

			customer.removeMediaOwned(media); //removes media & updates media status & associated customer
			
			media.moveQueue(); //Possibly take someone from queue to hold the book for 1 week
			
		
	}
	
	/**
	 * This function adds media to customers account or places book on hold for them
	 * @param media
	 * @param currentDate
	 * @param holdOrTake - String that is either "hold" or "take" depends what student wants if book is available now
	 * @return String - message
	 */
	public String addMediaOwned(Customer customer,PhysicalMedia media,String holdOrTake) {
		if (customer.getIsBlackListed() == false && customer.getNumMediaOwned() < customer.getMaxMedia()
				&& !media.getStatus().toString().equals("unavailable")) {
			
			//No one has the media on hold (and obviously no one has it because customer just took it from shelf)
			if (media.getCustomer() == null && media.getLineUp().size() == 0) {
				
				media.setCustomer(customer); //set media to customer that will take it or hold it
								
				if (holdOrTake.equals("take")) {
					Calendar retDate = media.calcReturnDate(); //either 2 wks or 2h
					customer.addMediaOwned(media, retDate); //add media to customer account & ret date
					media.setStatus(new Status("in use")); //set new status to media
									
					return "Media was issued to customer and added to customer's : " + customer.getID() + " account";
				}
				
				if (holdOrTake.equals("hold")) {
					
					customer.addMediaOnHold(media); //add media to customer's holds for 1 week from now
									
					return "Media is put on hold by customer: " + customer.getID();
				}
				
				
			}
			
			//If media is held by some other customer (& there's a possible queue or no queue) AND customer isn't holding same item
			//  multiple times
			else if (media.getCustomer() != null && media.getCustomer() != customer && media.getLineUp().isInLine(customer) == false) {
				
				media.getLineUp().addToLine(customer); //customer added to queue for media			
				
				return "Customer " +  customer.getID() + " was put on queue in position: " + media.getLineUp().size();
				
			}
		
		}
		
		return "Unable to issue a book to the customer: " + customer.getID();
		
	}
	
	/**
	 * This function is for librarian to set faculty blacklisted (allows to do it only if overdue fees are 50.0)
	 * @param faculty
	 */
	public void makeBlackListed(Faculty faculty) {
		if (faculty.getFeesOwned() == 50.0) {faculty.setIsBlackListed(true);}
	}
	
	public String removeFromHoldsToPickup(PhysicalMedia media, Customer customer) {
		return customer.moveFromHoldToOwned(media);
	}
	
	
	
}
