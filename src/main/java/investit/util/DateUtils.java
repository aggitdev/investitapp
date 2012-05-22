package investit.util;

import java.util.Date;

import org.joda.time.DateTime;

public class DateUtils {

	public static Date today() {
		return roundToDay(new Date()); 
	}
	
	public static Date roundToDay(Date d) {
		return new DateTime(d).dayOfYear().roundFloorCopy().toDate();
	}

	public static boolean onSameDay(Date d1, Date d2) {
		return roundToDay(d1).equals(roundToDay(d2));
	}

	public static boolean notOnSameDay(Date d1, Date d2) {
		return !onSameDay(d1, d2);
	}

}
