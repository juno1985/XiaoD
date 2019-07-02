package com.basic.deadlock;

public class DeadLockDemo {

	private static final Object objectA = new Object();
	private static final Object objectB = new Object();

	public static void main(String[] args) {

		new Thread(() -> {
			synchronized (objectA) {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (objectB) {

					System.out.println(Thread.currentThread().getName() + " is running");
				}
			}
		}, "Thread_A").start();

		new Thread(() -> {
			synchronized (objectB) {
				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (objectA) {

					System.out.println(Thread.currentThread().getName() + " is running");
				}
			}
		}, "Thread_B").start();
		

	}

}
