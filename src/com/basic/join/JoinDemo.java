package com.basic.join;

public class JoinDemo {

	public static void main(String[] args) {
		
		Thread thread = new Thread(()->{
			System.out.println(Thread.currentThread().getName() + " ��ʼ����");
			System.out.println(Thread.currentThread().getName() + " ��������");
		}, "thread1");
		
		new Thread(()->{
			System.out.println(Thread.currentThread().getName() + " ��ʼ����");
			try {
				// 1- start()֮����ܵ���join
				thread.start();
				// 2-
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " ��������");
		},"thread2").start(); 

	}

}
