import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-26
 * @time 下午6:14:52
 */

public class Homework1 {
	public static void main(String[] args) {
		// 定义两个变量，并交换位置
		// 法一：
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个数");
		int a = scanner.nextInt();
		System.out.println("请输入第二个数");
		int b = scanner.nextInt();
		System.out.println("初始顺序为:\ta=" + a + "\tb=" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("交换后顺序为:\ta=" + a + "\tb=" + b);
		// 法二：
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("请输入第一个数"); int a = scanner.nextInt();
		 * System.out.println("请输入第二个数"); int b = scanner.nextInt();
		 * System.out.println("初始顺序为:\ta=" + a + "\tb=" + b); c = a; a = b; b =
		 * c; System.out.println("交换后顺序为:\ta=" + a + "\tb=" + b);
		 */
	}
}
