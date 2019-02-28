package DataStorage;

import java.awt.print.Book;
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
		
		this.addCD(metallica);
		this.addDVD(titanic);
		this.addPaperMedia(atlantis);
		
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
}

