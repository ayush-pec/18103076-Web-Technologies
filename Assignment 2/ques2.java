import java.util.*;


public class ques2 {
		
		public static void countingSort(int arr[], int count[])
		{
			int n= arr.length;
			
			for(int i=1; i<21; i++)
			{
				count[i]= count[i]+count[i-1];
			}
			
			int sol[]= new int[n];
			
			System.out.println("Final Array:");
			
			for(int i=0; i<n; i++)
			{
				int a= arr[i];
				sol[count[a]-1]= a;
				count[a]--;
				
			}
			
			for(int i=0; i<n; i++)
				System.out.print(sol[i]+" ");
			
		}
	
		public static void main(String[] args) {
			Scanner input= new Scanner(System.in);
			System.out.print("Enter the size of your input: ");
			int n= input.nextInt();
			
			if(n<0)
			{
				System.out.println("Size of input can't be negative!!");
				System.out.println("Please try again!");
				return;
			}
			
			int count[]= new int[21];
			
			int arr[]= new int[n];
			
			for(int i=0; i<21; i++)
				count[i]=0;
			
			System.out.println("Enter the array:");
			
			for(int i=0; i<n; i++)
			{
				int a= input.nextInt();
				if(a<0 || a>20)
				{
					System.out.println("This is not a valid input. Please try again!!");
					System.out.println("The accepted values are from 0 to 20.");
					return;
				}
				arr[i]=a;
				count[a]++;
			}
			input.close();
			
			countingSort(arr, count);
		}
}
