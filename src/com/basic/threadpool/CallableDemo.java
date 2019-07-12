package com.basic.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo implements Callable<String>{
	
	@Override
	public String call() throws Exception {
		return "this is returned from CALL funtion";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableDemo demo = new CallableDemo();
		FutureTask<String> singleTask = new FutureTask<>(demo);
		new Thread(singleTask).start();
		String result = singleTask.get();
		System.out.println(result);
	}

}
