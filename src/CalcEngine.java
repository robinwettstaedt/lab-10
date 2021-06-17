/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  David J. Barnes and Michael Kolling 
 * @version 2008.03.30
 */
public class CalcEngine
{
    // The calculator's state is maintained in three fields:
    //     buildingDisplayValue, haveLeftOperand, and lastOperator.
    
    // Are we already building a value in the display, or will the
    // next digit be the first of a new one?
    private boolean buildingDisplayValue;
    // Has a left operand already been entered (or calculated)?
    private boolean haveLeftOperand;
    // The most recent operator that was entered.
    private char lastOperator;

    // The current value (to be) shown in the display.
    private String displayValue1;
    private String displayValue2;
    private String displayValue3;
    private String displayValue4;
    // The value of an existing left operand.
    private int leftOperand;

    /**
     * Create a CalcEngine.
     */
    public static void main(String[] args) {
    	
    }
    public CalcEngine()
    {
       
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public String getDisplayValue1()
    {
        return displayValue1;
    }
    public String getDisplayValue2()
    {
        return displayValue2;
    }
    public String getDisplayValue3()
    {
        return displayValue3;
    }
    public String getDisplayValue4()
    {
        return displayValue4;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */


    /**
     * The 'plus' button was pressed. 
     */
    public int giveJulianDate(int year, int month, int day)
    {
        int jd = 0;
        int y = year;
        int m = month;
        int d = day;
        jd = (int) Math.floor((1461 * (y + 4800 + (m - 14)/12))/4 + (367 * (m-2-12*((m-14)/12)))/12-(3*((y+4900+(m-14)/12)/100))/4+d-32077); 
        return jd + 2;
    }
    
    public void addDays(String date, String day)
    {
        int daysToAdd = Integer.parseInt(day);
        String[] s = date.split("/");
       
        int d = 0;
        int m = 0;
        int y = 0;
        if(s.length == 3) {
        	 d = Integer.parseInt(s[0]);
        	 m = Integer.parseInt(s[1]);
        	 y = Integer.parseInt(s[2]);
        }
        int jd = giveJulianDate(y, m ,d);
        jd += daysToAdd;  
        displayValue4 = "" + jd;
    }
    public void substractDays(String date, String day)
    {
        int daysToAdd = Integer.parseInt(day);
        String[] s = date.split("/");
       
        int d = 0;
        int m = 0;
        int y = 0;
        if(s.length == 3) {
        	 d = Integer.parseInt(s[0]);
        	 m = Integer.parseInt(s[1]);
        	 y = Integer.parseInt(s[2]);
        }
        int jd = giveJulianDate(y, m ,d);
        jd -= daysToAdd;  
        displayValue4 = "" + jd;
    }
    
    public void getDifference(String date1, String date2) {
    	String[] s = date1.split("/");
    	String[] s1 = date2.split("/");
        
    	int d = 0;
        int m = 0;
        int y = 0;
        if(s.length == 3) {
        	 d = Integer.parseInt(s[0]);
        	 m = Integer.parseInt(s[1]);
        	 y = Integer.parseInt(s[2]);
        }
        int jd = giveJulianDate(y, m ,d);
        
        int d1 = 0;
        int m1 = 0;
        int y1 = 0;
        if(s1.length == 3) {
        	 d1 = Integer.parseInt(s1[0]);
        	 m1 = Integer.parseInt(s1[1]);
        	 y1 = Integer.parseInt(s1[2]);
        }
        int jd1 = giveJulianDate(y1, m1 ,d1);
        
        
        int difference = jd - jd1;
        displayValue4 = "" + difference;
    }
    public void getWeekday(String date) { 
    	String[] s = date.split("/");
        
        int d = 0;
        int m = 0;
        int y = 0;
        if(s.length == 3) {
        	 d = Integer.parseInt(s[0]);
        	 m = Integer.parseInt(s[1]);
        	 y = Integer.parseInt(s[2]);
        }
        int jd = giveJulianDate(y, m ,d);
        
        String weekday = "";
        switch (jd % 7) {
            case (0):
                weekday = "Monday";
                break;
            case (1):
                weekday = "Tuesday";
                break;
            case (2):
                weekday = "Wednesday";
                break;
            case (3):
                weekday = "Thursday";
                break;
            case (4):
                weekday = "Friday";
                break;
            case (5):
                weekday = "Saturday";
                break;
            case (6):
                weekday = "Sunday";
                break;
        }
         displayValue4 = weekday;
    }



}
