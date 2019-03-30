package DataStorage;
import java.io.Serializable;

import Actors.Customer;
/**
 * This class is for order requests made by the customer
 *
 */
public class OrderRequest implements Serializable{

	private static final long serialVersionUID = -6492255713793560312L;
	private Customer whoOrdered;
	private String mediaType;
	private String name;
	private String creator;

	/**
	 * Constructor
	 * @param who
	 * @param med
	 * @param n
	 * @param c
	 */
	public OrderRequest(Customer who, String med, String n, String c) {
		this.whoOrdered = who;
		this.mediaType = med;
		this.name = n;
		this.creator = c;

	}
	
	/**
	 * Shows order request
	 * @return - returns a String with the information about the media Request
	 */
	public String ShowOrderRequest() {
		return "User: " + whoOrdered.getFirstName() + " " + whoOrdered.getLastName() + " with ID: " + 
	              whoOrdered.getID() + " ordered " + mediaType + " " + name + " by: " + creator;
	}

}
