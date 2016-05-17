/**
 * 多线程基础实例介绍了如何在底层实现线程同步, 但在实际开发中应尽量远离底层结构, 使用 java.util.concurrent 包将有助于简化开发.
 */

public class Producer implements Runnable {
	public void run() {	
		for (int i = 0; i<size; i++) { //size 为成员变量, 表示添加商品的次数
			int b = new Random().nextInt(255);

			System.out.println("生产商品: " + b);
			
			try {
				queue.put(b); //向队列中添加元素
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("仓库中还有" + queue.size() + "个商品");
			
			try {
				Thread.sleep(1000); //休眠 1 秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//BlockingQueue<E> 接口的使用: 定义了阻塞队列的常用方法, 如: 对于添加元素有 add(), offer(), put() 这三种方法.当队列满时, add 方法会抛出异常, offer 方法会返回 false, put 方法会产生阻塞!