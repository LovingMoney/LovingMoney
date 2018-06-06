package cn.blocking.que;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	
	public static String name = "�����";
	public static String gender = "Ů";
	
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();
		new Thread(new Demo10_change(lock)).start();
		new Thread(new Demo10_print(lock)).start();
	}

}

class Demo10_change implements Runnable {
	Lock lock = null;
	public Demo10_change(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			lock.lock();
			if ("�����".equals(LockDemo.name)) {
				LockDemo.name = "ŷ��";
				LockDemo.gender = "��";
			}else {
				LockDemo.name = "�����";
				LockDemo.gender = "Ů";
			}
			lock.unlock();
		}
	}
}

class Demo10_print implements Runnable {

	Lock lock = null;
	public Demo10_print(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		while (true) {
			lock.lock();
			System.out.println("���� "+LockDemo.name);
			System.out.println("��bie "+LockDemo.gender);
			lock.unlock();
		}
	}
}

