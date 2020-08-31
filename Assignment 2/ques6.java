import java.util.*;

public class ques6 {
	
	public static void main(String[] args) {
		int n;
		Scanner input= new Scanner(System.in);
		System.out.print("Enter n: ");
		n= input.nextInt();
		input.close();
		
		long s1= System.nanoTime();
		long sec= 9000000000L;
		while(n!=1)
		{
			if(n%2==0)
				n= n/2;
			else
			{
				long t= (long)n*3 + 1;
				if(t>Integer.MAX_VALUE)
					System.out.println("The value of n has crossed Integer LIMITS!!!");
				else
					n= n*3 + 1;
			}
			System.out.println(n);
			
			if(System.nanoTime()> s1+ sec)
				System.out.println("The value will never be 1");
		}
		
		
	
	}
}
