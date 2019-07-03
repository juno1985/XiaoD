package com.basic.lockdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	
	private static volatile int num = 0;
	private static Lock lock = new ReentrantLock();
	private static CountDownLatch countDownLatch = new CountDownLatch(100);
	private static synchronized void increase() {
		lock.lock();
		//这种自增是非原子操作，所以用lock包裹保证原子性
		num++;
		//注意需要手动释放锁
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0;i<100;i++) {
			new Thread(()->{
				LockDemo.increase();
				countDownLatch.countDown();
			}).start();
		}
		//这里使用countdownlatch,主线程必须等待其余100个线程完成后再输出
		countDownLatch.await();
		System.out.println("Total: " + num);

	}

}
