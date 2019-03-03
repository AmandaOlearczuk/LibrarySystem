package DataStorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
	public void loadCustomers(ArrayList<CD> cd,ArrayList<DVD> dvd,ArrayList<PaperMedia> paperMedia) {
		
		loadFile(cd,dvd,paperMedia);
		/*
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
		*/
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
	
	public void save() {
		ArrayList<Customer> customers = this.getCustomers();
		Customer tempC = null;
		PrintWriter writer = null;
		int i;
    	try {
    	writer = new PrintWriter("src/DataStorage/Customers.txt");
    	}
    	catch(Exception e) {System.out.println(e);}
    	writer.println("CUSTOMER STORAGE FILE\n");
    	for (i = 0; i < customers.size(); i++) {
    		tempC = customers.get(i); 
    			
    		writer.println("\nName: " + tempC.getFirstName()+ " " + tempC.getLastName());
    		writer.println("\nID: " + tempC.getID());
    		if (tempC instanceof Student) {
        		writer.println("\nCustomerType: Student");
    		}
    		if (tempC instanceof Faculty) {
        		writer.println("\nCustomerType: Faculty");
    		}
    		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    		String formatted = format1.format(tempC.getBirthDate().getTime());
    		writer.println("\nBirthdate: " + formatted.replace('-', ' '));
    		
    		writer.println("\nAddress: ");
    		writer.println(tempC.getAddress().getHouseNum());
    		writer.println(tempC.getAddress().getStreetName());
    		writer.println(tempC.getAddress().getZip());
    		writer.println(tempC.getAddress().getCity());
    		writer.println(tempC.getAddress().getCountry());
    		
    		writer.println("\nPhonenum: " + tempC.getPhoneNumber());
    		
    		writer.println("\nOwned:");
			for(Map.Entry<PhysicalMedia, Calendar> e : tempC.getMediaOwned().entrySet())
			{
				writer.println(e.getKey().getTitle() + "\n" + format1.format(e.getValue().getTime()));
				System.out.println(e.getKey().getTitle() + "\n" + format1.format(e.getValue().getTime()));
			}
    		writer.println("done");

    		writer.println("\nReturned:");
    		//TODO add media to returned list on return
    		/*
    		for(Map.Entry<PhysicalMedia, Calendar> e : tempC.getMediaReturned().entrySet())
			{
				writer.println(e.getKey().getTitle() + "\n" + format1.format(e.getValue().getTime()));
				System.out.println(e.getKey().getTitle() + "\n" + format1.format(e.getValue().getTime()));
			}
			*/
    		writer.println("\nHeld:");
    		for(Map.Entry<PhysicalMedia, CalendarPeriod> e : tempC.getMediaOnHold().entrySet())
			{
				writer.println(e.getKey().getTitle() +"\n"+ format1.format(e.getValue().getFrom().getTime())
						+"\n"+ format1.format(e.getValue().getTo().getTime()));
			}
    		writer.println("done");

    		writer.println("\nFees: " + tempC.getFeesOwned());

    		writer.println("\nEND\n");
    	}
    	writer.close();
    	System.out.println("Customer save successful");
	}
	
	public void loadFile(ArrayList<CD> cd,ArrayList<DVD> dvd,ArrayList<PaperMedia> paperMedia) {
			String fileName = "src/DataStorage/Customers.txt";
			FileReader fr = null;
			BufferedReader inputStream = null;
			try {
			    fr = new FileReader(fileName);
			    inputStream = new BufferedReader(fr);
					
			    Map<PhysicalMedia, Calendar> mediaOwned = new HashMap<PhysicalMedia, Calendar>();
				Map<PhysicalMedia,Calendar> mediaReturned = new HashMap<PhysicalMedia, Calendar>(); 
				Map<PhysicalMedia,CalendarPeriod> mediaOnHold = new HashMap<PhysicalMedia, CalendarPeriod>(); 
			    Customer temp = null;
			    String line = null;
			    String loadedID = null;
			    String loadedPhoneNum = null;
			    String loadedType = null;
			    String loadedTitle = null;
			    double loadedFees = 0.0;
			    int loadedAddressNum = 0;
			    int i;
			    String[] dates = null;
			    String[] address = new String[4];
			    String[] name = null;
			    CalendarPeriod period = null;
			    Calendar mediaDate = Calendar.getInstance();
			    Calendar mediaDate2 = Calendar.getInstance();
			    Calendar loadedDate = Calendar.getInstance();
			
			
			    while((line = inputStream.readLine()) != null) {
				if (line.length() <= 2) {continue;}
				if (line.equals("Returned:")|| line.equals("done")) {continue;}
				if (line.substring(0, 3).equals("ID:")) {
				    loadedID = line.substring(4, line.length());
				    continue;
				}
				if (line.substring(0, 3).equals("END")) {
				    if (loadedType.equals("Student")) {
				    	temp = new Student(loadedID,name[1] ,name[2] , loadedDate ,new Address 
				(loadedAddressNum, address[0],address[1],address[2],address[3]),loadedPhoneNum, mediaOwned, mediaOnHold, mediaReturned, loadedFees);
				    }
				    if (loadedType.equals("Faculty")) {
				    	temp = new Faculty(loadedID,name[1] ,name[2] , loadedDate ,new Address 
				(loadedAddressNum, address[0],address[1],address[2],address[3]),loadedPhoneNum, mediaOwned, mediaOnHold, mediaReturned, loadedFees);
				    }
				    this.customers.add(temp);
				    loadedDate = Calendar.getInstance();
				    mediaOwned = new HashMap<PhysicalMedia, Calendar>();
					mediaReturned = new HashMap<PhysicalMedia, Calendar>(); 
					mediaOnHold = new HashMap<PhysicalMedia, CalendarPeriod>(); 
				    continue;
				}
				if (line.substring(0, 5).equals("Fees:")) {
					loadedFees = Double.valueOf(line.substring(6,line.length()));
				    continue;
				}
				if (line.substring(0, 5).equals("Name:")) {
					name = line.split(" ");
				    continue;
				}
				if (line.substring(0, 5).equals("Held:")) {
					while(!((line = inputStream.readLine()).contains("done"))) {
						loadedTitle = inputStream.readLine();
						for (i = 0; i < cd.size(); i++) {
							if (cd.get(i).getTitle().equals(loadedTitle)) {
								line = inputStream.readLine();
								dates = line.split("-");
								mediaDate.set(Integer.valueOf(dates[dates.length-3]),Integer.valueOf(dates[dates.length-2]) - 1,Integer.valueOf(dates[dates.length-1]));
								line = inputStream.readLine();
								dates = line.split("-");
								mediaDate2.set(Integer.valueOf(dates[dates.length-3]),Integer.valueOf(dates[dates.length-2]) - 1,Integer.valueOf(dates[dates.length-1]));
								period = new CalendarPeriod(mediaDate,mediaDate2);
								mediaOnHold.put(cd.get(i),period);
								mediaDate = Calendar.getInstance();
							}
						}
					}
					continue;
				}
				if (line.substring(0, 6).equals("Owned:")) {
					while(!((line = inputStream.readLine()).contains("done"))) {
						loadedTitle = line;
						for (i = 0; i < cd.size(); i++) {
							if (cd.get(i).getTitle().equals(loadedTitle)) {
								line = inputStream.readLine();
								dates = line.split("-");
								mediaDate.set(Integer.valueOf(dates[dates.length-3]),Integer.valueOf(dates[dates.length-2]) - 1,Integer.valueOf(dates[dates.length-1]));
								mediaOwned.put(cd.get(i),mediaDate);
								mediaDate = Calendar.getInstance();
							}
						}
					}
					continue;
				}
				if (line.substring(0, 8).equals("Address:")) {
					loadedAddressNum = Integer.parseInt(inputStream.readLine());
					for (i = 0; i < 4; i++) {
						address[i] = inputStream.readLine();
					}
				    continue;
					
				}
				if (line.substring(0, 9).equals("Phonenum:")) {
				    loadedPhoneNum = line.substring(10, line.length());
				}
				if (line.substring(0, 10).equals("Birthdate:")) {
				    dates = line.split(" ");
				    loadedDate.set(Integer.valueOf(dates[dates.length-3]),Integer.valueOf(dates[dates.length-2]) - 1,Integer.valueOf(dates[dates.length-1]));
				}
				if (line.substring(0, 13).equals("CustomerType:")) {
					loadedType = line.substring(14, line.length());
				}
				else {continue;}
			    }
			}
			catch(FileNotFoundException e) {
			    System.out.println("Error opening file");
			}
			catch(IOException ioe) {
			    System.out.println("Error reading file");
			}
		}
		
	}

