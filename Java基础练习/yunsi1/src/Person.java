import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-29
 * @time 下午3:16:02
 */

public class Person {
	String name;// 姓名
	int score=0;// 分数

	public int style(int choice) {
		// 出拳方式
		switch (choice) {
		case 1:
			System.out.println(name + "出了石头");
			break;
		case 2:
			System.out.println(name + "出了剪刀");
			break;
		case 3:
			System.out.println(name + "出了布");
			break;
		default:
			break;
		}
		return choice;
	}
}
