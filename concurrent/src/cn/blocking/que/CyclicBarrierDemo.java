package cn.blocking.que;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier  դ��
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
			System.out.println("�س�T1 �Ѿ�����դ��");
			cBarrier.await();
			System.out.println("�س�T1 �Ѿ���դ��");
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
			System.out.println("�س�T2 �Ѿ�����դ��");
			cBarrier.await();
			System.out.println("�س�T2�Ѿ���դ��");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}

