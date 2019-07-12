package com.basic.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) {

		//�޶�ͬʱֻ���������̲߳���
		Semaphore semaphore = new Semaphore(2);
		
		for(int i=0;i<10;i++) {
			new Thread(()->{
				try {
					semaphore.acquire();//�����ź���
					System.out.println(Thread.currentThread().getName() + " ��ʼִ��");
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaphore.release();//�ͷ��ź���
				}
			}).start();
			
		}
	}

}
