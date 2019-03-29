package DataStorage;
import Actors.Customer;
public class Order {
	private Customer whoOrdered;
	private String mediaType;
	private String name;
	private String creator;
	private String year;
	private String month;
	private String day;
	
		
	public Order (Customer who, String med, String n, String c, String y, String m, String d) {
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
	public String showOrder() {
		return "User: " + whoOrdered.getFirstName() + " " + whoOrdered.getLastName() + " with ID: " + 
	              whoOrdered.getID() + " ordered " + mediaType + " " + name + " by: " + 
				    creator + " released on: " + day + "-" + month + "-" + year + "\n";
	}

}
