import java.io.IOException;
import java.util.Scanner;

public class MetricDate {

	public static void main(String[] args) throws IOException{
//		System.out.println(julianToMetric(100));
//		System.out.println(julianToMetric(3192));
//		System.out.println(julianToMetric(12501));
//        
//		System.out.println(metricToJulian(12, 5, 0, 1));
		System.out.println(julianToMetric(7318));
		System.out.println(julianToMetric(11152));
	}
	
	public static String julianToMetric(double jd) {
		
		int d = 0;
		int w = 0;
	    int m = 0;
	    int y = 0;
	    
	    y = (int) Math.floor(jd / 1000);
	    m = (int) Math.floor((jd % 1000) /100);
        w = (int) Math.floor(((jd % 1000) % 100) / 10);
        d = (int) Math.floor(((jd % 1000) % 100) % 10);
	     //10 weeks a month
	     //10 months a year
        String s = y + "/" + m +  "/" + w + "/"  + d ;
		 
		return s;

	}
	
	public static Double metricToJulian(int y, int m, int w , int d) {
		
		double metricDate = y * 1000 +  m * 100 + w * 10 + d;

		return metricDate;
	}

	
}
