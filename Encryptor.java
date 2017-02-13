import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.time.Instant;
public class Encryptor {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		int A,B;
		
		Scanner input = new Scanner(System.in);
		
		String timestampString;
		String messageOriginal;
		char[] messageArray;
		int[] encyptedArray;
		
		while(input.nextLine().equals("close")){
		
			messageOriginal = input.nextLine();
			
			timestamp = new Timestamp(System.currentTimeMillis());
			
			timestampString = sdf.format(timestamp).toString();
			
			A = 9*Integer.parseInt(timestampString.substring(0,2));

			B = (3*Integer.parseInt((timestampString).substring(3,5))) + 
			(Integer.parseInt(timestampString.substring(6)));
			
			messageArray = messageOriginal.toCharArray();
			encyptedArray = new int[messageArray.length];
			
			for(int x = 0; x < messageArray.length; x++){
				
				encyptedArray[x] = messageArray[x] ^ (x%2 == 0? A:B);
				
			}
			System.out.print(sdf.format(timestamp) + " ");
			
			for(int out: encyptedArray){
				
				System.out.print("0x" + Integer.toHexString(out).toUpperCase() + " ");
				
			}
			
			System.out.println();

		}
		
		input.close();
	}

}
