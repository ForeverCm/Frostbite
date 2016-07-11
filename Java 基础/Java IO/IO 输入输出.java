import java.io.*;
import java.util.Scanner;

public class Console {
	public static void main(String args[]) {
		String str = new String();
		int[] arr = new int[10];

		BufferedReader inputB = new BufferedReader(new InputStreamReader(System.in)); //字节->字符->文本(读取带缓冲)
		Scanner inputS = new Scanner(System.in);
		try {
			str = inputB.readLine();
			for (int i=0; i<10; i++) {
				arr[i] = inputS.nextInt();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}