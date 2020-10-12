import java.util.Scanner;

public class Solution {
	static int n;
	static int m;
	
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	n= in.nextInt();
	m= in.nextInt();
	
	in.nextLine();
	
	String[] crops = new String[n];
	for (int i=0;i<n;i++){
		crops[i]=in.nextLine();
	}
	
	in.close();
	System.out.print(replant(crops));
}

public static int check_harm(int i, int j, String[] crops) {
	int count=0;
	
	if(i!=0)
	{
		if(crops[i-1].charAt(j)==crops[i].charAt(j))
			count++;
	}
	
	if(i!=n-1)
	{
		if(crops[i+1].charAt(j)==crops[i].charAt(j))
			count++;
	}
	
	if(j!=0)
	{
		if(crops[i].charAt(j-1)==crops[i].charAt(j))
			count++;
	}
	
	if(j!=m-1)
	{
		if(crops[i].charAt(j+1)==crops[i].charAt(j))
			count++;
	}
	
	return count;
}

public static void change_crop(int i, int j, String[] crops)
{
	char a, b, c, d;
	a=b=c=d='A';
	
	if(i!=0)
		a=crops[i-1].charAt(j);
	if(j!=m-1)
		b= crops[i].charAt(j+1);
	if(i!=n-1)
		c= crops[i+1].charAt(j);
	if(j!=0)
		d= crops[i].charAt(j-1);
	
	for(char ch='a'; ch<='z'; ch++)
	{
		if(ch!=a && ch!=b && ch!=c && ch!=d)
			{
				crops[i]= crops[i].substring(0, j) + ch + crops[i].substring(j+1);
			}
	}
}

public static int replant(String[] crops){
	// Write your code here
	// Return the number of replanted crops
	
	int rep=0;
	
	for(int i=0; i<n; i++)
	{
		for(int j=0; j<m; j++)
		{
			int self_harm= check_harm(i, j, crops);
			if(self_harm==0)
				continue;
			int right=0;
			int down=0;
			int flag=0;
			
			if(j!=m-1)
			{
				if(crops[i].charAt(j+1)==crops[i].charAt(j))
					right= check_harm(i, j+1, crops);
			}
			
			if(right>self_harm)
				{change_crop(i, j+1, crops);
				rep++;
				self_harm--;}
			else
			{
				change_crop(i, j, crops);
				rep++;
				j--;
				continue;
			}
				
			if(self_harm==0)
				continue;
			
			if(i!=n-1)
			{
				if(crops[i+1].charAt(j)==crops[i].charAt(j))
					down= check_harm(i+1, j, crops);
			}
			if(down>self_harm) {
				change_crop(i+1, j, crops);
				rep++;
				}
			else
			{
				change_crop(i, j, crops);
				rep++;
			}
			
			
			
		}
	}
	
	return rep;
}

}