package DataStorage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import Actors.Customer;
import Actors.Librarian;
import Actors.Student;
import Media.CD;
import Media.DVD;
import Media.PaperMedia;
import Utilities.Address;
import Utilities.FeeChargeSystem;
import Utilities.Status;

/**
 * This class is responsible for loading and storing data about customers, and library to and from .bin file.
 *
 */
public class Database implements Serializable {
	
	
	private static final long serialVersionUID = 888845311545762296L;
	private ArrayList<CD> cds = new ArrayList<CD>();
	private ArrayList<DVD> dvds = new ArrayList<DVD>();
	private ArrayList<PaperMedia> paperMedias= new ArrayList<PaperMedia>();

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Librarian> librarians = new ArrayList<Librarian>();	
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	private int numOrders = 0;
	
	private ArrayList<OrderRequest> orderRequests = new ArrayList<OrderRequest>();
	private int numOrderRequests = 0;
 	
	/**
	 * Getters & setters
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
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public int getNumberOfOrders() {
		return numOrders;
	}
	
	public ArrayList<OrderRequest> getOrderRequests() {
		return orderRequests;
	}
	
	public int getNumberOfOrderRequests() {
		return numOrderRequests;
	}
	
	public void removeOrder(int index) {
		orders.remove(index);
		numOrders--;
	}
	
	public void removeOrderRequest(int index) {
		orderRequests.remove(index);
		numOrderRequests--;
	}
	

	/**
	 * This function searches customer by ID and returns that object
	 * @param text - String as a numeric ID
	 * @return Customer - if found by the ID
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
	 * This function searches customer by ID and returns that object
	 * @param text - String which is an ID
	 * @return Librarian - if found by ID
	 */
	public Librarian searchLibrarianByID(String text) {
		Librarian l ;
		
		for (int i = 0 ; i<librarians.size();i++) {
			if (librarians.get(i).getID().equals(text)) {
				l = librarians.get(i);
				return l;
			}
		}
		
		return null;
	}
	
	/**
	 * Use only if you want to create a new data base only so new Data.bin file
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
		
		//Create a librarian
		Calendar librarianSophieBirthDate = Calendar.getInstance();
		librarianSophieBirthDate.set(1970,0,12);
		Librarian Sophie = new Librarian("100","Sophie", "Lee", librarianSophieBirthDate, 
				new Address(10,"St.Paul","AAAA33","Calgary","Canada"),"4035667080", false);
		librarians.add(Sophie);
		
		Calendar librarianJaneBirthDate = Calendar.getInstance();
		librarianSophieBirthDate.set(1970,0,12);
		Librarian Jane = new Librarian("99","Jane", "Doe", librarianJaneBirthDate, 
				new Address(15,"1st ave","AAAB33","Calgary","Canada"),"4035557080", true);
		librarians.add(Jane);
		
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
	 * Saves library info to file. Expired holds are filtered, overdue fees calculated.
	 */
	public void save() {
		
		this.filterHolds(); //removes expired holds
    	this.calculateOverdueFees(); //calculates customer's owned books fees if return date is expired
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Data.bin",false));
			
			for (int i=0;i<customers.size();i++) {
				out.writeObject(customers.get(i));
				}
			for (int i=0;i<librarians.size();i++) {
				out.writeObject(librarians.get(i));
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
			for (int i=0;i<orders.size();i++) {
				out.writeObject(orders.get(i));
				}
			for (int i=0;i<orderRequests.size();i++) {
				out.writeObject(orderRequests.get(i));
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
     * Data of library is loaded. Expired holds are filtered, overdue fees calculated.
     */
    public void loadData() {
    	
    	//The two lines below can be uncommented and the rest of function commented out if we want to reset database basically
    	this.createCustomerMediaBase();
    	this.save();
    	
    	this.filterHolds(); //removes expired holds
    	this.calculateOverdueFees(); //calculates customer's owned books fees if return date is expired
   
    	try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Data.bin"));
			
			try {
				customers.clear();
				librarians.clear();
				cds.clear();
				dvds.clear();
				paperMedias.clear();
				orders.clear();
				orderRequests.clear();
				while(true) {
					Object obj = in.readObject();
					if(obj instanceof Customer) customers.add((Customer)obj);
					if(obj instanceof Librarian) librarians.add((Librarian)obj);
					if(obj instanceof CD) cds.add((CD)obj);{}
					if(obj instanceof DVD) dvds.add((DVD)obj);{}
					if(obj instanceof PaperMedia) paperMedias.add((PaperMedia)obj);
					if(obj instanceof Order) orders.add((Order)obj);
					if(obj instanceof OrderRequest) orderRequests.add((OrderRequest) obj);
					
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println("Class in file wasn't found");
				
			}
			catch (EOFException e) {
	    		System.out.println("End of file reached");
	    	}
		
			in.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error loading File");
			e.printStackTrace();
		}	
    	
		
    	System.out.println("\n^ Data load successful\n");
    }
	
    
    /**
     * Filters holds if the date is expired
     */
    public void filterHolds() {
    	
    	for(int i=0 ; i<this.getCustomers().size() ; i++) {
    		
    		this.getCustomers().get(i).removeExpiredHolds();
    	}
    }
    
    /**
     * Calculates customer's overdue fees based on return dates for owned media.
     */
    public void calculateOverdueFees() {
    	
    	for(int i=0;i<this.getCustomers().size();i++) {
    		
    		FeeChargeSystem feeCalc = new FeeChargeSystem();
    		feeCalc.calculateAndApplyOverdueFees(this.getCustomers().get(i));
    	}
    }
    
    /**
     * Prints virtual shelf to string
     * @return String - a nice format
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
    
    /**
     * Adds a media order to the order file
     * @param who
     * @param medType
     * @param name
     * @param creator
     * @param year
     * @param month
     * @param day
     */
    public void addLibrarianOrder(Librarian who, String medType, String name, String creator, String year, String month, String day) {
    	orders.add(new Order(who, medType, name, creator, year, month, day));
    	numOrders++;
    }
    
    /**
     * Adds a media request by Customer
     * @param who
     * @param medType
     * @param name
     * @param creator
     */
    public void addCustomerOrderRequest(Customer who, String medType, String name, String creator) {
    	orderRequests.add(new OrderRequest(who, medType, name, creator));
    	numOrderRequests++;
    }
    
    /**
     * Generates string of orders
     * @return String - orders in a nice format
     */
    public String listCustomerOrders() {
    	String temp = "";
    	for (int i = 0; i < orders.size(); i++)
    		temp = temp + orders.get(i).toString();
    	return temp;
    }
   
}



