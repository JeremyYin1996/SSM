import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-26
 * @time ����4:12:30
 */

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����������ѡ��");
		System.out.println("A.ղķ˹    B.����    C.Ҧ��   D.�Ʊ�  ");
		String name = scanner.next();
		switch (name) {
		case "A":
			System.out.println("ղķ˹");
			break;
		case "B":
			System.out.println("����");
			break;
		case "C":
			System.out.println("Ҧ��");
			break;
		case "D":
			System.out.println("�Ʊ�");
			break;
		default:
			System.out.println("�����������");
			break;
		}
	}
}
