package com.basic.lockdegrade;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ������
	ʹ�ó��������ڵ�ǰ�߳�������ȡ���µĸձ����±�����ֵ��
 * @author thinkpad
 *
 */
public class LockDegardeDemo {
	private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
	private Lock writeLock = reentrantLock.writeLock();
	private Lock readLock = reentrantLock.readLock();
	
	private int val = 0;
	
	private void changeAndReadVal() {
		writeLock.lock();//��ȡд��
		try {
			val++;
			readLock.lock();//�ͷ�д��ǰ��ȡ����,�Ӷ���֤��ȡ���µ�val,�����������̲߳����
		}finally {
			writeLock.unlock();//�ͷ�д��
		}
		try {
			System.out.println(Thread.currentThread().getName() + " changed val and read --> " + val);
		}finally {
			readLock.unlock();//�ͷŶ���
		}
	}

	public static void main(String[] args) {
		LockDegardeDemo lockDegradeDemo = new LockDegardeDemo();
		for(int i=0;i<10;i++) {
			new Thread(()->{
				lockDegradeDemo.changeAndReadVal();
			}).start();
		}
	}

}
