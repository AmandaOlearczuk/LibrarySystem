package Media;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Utilities.Status;

/**
 * This class is for dealing with CD's in library
 *
 */
public class CD extends PhysicalMedia {
	
	private static final long serialVersionUID = -3172051425845331509L;
	private ArrayList<String> composers;
	
	/**
	 * Constructor
	 */
	public CD(String title, ArrayList<String> composers, Calendar date,Status status) {
		
		super.setTitle(title);
		super.setDate(date);
		super.setStatus(status);
		this.setComposers(composers);
	}
	
	/**
	 * getters & setters
	 */
	public ArrayList<String> getComposers() {
		return composers;
	}

	public void setComposers(ArrayList<String> composers) {
		this.composers = composers;
	}
	
	public void addComposer(String c ) {
		this.composers.add(c);
	}
	
	/**
	 * Prints CD in a nice format
	 * @return String - nice format
	 */
	public String toString() {
		String owner = "None";
		if (this.getStatus().getCurrentStatus().equals("in use"))
			owner = this.getCustomer().getID();
		String c = String.join(", ", this.getComposers());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.getDate().getTime());
		return "CD Title: " + "'" + super.getTitle() + "'" + " | CD composer/s: " + c +" | Date: " + formatted 
				+  " | Status: " + this.getStatus() + " " + " | Owner: " + owner + " ";
	}

}
