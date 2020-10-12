
public class ques2 {
	
		public static void main(String[] args) {
			
			
				int var= -1;  // 1111 1111 1111 1111 1111 1111 1111 1111
				//1 is converted to 2's complement format.. 
				System.out.println(var);
				
				byte byt= (byte)var;  // 1111 1111  //Least significant 8 bits are sliced to form byte
				System.out.println(byt);
				//Since MSF is 1 hence, while displaying 2's complement is taken along with negative sign which becomes -1
				
				char ch= (char)byt;  // 1111 1111 1111 1111
				//Since MSF is 1, hence while converting to bigger datatype, the data has to be preserved, hence
				//the 8 1s are added, so that the value remains -1.
				System.out.println(ch);
				//Since, ch has no negative values, hence MSF here is not used for +/- sign,
				//Hence, the value becomes 65535
				//Symbol corresponding to the unicode value of ch is displayed.
				
				int final_val= (int)ch; //0000 0000 0000 0000 1111 1111 1111 1111
				//Since, char has no negatives, hence MSF is not taken into consideration while converting from char to int.
				//Hence, all zeroes are added in the most significant part to make 16 bits to 32 bits
				System.out.println(final_val);
				
				
				
		}
}