package com.basic.comsumerAndproducer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Medium {
	
	private Lock lock = new ReentrantLock();
	private Condition consumerCondition = lock.newCondition();
	private Condition producerCondition = lock.newCondition();
	
	private static final Integer TOTAL = 10;
	private int num = 0;
	
	public void take() throws InterruptedException {
		lock.lock();
		try {
			if(num > 0) {
				num--;
				System.out.println(Thread.currentThread().getName() + " has taken one, remains " + num);
				producerCondition.signal();//producer只有一个
			}
			else {
				System.out.println("Balance is " + num +" , set pending for " + Thread.currentThread().getName());
				consumerCondition.await();
			}
		}finally {
			lock.unlock();
		}
	}
	
	public void put() throws InterruptedException {
		lock.lock();
		try{
			if(num < TOTAL) {
				num++;
				System.out.println(Thread.currentThread().getName() + " has put one, remaings " + num);
				consumerCondition.signalAll();//consumer有多个
			}
			else {
				System.out.println("Buffer is full, set pending for " + Thread.currentThread().getName());
				producerCondition.await();
			}
		}finally {
			lock.unlock();
		}
	}

}
