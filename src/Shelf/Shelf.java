package Shelf;

import java.awt.print.Book;
import java.util.ArrayList;

import Media.*;

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

