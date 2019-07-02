package com.basic.singleton;
/**
 * 线程安全的懒汉模式
 * @author thinkpad
 *
 */
public class LazySingleton {
	
	private static volatile LazySingleton lazySingleton = null;
	
	private LazySingleton() {
		
	}
	//双重监测
	public static LazySingleton getInstance() {
		//第一次监测
		if(lazySingleton==null) {
			//锁住整个类
			synchronized(LazySingleton.class) {
				//第二次监测
				if(lazySingleton==null) {
					lazySingleton = new LazySingleton();
				}
			}
		}
		return lazySingleton;
		
	}

	public static void main(String[] args) {
		
	}

}
