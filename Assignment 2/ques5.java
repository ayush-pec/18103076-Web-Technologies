import java.util.*;

public class ques5 {
	
	public static void union(int A[], int B[], int n)
	{
		boolean check[]= new boolean[n];
		
		for(int i=0; i<A.length; i++)
		{
			check[A[i]]= true;
		}
		for(int i=0; i<B.length; i++)
			check[B[i]]= true;
		
		
		System.out.print("A UNION B is: ");
	    
		for(int i=0; i<n ; i++)
			if(check[i])
			System.out.print(i+" ");
		System.out.println();
	}
	
	public static void intersect(int A[], int B[], int n)
	{
		boolean check[]= new boolean[n];
		
		for(int i=0; i<A.length; i++)
		{
			check[A[i]]= true;
		}
		System.out.print("A INTERSECTION B is: ");
		
		for(int i=0; i<B.length; i++)
			if(check[B[i]])
				System.out.print(B[i]+" ");	
		System.out.println();
	}
	
	public static void complement(int A[], int n)
	{
		boolean check[]= new boolean[n];
		for(int i=0; i<A.length; i++)
			check[A[i]]= true;
		
		System.out.print("The complement of the give set is:");
		
		for(int i=0; i<n; i++)
			if(check[i]==false)
				System.out.print(i+" ");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n;
		Scanner input = new Scanner(System.in);
		System.out.println("Input the total numbers of elements in the universe. (E.g.: 2 for (0,1) ");
		n= input.nextInt();
		
	    System.out.print("No. of elements in Set A: ");
	    int count1= input.nextInt();
	    System.out.println("Enter the elements of Set A!");
	    int A[]= new int[count1];
	    Set<Integer> set_A= new HashSet<Integer>();
	    Set<Integer> set_B= new HashSet<Integer>();
	   
	    
	    for(int i=0; i<count1; i++)
	    {
	    	A[i]= input.nextInt();
	    	set_A.add(A[i]);
	    }
	    System.out.print("No. of elements in Set B: ");
	    int count2= input.nextInt();
	    System.out.println("Enter the elements of Set B!");
	    int B[]= new int[count2];
	    for(int i=0; i<count2; i++)
	    {
	    	B[i]= input.nextInt();
	    	set_B.add(B[i]);
	    }
	    input.close();
	    
	    long s1= System.nanoTime();
	    System.out.println("------------------------------------------------");
	    System.out.println("Using Arrays: ");
	    union(A, B, n);
	    intersect(A,B,n);
	    complement(A, n);
	    complement(B, n) ;
	    System.out.println("------------------------------------------------");
	    long e1= System.nanoTime();
	    
	   
	    
	    long s2= System.nanoTime();
	    System.out.println("------------------------------------------------");
	    System.out.println("Using Hash_Set: "); 
	    // To find union  
        Set<Integer> union = new HashSet<Integer>(set_A);  
        union.addAll(set_B);  
        System.out.print("A UNION B: ");
        System.out.println(union);  
  
        // To find intersection  
        Set<Integer> intersection = new HashSet<Integer>(set_A);  
        intersection.retainAll(set_B);  
        System.out.print("A INTERSECTION B: ");  
        System.out.println(intersection);  
	  
	    
	    //Complement
	    Set<Integer> Universe= new HashSet<Integer>();
	    for(int i=0; i<n; i++)
	    	Universe.add(i);
	    Set<Integer> differenceSet = new HashSet<Integer>(Universe);
	    differenceSet.removeAll(set_A);
        System.out.print("Complement of Set A: ");  
        System.out.println(differenceSet);
        
        differenceSet = new HashSet<Integer>(Universe);
	    differenceSet.removeAll(set_B);
        System.out.print("Complement of Set B: ");  
        System.out.println(differenceSet);
        System.out.println("------------------------------------------------");
	    
        long e2= System.nanoTime();
	    System.out.println("------------------------------------------------");
	    System.out.println("Cost of operations using ARRAY: "+ (e1-s1) + " ns");
	    System.out.println("Cost of operations using HASH_SET: "+ (e2-s2) + " ns");
	    System.out.println("------------------------------------------------");
	    
	}
}
