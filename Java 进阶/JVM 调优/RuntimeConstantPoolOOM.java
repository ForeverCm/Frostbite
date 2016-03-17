/**
 * 向常量池中添加对象最简单的方法是 String.intern() 这个 Native 方法，若池中存在一个等于此 String 对象的字符串，则返回代表池中这个字符串的 String 对象，否则把此对象包含的
 * 字符串添加到常量池中，并返回此 String 对象的引用。本实例通过限制方法区大小为 10M 来间接限制常量池容量，即：-XX:PermSize=10 和 -XX:MaxPermSize=10
 */

public class RuntimeConstantPoolOOM {
	int i = 0;
	
	public static void main(String[] args) {
		//使用 List 保持常量池引用，避免 Full GC 回收常量池的行为
		List<String> list = new ArrayList<String>();
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}