/**
 * TreeSet 集合属于 Set 集合的子类, Set 集合不允许有重复的元素, TreeSet() 类的 add() 方法添加元素：
 */

public class TreeSet {
	public static void main(String[] args) {
		TreeSet<Integer> tSet = new TreeSet<Integer>();
		Random ran = new Random();
		int count = 0;
		
		while(count < 10) { //循环生成随机数
			boolean succeed = tSet.add(ran.nextInt(100));
			if (succeed) {
				count++;
			}
		}
		
		int size = tSet.size();
		Integer[] arr = new Integer[size];
		tSet.toArray(arr);
		
		System.out.println("生成的不重复随机数组如下： ");
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}
}