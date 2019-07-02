package com.basic.singleton;
/**
 * �̰߳�ȫ������ģʽ
 * @author thinkpad
 *
 */
public class LazySingleton {
	
	private static volatile LazySingleton lazySingleton = null;
	
	private LazySingleton() {
		
	}
	//˫�ؼ��
	public static LazySingleton getInstance() {
		//��һ�μ��
		if(lazySingleton==null) {
			//��ס������
			synchronized(LazySingleton.class) {
				//�ڶ��μ��
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
