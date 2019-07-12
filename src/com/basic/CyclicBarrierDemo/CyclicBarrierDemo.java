package com.basic.CyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		//�ĸ��̵߳ĸ�դ
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		for(int i=0;i<4;i++) {
			long n = i*1000L;
			new Thread(()->{
				try {
					Thread.sleep(n);
					System.out.println(Thread.currentThread().getName() + " ����runnable״̬" + System.currentTimeMillis());
					//ÿ���̵߳���˴����еȴ������̣߳�ȫ����ִ�е����˲�һ�����ִ��
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				//���շ��������߳̿�ʼ����ʱ�����ȫ��ͬ
				System.out.println(Thread.currentThread().getName() + "��ʼ����ʱ���:" + System.currentTimeMillis());
				
			}).start();
		}

	}

}
