package Utilities;

import java.io.Serializable;
/**
 * This class contains information about address
 *
 */
public class Address  implements Serializable{

	private static final long serialVersionUID = -2078405323208062870L;
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
	
	/**
	 * getters & setters
	 */
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
	
	/**
	 * Generates string to show address nicely
	 * @retun String - a nice format for address
	 */
	public String toString() {
		return "House Num: " + Integer.toString(this.getHouseNum()) + " Street: " + this.getStreetName() 
		+ " ZIP: " + this.getZip() + " City: " + this.getCity() + " Country: " + this.getCountry();
	}
}
