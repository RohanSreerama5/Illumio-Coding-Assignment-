# Illumio-Coding-Assignment-
Illumio Coding Assignment files

Hello, and thank you for this opportunity to interview for Illumio! 

The main file, Firewall.java, can be found at /Illumio/src/Firewall.java. 

Solution Testing: 
My solution was tested using a short program I wrote called FireWallTester.java. Essentially, this program prompts the user to enter a 
path to a .csv file that includes Fire Wall Rules, such as the ones described in the assignment. 

ie. 
inbound,tcp,80,192.168.1.2
outbound,tcp,10000-20000,192.168.10.11
inbound,udp,53,192.168.1.1-192.168.2.5
outbound,udp,1000-2000,52.12.48.92

The FireWallTester class inputs the user's filepath into the Firewall constructor and then, using Firewall.java, is able to return true or false depending on if a packet should be allowed through the Fire Wall. Additionally, this class will output execution time, which 
was useful in testing my algorithm each time it was optimized for performance. 

In addition to testing the program with the 4 given Fire wall rules, I created my own dataset of 500k Fire wall rules in order to 
test the speed of my algorithm. This file can be found at the beginning of the repository labeled BigRules.csv. 

BigRules.csv was created using simple algorithms I wrote in LoadTester.java intended to randomly generate directions, protocols, port numbers, and IP addresses. 

Interesting choices: 
1. I utilized a Buffered Reader to read through the .csv file instead of what I initially used, a Scanner. The Scanner proved to be cumbersome and fail at times when the file had thousands of records. The Buffered Reader had the least latency. 

Refinements/Optimizations: 
Provided more time, there are certainly a number of ideas that would make this program more robust. 
- I could create a single method used to split the bounds of an IP range and subsequently split their octets, convert them to integers,
and store them in variables. This method could be called inside the while() loop instead of the current solution. 
- Perhaps I could even use a library like OpenCSV or Apache's CSVParser class to parse through the .csv file. 
-  If this was a real firewall, I could use a queue to queue up incoming network traffic. Each packet would be stored as a node, which can be passed to the algorithm individually to decide if the packet should be allowed past the firewall. 
- Code complexity could also be reduced if a hash map was used to first map the packet's direction and protocol to every Fire Wall Rule with the same packet and direction. Following this, the algorithm would scan through this new list of rules to see which one has the 
appropriate IP/IP range and port/port range. Essentially, network traffic would be stored as the values and the keys would be individual Fire Wall Rules. In the first pass, all of the keys that have a direction and protocol that matches the packet would be mapped to that packet. In the second pass, the algorithm would scan through this new list of keys to determine if the port matches, and finally the IP. 

After the hash table has been created in the first pass, the algorithm can simply perform lookups to generate a list of relevant 
Fire Wall Rules to linear scan through to determine if the packet matches with any one rule. Lookups take constant time O(1) which can signficanly reduce execution time. 

Interested Team: 
I would like to contribute to the platform team as I'm interested in managing infrastructure, both on-prem and on the cloud, for various applications. I'm particularly keen on implementing solutions for high availability and scalability using technologies like Kubernetes and automating installations, maintenance, monitoring, etc. 
Ranking: 
1. Platform Team 
2. Data Team 
3. Policy Team

