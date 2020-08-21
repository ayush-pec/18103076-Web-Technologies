import java.util.*;

public class four {
	
	public static boolean check(String s1, String s2)
	{
		int count[]= new int[256];
		
		if(s1.length()!= s2.length())
			return false;
		
		for(int i=0; i<s1.length(); i++)
		{
			count[s1.charAt(i)]++;
		}
		
		for(int i=0; i<s1.length(); i++)
		{
			int ch= s2.charAt(i);
			
			if(count[ch]==0)
				return false;
			
			count[ch]--;
		}
		
		return true;
	}
	
public static void main(String[] args) {
		System.out.println("Enter First String:");
		Scanner sc= new Scanner(System.in);
		String s1= sc.nextLine();
		
		System.out.println("Enter Second String:");
		String s2= sc.nextLine();
		
		sc.close();
		
		if(check(s1, s2))
			System.out.println("The given strings are Anagrams!!");
		else
			System.out.println("The given strings are NOT Anagrams");
		
}

}
