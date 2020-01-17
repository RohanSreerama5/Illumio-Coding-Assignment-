/* By Rohan Sreerama for Illumio
 * The following program accepts 'packets of network traffic' and returns true if the packet should be let through the Fire Wall.  
 */


import java.io.*; 


public class Firewall{
	
	
	
	private String myFilePath; 
	
	//Constructor
	public Firewall(String filepath) {
		
		myFilePath = filepath; 
		
	}
	
	
	
	//Accessors
	public String getFilePath() {                      //cane be called to return the filepath 
		return myFilePath; 
	}
	
	//Mutators
	public void setFilePath(String filepath) {         //can be called to set a filepath 
		myFilePath = filepath; 
	}
	
	
	
	//Functions 
	public boolean acceptPacket(String direction, String protocol, int port, String ipAddress) {
		
	 BufferedReader reader = null;                    //reader intended to read the file 
		
		
		
	 try{
			
		
		
		reader = new BufferedReader(new FileReader(myFilePath));
		
	  }catch (FileNotFoundException fnfex) {          //Outputs "File not found" if file does not exist 
	 	 	System.out.println(fnfex.getMessage() + "File not found"); 
			System.exit(0);                           //exits program if file not found 
			
	  }
		
		
	 String ipParts[] = ipAddress.split("\\.");       //splits ipAddress from packet into 4 octets and stores in a String array
	 int ipPart1 = Integer.parseInt(ipParts[0]);      //turns each octet string into an integer 
	 int ipPart2 = Integer.parseInt(ipParts[1]);
	 int ipPart3 = Integer.parseInt(ipParts[2]); 
	 int ipPart4 = Integer.parseInt(ipParts[3]); 
		
		
		
		
	 String portString = Integer.toString(port);      //turns packet's port number from integer to string 
	 
		
	  try {
		  
		
		String line = ""; 
		
		while((line = reader.readLine()) != null) {   //as long as the csv file has data to read, while loop functions 
			String data =  line;                      //loads one record on csv file each time 
			String[] dataStream = data.split(",");    //splits each record at the comma, and stores in a String array 
			String dir = dataStream[0];               //direction is stored in first index of array
			String prot = dataStream[1];              //protocol is stored in second index of array
			String portNum = dataStream[2];           //port number is stored in third index of array
			String ipAddr = dataStream[3];            //ipAddress is stored in 4th index of array
			
			
			boolean portInRange = false;              //preset defaults that can change later in program
			boolean ipInRange = false; 
			
			if(portNum.contains("-")) {                            //if port number given as a range, then enters this if-statement
				String parts1[] = portNum.split("-");              //splits the range at the "-" and stores left and right bound in a String array
				int portNumBound1 = Integer.parseInt(parts1[0]);   //converts left bound into integer 
				int portNumBound2 = Integer.parseInt(parts1[1]);   //converts right bound into integer
				
				if(port >= portNumBound1 && port <= portNumBound2) {   //if the port number from the packet is in the port range, then
					portInRange = true;                                //portInRange becomes true
				} 
				
				
			}
			
			if(ipAddr.contains("-")) {                //if ipAddress is given as a range (in the csv file), 
				String parts2[] = ipAddr.split("-");  //ipAddress range is split at the "-" and stores each bound in a String array
				
				String subpartsBound1[] = parts2[0].split("\\."); //the left bound is split at the "." and each octet is stored in a String array
				int subpartBound1Part1 = Integer.parseInt(subpartsBound1[0]);    //converts 1st octet into integer 
				int subpartBound1Part2 = Integer.parseInt(subpartsBound1[1]);    //converts 2nd octet into integer
				int subpartBound1Part3 = Integer.parseInt(subpartsBound1[2]);    //converts 3rd octet into integer
				int subpartBound1Part4 = Integer.parseInt(subpartsBound1[3]);    //converts 4th octet into integer
				
				
				String subpartsBound2[] = parts2[1].split("\\.");     //right bound is split at the "." and each octet is stored in String array
				int subpartBound2Part1 = Integer.parseInt(subpartsBound2[0]); 
				int subpartBound2Part2 = Integer.parseInt(subpartsBound2[1]); 
				int subpartBound2Part3 = Integer.parseInt(subpartsBound2[2]); 
				int subpartBound2Part4 = Integer.parseInt(subpartsBound2[3]); 
				
				
				//ipAddress from packet is compared to ipAddress range from csv file 
				
				if(ipPart1 >= subpartBound1Part1 && ipPart1 <= subpartBound2Part1) {   //packet's first IP octet (ex.192) is compared to first octet of left bound and first octet of right bound IP
					if(ipPart2 >= subpartBound1Part2 && ipPart2 <= subpartBound2Part2) {  
						if(ipPart3 >= subpartBound1Part3 && ipPart3 <= subpartBound2Part3) {
							if(ipPart4 >= subpartBound1Part4 && ipPart4 <= subpartBound2Part4) {   //comparison continues till the innermost octets of the bounds are compared to the packet's innermost (4th octet)
								ipInRange = true;      //if all tests pass, then packet's IP is in range
							}
						}
					}
				}
				
			}
			
			if(dir.equals(direction) && prot.equals(protocol)) {  //first checks if packet's direction or protocol match that of a rule in csv file
				
				if((portString.equals(portNum)) || (portInRange == true)) { //then checks if the packet's port number is exactly the same as the port number in the respective Fire Wall Rule in the csv file
					
					  //if algorithm is comparing packet port number with a range of port numbers, then portInRange must be true to pass test
					
					if((ipAddress.equals(ipAddr)) || (ipInRange == true)) { //finally checks if packet's IP is exactly the same as the respective IP on the csv file 
						
						//if algorithm is comparing packet's IP to a range of IPs, then ipInRange must be true 
						
						reader.close();   //closes Buffered Reader to avoid resource leak 
						return true;  //If algorithm gets this far, then all tests have passed and the packet matches with a rule in the csv file 
						
						
						
					}
				}
				
			}
			
			
			
		}
		
		reader.close();
		return false; //packet's information does not match any rule in the csv file, so it cannot be let through the Fire Wall; returns false 
		
		
		
	 }catch (IOException ioex) {
	 	 	System.out.println(ioex.getMessage() + " Error reading file"); 
			return false; 
			
	 }
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}