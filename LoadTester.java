/*The following was used to test individual segments of code in Firewall.java and to generate the BigRules.csv file that contains over 500K
 * records of Fire Wall Rules. It includes the sample inputs given in the Coding Assignment. 
 */

import java.util.*; 
import java.io.*; 


public class LoadTester {
	
  public static void main(String[] args) throws FileNotFoundException {
	  
	  File filename = new File("C:\\Users\\Rohan\\Desktop\\BigRules.csv"); 
	  
	  Scanner scan = null; 
	  
	
		  scan = new Scanner(filename); 
		  
		  
			  System.out.println(scan.nextLine());
		  
		  
		  
		  scan.close();
	  
	  
	  /*while(scan.hasNextLine()) {
		  System.out.println(scan.nextLine());
	  }
	  scan.close();
	}catch(FileNotFoundException e){
		e.printStackTrace(); */
		
	
	
	/*Random dir = new Random(); 
	
	int number; 
	
	for(int i=1; i<=1000000000; i++) {
		number = 1+dir.nextInt(2); 
		
		
		if(number == 1) {
			System.out.println("outbound");
		}else {
			System.out.println("inbound"); 
		}
		
	}*/
	
	

  }
}
