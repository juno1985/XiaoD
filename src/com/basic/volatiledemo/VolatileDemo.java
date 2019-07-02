package com.basic.volatiledemo;

public class VolatileDemo implements Runnable{

	//volatile修饰的变量保证线程间可见性，从而当做线程开关
	private static volatile boolean flag = true;
	
	public static void main(String[] args) throws InterruptedException {

		new Thread(new VolatileDemo()).start();
		
		Thread.sleep(5000L);
		
		VolatileDemo.flag = false;
		
	}

	@Override
	public void run() {
		//线程开关
		while(flag) {
			System.out.println(Thread.currentThread().getName() + " is running");
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " stopped");
	}

}
