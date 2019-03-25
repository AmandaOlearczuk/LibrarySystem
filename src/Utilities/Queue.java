package Utilities;
import java.io.Serializable;
import java.util.ArrayList;

import Actors.Customer;

/**
 * Queue implementation using array
*/

public class Queue implements Serializable{
	
	private static final long serialVersionUID = -2939228882897825556L;
	ArrayList<Customer> Q ;
	
	/**
	 * Constructor
	 */
	public Queue() {
		this.Q = new ArrayList<Customer>();
	}
	
	/**
	 * Adds customer to end of line
	 * @param c -  Customer to be added to line
	 */
	public void addToLine(Customer c) {
		Q.add(c);
	}
	
	/**
	 * Removes first person in line & returns that person. If no person is in line, null returned
	 * @return Customer - customer removed from front of the line
	 */
	public Customer pop() {
		if(Q.size() == 0) {
			return null;
		}else {
			Customer popped = Q.get(0);
			Q.remove(0);
			return popped;
		}
	}

	/**
	 * Returns size of queue
	 * @return int - size of queue
	 */
	public int size() {
		return Q.size();
	}
	
	/**
	 * Returns String 
	 * @return String - nice format for queue 
	 */
	public String toString() {
		String s= "\nFront Of Queue : \n";
		for (int i=0;i<Q.size();i++) {
			s = s + Q.get(i).getFirstName() + " " +Q.get(i).getLastName() +"\n";
		}
		s= s + " : Back of Queue\n";
		return s;
		
	}
	
	/**
	 * Checks if customer is in line
	 * @param c - Customer to check
	 * @return Boolean - depending if customer is in line
	 */
	public Boolean isInLine(Customer c) {
		if (Q.contains(c)) {return true;}else {return false;}
	}
}
