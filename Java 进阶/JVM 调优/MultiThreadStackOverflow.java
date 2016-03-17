/**
 * 如果实验不限于单线程，通过不断的新建线程的方式也是可以产生内存溢出异常的，但是，这种方式产生的异常与栈帧的大小并没有必然联系。或者准确的说，在这种情况下，每个线程的栈分配的内存
 * 越大，反而越容易产生内存溢出异常。原因其实很好理解，操作系统分配给每个进程的内存是有限的，虚拟机提供了参数来控制 Java 堆和方法区内存的最大值(Xmx 和 MaxPermSize，PC 占内存
 * 很小忽略不计)，同时把虚拟机进程本身消耗内存忽略不计，剩下的内存由虚拟机栈和本地方法栈瓜分，每个线程分配到的栈容量越大，可以建立的线程数量自然就越少，建立线程时候就越容易把剩下的
 * 内存耗尽。
 *
 * 出现 StackOverflow 异常有堆栈信息，相对而言是比较容易找到问题所在。而且如果使用虚拟机默认参数，栈深度在大多数情况下达到 1000~2000 完全没
 * 问题，对于正常的方法调用(包括递归)完全够用了。但是，如果是建立过多线程导致的内存溢出，在不能减少线程数或者更换 64 位的虚拟机的情况下，就只能通过减少最大堆和减少栈容量来换取更多
 * 的线程，这种通过"减少内存"的手段来解决内存溢出的方法，这在开发多线程应用时需要特别注意。
 */
 
public class MultiThreadStackOverflow implements Runnable {
	public static void main(String[] args) {
		while (true) {
			Thread th = new Thread(new MultiThreadStackOverflow());
			th.start();
		}
	}
	
	public void run() {
		int i = 0;
		while (true) {
			i++;
		}
	}
}