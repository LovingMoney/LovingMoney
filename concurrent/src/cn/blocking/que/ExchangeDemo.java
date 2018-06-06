package cn.blocking.que;

import java.util.concurrent.Exchanger;

public class ExchangeDemo {

	public static void main(String[] args) {
		//����������
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
			String obj = exchanger.exchange("�����ǵػ�");
			System.out.println("�߳�1��������Ϣ"+obj);
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
			String obj = exchanger.exchange("С����Ģ��");
			System.out.println("�߳�2��������Ϣ"+obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
