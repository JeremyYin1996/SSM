import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-29
 * @time ����3:12:46
 */

public class PK {
	static String isContinue;
	static Person person = new Person();
	static Computer computer = new Computer();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\t������������ƣ�");
		person.name = scanner.next();
		System.out.println("\t�������������");
		computer.name = scanner.next();

		do {
			System.out.println("\t\t���������ѡ��");
			System.out.println("\t\t1.����");
			System.out.println("\t\t2.��ʾ��ҷ���");
			System.out.println("\t\t3.�˳�ϵͳ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				bisai();
				break;
			case 2:
				total();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("���������д�");
				;
				break;
			}
		} while (true);
	}

	private static void total() {
		int score = person.score;
		System.out.println("\t\t" + person.name + "һ���÷�" + score + "��");
		System.out.println();
	}

	public static void bisai() {
		// ��ȭ
		do {
			System.out.println("\t���ȭ��1.ȭͷ��2.������3.��");
			int CQ = scanner.nextInt();
			int P = person.style(CQ);// �����ȭ��ʽ
			int C = computer.style();// ���Գ�ȭ��ʽ
			if ((C == 1 && P == 2) || (C == 2 && P == 3) || (C == 3 && P == 1)) {
				System.out.println("\t\t������");
				person.score -= 3;
			} else if ((C == 1 && P == 3) || (C == 2 && P == 1)
					|| (C == 3 && P == 2)) {
				System.out.println("\t\t��Ӯ�ˣ�");
				person.score += 3;
			} else if ((C == 1 && P == 1) || (C == 2 && P == 2)
					|| (C == 3 && P == 3)) {
				System.out.println("\t\t��͵���55��");
			}
			System.out.println();
			System.out.println("\t\t�Ƿ���Ҫ������ȭ��y/n��");
			isContinue = scanner.next();
		} while (isContinue.equals("y"));
	}

}
