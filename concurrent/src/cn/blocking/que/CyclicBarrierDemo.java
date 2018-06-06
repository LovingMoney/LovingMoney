package cn.blocking.que;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier  栅栏
 * @author Administrator
 *
 */
public class CyclicBarrierDemo {
	
	public static void main(String[] args) {
		
		CyclicBarrier cBarrier = new CyclicBarrier(2);
		new Thread(new T1(cBarrier)).start();
		new Thread(new T2(cBarrier)).start();
	}

}

class T1 implements Runnable{
	
	private CyclicBarrier cBarrier = null;
	
	public T1 (CyclicBarrier cBarrier) {
		this.cBarrier = cBarrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println("县城T1 已经到达栅栏");
			cBarrier.await();
			System.out.println("县城T1 已经出栅栏");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}

class T2 implements Runnable{
	
	private CyclicBarrier cBarrier = null;
	
	public T2 (CyclicBarrier cBarrier) {
		this.cBarrier = cBarrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("县城T2 已经到达栅栏");
			cBarrier.await();
			System.out.println("县城T2已经出栅栏");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}

