package com.basic.CyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		//四个线程的格栅
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		for(int i=0;i<4;i++) {
			long n = i*1000L;
			new Thread(()->{
				try {
					Thread.sleep(n);
					System.out.println(Thread.currentThread().getName() + " 进入runnable状态" + System.currentTimeMillis());
					//每个线程到达此处进行等待其他线程，全部都执行到这了才一起继续执行
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				//最终发现所有线程开始运行时间点完全相同
				System.out.println(Thread.currentThread().getName() + "开始运行时间点:" + System.currentTimeMillis());
				
			}).start();
		}

	}

}
