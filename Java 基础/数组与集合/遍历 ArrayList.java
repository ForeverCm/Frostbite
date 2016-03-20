import java.util.ArrayList;
import java.util.List;

public class LocalTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		/** 初始化 List 集合 **/
		list.add("abc");
		list.add("def");
		
		System.out.println("foreach 遍历集合: ");
		for(String string : list) {
			System.out.println(string);
		}
		
		
		String[] strs = new String[list.size()];
		list.toArray(strs);
		
		System.out.println("foreach 遍历数组: ");
		for (String s : strs) {
			System.out.println(s);
		}
	}
}