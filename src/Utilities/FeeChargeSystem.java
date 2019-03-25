package Utilities;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Map;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import Actors.Customer;
import Media.PhysicalMedia;

/**
 * This class is responsible for charging customer's fees. It has functions that can add a specific fee,
 *  remove a specific fee and also calculate total fees based on the return dates for customer's owned media.
 * @author Group 10 
 *
 */
public class FeeChargeSystem implements Serializable{
	
	private static final long serialVersionUID = 6242319529747964641L;
	public static final Double maxFee = 50.0;
	
	/**
	 * This function charges indicated fee
	 * @param fee - Double which is an amount we want to charge
	 * @param customer - Customer that we want to charge a fee
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
	 * @param fee - Double which is an amount we want to remove
	 * @param customer - Customer of which we want to remove the fee
	 * @return Double - fee that has been removed
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
	 * This function calculates all fees that should be applied to customer.
	 * $5/month per each media if the return date passed.
	 *   *Note : It does not take into account the time. 
	 * @param customer - Customer whose fees we want to calculate
	 * @return Double - fees that have been added
	 */
	public Double calculateAndApplyOverdueFees(Customer customer){
		
		Map<PhysicalMedia,Calendar> media = customer.getMediaOwned();
		
		//Get current date 
		Calendar currentDate = Calendar.getInstance(); //(Month range is 0-11 in Calendar)
		//Convert to local date, including time (Month range is 1-12 in LocalDate)
		LocalDate now = LocalDate.of(currentDate.get(Calendar.YEAR),
				currentDate.get(Calendar.MONTH)+1,currentDate.get(Calendar.DAY_OF_MONTH));
		now.atTime(currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), currentDate.get(Calendar.SECOND));
		
		Double totalFees = 0.0;
		
		//Iterate over customer's media
		for (Map.Entry<PhysicalMedia, Calendar> entry : media.entrySet()){
			
			//Get return date for iterated media & convert to localDate
			Calendar mediaRetDate = entry.getValue();
			LocalDate mediaDate = LocalDate.of(mediaRetDate.get(Calendar.YEAR),
					mediaRetDate.get(Calendar.MONTH)+1,mediaRetDate.get(Calendar.DAY_OF_MONTH));
			mediaDate.atTime(mediaRetDate.get(Calendar.HOUR_OF_DAY), mediaRetDate.get(Calendar.MINUTE), 
					mediaRetDate.get(Calendar.SECOND));
			
			long monthsBetween = Math.abs(ChronoUnit.MONTHS.between(now,mediaDate));
			this.addFee(monthsBetween*(5.0),customer);
			totalFees = totalFees + (monthsBetween*(5.0));
			
		}
		  
		return totalFees;
			
	}
		
	
}

