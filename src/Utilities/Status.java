package Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class deals with status of physical media - available, not available, available for hold, reserved
 *
 */
public class Status implements Serializable {

	private ArrayList<String> statuses;
	private String currentStatus;
	private String primaryStatus;
	
	/**
	 * Constructor
	 * @param s - status
	 */
	public Status(String s) {
		statuses = new ArrayList<String>(Arrays.asList("available","unavailable","reserved","in use"));
		setCurrentStatus(s);
		setPrimaryStatus(s);
		
	}
	
	/**
	 * Getters & setters
	 */
	
	public String getCurrentStatus() {
		return this.currentStatus;
	}
	
	private void setCurrentStatus(String s) {
		if (statuses.indexOf(s) != (-1)) {
			this.currentStatus = s; //if status set is correct
	    }else {
	    	this.currentStatus = statuses.get(1); //status = unavailable by default 
	    	} 
	}
	
	private void setPrimaryStatus(String status) {
		this.primaryStatus = status;
	}
	/**
	 * sets status to "in use"
	 */
	public void setInUse() 
	{
		this.setCurrentStatus("in use");
	}
	
	public void setAvailable() 
	{
		this.setCurrentStatus(primaryStatus);
	}
	
	public void setReserved() 
	{
		this.setPrimaryStatus("reserved");
		if ( !this.getCurrentStatus().equals("in use") ){
			this.setCurrentStatus("reserved");
		}
	}
	
	public String toString() {
		return this.currentStatus;
	}

}
