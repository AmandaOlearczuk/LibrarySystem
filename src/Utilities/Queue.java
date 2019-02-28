package Utilities;
import java.util.ArrayList;

import Actors.Customer;

/*
 * Queue implementation using array
*/

public class Queue{
	
	ArrayList<Customer> Q ;
	
	public Queue() {
		this.Q = new ArrayList<Customer>();
	}
	
	/**
	 * Adds customer to end of line
	 * @param c
	 */
	public void addToLine(Customer c) {
		Q.add(c);
	}
	
	/**
	 * Removes first person in line & returns that person. If no person is in line, null returned
	 * @return
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

	public int size() {
		return Q.size();
	}
	
	/**
	 * Prints queue as a nice string
	 */
	public String toString() {
		String s= "\nFront Of Queue : \n";
		for (int i=0;i<Q.size();i++) {
			s = s + Q.get(i).getFirstName() + " " +Q.get(i).getLastName() +"\n";
		}
		s= s + " : Back of Queue\n";
		return s;
		
	}
	
	public Boolean isInLine(Customer c) {
		if (Q.contains(c)) {return true;}else {return false;}
	}
}
