package DataStorage;

public class Order {
	private String whoOrdered;
	private String mediaType;
	private String name;
	private String creator;
	private String year;
	private String month;
	private String day;
	
		
	public Order (String who, String med, String n, String c, String y, String m, String d) {
		this.whoOrdered = who;
		this.mediaType = med;
		this.name = n;
		this.creator = c;
		this.year = y;
		this.month = m;
		this.day = d;
		
	}
	
	public String showOrder() {
		return "User " + whoOrdered + " ordered " + mediaType + " " + name + " by: " + creator + " released on: " + day + "-" + month + "-" + year + "\n";
	}

}
