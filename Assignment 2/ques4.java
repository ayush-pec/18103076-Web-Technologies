import java.util.*;

public class ques4 {
	
	public static long findsum(int i)
	{
		long sum=0;
		for(int j=i; j>=1; j--)
		{
			sum+= j;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		//By solving using quadratic, it is clear that 1 is the maximum integer
		//But below is the code for checking it automatically
		
		System.out.println("Please Wait!!!! The procesing will take some time.");
		
		long sum= findsum(Integer.MAX_VALUE);
		
		//System.out.println(sum);
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println((long)i*(long)i);
		//System.out.println(Long.MAX_VALUE);
		
		System.out.println("Loading...");
		
		for(int i=Integer.MAX_VALUE; i>=1; i--)
		{
			long sq= (long)i*(long)i;
			if(sq==sum)
			{
				System.out.println("The answer is: "+i);
				break;
			}
			sum= sum- (long)i;
			
			if(i==1)
			{
				System.out.println("There is no such integer.");
			}
		}
		
		
	}
}
