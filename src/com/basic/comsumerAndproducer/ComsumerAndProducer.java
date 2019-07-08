package com.basic.comsumerAndproducer;

public class ComsumerAndProducer {
	
	private class Consumer implements Runnable{
		
		private Medium medium;

		public Consumer(Medium medium) {
			this.medium = medium;
		}

		@Override
		public void run() {
			while(true) {
				try {
					medium.take();
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class Producer implements Runnable{
		
		private Medium medium;

		public Producer(Medium medium) {
			this.medium = medium;
		}


		@Override
		public void run() {
			while(true) {
				try {
					medium.put();
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void main(String[] args) {
		ComsumerAndProducer cap = new ComsumerAndProducer();
		// producer和consumer通过同一个medium对象进行wait()/notify()
		Medium medium = new Medium();
		ComsumerAndProducer.Producer producer = cap.new Producer(medium);
		new Thread(producer, "producer").start();
		for(int i=1;i<=3;i++) {
			ComsumerAndProducer.Consumer consumer = cap.new Consumer(medium);
			new Thread(consumer, "consumer" + i).start();
		}
	}

}
