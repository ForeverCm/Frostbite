/**
 * DirectMemory 容量可以通过 -XX:MaxDirectMemorySize 指定，如果不指定，则默认与 Java 堆的最大值(-Xmx)一致。
 */
 
public class DirectMemoryOOM {
	private static final int _MB = 1024*1024;
	
	public static void main(String[] args) throws Exception {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0]; //反射
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe)unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(_MB);
		}
	}
}