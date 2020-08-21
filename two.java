import java.util.*;

public class two {
		
	public static String censor(String text, String word)
	{
		String[] temp= text.split(" ");
		
		int index=0;
		for(String str: temp)
		{
			if(str.compareTo(word)==0)
			{
				String s="";
				s+= str.charAt(0);
				
				for(int j=1; j<str.length(); j++)
				s+= '*';
				
				temp[index]= s;
			}
			index++;
		}
		
		String s="";
		for(String t:temp)
		{
			s+= t;
			s+=" ";
		}
		s= s.trim();
		return s;
	}
	
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the paragraph:");
		String text= sc.nextLine();
		
		
		String[] v= {"happy", "sad"};
		
		for(String str: v)
		{
			text= censor(text, str);
		}
		
		System.out.println(text);
		
	}
}
