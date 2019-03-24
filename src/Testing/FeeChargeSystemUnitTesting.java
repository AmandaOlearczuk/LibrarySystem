package Testing;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Actors.Customer;
import Actors.Student;
import Media.CD;
import Utilities.Address;
import Utilities.FeeChargeSystem;
import Utilities.Status;

public class FeeChargeSystemUnitTesting {

	@Test
	public void chargeTwentyDollars(){
		
		//Initialization
		Calendar johnBirthDate = Calendar.getInstance();
		johnBirthDate.set(1997,4,17);
		Student JohnSmith = new Student("101","John" , "Smith" , johnBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 0.0);
		
		//Create metallica CD
				ArrayList<String> metallicaComposers = new ArrayList<String>();
				metallicaComposers.add("Metallica");
				Calendar metallicaDate = Calendar.getInstance();
				metallicaDate.set(1988,7,25);
				CD metallica = new CD("...And Justice For All",metallicaComposers, metallicaDate,new Status("available"));
				
		//Create Queen CD
		ArrayList<String> theGameComposers = new ArrayList<String>();
		theGameComposers.add("Queen");
		Calendar theGameDate = Calendar.getInstance();
		theGameDate.set(1980,06,30);
		CD theGameCd = new CD("The Game",theGameComposers,theGameDate,new Status("available"));
		
		//Generate return date : January 20th, 2019.
		Calendar mediaRetDate = Calendar.getInstance();
		mediaRetDate.set(2019, Calendar.JANUARY, 20);
		LocalDate mediaDate = LocalDate.of(mediaRetDate.get(Calendar.YEAR),
				mediaRetDate.get(Calendar.MONTH)+1,mediaRetDate.get(Calendar.DAY_OF_MONTH));
		mediaDate.atTime(mediaRetDate.get(Calendar.HOUR_OF_DAY), mediaRetDate.get(Calendar.MINUTE), 
				mediaRetDate.get(Calendar.SECOND));	
		
		//Add media to John's account with that expired date of one month
		JohnSmith.addMediaOwned(metallica, mediaRetDate);
		JohnSmith.addMediaOwned(theGameCd,mediaRetDate);
		
		FeeChargeSystem s = new FeeChargeSystem();
		Double totFees = s.calculateAndApplyOverdueFees(JohnSmith);
		
		//Comparison
		Assert.assertTrue((JohnSmith.getFeesOwned()).equals(20.0));
		
		
	}
}
