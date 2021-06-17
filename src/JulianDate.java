
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Scanner;

public class JulianDate {

	public static final LocalDateTime START_DATE = LocalDateTime.of(-4712,1,1,12,0,0,0);

	public static void main(String[] args) throws IOException{
		currentTime();   //get CurrentTime as standard and julian Date
		Scanner myInput = new Scanner( System.in );
	      int day;
	      int month;
	      int year;
	      System.out.print( "Enter your year of birth as YYYY" );
	      year = myInput.nextInt();
	      System.out.print( "Enter your month of birth as MM" );
	      month = myInput.nextInt();
	      System.out.print( "Enter your day of birth as DD" );
	      day = myInput.nextInt();
	      
	      System.out.println("Your Birthday is set as " + month + "/" + day + "/" + year);
	      
	      double birthday = giveJulianDate(year, month, day);
	      
	      double daysAlive = Math.abs(currentJulianDate()- birthday);
	      
	      System.out.println("You have been alive for " + daysAlive  +"days");
	      String weekday = "";
	      int we = (day + month + year + Math.round(year/100))%7;
	      
	      if(we == 2) {
	    	  weekday = "monday";
	      }
	      if(we == 3) {
	    	  weekday = "tuesday";
	      }
	      if(we == 4) {
	    	  weekday = "wednesday";
	      }
	      if(we == 5) {
	    	  weekday = "thursday";
	      }
	      if(we == 6) {
	    	  weekday = "friday";
	      }
	      if(we == 0) {
	    	  weekday = "saturday";
	      }
	      if(we == 1) {
	    	  weekday = "sunday";
	      }
	      
	      System.out.println("You were born on a " + weekday);
	      if(day == getCurrentDay() && month == getCurrentMonth()) {
	    	  System.out.println("Happy Birthday!!!!!");
	      }
	      if(daysAlive % 100 == 0 && daysAlive != 0) {
	    	  System.out.println("Cool! Your days alive are divisible by 100");
	      }
		
		 
	}
	
	public static double giveJulianDate(double year, double month, double day)
    {
        double jd = 0;
        double y = year;
        double m = month;
        double d = day;
        jd = Math.floor((1461 * (y + 4800 + (m - 14)/12))/4 + (367 * (m-2-12*((m-14)/12)))/12-(3*((y+4900+(m-14)/12)/100))/4+d-32077); 
        return jd + 2;
    }

	public static double currentJulianDate() {
		LocalDateTime now = LocalDateTime.now();
		return giveJulianDate(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
	}
	public static double getCurrentDay() {
		LocalDateTime now = LocalDateTime.now();
		return now.getDayOfMonth();
	}
	public static double getCurrentMonth() {
		LocalDateTime now = LocalDateTime.now();
		return now.getMonthValue();
	}
	public static void currentTime() {
		LocalDateTime now = LocalDateTime.now();
		int y = now.getYear();
		int m = now.getMonthValue();
		int d = now.getDayOfMonth();
		System.out.println(d + "." + m + "." + y);
		System.out.println(giveJulianDate(y,m ,d));
	}
	public static int getTimeBetween(double first, double second) {
		
		return (int) Math.round(Math.abs(first-second));
		
	}
	

	
	
	
	
}
