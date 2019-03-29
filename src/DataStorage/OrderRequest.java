package DataStorage;
import Actors.Customer;

public class OrderRequest {
	private Customer whoOrdered;
	private String mediaType;
	private String name;
	private String creator;

	
	public OrderRequest(Customer who, String med, String n, String c) {
		this.whoOrdered = who;
		this.mediaType = med;
		this.name = n;
		this.creator = c;

	}
	
	public String ShowOrderRequest() {
		return "User: " + whoOrdered.getFirstName() + " " + whoOrdered.getLastName() + " with ID: " + 
	              whoOrdered.getID() + " ordered " + mediaType + " " + name + " by: " + creator;
	}

}
