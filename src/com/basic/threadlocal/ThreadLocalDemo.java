package com.basic.threadlocal;
import java.util.function.Supplier;
public class ThreadLocalDemo implements Runnable{
	// 注意下面初始赋值
	private ThreadLocal<Integer> localInteger = ThreadLocal.withInitial(new Supplier<Integer>() {
		@Override
		public Integer get() {
			
			return 0;
		}
	});
	public static void main(String[] args) {
		ThreadLocalDemo demo = new ThreadLocalDemo();
		for(int i=0;i<3;i++) {
			new Thread(demo).start();
		}
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			Integer num = this.localInteger.get();//////////////////////////////
			num++;
			System.out.println(Thread.currentThread().getName() + " " + num);
			this.localInteger.set(num);//////////////////////////////
		}
	}

}