package com.basic.singleton;
/**
 * 饿汉单例
 * @author thinkpad
 *
 */
public class HungerSingleton {
	//类加载的时候就生成实例
	private static HungerSingleton hungerSingleton = new HungerSingleton();
	
	public static HungerSingleton getInstance() {
		return hungerSingleton;
	}
	//一定是private修饰,禁止使用构造器生成实例
	private HungerSingleton() {
		
	}

	public static void main(String[] args) {
		for(int i=0; i<10;i++) {
			//所有线程生成同一个实例
			new Thread(()->{
				System.out.println(HungerSingleton.getInstance());
			}).start();
		}
	}

}
