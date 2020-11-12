
class Counting extends Thread{
	
	public void run() {
		String S="";
		 for(int i=1; i<=100; i++)
		 {
			 try{Thread.sleep(1000);}catch(Exception e) {}
			 S=S+i+" ";
			 if(i%10==0)
			 {
				System.out.print(S);
				 S="";
				 System.out.println();
			 }
		 }
	}
}


public class ques1 {
	
public static void main(String[] args) {
	Counting t1= new Counting();
	t1.start();
}

}
