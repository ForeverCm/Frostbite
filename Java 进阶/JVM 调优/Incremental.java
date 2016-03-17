import java.util.List;
import java.util.ArrayList;

public class Incremental implements Runnable {
	List<Object> list = new ArrayList<Object>();

	public static void main(String[] args) {
		Thread t = new Thread(new Incremental());
		t.start();
	}

	public void run() {
		for (int i=1; i<1000000; i++) {
			Object o = new Object();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("This is the " + i + " Object!!!");
			list.add(o);
		}
	}
}