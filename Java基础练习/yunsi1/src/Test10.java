import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-27
 * @time 下午1:42:52
 */

public class Test10 {
	public static void main(String[] args) {

		String[] name = new String[10];
		double[] score = new double[10];
		Scanner scanner = new Scanner(System.in);
		int i;
		for (i = 0; i < 10; i++) {
			System.out.println("请输入第" + (i + 1) + "位学生姓名");
			name[i] = scanner.next();
			System.out.println("请输入第" + (i + 1) + "位学生分数");
			score[i] = scanner.nextDouble();
		}
		for (i = 0; i < 10; i++) {
			System.out.println("第" + (i + 1) + "位学生" + name[i] + "的成绩为"
					+ score[i]);
		}
	}
}
