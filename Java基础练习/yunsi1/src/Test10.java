import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-27
 * @time ����1:42:52
 */

public class Test10 {
	public static void main(String[] args) {

		String[] name = new String[10];
		double[] score = new double[10];
		Scanner scanner = new Scanner(System.in);
		int i;
		for (i = 0; i < 10; i++) {
			System.out.println("�������" + (i + 1) + "λѧ������");
			name[i] = scanner.next();
			System.out.println("�������" + (i + 1) + "λѧ������");
			score[i] = scanner.nextDouble();
		}
		for (i = 0; i < 10; i++) {
			System.out.println("��" + (i + 1) + "λѧ��" + name[i] + "�ĳɼ�Ϊ"
					+ score[i]);
		}
	}
}
