import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-26
 * @time 下午2:37:11
 */

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入分数：");
		int point = scanner.nextInt();
		if (point < 12) {
			System.out.println("进入决赛");
			System.out.println("请输入性别：");
			String sex = scanner.next();
			if (sex.equals("男")) {
				System.out.println("进入男子组");
			} else {
				System.out.println("进入女子组");
			}
		} else {
			System.out.println("没有进入决赛");
		}

	}
}
