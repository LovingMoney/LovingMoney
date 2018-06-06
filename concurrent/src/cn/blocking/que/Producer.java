package cn.blocking.que;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	
	public static void main(String[] args) {
		BlockingQueue<String> que = new ArrayBlockingQueue<>(5);
		new Thread(new Producer(que)).start();
		new Thread(new Customer(que)).start();
	}
	
	private BlockingQueue<String> queue;
	
	public Producer (BlockingQueue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		int i=0;
		while (true) {
			try {
				Thread.sleep(1000);
				int num = ++i;
				queue.put("n="+num);
				System.out.println("生产者生产了"+num);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
