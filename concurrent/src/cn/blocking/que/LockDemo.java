package cn.blocking.que;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	
	public static String name = "À¼½ã½ã";
	public static String gender = "Å®";
	
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
			if ("À¼½ã½ã".equals(LockDemo.name)) {
				LockDemo.name = "Å·°Í";
				LockDemo.gender = "ÄÐ";
			}else {
				LockDemo.name = "À¼½ã½ã";
				LockDemo.gender = "Å®";
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
			System.out.println("ÐÕÃû "+LockDemo.name);
			System.out.println("ÐÕbie "+LockDemo.gender);
			lock.unlock();
		}
	}
}

