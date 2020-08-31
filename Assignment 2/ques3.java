import java.util.*;

public class ques3 {
	
	public static void merge(char arr[], int start, int mid, int end)
	{
		int i= start;
		int j= mid+1;
		
		char temp[]= new char[end-start+1];
		int k=0;
		
		while(i<=mid && j<=end)
		{
			if(arr[i]<=arr[j])
				temp[k++]= arr[i++];
			else
				temp[k++]= arr[j++];
		}
		
		while(i<=mid)
			temp[k++]= arr[i++];
		
		while(j<=end)
			temp[k++]= arr[j++];
		
		for(i=start; i<=end; i++)
		{
			arr[i]= temp[i-start];
		}
		
	}
	
	public static void merge_sort(char arr[], int start, int end)
	{
		if(start>=end)
			return;
		
		int mid= (start+end)/2;
		
		merge_sort(arr, start, mid);
		merge_sort(arr, mid+1, end);
		
		merge(arr, start, mid, end);
			
	}
	
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("Enter the string: ");
		String s= input.nextLine();
		input.close();
		
		char arr[]= new char[s.length()];
		for(int i=0; i<s.length(); i++)
			arr[i]= s.charAt(i);
		
		merge_sort(arr, 0, s.length()-1);
		
		System.out.println("The new string is: ");
		for(int i=0; i<s.length(); i++)
			System.out.print(arr[i]);
	}
}
