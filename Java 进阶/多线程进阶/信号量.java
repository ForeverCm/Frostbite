/**
 * 信号量是由 Dijkstra 在 1968 年发明的, 该概念最初是用于在进程间发信号的一个整数值.
 *     一个信号量有且仅有 3 种操作, 且全部是原子的: 1.初始化, 2.增加, 3.减少
 * 		  增加可以为一个进程解除阻塞;
 * 		  减少可以让一个进程进入阻塞;
 *
 * Java 的 Semaphore 类是一个计数信号量, 从概念上讲, 信号量维护了一个许可集, 如有必要. 在许可可用之前会阻塞每一个 
 * acquire(), 然后再获取该许可, 每个 release() 添加一个许可, 从而可能释放一个正在阻塞的获取者. 但是, 不使用实际的
 * 许可对象, Semaphore 只对可用许可的号码进行计数, 并采取相应的行动. 声明如下:
 *	   public Semaphore(int permits, boolean fair) 参数说明:
 *		    permits: 初始的可用许可数目, 该值可能为负数, 在这种情况下, 必须在授予任何获取前进行释放.
 *		    fair: 如果该信号量保证在争用时按先进先出的授权许可, 则为 true, 反之为 false.
 *	   1.为了从信号量获得一个许可, 需要使用 acquire() 方法, 声明如下:
 *		    public void acquire() throws InterruptedException
 *	   2.为了释放一个许可到的信号量, 需要使用 release() 方法, 声明如下:
 *			public void release()
 */

public class Bank {
	private int account = 100;
	
	public void deposit(int money) {
		account += money; 
	}
	
	public int getAccount() {
		return account;
	}
}

public class Transfer implements Runnable {
	private Bank bank;
	private Semaphore semaphore;
	
	public Transfer(Bank bank, Semaphore semaphore) {
		this.bank = bank;
		this.semaphore = semaphore;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				semaphore.acquire(); //获得许可, 进入临界区
				bank.deposit(10);
				System.out.println("账户的余额是: " + bank.getAccount());
				semaphore.release(); //释放, 离开临界区
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//总结: Java 中的 Semaphore 类是一个计数信号量, 而且必须由获取的线程来释放, 这对信号量的管理会造成困难.