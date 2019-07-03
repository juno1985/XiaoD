package com.basic.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteDemo {
	
	private int i = 0;
	private int j = 0;
	/**
	 * ReentrantReadWriteLock
		дд���⣬��д���⣬��������
	 */
	ReadWriteLock lock = new ReentrantReadWriteLock();
	//���ɶ���
	Lock readLock = lock.readLock();
	//����д��
	Lock writeLock = lock.writeLock();
	
	private void out() {
		readLock.lock();
		try{
			System.out.println("i&j must equals: " + i + "-->" + j);
		}
		//�ͷ����Ĳ���Ҫ����finally���֤�϶���ִ�� (��ʹ�����쳣)
		finally {
			readLock.unlock();	
		}
	}
	
	private void write() throws InterruptedException {
		writeLock.lock();
		try{
			i++;
			Thread.sleep(1000L);
			j++;
		}
		finally {
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {
		ReentrantReadWriteDemo demo = new ReentrantReadWriteDemo();
		for(int i=0;i<2;i++) {
			new Thread(()->{
				try {
					demo.write();
					demo.out();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
		}

	}

}
