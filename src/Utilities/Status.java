package Utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class deals with status of physical media - available, not available, available for hold, reserved
 *
 */
public class Status implements Serializable {

	private static final long serialVersionUID = -4282712274151844233L;
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
	
	/**
	 * This function sets current status to desired
	 * @param s - a status as a String
	 */
	public void setCurrentStatus(String s) {
		if (statuses.indexOf(s) != (-1)) 
		{
			this.currentStatus = s; //if status set is correct
		}
	}
	
	public void setPrimaryStatus(String status) {
		this.primaryStatus = status;
	}
	
	public String getPrimaryStatus() {
		return primaryStatus;
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
