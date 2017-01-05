package cn.mhope.test;

public class TestThread01 {
	public static void main(String[] args) {
		FirstThread firstThread = new FirstThread();
		firstThread.start();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("main:"+i);
		}
	}
	
}
 class FirstThread extends Thread{
	 @Override
	public void run() {
		 for (int i = 0; i < 100; i++) {
			 System.out.println("firstThread:"+i);
		}
	}
 }
