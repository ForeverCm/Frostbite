/**
 * Java JVM 启动的时候会有一个进程 java.exe.
 * Java 进程中至少有一个线程负责 java 程序的执行, 运行的代码存在于 main() 函数中, 称之为主线程.
 * 实际上, JVM 的启动不止一个线程, 还有一个负责垃圾回收的线程. 
 */

public class SubsidiaryThread extends Thread {
	public void run() {
		for (int i = 0; i < 60; i++) {
			System.out.println("这是分线程在运行!!!" + i);
		}
	}
}


public class MainThread {
	public static void main(String[] args) {
		//实例化 SubsidiaryThread 对象, 就创建了一个新线程
		SubsidiaryThread st = new SubsidiaryThread();
		
		//调用 start() 方法执行线程(自动调用 run() 方法执行辅线程要做的事情)
		st.start();
		for (int i = 0; i < 60; i++) {
			System.out.println("这是主线程在运行!!!" + i);
		}
	}
}