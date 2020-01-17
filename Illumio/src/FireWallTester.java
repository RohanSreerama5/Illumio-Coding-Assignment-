/* The following class can be used to test Firewall.java with the given test cases. The program will prompt you to enter a filepath to a csv file 
 * that contains Fire Wall Rules. 
 */


import java.util.*; 





public class FireWallTester {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis(); //timer 
		System.out.println("Enter a filepath to a csv file containing Fire Wall Rules: "); 
		Scanner userInput = new Scanner(System.in); 
		String userDesiredPath = userInput.nextLine();
		userInput.close();
		
		Firewall myFirewall = new Firewall(userDesiredPath); 

		
		
		System.out.println(myFirewall.acceptPacket("inbound","tcp", 80,"192.168.1.2")); //running test cases
		System.out.println(myFirewall.acceptPacket("outbound","tcp", 15000,"192.168.10.11")); 
		System.out.println(myFirewall.acceptPacket("inbound","udp", 53,"192.168.2.1")); 
		System.out.println(myFirewall.acceptPacket("outbound","udp", 1500,"52.12.48.92")); 
		System.out.println(myFirewall.acceptPacket("inbound","tcp", 81,"192.168.1.2")); 
		System.out.println(myFirewall.acceptPacket("inbound","udp", 24,"52.12.48.92")); 
		
		long end = System.currentTimeMillis(); 
		
		System.out.println(end-start); //prints execution time 
		
		
	}
	
	
}

//C:\\Users\\Rohan\\Desktop\\FireRules.csv
//C:\\Users\\Rohan\\Desktop\\BigRules.csv