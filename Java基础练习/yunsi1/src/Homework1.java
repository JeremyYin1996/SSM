import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-26
 * @time ����6:14:52
 */

public class Homework1 {
	public static void main(String[] args) {
		// ��������������������λ��
		// ��һ��
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������һ����");
		int a = scanner.nextInt();
		System.out.println("������ڶ�����");
		int b = scanner.nextInt();
		System.out.println("��ʼ˳��Ϊ:\ta=" + a + "\tb=" + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("������˳��Ϊ:\ta=" + a + "\tb=" + b);
		// ������
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * System.out.println("�������һ����"); int a = scanner.nextInt();
		 * System.out.println("������ڶ�����"); int b = scanner.nextInt();
		 * System.out.println("��ʼ˳��Ϊ:\ta=" + a + "\tb=" + b); c = a; a = b; b =
		 * c; System.out.println("������˳��Ϊ:\ta=" + a + "\tb=" + b);
		 */
	}
}
