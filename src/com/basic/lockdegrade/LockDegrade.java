package com.basic.lockdegrade;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * 锁降级
	1.获得写锁
	2.获取读锁（虽然读写互斥，但在锁降级的情况下，在写锁后可以获取读锁）
	3.释放写锁
	4.释放读锁
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
		
		System.out.println("程序运行结束");
	}

}
