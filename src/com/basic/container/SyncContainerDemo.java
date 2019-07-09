package com.basic.container;

import java.util.Iterator;
import java.util.Vector;
public class SyncContainerDemo {
	
	private Vector<String> strVector = new Vector<>();
	
	private void initVector() {
		for(int i=0;i<1000;i++) {
			strVector.add("element " + i);
		}
	}

	public static void main(String[] args) {
		SyncContainerDemo demo = new SyncContainerDemo();
		Iterator<String> vectorInter = demo.strVector.iterator();
		demo.initVector();
		for(int i=0;i<4;i++) {
			new Thread(()->{
				/**
				 * �ڸ��ϲ���ʱ��(hasNext()��ʹ��next()),�ᷢ���쳣
				 */
				while(vectorInter.hasNext()) {
					String temp = vectorInter.next();
					System.out.println(Thread.currentThread().getName() + "-->" + temp);
				}
			}).start();
		}
	}

}
