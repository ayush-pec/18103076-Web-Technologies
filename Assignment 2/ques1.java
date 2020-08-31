import java.util.Scanner;

public class ques1 {
	
	public static void compare(String s1, String s2)
	{
		int res=0;
		
		int l1= s1.length();
		int l2= s2.length();
		
		int i=0, j=0;
		
		while(i<l1 && j<l2)
		{
			if(s1.charAt(i)<s2.charAt(j))
			{	res=-1;
				break;
			}
			if(s1.charAt(i)>s2.charAt(j))
			{	res=1;
				break;
			}
			i++;
			j++;
		}
		
		if(res==0)
		{
			if(l1<l2)
				res=-1;
			if(l1>l2)
				res=1;		
		}
		
		if(res==0)
			System.out.println("Both strings are equal");
		if(res==-1)
			System.out.println("s1 comes befor s2 lexicographically!");
		if(res==1)
			System.out.println("s2 comes before s1 lexicographically!!");
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter First String: ");
		String s1= input.nextLine();
		System.out.print("Enter Second String: ");
		String s2= input.nextLine();
		input.close();
		compare(s1, s2);
	}
}
