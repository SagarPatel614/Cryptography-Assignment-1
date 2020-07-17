package rc4;

import java.util.Scanner;

public class Main_RC4_Code {
	
	static RC4_Logic rc4;
	
	public static void main(String args[]) throws Exception {
		
		String key;			//variable to store user's key
		int n;				//to store the number of rounds for PRGA and IPRGA
		
		//Request key from user
		System.out.print("\nEnter key: ");
		Scanner scanKey = new Scanner(System.in);
		key = scanKey.next();				//get users key
		
		byte[] keyword = key.getBytes();	//convert string key to bytes for S array generation
		
		//Obtain the number of rounds to check the PRGA and IPRGA algorithms
		System.out.print("\nEnter number of rounds: ");
		Scanner scanRounds = new Scanner(System.in);
		n = scanRounds.nextInt();		//get the number
		
		//Close the scanner objects
		scanKey.close();
		scanRounds.close();
		
		//Initialize the KSA with user key
		rc4 = new RC4_Logic(keyword);	
		
		System.out.print("\n\n");
		
		//Perform n-round PRGA
		System.out.println("Performing given rounds of PRGA on S array results into the following state:");
		rc4.prga(n);
		
		System.out.print("\n\n");
		
		//Perform n-round IPRGA
		System.out.println("Performing same number of rounds of IPRGA on the obtained state from PRGA gives the following state:");
		rc4.iprga(n);
		
		System.out.print("\n\n");
		
		//Conclusion
		System.out.println("\nAs it can be observed that applying IPRGA-n algorithm on the obtained state after PRGA-n algorithm is equal to the initial state, i.e. the generated S array from KSA.\nThus, any former state can be obtained from latter state by applying certain rounds of IPRGA.");
	}
}
