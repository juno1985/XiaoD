package com.basic.container;

import java.util.Iterator;
import java.util.Vector;
public class SyncContainerDemo {
	
	private Vector<String> strVector = new Vector<>();
	private Iterator<String> vectorInter = null;
	private void initVector() {
		for(int i=0;i<1000;i++) {
			this.strVector.add("element " + i);
		}
		vectorInter=strVector.iterator();
	}
	
	private void out() {
		
		/**
		 * 在复合操作时如(hasNext()后使用next()),会发生异常
		 */
		synchronized(this.vectorInter) {
			while(this.vectorInter.hasNext()) {
				String temp = this.vectorInter.next();
				System.out.println(Thread.currentThread().getName() + "-->" + temp);
			}
		}
	}

	public static void main(String[] args) {
		SyncContainerDemo demo = new SyncContainerDemo();
		demo.initVector();
		
		for(int i=0;i<4;i++) {
			new Thread(()->{
				demo.out();
			}).start();
		}
	}

}
