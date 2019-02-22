package Media;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//import Utilities.Date;
import Utilities.Status;

/**
 * Book includes Book,Magazine,Comics
 * 
 *
 */
public class PaperMedia extends PhysicalMedia{
	
	private ArrayList<String> authors;
	
	/**
	 * Constructor sets title, author/s and year of release
	 */
	public PaperMedia(String title,ArrayList<String> authors,Calendar date,Status status) {
		super.setTitle(title);
		super.setDate(date);
		super.setStatus(status);
		this.setAuthors(authors);
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

	public String toString() {
		String c = String.join(", ", this.getAuthors());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format1.format(this.getDate().getTime());
		return "Book/Magazine/Comic Title: " + "'" + super.getTitle() + "'" + " | Author/s: " + c +
				" | Date: " + formatted + " | Status: " + this.getStatus().toString();
	}
}
