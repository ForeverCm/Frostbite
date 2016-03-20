/**
 * 在编写多线程程序时, 必须注意资源的使用情况, 如果两个线程分别拥有不同的资源, 而又同时需要对方释放资源才能继续运行, 就会导致死锁!
 */

public class DeadLock implements Runnable {
	private boolean flag;
	private static final Object o1 = new Object();
	private static final Object o2 = new Object();
	
	public void run() {
		String threadName = Thread.currentThread().getName(); //获得当前线程名称
		System.out.println(threadName + ": flag =" + flag); //输出当前线程的 flag 变量值
		
		if (flag == true) {
			synchronized(o1) { //加锁
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(threadName + "进入 o1 准备进入 o2");
				synchronized(o2) {
					System.out.println(threadName + "已经进入 o2");
				}
			}
		}
		
		if (flag == false) {
			synchronized(o2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(threadName + "进入 o2 准备进入 o1");
				synchronized(o1) {
					System.out.println(threadName + "已经进入 o1");
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		DeadLock dl1 = new DeadLock();
		DeadLock dl2 = new DeadLock();
		
		dl1.flag = true;
		dl2.flag = false;
		
		//启动新线程运行
		new Thread(dl1).start();
		new Thread(dl2).start();
	}
}