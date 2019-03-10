package DataStorage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;

import Actors.*;
import Media.CD;
import Media.DVD;
import Media.PaperMedia;
import Media.PhysicalMedia;
import Utilities.Address;
import Utilities.CalendarPeriod;
import Utilities.Status;

public class Database implements Serializable {
	
	private ArrayList<CD> cds = new ArrayList<CD>();
	private ArrayList<DVD> dvds = new ArrayList<DVD>();
	private ArrayList<PaperMedia> paperMedias= new ArrayList<PaperMedia>();

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	/**
	 * Getters & setters
	 * @return
	 */
	public ArrayList<CD> getCds() {
		return cds;
	}


	public void setCds(ArrayList<CD> cds) {
		this.cds = cds;
	}


	public ArrayList<DVD> getDvds() {
		return dvds;
	}


	public void setDvds(ArrayList<DVD> dvds) {
		this.dvds = dvds;
	}


	public ArrayList<PaperMedia> getPaperMedias() {
		return paperMedias;
	}


	public void setPaperMedias(ArrayList<PaperMedia> paperMedias) {
		this.paperMedias = paperMedias;
	}


	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
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
	
	/**
	 * Use only if you want to create a new customer base only so new Data.bin file
	 */
	public void createCustomerMediaBase() {
		
		//Create 2 customers
		Calendar johnBirthDate = Calendar.getInstance();
		johnBirthDate.set(1997,4,17);
		Student JohnSmith = new Student("101","John" , "Smith" , johnBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 10.0);
				//Note:Blacklist status is based only on fees only so need to specify it.
				
		Calendar annBirthDate = Calendar.getInstance();
		annBirthDate.set(1995,2,22);
		Student AnnLis = new Student("102","Ann" , "Lis" , annBirthDate,new Address 
			(102,"st king street","t2y444","calgary","canada"),"4038724555", null,null,null, 40.0);
		
		customers.add(JohnSmith);
		customers.add(AnnLis);
		
		//Create metallica CD
		ArrayList<String> metallicaComposers = new ArrayList<String>();
		metallicaComposers.add("Metallica");
		Calendar metallicaDate = Calendar.getInstance();
		metallicaDate.set(1988,7,25);
		CD metallica = new CD("...And Justice For All",metallicaComposers, metallicaDate,new Status("available"));
		
		//Create Aerosmith CD
		ArrayList<String> theBigOnesComposers = new ArrayList<String>();
		theBigOnesComposers.add("Aerosmith");
		Calendar theBigOnesDate = Calendar.getInstance();
		theBigOnesDate.set(1994,11,01);
		CD bigones = new CD("Big Ones",theBigOnesComposers,theBigOnesDate,new Status("unavailable"));
		
		//Create Queen CD
		ArrayList<String> theGameComposers = new ArrayList<String>();
		theGameComposers.add("Queen");
		Calendar theGameDate = Calendar.getInstance();
		theGameDate.set(1980,06,30);
		CD theGameCd = new CD("The Game",theGameComposers,theGameDate,new Status("available"));
		
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
		
		cds.add(metallica);
		cds.add(bigones);
		cds.add(theGameCd);
		dvds.add(titanic);
		paperMedias.add(atlantis);	  
		
		
	}
	
	/**
	 * Saves data info to file
	 */
	public void save() {
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data.bin",false));
			
			for (int i=0;i<customers.size();i++) {
				out.writeObject(customers.get(i));
				}
			for (int i=0;i<cds.size();i++) {
				out.writeObject(cds.get(i));
				}
			for (int i=0;i<dvds.size();i++) {
				out.writeObject(dvds.get(i));
				}
			for (int i=0;i<paperMedias.size();i++) {
				out.writeObject(paperMedias.get(i));
				}
			
			out.close();
			
			System.out.println("\nData save successful\n");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO exception ");
			e.printStackTrace();
		}
		
	}

	
	/**
     * Data is loaded from file and put into shelf
     * 
     */
    public void loadData() {
    	
    	//this.createCustomerMediaBase();
    	//this.save();
    	try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data.bin"));
			
			try {
				customers.clear();
				cds.clear();
				dvds.clear();
				paperMedias.clear();
				while(true) {
					Object obj = in.readObject();
					if(obj instanceof Customer) customers.add((Customer)obj);
					if(obj instanceof CD) cds.add((CD)obj);{}
					if(obj instanceof DVD) dvds.add((DVD)obj);{}
					if(obj instanceof PaperMedia) paperMedias.add((PaperMedia)obj);
					
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println("Class in file wasn't found");
				
			}
		
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
		
			System.out.println("\n^ Data load successful\n");
		}	
    }
	
    /**
     * Prints virtual shelf to string
     */
    public String shelfString() {
    	String a = "";
    	String b = "";
    	String c = "";
    		
    	int counter = 1;
    		
    	for (int i=0;i<cds.size();i++) {
    	    a = a+ counter + ". " + cds.get(i).toString() + "\n";
    	    counter++;
    	}
    	counter = 1;
    	for (int j=0;j<dvds.size();j++) {
    	    b = b +  counter+ ". " + dvds.get(j).toString() + "\n";
    	    counter++;
    	}
    		
    	counter = 1;
    	for (int k=0;k<paperMedias.size();k++) {
    	    c = c+ counter + ". "+ paperMedias.get(k).toString() + "\n";
    	    counter++;
    	}
    		
    	return "\n----------- On Virtual Shelf: ------------\n" + "\n------ CD's ------\n" +
    	    a + "\n------ DVDS --------\n" + b + "\n------ PAPER MEDIA ------\n" +c + "\n------------------------------------------";
    				
        }
}



