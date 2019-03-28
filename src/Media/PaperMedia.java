package Media;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import Utilities.Date;
import Utilities.Status;

/**
 * This class deals with paper medias.
 * Note: Book includes Book,Magazine,Comics
 */
public class PaperMedia extends PhysicalMedia {
	
	private static final long serialVersionUID = 8399886307255026826L;
	private ArrayList<String> authors;
	
	/**
	 * Constructor 
	 */
	public PaperMedia(String title,ArrayList<String> authors,Calendar date,Status status) {
		super.setTitle(title);
		super.setDate(date);
		super.setStatus(status);
		this.setAuthors(authors);
	}
	
    /**
     * Getters & setters
      */
	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
    /**
    * Prints paper media as a nice string
    * @return String - nice format
     */
	public String toString() {
		String owner = "None";
		if (this.getStatus().getCurrentStatus().equals("in use"))
			owner = this.getCustomer().getID();
		String c = String.join(", ", this.getAuthors());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.getDate().getTime());
		return "Book/Magazine/Comic Title: " + "'" + super.getTitle() + "'" + " | Author/s: " + c +
				" | Date: " + formatted + " | Status: " + this.getStatus().toString() + " " + " | Owner: " + owner + " ";
	}
}
