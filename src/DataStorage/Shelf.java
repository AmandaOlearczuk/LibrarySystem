package DataStorage;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

import Media.*;
import Utilities.Status;

/**
 * This class holds and deals with library's physical media : CD's, DVD's , Paper Media as arrayLists.
 *
 */
public class Shelf {
	private ArrayList<CD> cds;
	private ArrayList<DVD> dvds;
	private ArrayList<PaperMedia> paperMedias;
	
	/**
	 * Constructors
	 */
	public Shelf() {
		this.cds = new ArrayList<CD>();
		this.dvds = new ArrayList<DVD>();
		this.paperMedias = new ArrayList<PaperMedia>();
	}
	
	public Shelf(ArrayList<CD> cd,ArrayList<DVD> dvd,ArrayList<PaperMedia> paperMedia) {
		this.cds = cd;
		this.dvds = dvd;
		this.paperMedias = paperMedia;
	}
	
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

	/**
	 * Add CD to shelf
	 * @param disc
	 */
	public void addCD(CD disc) {
		cds.add(disc);
	}
	/**
	 * Add DVD to shelf
	 * @param disc
	 */
	public void addDVD(DVD disc) {
		dvds.add(disc);
	}
	
	/**
	 * Add Paper media to shelf
	 * @param paper
	 */
	public void addPaperMedia(PaperMedia paper) {
		paperMedias.add(paper);
	}
	
    /**
     * Media is loaded from file and put into shelf
     * TODO
     */
    public void loadMedia() {
	//load media from file.. so create objects of CDS,DVDS and Books/Magazines/Comics & store them in arrays of this class
		
	//load CD from file
	setCds(readCDFile(getCds()));
		
		
	//Load DVDs from file
	setDvds(readDVDFile(getDvds()));
		 
	//Load BOOKs from file
	setPaperMedias(readPMFile(getPaperMedias()));
		 
		
		
    }
	
    public String toString() {
	String a = "";
	String b = "";
	String c = "";
		
	int counter = 1;
		
	for (int i=0;i<cds.size();i++) {
	    a = counter + ". " + cds.get(i).toString() + "\n";
	}
	counter = 1;
	for (int j=0;j<dvds.size();j++) {
	    b = counter+ ". " + dvds.get(j).toString() + "\n";
	}
		
	counter = 1;
	for (int k=0;k<paperMedias.size();k++) {
	    c = counter + ". "+ paperMedias.get(k).toString() + "\n";
	}
		
	return "\n----------- On Virtual Shelf: ------------\n" + "\n------ CD's ------\n" +
	    a + "\n------ DVDS --------\n" + b + "\n------ PAPER MEDIA ------\n" +c + "\n------------------------------------------";
				
    }

    public ArrayList<CD> readCDFile(ArrayList<CD> loadedList) {
	String fileName = "src/DataStorage/CDs.txt";
	FileReader fr = null;
	BufferedReader inputStream = null;
	try {
	    fr = new FileReader(fileName);
	    inputStream = new BufferedReader(fr);
				    
	    CD temp;
	    String line = null;
	    String loadedTitle = null;
	    String[] dates = null;
	    String status = null;
	    ArrayList<String> creators = new ArrayList<String>();
	    Calendar loadedDate = Calendar.getInstance();
				    
	    while((line = inputStream.readLine()) != null) {
		if (line.length() <= 2) {continue;}
		if (line.substring(0, 3).equals("END")) {
		    temp = new CD(loadedTitle,creators, loadedDate,new Status(status));
		    loadedList.add(temp);
		    creators.clear();
		    continue;
		}
		if (line.substring(0, 5).equals("Date:")) {
		    dates = line.split(" ");
		    loadedDate.set(Integer.valueOf(dates[dates.length-3]),Integer.valueOf(dates[dates.length-2]),Integer.valueOf(dates[dates.length-1]));
		}
		if (line.substring(0, 6).equals("Title:")) {
		    loadedTitle = line.substring(7, line.length());
		}
		if (line.substring(0, 7).equals("Status:")) {
		    status = line.substring(8, line.length());
		}
		if (line.substring(0, 8).equals("Creator:")) {
		    creators.add(line.substring(9, line.length()));
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
	return loadedList;
    }
	
    public ArrayList<DVD> readDVDFile(ArrayList<DVD> loadedList) {
	String fileName = "src/DataStorage/DVDs.txt";
	FileReader fr = null;
	BufferedReader inputStream = null;
	try {
	    fr = new FileReader(fileName);
	    inputStream = new BufferedReader(fr);
				
	    DVD temp;
	    String line = null;
	    String loadedTitle = null;
	    String[] dates = null;
	    String status = null;
	    ArrayList<String> creators = new ArrayList<String>();
	    Calendar loadedDate = Calendar.getInstance();
	
	
	    while((line = inputStream.readLine()) != null) {
		if (line.length() <= 2) {continue;}
		if (line.substring(0, 3).equals("END")) {
		    temp = new DVD(loadedTitle,creators, loadedDate,new Status(status));
		    loadedList.add(temp);
		    creators.clear();
		    continue;
		}
		if (line.substring(0, 5).equals("Date:")) {
		    dates = line.split(" ");
		    loadedDate.set(Integer.valueOf(dates[dates.length-3]),Integer.valueOf(dates[dates.length-2]),Integer.valueOf(dates[dates.length-1]));
		}
		if (line.substring(0, 6).equals("Title:")) {
		    loadedTitle = line.substring(7, line.length());
		}
		if (line.substring(0, 7).equals("Status:")) {
		    status = line.substring(8, line.length());
		}
		if (line.substring(0, 8).equals("Creator:")) {
		    creators.add(line.substring(9, line.length()));
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
	return loadedList;
    }
	
    public ArrayList<PaperMedia> readPMFile(ArrayList<PaperMedia> loadedList) {
	String fileName = "src/DataStorage/PaperMedia.txt";
	FileReader fr = null;
	BufferedReader inputStream = null;
	try {
	    fr = new FileReader(fileName);
	    inputStream = new BufferedReader(fr);
				
	    PaperMedia temp;
	    String line = null;
	    String loadedTitle = null;
	    String[] dates = null;
	    String status = null;
	    ArrayList<String> creators = new ArrayList<String>();
	    Calendar loadedDate = Calendar.getInstance();
	
	
	    while((line = inputStream.readLine()) != null) {
		if (line.length() <= 2) {continue;}
		if (line.substring(0, 3).equals("END")) {
		    temp = new PaperMedia(loadedTitle,creators, loadedDate,new Status(status));
		    loadedList.add(temp);
		    creators.clear();
		    continue;
		}
		if (line.substring(0, 5).equals("Date:")) {
		    dates = line.split(" ");
		    loadedDate.set(Integer.valueOf(dates[dates.length-3]),Integer.valueOf(dates[dates.length-2]),Integer.valueOf(dates[dates.length-1]));
		}
		if (line.substring(0, 6).equals("Title:")) {
		    loadedTitle = line.substring(7, line.length());
		}
		if (line.substring(0, 7).equals("Status:")) {
		    status = line.substring(8, line.length());
		}
		if (line.substring(0, 8).equals("Creator:")) {
		    creators.add(line.substring(9, line.length()));
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
	return loadedList;
    }
	
}
	
	

