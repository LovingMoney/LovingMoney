package cn.blocking.que;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch cdl = new CountDownLatch(3);
		new Thread(new Demo_T1(cdl)).start();
		new Thread(new Demo_T2(cdl)).start();
		new Thread(new Demo_T3(cdl)).start();
		
		cdl.await();
		System.out.println("开始做饭");
		
	}
	
}

class Demo_T1 implements Runnable {

	private CountDownLatch cdl = null;
	
	public Demo_T1(CountDownLatch cdl) {
		this.cdl =cdl;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("米买回来了");
			cdl.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Demo_T2 implements Runnable {
	
	private CountDownLatch cdl = null;
	
	public Demo_T2(CountDownLatch cdl) {
		this.cdl =cdl;
	}
	

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("菜米买回来了");
			cdl.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Demo_T3 implements Runnable {
	
	private CountDownLatch cdl = null;
	
	public Demo_T3(CountDownLatch cdl) {
		this.cdl =cdl;
	}
	

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("锅买回来了");
			cdl.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}