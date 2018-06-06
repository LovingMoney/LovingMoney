package cn.blocking.que;

import java.util.concurrent.Exchanger;

public class ExchangeDemo {

	public static void main(String[] args) {
		//创建交换机
		Exchanger<String> exchanger = new Exchanger<>();
		new Thread(new T3(exchanger)).start();
		new Thread(new T4(exchanger)).start();
	}
}

class T3 implements Runnable{
	
	private Exchanger<String> exchanger = null;
	
	public T3(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			String obj = exchanger.exchange("天王盖地虎");
			System.out.println("线程1换回了信息"+obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class T4 implements Runnable{
	
	private Exchanger<String> exchanger = null;
	
	public T4(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			String obj = exchanger.exchange("小鸡炖蘑菇");
			System.out.println("线程2换回了信息"+obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
