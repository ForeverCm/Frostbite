/**
 * 堆溢出：
 * Java 堆用于存储对象实例，通过不断的创造对象，并且保证 GC Root 到对象之间有路径可达来避免垃圾回收机制清除这些对象，就可以造成在对象数量到达最大堆的容量限制后产生 
 * OutOfMemoryError 内存溢出异常。
 * 
 * 本实例限制 Java 堆大小为 20MB 不可扩展，10MB 分配给新生代，10M 分配给老年代，Eden 区和 Suivivor 区比为 8 比 1。
 * 即：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8，参数：-XX:+HeapDumpOnOutOfMemoryError 把虚拟机在出现内存溢出异常时 Dump 出当前的内存堆转储快照以便分析。
 */
 
public class HeapOOM {
    static class OOMObject {
		 
    }
	 
    public static void main(String[] args) {
	    List<OOMObject> list = new ArrayList<OOMObject>();
	    while (true) {
		    list.add(new OOMObject());
	    }
    }
}
 
/**
 * Java 堆内存 OOM 异常是实际应用中最常见的内存溢出异常，要解决这个区域的异常，一般的手段是通过内存映像分析工具(如:Eclipse Memory Analyzer)对 Dump 出来的堆转
 * 存储快照分析，重点是确认内存中的对象是否必要的，也就是要分清楚到底是出现了内存泄露(Memory Leak)还是内存溢出(Memory Overflow)。
 *
 * 如果是内存泄露，进一步通过工具查看泄露对象到 GC Roots 的引用链，就能找到泄露对象是通过怎样的路径与 GC Roots 相关联并导致垃圾收集器无法自动回收的，就可以比较准确
 * 的定位出泄露代码的位置。
 *
 * 如果不存在泄露，换句话说就是内存中对象确实都还必须存活着，那就对照物理机器内存检查虚拟机堆参数 -Xmx 和 -Xms 看看是否还可以调大，同时，从代码上检查是否存在某些对象
 * 生命周期过长、持有状态过长的情况，尝试减少运行期间内存的消耗。
 */