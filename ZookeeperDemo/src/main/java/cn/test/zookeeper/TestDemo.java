package cn.test.zookeeper;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.junit.Test;
import org.apache.zookeeper.ZooKeeper;

public class TestDemo {
	
	
	/**
	 * 监听子节点发生变化
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	@Test
	public void testWatchNodeDelete() throws IOException, InterruptedException, KeeperException {
		CountDownLatch latch = new CountDownLatch(1);
		ZooKeeper zk = new ZooKeeper("192.168.198.131:2181", 3000, new Watcher() {
			@Override
			public void process(WatchedEvent event) { // 主要做监听的方法
				if (event.getState() == KeeperState.SyncConnected) { // 事件状态等于链接成功事件 KeeperState.SyncConnected
					System.out.println("connect success");
					latch.countDown();
				}
			}
		});
		latch.await(); // 产生阻塞的方法
		
		//此监听作用：一般是监听某台服务器是否宕机，
		//每台服务器都会注册自己的临时节点，当即后临时节点删除
		zk.exists("/park02/node02", new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				if(event.getType() == EventType.NodeDeleted) {	//此节点已经被删除
					System.out.println("删除了");
				}
				
			}
			
		});
		
		while (true) {
			
		}
	}
	
	
	/**
	 * 监听子节点发生变化
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	@Test
	public void testWatchChildChange() throws IOException, InterruptedException, KeeperException {
		CountDownLatch latch = new CountDownLatch(1);
		ZooKeeper zk = new ZooKeeper("192.168.198.131:2181", 3000, new Watcher() {
			@Override
			public void process(WatchedEvent event) { // 主要做监听的方法
				if (event.getState() == KeeperState.SyncConnected) { // 事件状态等于链接成功事件 KeeperState.SyncConnected
					System.out.println("connect success");
					latch.countDown();
				}
			}
		});
		latch.await(); // 产生阻塞的方法
		
		zk.getChildren("/park02", new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				if(event.getType() == EventType.NodeChildrenChanged) {
					System.out.println("有子节点发生变化");
				}
				
			}
		});
		
		while (true) {
			
		}
	}
	
	
	

	/**
	 * 获取数据的变化时间
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws KeeperException 
	 */
	@Test
	public void testWatchDataChange() throws IOException, InterruptedException, KeeperException {

		CountDownLatch latch = new CountDownLatch(1);
		/*
		 * 1参 ： zk服务器地址 ip:port 2 时间 3 监听者：匿名内部类的形式
		 */
		ZooKeeper zk = new ZooKeeper("192.168.198.131:2181", 3000, new Watcher() {
			// CountDownLatch countDownLatch = latch; 1.8之后不需要final
			@Override
			public void process(WatchedEvent event) { // 主要做监听的方法
				// 监听链接成功事件
				if (event.getState() == KeeperState.SyncConnected) { // 事件状态等于链接成功事件 KeeperState.SyncConnected
					System.out.println("connect success");
					latch.countDown();
				}
			}
		});
		latch.await(); // 产生阻塞的方法
		// 1.监听节点数据变化的时间，通过zk.getData来监听，zk的监听器是一次性监听，需要永久监听，需要自己写
		//循环+闭锁来做
		for(;;) {
			CountDownLatch latch2 = new CountDownLatch(1);
			zk.getData("/park02", new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					if(event.getType() == EventType.NodeDataChanged) {	//数据发生变化
						System.out.println("数据发生那个变化");
						latch2.countDown();
					}
					
				}
			}, null);
			latch2.await();
		}
	}

	/**
	 * 创建节点 + 更新节点 + 删除节点
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws KeeperException
	 */
	@Test
	public void testCreate() throws IOException, InterruptedException, KeeperException {
		CountDownLatch latch = new CountDownLatch(1);

		/*
		 * 1参 ： zk服务器地址 ip:port 2 时间 3 监听者：匿名内部类的形式
		 */
		ZooKeeper zk = new ZooKeeper("192.168.198.131:2181", 3000, new Watcher() {
			// CountDownLatch countDownLatch = latch; 1.8之后不需要final
			@Override
			public void process(WatchedEvent event) { // 主要做监听的方法
				// 监听链接成功事件
				if (event.getState() == KeeperState.SyncConnected) { // 事件状态等于链接成功事件 KeeperState.SyncConnected
					System.out.println("connect success");
					latch.countDown();
				}
			}
		});
		latch.await(); // 产生阻塞的方法
		/*
		 * 创建节点 1.路径 node 2.字节 3. 权限 4.节点类型
		 */
		// zk.create("/park03", "hello world".getBytes(), Ids.OPEN_ACL_UNSAFE,
		// CreateMode.EPHEMERAL);

		// 更新节点数据 版本号和dataVersion 一zhi 如果无论如何都更新，可以将version改成-1
		// zk.setData("/park02", "hello every happy".getBytes(), -1);

		// 删除节点 如果无论如何都删除，可以将version改成-1
		// zk.delete("/park010000000001", -1);

		// 查看指定节点的数据 2.监听者 3 节点状态信息，不想要可以写null
		// byte[] data = zk.getData("/park02", null, null);
		// System.out.println(new String(data));

		// 获取指定节点的子节点 //获取的是名字。不是全路径，需要自己拼接路径
		List<String> children = zk.getChildren("/park02", null);
		for (String path : children) {
			System.out.println(path);
		}
		// System.out.println(children);

	}

	/**
	 * 通过代码链接zookeeper zookeeper 链接是异步链接（非阻塞链接） 所以要保证链接成功 做法：while true 退出：阻塞放开
	 */
	@Test
	public void testConnect() throws IOException, InterruptedException {

		CountDownLatch latch = new CountDownLatch(1);

		/*
		 * 1参 ： zk服务器地址 ip:port 2 时间 3 监听者：匿名内部类的形式
		 */
		ZooKeeper zk = new ZooKeeper("192.168.198.131:2181", 3000, new Watcher() {
			// CountDownLatch countDownLatch = latch; 1.8之后不需要final
			@Override
			public void process(WatchedEvent event) { // 主要做监听的方法
				// 监听链接成功事件
				if (event.getState() == KeeperState.SyncConnected) { // 事件状态等于链接成功事件 KeeperState.SyncConnected
					System.out.println("connect success");
					latch.countDown();
				}
			}
		});

		latch.await(); // 产生阻塞的方法

		// while (true) {

		// }
	}
}
