package cn.blocking.que;

import java.util.concurrent.BlockingQueue;

public class Customer implements Runnable{
	
	private BlockingQueue<String> queue;
	
	public Customer (BlockingQueue<String> queue){
		this.queue = queue;
	}
	
	
	
	@Override
	public void run() {
		int i=0;
		while (true) {
			try {
				Thread.sleep(2000);
				int num = ++i;
				String nString = queue.take();
				System.out.println("��������������"+num +nString);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
