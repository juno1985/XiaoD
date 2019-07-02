package com.basic.volatiledemo;

public class VolatileDemo implements Runnable{

	//volatile���εı�����֤�̼߳�ɼ��ԣ��Ӷ������߳̿���
	private static volatile boolean flag = true;
	
	public static void main(String[] args) throws InterruptedException {

		new Thread(new VolatileDemo()).start();
		
		Thread.sleep(5000L);
		
		VolatileDemo.flag = false;
		
	}

	@Override
	public void run() {
		//�߳̿���
		while(flag) {
			System.out.println(Thread.currentThread().getName() + " is running");
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " stopped");
	}

}
