package com.basic.comsumerAndproducer;

public class Medium {
	
	private static final Integer TOTAL = 10;
	private int num = 0;
	
	public synchronized void take() throws InterruptedException {
		if(num > 0) {
			num--;
			System.out.println(Thread.currentThread().getName() + " has taken one, remains " + num);
			notifyAll();
		}
		else {
			System.out.println("Balance is " + num +" , set pending for " + Thread.currentThread().getName());
			wait();
		}
	}
	
	public synchronized void put() throws InterruptedException {
		if(num < TOTAL) {
			num++;
			System.out.println(Thread.currentThread().getName() + " has put one, remaings " + num);
			notifyAll();
		}
		else {
			System.out.println("Buffer is full, set pending for " + Thread.currentThread().getName());
			wait();
		}
	}

}
