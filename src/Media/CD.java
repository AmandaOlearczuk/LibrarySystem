package Media;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Utilities.Status;

//import Utilities.Date;
/**
 * This class is for dealing with CD's in library
 *
 */
public class CD extends PhysicalMedia {
	
	private ArrayList<String> composers;
	
	/**
	 * Constructor that sets title,composer/s of CD and year of release
	 */
	public CD(String title, ArrayList<String> composers, Calendar date,Status status) {
		
		super.setTitle(title);
		super.setDate(date);
		super.setStatus(status);
		this.setComposers(composers);
	}
	
	public ArrayList<String> getComposers() {
		return composers;
	}

	public void setComposers(ArrayList<String> composers) {
		this.composers = composers;
	}
	
	public void addComposer(String c ) {
		this.composers.add(c);
	}
	
	public String toString() {
		String c = String.join(", ", this.getComposers());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.getDate().getTime());
		return "CD Title: " + "'" + super.getTitle() + "'" + " | CD composer/s: " + c +" | Date: " + formatted 
				+  " | Status: " + this.getStatus() + " ";
	}

}
