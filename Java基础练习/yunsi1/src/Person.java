import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-29
 * @time ����3:16:02
 */

public class Person {
	String name;// ����
	int score=0;// ����

	public int style(int choice) {
		// ��ȭ��ʽ
		switch (choice) {
		case 1:
			System.out.println(name + "����ʯͷ");
			break;
		case 2:
			System.out.println(name + "���˼���");
			break;
		case 3:
			System.out.println(name + "���˲�");
			break;
		default:
			break;
		}
		return choice;
	}
}
