package com.basic.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {

		//限定同时只能有两个线程并发
		Semaphore semaphore = new Semaphore(2);
		
		for(int i=0;i<10;i++) {
			new Thread(()->{
				try {
					semaphore.acquire();//锁定信号量
					System.out.println(Thread.currentThread().getName() + " 开始执行");
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaphore.release();//释放信号量
				}
			}).start();
			
		}
	}

}
