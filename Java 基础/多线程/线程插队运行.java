/**
 * 在编写多线程程序时, 如果让一个线程优先于其他线程运行的状况, 除了可以设置该线程的优先级高于其他线程外, 
 * 更直接的方式就是使用 Thread 类的 join() 和 yield() 方法.
 */

public class JoinThread implements Runnable {
    public static void main(String[] args) throws InterruptedException {
		Thread lt = new Thread(new JoinThread());
		lt.start(); //分线程 start，不是立即执行
		System.out.println("Hello!"); //执行主线程
		lt.join(); //A.join() 阻塞当前线程 B，直至 A 执行完
		System.out.println("What the hell just happened?");
    }
	
    public void run() {
		System.out.println("A");
		System.out.println("B");
		System.out.println("C");
    }	
}

/**
 * 输出结果为：
 * Hello!
 * A
 * B
 * C
 * What the hell just happened?
 */