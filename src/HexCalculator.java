//import java.io.*; 
import java.util.Scanner;
import java.util.HashMap; 

class HexCalculator 
{ 
	
	// Hexadecimal to Binary 
    static boolean hexToBinary(String hex1, String hex2, int type) 
    { 
        String binary1 = ""; 
        String binary2 = ""; 
        hex1 = hex1.toUpperCase(); 
        hex2 = hex2.toUpperCase(); 
  
        // initializing the HashMap class 
        HashMap<Character, String> hashMap 
            = new HashMap<Character, String>(); 
  
        // storing the key value pairs 
        hashMap.put('0', "0000"); 
        hashMap.put('1', "0001"); 
        hashMap.put('2', "0010"); 
        hashMap.put('3', "0011"); 
        hashMap.put('4', "0100"); 
        hashMap.put('5', "0101"); 
        hashMap.put('6', "0110"); 
        hashMap.put('7', "0111"); 
        hashMap.put('8', "1000"); 
        hashMap.put('9', "1001"); 
        hashMap.put('A', "1010"); 
        hashMap.put('B', "1011"); 
        hashMap.put('C', "1100"); 
        hashMap.put('D', "1101"); 
        hashMap.put('E', "1110"); 
        hashMap.put('F', "1111"); 
  
        int i; 
        char ch; 
  
        for (i = 0; i < hex1.length(); i++) { 
             
            ch = hex1.charAt(i); 
            if (hashMap.containsKey(ch)) 
                binary1 += hashMap.get(ch); 
  
        } 
        
        for (i = 0; i < hex2.length(); i++) { 
            
            ch = hex2.charAt(i); 
            if (hashMap.containsKey(ch)) 
                binary2 += hashMap.get(ch); 
  
        }
        
        int bin1 = Integer.parseInt(binary1);
        int bin2 = Integer.parseInt(binary2);
        boolean binary3 = false;
        
        if (type==1){
        	binary3 = bin1 < bin2;
        }
        else if(type==2){
        	binary3 = bin1 > bin2;
        }
        
        return binary3;
    }
	
	// Function to convert hexadecimal to decimal 
	static int hexadecimalToDecimal(String hexVal) 
	{ 
		int len = hexVal.length(); 
	
		// Initializing base value to 1, i.e 16^0 
		int base = 1; 
	
		int dec_val = 0; 
	
		// Extracting characters as digits from last character 
		for (int i=len-1; i>=0; i--) 
		{ 
			
			if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9') 
			{ 
				dec_val += (hexVal.charAt(i) - 48)*base; 
				
				// incrementing base by power 
				base = base * 16; 
			} 

			else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F') 
			{ 
				dec_val += (hexVal.charAt(i) - 55)*base; 
		
				// incrementing base by power 
				base = base*16; 
			} 
		} 
		return dec_val; 
	} 
	
	
	// function to convert decimal to hexadecimal 
	static void decToHexa(int n) 
	{ 
		// char array to store hexadecimal number 
		char[] hexaDeciNum = new char[100]; 
	
		// counter for hexadecimal number array 
		int i = 0; 
		while(n!=0) 
		{ 
			int temp = 0; 
			temp = n % 16; 
			if(temp < 10) 
			{ 
				hexaDeciNum[i] = (char)(temp + 48); 
				i++; 
			} 
			else
			{ 
				hexaDeciNum[i] = (char)(temp + 55); 
				i++; 
			} 
		
			n = n/16; 
		} 
	
		// printing hexadecimal number array in reverse order 
		System.out.print("The result is : " );
		for(int j=i-1; j>=0; j--) 
			System.out.print( hexaDeciNum[j]); 
		System.out.print("\n");
	} 
	
	
	public static void main (String[] args) 
	{ 
		
		Scanner scan = new Scanner(System.in);
		int n = 0;
		int ch;
		while (true) {
	          System.out.println("Menu:");
	          System.out.println(
	                    "1) Perform arithmatic operation on Hexadecimal numbers" + "\n"
	                  + "2) Compare 2 hexadecimal numbers " + "\n"
	                  + "3) Convert Hexadecimal to Decimal" + "\n"
	                  + "4) Convert Decimal to Hexadecimal" + "\n"
	                  + "5) Exit " + "\n");
	          ch = scan.nextInt();
	          
	          switch (ch) {
	          
	          case 1:
	        	  
	        	  int ari;
	        	  System.out.println("Menu:");
		          System.out.println(
		                    "1) Add 2 Hexadecimal numbers" + "\n"
		                  + "2) Subtract 2 Hexadecimal numbers" + "\n"
		                  + "3) Multiply 2 Hexadecimal numbers" + "\n"
		                  + "4) Divide 2 Hexadecimal numbers" + "\n"
		                  + "5) Exit " + "\n");
		          	ari = scan.nextInt();
		          	
		          System.out.print("Enter first hexadecimal number : ");
	        	  String hexNum1 = scan.next();
	        	  System.out.print("Enter second hexadecimal number : ");
	        	  String hexNum2 = scan.next();
	        	  int dec1 = hexadecimalToDecimal(hexNum1);
	        	  int dec2 = hexadecimalToDecimal(hexNum2);
		          	
		          	
		          	switch(ari){
		          	case 1:
		          		int addedDec = dec1 + dec2;
		          		decToHexa(addedDec);
		          		break;
		          		
		          	case 2:
		          		int subDec = (dec1 - dec2);
		          		decToHexa(subDec);
		          		break;
		          		
		          	case 3:
		          		int mulDec = dec1 * dec2;
		          		decToHexa(mulDec);
		          		break;
		          		
		          	case 4:
		          		int divDec = dec1 / dec2;
		          		decToHexa(divDec);
		          		break;
		          		
		          	case 5:
		          		System.exit(1);;
		          	}
		          	
	        	  break;
	        
	          case 2:
	        	  
	        	  int com;
	        	  System.out.println("Menu:");
		          System.out.println(
		                    "1) First is equal to Second" + "\n"
		                  + "2) First is lesser than Second" + "\n"
		                  + "3) First is greater than Second" + "\n"
		                  + "5) Exit " + "\n");
		          com = scan.nextInt();
	        	  
	        	  System.out.print("Enter first hexadecimal number : ");
	        	  String hexNum3 = scan.next();
	        	  System.out.print("Enter second hexadecimal number : ");
	        	  String hexNum4 = scan.next();
	        	  
	        	  switch(com){
	        	  
	        	  	case 1:
	        	  		System.out.print(hexNum3.contentEquals(hexNum4));
	        	  		break;
	        	  	
	          	  	case 2:
	          	  		boolean checkSmaller = hexToBinary(hexNum3, hexNum4, 1);
	          	  		System.out.print("Is "+hexNum3+"smaller than "+hexNum4+ ": "+checkSmaller);
	          	  		break;
	          	  		
	          	  	case 3:
	          	  		boolean checkGreater = hexToBinary(hexNum3, hexNum4, 2);
	          	  		System.out.print("Is "+hexNum3+"smaller than "+hexNum4+ ": "+checkGreater);
	          	  		break;
	        	  }
	        	  int length1 = hexNum3.length();
	        	  int length2 = hexNum4.length();
	        	  if ( length1 == length2 ){
	        		  if(hexNum3.contentEquals(hexNum4)){
        				  System.out.println("The numbers are equal.");
        				  break;
        			  }
	        	  }
	        	  
	        	  else if( length1 < length2 ){
	        		  System.out.println(hexNum4 +" number is greater than "+ hexNum3);
    				  break;
	        	  }
	        	  
	        	  else {
	        		  System.out.println(hexNum3 +" number is greater than "+ hexNum4);
    				  break;
	        	  }
	        	  
	        	  break;
	        	  
	          case 3:
	        	  String hexNum = scan.next();	 
	        	  System.out.println(hexadecimalToDecimal(hexNum));
	        	  break;
	          
	          case 4:
	        	  decToHexa(n); 
	        	  break;
	        	  
	          case 5:
	        	  System.exit(0);
	          }
	          
//	         scan.close();
		}
	}
} 
