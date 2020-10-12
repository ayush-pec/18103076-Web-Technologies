import java.util.Scanner;

public class ques1 {
	static int n;
	static int m;
	
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.print("Enter number of rows: ");
	n= in.nextInt();
	System.out.print("Enter number of columns: ");
	m= in.nextInt();
	
	in.nextLine();
	
	String[] crops = new String[n];
	for (int i=0;i<n;i++){
		System.out.print("Row No. "+(int)(i+1)+": ");
		crops[i]=in.nextLine();
	}
	
	in.close();
	System.out.print(replant(crops, 0, 0));
}

public static int replant(String[] crops, int i, int j) {
	
	if(i>=n)
		return 0;
	
	int count=0;
	
	if(i!=n-1)
	{
		if(crops[i+1].charAt(j)==crops[i].charAt(j))
			count++;
	}

	if(j!=m-1)
	{
		if(crops[i].charAt(j+1)==crops[i].charAt(j))
			count++;
	}
	
	if(count==0)
		return replant(crops, i+(j+1)/m, (j+1)%m);
	
	if(count==2)
	{
		String copy1[]= crops.clone();
		change_crop(i, j, copy1);
		int a= 1 + replant(copy1, i+(j+1)/m, (j+1)%m);
		
		change_crop(i+1, j, crops);
		change_crop(i, j+1, crops);
		int b= 2+ replant(crops, i+(j+1)/m, (j+1)%m);
		
		if(a<=b)
			return a;
		else
			return b;
	}
	
	if(i!=n-1 && crops[i+1].charAt(j)==crops[i].charAt(j))
	{
		change_crop(i+1, j, crops);
		return 1+replant(crops, i+(j+1)/m, (j+1)%m);
	}
	
	if(j!=m-1 && crops[i].charAt(j+1)==crops[i].charAt(j))
	{
		change_crop(i, j+1, crops);
		return 1+replant(crops, i+(j+1)/m, (j+1)%m);
	}
	
	return 0;
	
}


public static int check_harm(int i, int j, String[] crops) {
	int count=0;
	
	
	if(i!=n-1)
	{
		if(crops[i+1].charAt(j)==crops[i].charAt(j))
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

}