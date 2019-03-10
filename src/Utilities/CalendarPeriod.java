package Utilities;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is for period of time from: to: as calendar dates
 *
 */
public class CalendarPeriod implements Serializable {

		private Calendar from;
	    private Calendar to;
	    
	    /**
	     * Constructor
	     * @param from
	     * @param to
	     */
	    public CalendarPeriod(Calendar from, Calendar to) {
	    	this.from = from;
	    	this.to = to;
	}
	    /**
	     * Getters & setters
	     * @return
	     */
		public Calendar getFrom() {
			return from;
		}
		public void setFrom(Calendar from) {
			this.from = from;
		}
		public Calendar getTo() {
			return to;
		}
		public void setTo(Calendar to) {
			this.to = to;
		}
	    
		public String toString() {
			return " | Held until : " + to.getTime();
		}
	    
}
