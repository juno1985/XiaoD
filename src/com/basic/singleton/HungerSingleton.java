package com.basic.singleton;
/**
 * ��������
 * @author thinkpad
 *
 */
public class HungerSingleton {
	//����ص�ʱ�������ʵ��
	private static HungerSingleton hungerSingleton = new HungerSingleton();
	
	public static HungerSingleton getInstance() {
		return hungerSingleton;
	}
	//һ����private����,��ֹʹ�ù���������ʵ��
	private HungerSingleton() {
		
	}

	public static void main(String[] args) {
		for(int i=0; i<10;i++) {
			//�����߳�����ͬһ��ʵ��
			new Thread(()->{
				System.out.println(HungerSingleton.getInstance());
			}).start();
		}
	}

}
