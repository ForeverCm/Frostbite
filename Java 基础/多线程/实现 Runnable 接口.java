/**
 * 步骤:
 * 定义类实现 Runnable 接口,
 * 实现 Runnable 接口中的 run 方法,
 * 通过 Thread 类建立线程对象,
 * 把 Runnable 接口的子类对象, 作为实际的参数传递给 Thread 类构造函数(Thread(Runnable target) 分配新的 Thread 对象),
 * 调用 Thread 类的 start() 方法开启线程(自动调用 Runnable 接口子类的 run() 方法).
 */

public class Ticket implements Runnable {
	private int ticket = 100;
	
	public void run() {
		while(ticket > 0) {
			System.out.println(Thread.currentThread().getName() + "-->sale:" + ticket--);
		}
	}
}

public class MainThread {
	public static void main(String[] args) {
		//创建新的线程实例
		Ticket ticket = new Ticket();
		
		/** 启动新的线程对象 **/
		new Thread(ticket).start();
		new Thread(ticket).start();
		new Thread(ticket).start();
		new Thread(ticket).start();
	}
}