package xh.concurrentThread;

public class JVMExample {
public static volatile int race = 0;
	
	public static void increase(){
		race++;
	}
	
	private static final int THREADS_COUNT = 20;
	
	public static void main(String[] args){
		Thread[] threads = new Thread[THREADS_COUNT];
		for(int i = 0; i < THREADS_COUNT; i++){
			threads[i] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int i = 0; i < 100; i++){
						increase();
					}
					
				}
			});
			threads[i].start();
		}
		
		//等到所有线程累加结束
		while(Thread.activeCount() > 1){
			Thread.yield();
			System.out.println(race);
		}
	}
}

//验证volatile的不安全性
class VolatileTest{
	
}