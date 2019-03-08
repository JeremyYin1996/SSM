import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-27
 * @time 上午9:08:24
 */

public class Test8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		do {
			System.out.println("请输入第" + (i+1) + "位学生的成绩:");
			int score = scanner.nextInt();
			System.out.println(score);
			i++;
		} while (i < 10);

	}

}
