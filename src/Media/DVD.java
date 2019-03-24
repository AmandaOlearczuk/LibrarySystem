package Media;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import Utilities.Status;

/**
 * This class deals with the DVD
 */

public class DVD extends PhysicalMedia{
	
	private ArrayList<String> directors;
	
	/**
	 * Constructor
	 */
	
	public DVD(String title, ArrayList<String> directors,Calendar date,Status status) {
		super.setTitle(title);
		super.setDate(date);
		super.setStatus(status);
		this.setDirectors(directors);
		
	}
	
	/**
	 * getters & setters
	 */
	public ArrayList<String> getDirectors() {
		return directors;
	}
	
	public void setDirectors(ArrayList<String> directors) {
		this.directors = directors;
	}
	
	/**
	 * Used to print DVD in a nice format
	 * @return String - nice format
	 */
	public String toString() {
		String d = String.join(", ", this.getDirectors());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.getDate().getTime());
		return "DVD Title: " + "'" + super.getTitle() + "'" + " | DVD director/s: " +d + " | Date: " 
				+ formatted + " | Status: " + this.getStatus() + " ";
	}
}


