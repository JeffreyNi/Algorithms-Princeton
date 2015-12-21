/* Sample implementation of equals() method.
*/
import java.util.*;

public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date (int month, int day, int year) {
	this.month = month;
	this.day = day;
	this.year = year;
    }

    public boolean equals (Object y) {
	if (y == this) {return true;}

	if (y == null) {return false;}

	if (y.getClass() != this.getClass()) {return false;}
	
	Date date = (Date) y;
	if (this.month != date.month) {return false;}
	if (this.day != date.day)     {return false;}
	if (this.year != date.year)   {return false;}
	return true;
    }
}