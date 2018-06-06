package cn.blocking.que;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteDemoLock {
	
	public static String name = "����";
	
	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		new Thread(new Demo12_read(lock)).start();
		new Thread(new Demo12_read(lock)).start();
		new Thread(new Demo12_read(lock)).start();
		new Thread(new Demo12_write(lock)).start();
		new Thread(new Demo12_read(lock)).start();
		new Thread(new Demo12_write(lock)).start();
	}
}

class Demo12_read implements Runnable{
	ReadWriteLock lock = null;
	public Demo12_read(ReadWriteLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.readLock().lock();
		System.out.println(Thread.currentThread()+"��ʼ������");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("��ȡ������"+ReadWriteDemoLock.name);
		lock.readLock().unlock();
	}
	
}

class Demo12_write implements Runnable{
	ReadWriteLock lock = null;
	public Demo12_write(ReadWriteLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.writeLock().lock();
		System.out.println(Thread.currentThread()+"��ʼд����");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("д������"+ReadWriteDemoLock.name);
		lock.writeLock().unlock();
	}
	
}
