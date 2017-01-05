package cn.mhope.test;

public class TestThread02 {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println("Main: "+i);
		}
	}
}

class MyThread implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("MyThread: "+i);
		}
	}
}