package edu.ncsu.csc316.security_log.data;

/**
 * Class that records the date of the log entry. The date will
 * consist of the month (MM), day (DD), year (YYYY), and time
 * (hours, minutes, seconds, and AM/PM). This class is reused
 * from the Timestamp class from CSC316 project 1.
 * 
 * @author Jimmy Nguyen
 */
public class Timestamp implements Comparable<Timestamp> {

	/** The recorded month from the user activity log. */
	private String month;
	/** The recorded day from the user activity log. */
	private String day;
	/** The recorded year from the user activity log. */
	private String year;
	/** The recorded hour from the user activity log. */
	private String hour;
	/** The recorded minutes from the user activity log. */
	private String minutes;
	/** The recorded seconds and indication of time from the user activity log. */
	private String secondsXM;
	
	/**
	 * Constructor that initializes the month, day, year, and time fields to the 
	 * values passed as parameters.
	 * 
	 * @param date the date that consists of the month, day, and year
	 * @param time the time that consists of the hours, minutes, seconds, and
	 * time indication (AM/PM)
	 */
	public Timestamp(String date, String time) {
		setMonth(date.substring(0, 2));
		setDay(date.substring(3, 5));
		setYear(date.substring(6, 10));
		setHour(time.substring(0, 2));
		setMinutes(time.substring(3, 5));
		setSecondsXM(time.substring(6, 10));
	}
	
	/**
	 * Returns the recorded month from the user activity log.
	 * 
	 * @return the recorded month
	 */
	public String getMonth() {
		return month;
	}
	
	
	/**
	 * Sets the recorded month from the user activity log.
	 * 
	 * @param month the recorded month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Returns the recorded day from the user activity log.
	 * 
	 * @return the recorded day
	 */
	public String getDay() {
		return day;
	}
	
	/**
	 * Sets the recorded day from the user activity log.
	 * 
	 * @param day the recorded day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}
	
	/**
	 * Returns the recorded year from the user activity log.
	 * 
	 * @return the recorded year
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Sets the recorded year from the user activity log.
	 * 
	 * @param year the recorded year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Returns the recorded hour from the user activity log.
	 * 
	 * @return the recorded hour
	 */
	public String getHour() {
		return hour;
	}
	
	/**
	 * Sets the recorded hour from the user activity log.
	 * 
	 * @param hour the recorded hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	/**
	 * Returns the recorded minutes from the user activity log.
	 * 
	 * @return the recorded minutes
	 */
	public String getMinutes() {
		return minutes;
	}
	
	/**
	 * Sets the recorded minutes from the user activity log.
	 * 
	 * @param minutes the recorded minutes to set
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
	
	/**
	 * Returns the recorded seconds and time indication (AM/PM)
	 * from the user activity log.
	 * 
	 * @return the recorded seconds and time indication
	 */
	public String getSecondsXM() {
		return secondsXM;
	}
	
	/**
	 * Sets the recorded seconds along with the time indication
	 * (AM/PM) from the user activity log.
	 * 
	 * @param secondsXM the recorded seconds and time indication
	 * to set
	 */
	public void setSecondsXM(String secondsXM) {
		this.secondsXM = secondsXM;
	}
	
	/**
	 * Creates and returns a String representation of the log 
	 * entry's timestamp.
	 * 
	 * @return the String representation of the log entry's
	 * timestamp
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMonth());
		sb.append("/");
		sb.append(getDay());
		sb.append("/");
		sb.append(getYear());
		sb.append(" ");
		sb.append(getHour());
		sb.append(":");
		sb.append(getMinutes());
		sb.append(":");
		sb.append(getSecondsXM());
		return sb.toString();
	}

	/**
	 * Calculates and returns the hash code value of the Timestamp object.
	 * 
	 * @return the resulting hash code of the Timestamp object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + ((minutes == null) ? 0 : minutes.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((secondsXM == null) ? 0 : secondsXM.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	/**
	 * Compares two Timestamp objects to determine if both of them are
	 * equal on all fields.
	 * 
	 * @param obj the Timestamp object used for comparison
	 * @return true if the two Timestamp objecs are equal or false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		Timestamp other = (Timestamp) obj;
	    if (!day.equals(other.day))
			return false;
	    if (!hour.equals(other.hour))
			return false;
	    if (!minutes.equals(other.minutes))
			return false;
	    if (!month.equals(other.month))
			return false;
	    if (!secondsXM.equals(other.secondsXM))
			return false;
	    if (!year.equals(other.year))
			return false;
		return true;
	}

	/**
	 * Compares two timestamps from log entries. Returns a negative
	 * if the first timestamp is chronologically before the second 
	 * timestamp, 0 if both timestamps are equal, or a positive
	 * number if the first timestamp is chronologically after the
     * second timestamp.
	 * 
	 * @param other the second, or other, timestamp to compare
	 * @return a negative value, 0, or a positive value if the first
	 * timestamp is before, the same,
	 * or after the second timestamp
	 */
	@Override
	public int compareTo(Timestamp other) {
		//Perhaps better to have sequential if-statements
		if (this.toString().compareTo(other.toString()) == 0) {
			return 0;
		}
		if (this.getYear().compareTo(other.getYear()) < 0) {
			return -1;
		}
		if (this.getYear().compareTo(other.getYear()) > 0) {
			return 1;
		}
		if (this.getMonth().compareTo(other.getMonth()) < 0) {
			return -1;
		}
		if (this.getMonth().compareTo(other.getMonth()) > 0) {
			return 1;
		}
		if (this.getDay().compareTo(other.getDay()) < 0) {
			return -1;
		}
		if (this.getDay().compareTo(other.getDay()) > 0) {
			return 1;
		}
		if (this.getSecondsXM().substring(2, 4).compareTo(other.getSecondsXM().substring(2, 4)) < 0) {
			return -1;
		}
	    if (this.getSecondsXM().substring(2, 4).compareTo(other.getSecondsXM().substring(2, 4)) > 0) {
	    		return 1;
	    }
	    if (this.getHour().equals("12")) {
	    		String hourConvert = "00";
	    		if (!other.getHour().equals("12")) {
	        		if (hourConvert.compareTo(other.getHour()) < 0) {
		    			return -1;
		    		}
		    		if (hourConvert.compareTo(other.getHour()) > 0) {
		    			return 1;
		    		}
	    		}
	    }
	    if (other.getHour().equals("12")) {
	    		String hourConvert = "00";
	    		if (!this.getHour().equals("12")) {
	    			if (this.getHour().compareTo(hourConvert) < 0) {
	    				return -1;
	    			}
	    			if (this.getHour().compareTo(hourConvert) > 0) {
	    				return 1;
	    			}
	    		}
	    }
		if (this.getHour().compareTo(other.getHour()) < 0) {
			return -1;
		}
		if (this.getHour().compareTo(other.getHour()) > 0) {
			return 1;
		}
		if (this.getMinutes().compareTo(other.getMinutes()) < 0) {
			return -1;
		}
		if (this.getMinutes().compareTo(other.getMinutes()) > 0) {
			return 1;
		}
		if (this.getSecondsXM().substring(0, 2).compareTo(other.getSecondsXM().substring(0, 2)) < 0) {
			return -1;
		}
		if (this.getSecondsXM().substring(0, 2).compareTo(other.getSecondsXM().substring(0, 2)) > 0) {
			return 1;
		}
		return 0;
	}
	
}
