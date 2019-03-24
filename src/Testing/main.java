package Testing;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import Actors.Librarian;
import Actors.Student;
import Media.*;
import DataStorage.Database;
import Utilities.*;
/**
 * Class for testing various things about library system
 *
 */
public class main {

	public static void main(String[] args) {
			
		//Create customer
		Calendar johnBirthDate = Calendar.getInstance();
		johnBirthDate.set(1997,4,17);
		Student JohnSmith = new Student("101","John" , "Smith" , johnBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 10.0);
		
		//Create metallica CD
		ArrayList<String> metallicaComposers = new ArrayList<String>();
		metallicaComposers.add("Metallica");
		Calendar metallicaDate = Calendar.getInstance();
		metallicaDate.set(1988,7,25);
		CD metallica = new CD("...And Justice For All",metallicaComposers, metallicaDate,new Status("available"));
				
		//Custom return date
		Calendar retDate = Calendar.getInstance();
	    retDate.set(Calendar.HOUR_OF_DAY, 12);
		retDate.set(Calendar.MINUTE, 40);
		retDate.set(Calendar.SECOND, 0);
		retDate.set(Calendar.MILLISECOND, 0);
		
		//JohnSmith.addMediaOnHold(metallica,retDate); //adds it with date one week from now
		
		System.out.println(JohnSmith.showMediaOnHold());
		
		JohnSmith.removeExpiredHolds();
		
		System.out.println(JohnSmith.showMediaOnHold());
		
		//SimpleDateFormat format1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		//String formatted = format1.format(retDate.getTime());
		//System.out.println(formatted);

		
		System.out.println(Calculations.checkExpired(retDate));
			
	}

}
