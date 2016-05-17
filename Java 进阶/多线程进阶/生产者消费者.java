import java.util.concurrent.LinkedBlockingQueue;

public class LocalTest {
	public static void main(String[] args) {
		LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>();
		Storage store = new Storage(list);
		
		Producer p1 = new Producer(store);
		Producer p2 = new Producer(store);
		Producer p3 = new Producer(store);
		Producer p4 = new Producer(store);
		Producer p5 = new Producer(store);
		Producer p6 = new Producer(store);
		Producer p7 = new Producer(store);
		Producer p8 = new Producer(store);
		Producer p9 = new Producer(store);
		Producer p10 = new Producer(store);
		Producer p11 = new Producer(store);
		
		Consumer c1 = new Consumer(store);
		Consumer c2 = new Consumer(store);
		Consumer c3 = new Consumer(store);
		Consumer c4 = new Consumer(store);
		Consumer c5 = new Consumer(store);
		Consumer c6 = new Consumer(store);
		Consumer c7 = new Consumer(store);
		Consumer c8 = new Consumer(store);
		
		p1.start();
		p2.start();
		c2.start();
		p3.start();
		c1.start();
		p4.start();
		c3.start();
		p5.start();
		p6.start();
		c4.start();
		p7.start();
		p8.start();
		p9.start();
		c5.start();
		c6.start();
		p10.start();
		p11.start();
		c7.start();
		c8.start();
	}
}



import java.util.concurrent.LinkedBlockingQueue;

public class Storage {
	private LinkedBlockingQueue<Object> list;
	
	public Storage(LinkedBlockingQueue<Object> list) {
		this.list = list;
	}
	
	public LinkedBlockingQueue<Object> getList() {
		return list;
	}
}



import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread {
	private Storage str;
	
	public Producer(Storage str) {
		this.str = str;
	}
	
	public void run() {
		LinkedBlockingQueue<Object> list = str.getList();
		
		if (list.size() == 100) {
			System.out.println(Thread.currentThread().getName() + "-" + "仓库已满！");
		}
		
		for (int i=1; i<Math.random()*20; i++) {
			try {
				list.put(new Object());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "-" + "库存：" + list.size());
	}
}



import java.util.concurrent.LinkedBlockingQueue;

public class Consumer extends Thread {
	private Storage str;
	
	public Consumer(Storage str) {
		this.str = str;
	}
	
	public void run() {
		LinkedBlockingQueue<Object> list = str.getList();
		
		if (list.size() == 100) {
			System.out.println(Thread.currentThread().getName() + "-" + "仓库已满！");
		}
		
		for (int i=1; i<5; i++) {
			try {
				list.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "-" + "库存：" + list.size());
	}
}