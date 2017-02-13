import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Friendly {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		int A,B;
		
		Scanner input = new Scanner(new File("friendly.dat"));
		
		String timestamp;
		String messageOriginal;
		char[] messageArray;
		int[] encyptedArray;
		
		while(input.hasNextLine()){
		
			timestamp = input.next().substring(0,8);
			//System.out.println(timestamp);
			
			messageOriginal = input.nextLine().substring(1);
			//System.out.println(messageOriginal);
			
			A = 9*Integer.parseInt(timestamp.substring(0,2));
			//System.out.println(A);
			
			B = (3*Integer.parseInt(timestamp.substring(3,5))) + (Integer.parseInt(timestamp.substring(6)));
			//System.out.println(B);
			
			messageArray = messageOriginal.toCharArray();
			encyptedArray = new int[messageArray.length];
			
			for(int x = 0; x < messageArray.length; x++){
				
				encyptedArray[x] = messageArray[x] ^ (x%2 == 0? A:B);
				
			}
			System.out.print(timestamp + " ");
			
			for(int out: encyptedArray){
				
				System.out.print("0x" + Integer.toHexString(out).toUpperCase() + " ");
				
			}
			
			System.out.println();
		}
	}

}
