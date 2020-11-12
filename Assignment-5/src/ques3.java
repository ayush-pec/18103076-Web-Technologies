import java.util.*;

public class ques3 {
	
	//Function to check if the character is a bracket of not
	public static boolean isBracket(char ch) {
		if(ch=='(' || ch=='[' || ch=='{' || ch==')' || ch==']' || ch=='}' )
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please Enter the String!");
		String S= sc.nextLine();
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<S.length(); i++)
		{
			if(!isBracket(S.charAt(i)))
				continue;
			if(stack.isEmpty())
				stack.push(S.charAt(i));
			else
			{
				Character top= stack.peek();
				Character curr= S.charAt(i);
				
				if(curr=='(' || curr=='[' || curr=='{')
					stack.push(curr);
				else {
					if( (top=='(' && curr==')') || (top=='[' && curr==']') || (top=='{' && curr=='}'))
						stack.pop();
					else
					{
						System.out.println("The bracket sequence is INCORRECT");
						System.exit(0);
					}
				}
			}
			
		}
		
		if(stack.isEmpty())
			System.out.println("The bracket sequence is CORRECT");
		else
			System.out.println("The bracket sequence is INCORRECT");
		
	}
}
