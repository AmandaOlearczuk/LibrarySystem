package Utilities;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class deals with status of physical media - available, not available, available for hold, reserved
 *
 */
public class Status {

	private ArrayList<String> statuses;
	private String status;
	
	/**
	 * Constructor
	 * @param s - status
	 */
	public Status(String s) {
		statuses = new ArrayList<String>(Arrays.asList("available","unavailable","reserved","in use"));
		setStatus(s);
		
	}
	
	/**
	 * Getters & setters
	 */
	
	public void setStatus(String s) {
		if (statuses.indexOf(s) != (-1)) {
			this.status = s; //if status set is correct
	    }else {
	    	this.status = statuses.get(1); //status = unavailable by default 
	    	} 
	}
	
	
	
	public String toString() {
		return this.status;
	}

}
