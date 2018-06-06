package cn.blocking.que;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author Administrator
 *
 */
public class ArrayBlockingQue {
	public static void main(String[] args) throws Exception {
		name2();
	}
	
	public static void name2() {
		
	} 
	
	public void name1() throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
		queue.put("aaa");
		queue.put("bbb");
		queue.put("ccc");
		queue.put("eee");
		queue.put("ddd");
		//queue.put("fff");
		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());
		System.out.println(queue.take());
	}
}
