import java.util.ArrayList;
import java.util.Calendar;

import Utilities.FeeChargeSystem;
import Actors.Librarian;
import Actors.Student;
import Media.*;
import DataStorage.Shelf;
import Utilities.*;

public class main {

	public static void main(String[] args) {
		
		//Create metallica CD
		ArrayList<String> metallicaComposers = new ArrayList<String>();
		metallicaComposers.add("Metallica");
		Calendar metallicaDate = Calendar.getInstance();
		metallicaDate.set(1988,7,25);
		CD metallica = new CD("...And Justice For All",metallicaComposers, metallicaDate,new Status("available"));
		
		//Create titanic DVD
		ArrayList<String> titanicDirectors = new ArrayList<String>();
		 titanicDirectors.add("James Cameron");
		 titanicDirectors.add("james C.");
		 Calendar titanicDate = Calendar.getInstance();
		 titanicDate.set(1997,11,18);
		 DVD titanic = new DVD("Titanic",titanicDirectors, titanicDate,new Status("unavailable"));
		 
		 //Create atlantis BOOK
		 ArrayList<String> atlantisAuthor = new ArrayList<String>();
		 atlantisAuthor.add("Stephen King");
		 Calendar atlanticDate = Calendar.getInstance();
		 atlanticDate.set(1999,8,14);
		 PaperMedia atlantis = new PaperMedia("Hearts in Atlantis",atlantisAuthor, atlanticDate,new Status("reserved"));
		 
		 //Add physical media (CD,DVD,BOOK) on virtual shelf
		Shelf shelf = new Shelf();
		shelf.addCD(metallica);
		shelf.addDVD(titanic);
		shelf.addPaperMedia(atlantis);
		
		//Print items added on shelf
		System.out.println(shelf.toString());

		//Create 2 customers (Later -> Load all customers from SQL database)
		Calendar johnBirthDate = Calendar.getInstance();
		johnBirthDate.set(1997,4,17);
		Student JohnSmith = new Student("101","John" , "Smith" , johnBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 10.0);
				//Note:Blacklist status is based only on fees only so need to specify it.
		
		Calendar annBirthDate = Calendar.getInstance();
		johnBirthDate.set(1995,2,22);
		Student AnnLis = new Student("102","Ann" , "Lis" , annBirthDate,new Address 
				(100,"st king street","t2y444","calgary","canada"),"4038724555", null,null,null, 40.0);
		
		//Print student's information
		System.out.println(JohnSmith.toString());
		System.out.println(AnnLis.toString());
		
		//Create a librarian
		Calendar librarianSophieBirthDate = Calendar.getInstance();
		librarianSophieBirthDate.set(1970,0,12);
		Librarian Sophie = new Librarian("101","Sophie", "L", librarianSophieBirthDate, 
				new Address(10,"St.Paul","AAAA33","Calgary","Canada"),"4035667080");
		
		//Librarian adds some CD picked up by John
		Sophie.addMediaOwned(JohnSmith,metallica,"hold");
		
		//Ann wants to be put in queue for same CD John got
		Sophie.addMediaOwned(AnnLis, metallica, "hold"); 
		Sophie.addMediaOwned(AnnLis, metallica, "hold"); 
		
		
		//Print books involved with customers
		System.out.println("\nJohn Smith's media: \n" + JohnSmith.showMedia());
		System.out.println("\nAnn Lis's media: \n" + AnnLis.showMedia());
		
		//Print line up to metallica CD
		System.out.println(metallica.getLineUp().toString());
		
		//Print items added on shelf
		System.out.println(shelf.toString());
		


	}

}
