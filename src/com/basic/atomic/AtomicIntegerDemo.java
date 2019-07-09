package com.basic.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
	
	private AtomicInteger sum = new AtomicInteger(0);
	
	private Integer increateAndget() {
		return sum.incrementAndGet();
	}

	public static void main(String[] args) {
		AtomicIntegerDemo demo = new AtomicIntegerDemo();
		for(int i=0;i<10;i++) {
			new Thread(()-> {
				for(int j=0;j<10;j++) {
					System.out.println(Thread.currentThread().getName()+"-->"+demo.increateAndget());
				}
			}).start();
		}
	}
}
