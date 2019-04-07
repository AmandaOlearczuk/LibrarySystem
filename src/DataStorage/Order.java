package DataStorage;
import java.io.Serializable;
import java.util.Calendar;

import Actors.Librarian;
/**
 * This class deals with librarian's orders
 *
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 4728281715777434870L;
	private Librarian whoOrdered;
	private String mediaType;
	private String name;
	private String creator;
	private String year;
	private String month;
	private String day;
	
	/**
	 * Getters and Setters
	 */
	public String getType() {
		return this.mediaType;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAuthor() {
		return this.creator;
	}
	
	public Calendar getDate() {
		Calendar mediaDate = Calendar.getInstance();
		int y = 2000;
		int m = 1;
		int d = 1;
		try {
			y = Integer.parseInt(this.year);
			m = Integer.parseInt(this.month);
			d = Integer.parseInt(this.day);
			
		} catch (NumberFormatException e) {
			System.out.println("Error - format incorrect");
		}
		
		mediaDate.set(y, m, d);
		return mediaDate;
	}
	
	/**
	 * Constructor
	 */
	public Order (Librarian who, String med, String n, String c, String y, String m, String d) {
		this.whoOrdered = who;
		this.mediaType = med;
		this.name = n;
		this.creator = c;
		this.year = y;
		this.month = m;
		this.day = d;
		
	}
	
	/**
	 * 
	 * @return String - order in a nice format
	 */
	public String toString() {
		return "User: " + whoOrdered.getFirstName() + " " + whoOrdered.getLastName() + " with ID: " + 
	              whoOrdered.getID() + " ordered " + mediaType + " " + name + " by: " + 
				    creator + " released on: " + day + "-" + month + "-" + year + "\n";
	}

}
