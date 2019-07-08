package com.basic.join;

public class JoinDemo {

	public static void main(String[] args) {
		
		Thread thread = new Thread(()->{
			System.out.println(Thread.currentThread().getName() + " 开始运行");
			System.out.println(Thread.currentThread().getName() + " 结束运行");
		}, "thread1");
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName() + " 开始运行");
			try {
				// 1- start()之后才能调用join
				thread.start();
				// 2-
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " 结束运行");
		},"thread2").start(); 

	}

}
