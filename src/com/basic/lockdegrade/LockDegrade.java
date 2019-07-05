package com.basic.lockdegrade;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * ������
	1.���д��
	2.��ȡ��������Ȼ��д���⣬����������������£���д������Ի�ȡ������
	3.�ͷ�д��
	4.�ͷŶ���
 * @author thinkpad
 *
 */
public class LockDegrade {
	
	private static ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
	private static Lock writeLock = reentrantLock.writeLock();
	private static Lock readLock = reentrantLock.readLock();

	public static void main(String[] args) {

		writeLock.lock();
		readLock.lock();
		writeLock.unlock();
		readLock.unlock();
		
		System.out.println("�������н���");
	}

}
