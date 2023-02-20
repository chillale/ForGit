package utility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int generateRandom() {
		Random r = new Random();
		int num = r.nextInt(100);
		return num;
	}
	public String generateDate() {
		Date d = new Date();
	    String date = d.toString();
	    System.out.println(date);
	    String[] str=date.split(" ");
	    String todaysDate=str[2]+" "+str[1]+" "+str[5];
	    //System.out.println(todaysDate);
	    return todaysDate;
	   
	    
	}
	public static void main(String[] args) {
		new JavaUtility().generateDate();
		
	}
	
}
