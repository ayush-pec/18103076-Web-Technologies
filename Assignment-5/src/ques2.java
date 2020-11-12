
class Count{
	static int max;
	static int number;
	
	public void run(int start, int end) {
		
		
		for(int i=start; i<=end; i++)
		{
			int count=1;
			for(int j=1; j<=(i/2)+1; j++)
			{
				if(i%j==0)
					count++;
			}
			
			synchronized(this) {
				if(count>max)
				{
					max=count;
					number= i;
				}
			}
				
		}
		//System.out.println(count);
		//try {Thread.sleep(1000);}catch(Exception w) {}
		//count++;
		//System.out.println(count);
	}
}


class MyThread extends Thread{
	Count C;
	int start;
	int end;

	MyThread(Count C, int start, int end){
		this.C= C;
		this.start= start;
		this.end= end;
	}
	
	public void run() {
		C.run(start, end);
	}
	
}


public class ques2 {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Count C= new Count();
		MyThread threads[]= new MyThread[100];
		int j=0;
		for(int i= 100; i<=10000; i+=100) {
			threads[j]= new MyThread(C,i-99,i);
			threads[j].start();
			j++;
		}
		
		for(int i=0; i<100; i++)
		{
			try {
				threads[i].join();
			}
			catch(Exception e) {}
		}
		long end = System.currentTimeMillis();
		System.out.println("Range: 1 to 10000");
		System.out.println("The maximum number of divisors are: "+C.max);
		System.out.println("Of number: "+C.number);
		System.out.println("Time elapsed: "+ (end - start) +" milli-seconds");
	}	
}
