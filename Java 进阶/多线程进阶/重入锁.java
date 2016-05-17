/**
 * ReentrantLock 类是可重入、互斥实现了 Lock 接口的锁, 具有和使用 Synchronized 方法相同的基本行为和语义, 并且大大扩展了其能力.
 */

public class Bank {
	private int account = 100;
	private Lock lock = new ReentrantLock();
	
	public void deposit(int money) {
		lock.lock(); //锁
		try {
			account += money; 
		} finally { 
			lock.unlock(); //解锁
		}
	}
	
	public int getAccount() {
		return account;
	}
}


public class Transfer implements Runnable {
	private Bank bank;
	
	public Transfer(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.deposit(10); //每次存 10 块钱
			System.out.println("账户余额是: " + bank.getAccount());
		}
	}
}