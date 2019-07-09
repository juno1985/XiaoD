package com.basic.container;

import java.util.Iterator;
import java.util.Vector;
public class SyncContainerDemo {
	
	private Vector<String> strVector = new Vector<>();
	private final Iterator<String> vectorInter = strVector.iterator();
	private void initVector() {
		for(int i=0;i<1000;i++) {
			this.strVector.add("element " + i);
		}
	}
	
	private void out() {
		
		/**
		 * �ڸ��ϲ���ʱ��(hasNext()��ʹ��next()),�ᷢ���쳣
		 */
		while(this.vectorInter.hasNext()) {
			String temp = this.vectorInter.next();
			System.out.println(Thread.currentThread().getName() + "-->" + temp);
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
