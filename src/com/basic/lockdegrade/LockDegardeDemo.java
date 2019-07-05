package com.basic.lockdegrade;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级
	使用场景：用于当前线程立即读取最新的刚被更新变量的值。
 * @author thinkpad
 *
 */
public class LockDegardeDemo {
	private ReentrantReadWriteLock reentrantLock = new ReentrantReadWriteLock();
	private Lock writeLock = reentrantLock.writeLock();
	private Lock readLock = reentrantLock.readLock();
	
	private int val = 0;
	
	private void changeAndReadVal() {
		writeLock.lock();//获取写锁
		try {
			val++;
			readLock.lock();//释放写锁前获取读锁,从而保证读取最新的val,不让其他的线程插进来
		}finally {
			writeLock.unlock();//释放写锁
		}
		try {
			System.out.println(Thread.currentThread().getName() + " changed val and read --> " + val);
		}finally {
			readLock.unlock();//释放读锁
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
