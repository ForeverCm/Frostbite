/**
 * Java 提供了很多种方式和工具类来帮助程序员简化多线程的开发, 同步方法是最简单和最常用的的一种!!!
 * 使用 ThreadLocal 类管理线程的局部变量, 使每个线程都能获得相互独立的副本, 每个线程都可以随意的修改自己的变量值而不会对其他线程产生任何影响. 
 */

public class Bank {
	//ThreadLocal 通常是 private static 类型
	private static ThreadLocal<Integer> account = new ThreadLocal<Integer>() {
		
		//重写 initialValue 方法, 将 account 的初始值设置为 100
		@Override
		protected Integer initialValue() {
			return 100;
		}
	};
	
	public void deposit(int money) {
		account.set(account.get() + money);
	}
	
	public int getAccount() {
		return account.get();
	}
}


public class Transfer implements Runnable {
	private Bank bank;
	
	public Transfer(Bank bank) {
		this.bank = bank;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			bank.deposit(10); //每次存 10 块
			System.out.println("账户余额是: " + bank.getAccount());
		}
	}
}
//ThreadLocal 和同步机制都是为了解决多线程中相同变量的访问冲突问题, 前者采用了"空间换时间"的方式, 后者采用了"时间换空间"的方式.