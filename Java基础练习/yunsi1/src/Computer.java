/**
 * @author Jeremy
 * @date 2018-12-29
 * @time ����3:16:56
 */

public class Computer {
	String name;// ����
	int score=0;// ����

	public int style() {
		// ��ȭ��ʽ
		int choice = (int) Math.ceil(Math.random() * 3);// ������� 1-3
		switch (choice) {
		case 1:
			System.out.println(name+"����ʯͷ");
			break;
		case 2:
			System.out.println(name+"���˼���");
			break;
		case 3:
			System.out.println(name+"���˲�");
			break;
		default:
			break;
		}
		return choice;
	}
}
