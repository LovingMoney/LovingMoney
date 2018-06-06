package cn.blocking.que;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
	
	public static void main(String[] args) throws Exception {
		Callable<String> callThread = new CallThread();
		FutureTask<String> fu = new FutureTask<String>(callThread);
		Thread th = new Thread(fu, "�з���ֵ���߳�");   
		th.start(); 
        System.out.println("����ֵ��:" + fu.get());    
	}
}

class CallThread implements Callable<String> {
	@Override
	public String call() throws Exception {
		System.out.println("hello world");
		return "hello";
	}
}


