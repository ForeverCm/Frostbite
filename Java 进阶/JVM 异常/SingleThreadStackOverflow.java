/**
 * 在 HotSpot 虚拟机中并不区分虚拟机栈和本地方法栈，JVM 中描述了两种异常：
 *	1、如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出 StackOverflowError 异常。
 *	2、如果虚拟机在扩展栈时无法申请到足够的内存空间，将抛出 OutOfMemoryError 异常。
 *	
 * 其实，当栈空间无法继续分配时，内存太小或占用栈空间太大，其本质都是对同一件事情的两种描述而已。如果把实验范围限制在单线程中，下面两种方法都无法
 * 让虚拟机产生 OutOfMemoryError 异常，都获得了 StackOverflowError 中描述了两种异常：
 *	1、使用 -Xss 参数减少栈内存容量，结果抛出 StackOverflowError 异常，异常出现时输出的栈深度相应缩小。
 *	2、定义了大量的本地变量，增加此方法帧中本地变量表的长度，结果抛出 StackOverflowError 异常，异常出现时输出的栈深度相应缩小。
 */

public class StackOverflow {
	private static int level = 0;
	
	public static void main(String[] args) {
		try {
			System.out.println(fac(1<<15));
		} catch (StackOverflowError e) {
			System.out.println("true recursive level: "+level);
			System.out.println("reported recursive level: "+e.getStackTrace().length);
			e.printStackTrace();
		}
	}

	private static long fac(int n) { //深度递归
		level++;
		return n<2 ? n : fac(n-1);
	}
}