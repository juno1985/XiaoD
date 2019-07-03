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
		//���������Ƿ�ԭ�Ӳ�����������lock������֤ԭ����
		num++;
		//ע����Ҫ�ֶ��ͷ���
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0;i<100;i++) {
			new Thread(()->{
				LockDemo.increase();
				countDownLatch.countDown();
			}).start();
		}
		//����ʹ��countdownlatch,���̱߳���ȴ�����100���߳���ɺ������
		countDownLatch.await();
		System.out.println("Total: " + num);

	}

}
