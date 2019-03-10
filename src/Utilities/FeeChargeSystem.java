package Utilities;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Map;

import Actors.Customer;
import Media.PhysicalMedia;

public class FeeChargeSystem implements Serializable{
	
	public static final Double maxFee = 50.0;
	
	/**
	 * This function charges indicated fee
	 * @return Double - amount charged
	 */
	public Double addFee(Double fee , Customer customer) {
		
		Double actualFeeCharged = 0.0;
		
		if(fee + customer.getFeesOwned() >= maxFee) { //Check if fee charged will exceed max amount of charge
			actualFeeCharged = maxFee - customer.getFeesOwned();
			customer.setFeesOwned(maxFee);
		} else { //Fee won't exceed max charge
			customer.setFeesOwned(customer.getFeesOwned() + fee);
			actualFeeCharged = fee;
		}
		return actualFeeCharged;
		
	}
	
	/**
	 * This function clears all fees
	 * @param customer
	 */
	public void clearFees(Customer customer) {
		customer.setFeesOwned(0.0);
	}
	
	/**
	 * This function removes some fee from total fee of customer
	 */
	public Double removeFee(Double fee,Customer customer) {
		Double actualFeeRemoved = 0.0;
		if(customer.getFeesOwned() - fee <= 0.0) { //check if fee tried to be removed sets customer fees to negative
			actualFeeRemoved = customer.getFeesOwned();
			clearFees(customer);
		} else { 
			customer.setFeesOwned(customer.getFeesOwned() - fee);
		}
		
		customer.updateBlackListStatus();
		return actualFeeRemoved;
		
	}
	
	/**
	 * This function calculates all fees that should be applies to student based on scenarios:
	 *   ~book not returned but return date passed -> $5/month 
	 *   ~returned book but fees not paid -> $5/month
	 */
	public void calculateOverdueFees(Customer customer){
		Map<PhysicalMedia,Calendar> media = customer.getMediaOwned();
		
		//Get current date day/month/year
		Calendar currentDate = Calendar.getInstance();
		int day = currentDate.get(Calendar.DAY_OF_MONTH);
		int month = currentDate.get(Calendar.MONTH);
		String strMonth = new DateFormatSymbols().getMonths()[month-1];
		int year = currentDate.get(Calendar.YEAR);
		
		for (Map.Entry<PhysicalMedia, Calendar> entry : media.entrySet()){
			//Date date = entry.getValue();
			
			//TODO
			
		}
			
		}
		
	
}

