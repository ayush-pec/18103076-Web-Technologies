import java.util.*;

public class one {
	
	public static boolean checkzeros(int arr[])
	{
		for(int i=0; i<256; i++)
			if(arr[i]!=0)
				return false;
		
		return true;
	}
	
	public static int count(int arr[], String sub, String text)
	{
		if(sub.length()>text.length() || sub.length()==0)
			return 0;
			
		
		int total=0;
		
		for(int i=0; i<sub.length(); i++)
			arr[text.charAt(i)]--;
		
		if(checkzeros(arr))
			total++;
		
		for(int i=sub.length(); i<text.length(); i++)
		{
			arr[text.charAt(i)]--;
			arr[text.charAt(i-sub.length())]++;
			
			if(checkzeros(arr))
				total++;
		}
		
		return total;
	}
	
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the main String:");
		String text= sc.nextLine();
		
		System.out.println("Enter the Substring:");
		String sub= sc.nextLine();
		
		int arr[]= new int[256];
		
		for(int i=0; i<sub.length(); i++)
			arr[sub.charAt(i)]++;
		
		System.out.println("The count is: ");
		System.out.println(count(arr, sub, text));
		
		sc.close();

	}
}
