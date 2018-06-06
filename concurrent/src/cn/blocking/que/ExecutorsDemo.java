package cn.blocking.que;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ʹ�ù���executor�����̳߳�
 * �̳߳ص������ύ
 * @author Administrator
 *
 */
public class ExecutorsDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		service.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("hahaha");
			}
		});
		
		
		
		/*submit(callback)�ķ���ʵ��
		 * Future<String> futu = service.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				System.out.println("�߳�ִ�н���");
				return "���Է���ֵ";
			}
		});
		
		System.out.println(futu.get());*/
		
		/*
		 * submit(runnable)�ķ���ʵ��
		Future<?> futu = service.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("�߳�ִ�н���");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		futu.get();			//��ѯ�̳߳ص�ִ�н�������û��ִ����ɣ�������
		System.out.println("�߳�������");
		*/
		
	}
}





