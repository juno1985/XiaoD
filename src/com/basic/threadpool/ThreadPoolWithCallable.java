package com.basic.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolWithCallable {
	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1000L, TimeUnit.SECONDS, queue);
		Future<String> future = null;//线程池结果存于future
		for(int i=0;i<100;i++) {
			 future = executor.submit(new CallableDemo());
		}
		for(int i=0;i<100;i++) {
			System.out.println( i + "-->" +future.get());
		}
		executor.shutdown();
	}

}
