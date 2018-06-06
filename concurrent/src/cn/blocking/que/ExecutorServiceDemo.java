package cn.blocking.que;

import java.rmi.RemoteException;
import java.rmi.UnknownHostException;
import java.rmi.registry.Registry;
import java.rmi.registry.RegistryHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {
	
	public static void main(String[] args) {
		
		//new �̳߳�
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 30L, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(5),new RejectedExecutionHandler() {
					
					@Override
					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
						System.out.println("########�̳߳������� ##########����ܾ�");
						
					}
				});
		
		poolExecutor.execute(new Demo06(1));
		poolExecutor.execute(new Demo06(2));
		poolExecutor.execute(new Demo06(3));
		poolExecutor.execute(new Demo06(4));
		poolExecutor.execute(new Demo06(5));
		poolExecutor.execute(new Demo06(6));
		poolExecutor.execute(new Demo06(7));
		poolExecutor.execute(new Demo06(8));
		poolExecutor.execute(new Demo06(9));
		poolExecutor.execute(new Demo06(10));
		poolExecutor.execute(new Demo06(11));
		poolExecutor.execute(new Demo06(12));
		poolExecutor.execute(new Demo06(13));
		poolExecutor.execute(new Demo06(14));
		poolExecutor.execute(new Demo06(15));
		poolExecutor.execute(new Demo06(16));
		poolExecutor.execute(new Demo06(17));
		poolExecutor.execute(new Demo06(18));
		poolExecutor.execute(new Demo06(19));
		poolExecutor.execute(new Demo06(20));
		
	}
}

class Demo06 implements Runnable {
	
	private int id=0;
	
	public Demo06(int id) {
		this.id = id;
	}
	

	@Override
	public void run() {
		try {
			System.out.println("�߳�"+id+"��ʼִ����");
			Thread.sleep(2000);
			System.out.println("�߳�"+id+"�߳̽�����");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}






