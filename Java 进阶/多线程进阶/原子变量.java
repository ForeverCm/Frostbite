/**
 * 需要使用线程同步的根本原因在于对普通变量的操作并不是原子的! 所谓原子操作是将读取变量值、修改变量值、保存变量值看作一个整体，要么同时完成，要么不同时完成，参考数据库的事务原理。
 */

public class Bank {
	private AtomicInteger account = new AtomicInteger(100);
	
	//存钱
	public void deposit(int money) {
		account.addAndGet(money); //以原子方式将给定值和当前值相加
	}
	
	//取钱
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
		for ( int i = 0; i < 10; i++ ) {
			bank.deposit(10);
			System.out.println("账户的余额是: " + bank.getAccount());
		}
	}
}