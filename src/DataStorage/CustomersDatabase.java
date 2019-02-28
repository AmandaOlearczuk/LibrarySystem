package DataStorage;

import java.util.ArrayList;
import java.util.Calendar;

import Actors.Customer;
import Actors.Student;
import Utilities.Address;

public class CustomersDatabase {

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	/**
	 * Getters & setters
	 * @return
	 */
	public ArrayList<Customer> getCustomers(){
		return this.customers;
	}
	
	/**
	 * Load customers from file
	 */
	public void loadCustomers() {
		//TODO
		
		//Create 2 customers - load from file tho!! this is just an example
		Calendar johnBirthDate = Calendar.getInstance();
		johnBirthDate.set(1997,4,17);
		Student JohnSmith = new Student("101","John" , "Smith" , johnBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 10.0);
				//Note:Blacklist status is based only on fees only so need to specify it.
		
		Calendar annBirthDate = Calendar.getInstance();
		johnBirthDate.set(1995,2,22);
		Student AnnLis = new Student("102","Ann" , "Lis" , annBirthDate,new Address 
				(100,"st king street","t2y444","calgary","canada"),"4038724555", null,null,null, 40.0);
		
		customers.add(JohnSmith);
		customers.add(AnnLis);
	}
	
	/**
	 * Store customers to file
	 */
	public void storeCustomers() {
		//TODO
	}

	/**
	 * This function searches customer by ID and returns that object
	 * @param text
	 * @return
	 */
	public Customer searchByID(String text) {
		Customer c ;
		
		for (int i = 0 ; i<customers.size();i++) {
			if (customers.get(i).getID().equals(text)) {
				c = customers.get(i);
				return c;
			}
		}
		
		return null;
	}
}
