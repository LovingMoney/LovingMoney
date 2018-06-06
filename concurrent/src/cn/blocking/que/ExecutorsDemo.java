package cn.blocking.que;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用工具executor创建线程池
 * 线程池的任务提交
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
		
		
		
		/*submit(callback)的方法实现
		 * Future<String> futu = service.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(1000);
				System.out.println("线程执行结束");
				return "来自返回值";
			}
		});
		
		System.out.println(futu.get());*/
		
		/*
		 * submit(runnable)的方法实现
		Future<?> futu = service.submit(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("线程执行结束");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		futu.get();			//查询线程池的执行结果，如果没有执行完成，则阻塞
		System.out.println("线程走下来");
		*/
		
	}
}





