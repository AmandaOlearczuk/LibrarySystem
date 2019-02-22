package Utilities;

public class Address {
	private int houseNum; //house or appt num
	private String streetName;
	private String zip;
	private String city;
	private String country;
	
	/**
	 * Constructor
	 * @param houseNum
	 * @param streetName
	 * @param city
	 * @param country
	 */
	public Address(int houseNum, String streetName, String zip,String city, String country) {
		super();
		this.houseNum = houseNum;
		this.streetName = streetName;
		this.zip = zip;
		this.city = city;
		this.country = country;
	}
	public String getZip() {
		return this.zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return "House Num: " + Integer.toString(this.getHouseNum()) + " Street: " + this.getStreetName() 
		+ " ZIP: " + this.getZip() + " City: " + this.getCity() + " Country: " + this.getCountry();
	}
}
