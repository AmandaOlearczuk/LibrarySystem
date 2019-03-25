package Media;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import Actors.Customer;
import Utilities.Queue;
import Utilities.Status;

/**
 * This class contains physical media such as Book, DVD, CD.
 * Each media has title eg. "Key to success" for book, "Titanic" for movie, "Metallica" for music.
 */
public class PhysicalMedia  implements Serializable{

	private static final long serialVersionUID = 2371167415672914845L;
	private String title;
	private Calendar date;
	private Queue lineUp = new Queue();
	private Customer customerInvolved; //customer that owns book or has it on hold
	private Status status = new Status("available"); //Status of media if available,available for hold,reserved,unavailable

	/**
	 * Getters & setters
	 */
	public Customer getCustomer() {
		return customerInvolved;
	}
	
	public void setCustomer(Customer customer) {
		this.customerInvolved = customer;
		
	}
	
	protected void setStatus(Status s) {
		this.status = s;
	}
	public Status getStatus() {
		return status;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Queue getLineUp() {
		return lineUp;
	}

	public void setLineUp(Queue lineUp) {
		this.lineUp = lineUp;
	}
	
	
	/**
	 * Calculates return date based on current date & if media is reserved (2h) or not (2weeks)
	 * @return Calendar - date of return
	 */
	public Calendar calcReturnDate() {
		
		Calendar calendar = Calendar.getInstance(); //current date
		
		if(this.getStatus().getCurrentStatus().equals("reserved")) {// adds 2h
			calendar.add(Calendar.HOUR_OF_DAY, 2); 
		}else { //status is "available" 
			//Get date that's 2 weeks ahead
			int noOfDays = 14; //i.e two weeks
			calendar.setTime(new Date());            
			calendar.add(Calendar.DAY_OF_YEAR, noOfDays);	
		}
		
		return calendar;
	}

	/**
	 * Updates queue if a spot has emptied for book. 
	 */
	public void moveQueue() {
		
		if (this.getLineUp().size()>0) { //If there's a queue for this media
			
			Customer nextCustomer = this.getLineUp().pop(); //remove customer from waiting list
			System.out.println("Customer with ID :" + nextCustomer.getID() + " is on waiting queue for this book");
			this.setCustomer(nextCustomer); //set active customer for the media
			nextCustomer.addMediaOnHold(this); //add media to customer's holds for 1 week from now
								
		} else { //There's no line up for this media, so set customer to null
			
			this.setCustomer(null);
			this.getStatus().setAvailable();
		}
		
	}
	

	

	

	

	
}
