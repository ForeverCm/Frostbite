/**
 * 引用计数算法，简单高效，包括微软 COM(Component Object Model) 技术，ActionScript 3 的 FlashPlayer，Python 语言等都是使用该技术进行内存管理。
 * 但是，Java 并没有采用这项技术，最主要的原因是引用计数很难解决对象之间相互循环引用的问题，我们可以验证一下，如下例：GC 日志清楚的包含了 5427K->600K，
 * 意味着 JVM 并没有因为这两个对象相互引用就不回收，故 JVM 并不是通过引用计数算法来判断对象是否存活。
 */
 
public class ReferenceCountGC {
	public Objcet instance = null;
	private static final int _MB = 1024*1024;
	
	//这个成员变量的意义是占多点内存，便于在 GC 日志中看清楚是否被回收过
	private byte[] bigSize = new byte[2*_MB];
	
	public static void main(String[] args) {
		ReferenceCountGC objA = new ReferenceCountGC();
		ReferenceCountGC objB = new ReferenceCountGC();
		
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();
	}
}

/**
 * [GC (System.gc()) [PSYoungGen: 5427K->600K(38400K)] 5427K->608K(125952K), 0.0006499 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
 * [Full GC (System.gc()) [PSYoungGen: 600K->0K(38400K)] [ParOldGen: 8K->498K(87552K)] 608K->498K(125952K), 
 * [Metaspace: 2509K->2509K(1056768K)], 0.0034147 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
 *	Heap
 *	PSYoungGen      total 38400K, used 333K [0x00000000d5900000, 0x00000000d8380000, 0x0000000100000000)
 *	eden space 33280K, 1% used [0x00000000d5900000,0x00000000d59534a8,0x00000000d7980000)
 *	from space 5120K, 0% used [0x00000000d7980000,0x00000000d7980000,0x00000000d7e80000)
 *	to   space 5120K, 0% used [0x00000000d7e80000,0x00000000d7e80000,0x00000000d8380000)
 *	ParOldGen       total 87552K, used 498K [0x0000000080a00000, 0x0000000085f80000, 0x00000000d5900000)
 *	object space 87552K, 0% used [0x0000000080a00000,0x0000000080a7c9b8,0x0000000085f80000)
 *	Metaspace       used 2516K, capacity 4486K, committed 4864K, reserved 1056768K
 *	class space    used 270K, capacity 386K, committed 512K, reserved 1048576K
 */