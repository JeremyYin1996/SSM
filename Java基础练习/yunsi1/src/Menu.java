import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-25
 * @time ����2:08:09
 */
public class Menu {
	/**
	 * @param args
	 */
	static String isBuy;
	static double payMoney;

	public static void main(String[] args) {
		String[] goodsName = new String[1024];// ������Ʒ����
		int[] goodsNumber = new int[1024];// ������Ʒ����
		double[] goodsPrice = new double[1024];// ������Ʒ����
		int i = 0;// �����±�
		System.out.println("\t+++++���ֶ೬��+++++");
		System.out.println("\t    1.�鿴����");
		System.out.println("\t    2.����");
		System.out.println("\t          ��������Ľ��");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:// �鿴����ģ��
			String name = "����";
			int cardId = 1234566;
			double point = 100.05;
			System.out.println("\t+++++�鿴����+++++");
			System.out.println("\t����\t����\t����");
			System.out.println("\t" + name + "\t" + cardId + "\t" + point);
			break;
		case 2:// ����ģ��
			double total = 0.0;
			do {
				System.out.println("\t+++++�������+++++");
				System.out.println("������������Ʒ����");
				goodsName[i] = scanner.next();
				System.out.println("������������Ʒ����");
				goodsNumber[i] = scanner.nextInt();
				System.out.println("������������Ʒ����");
				goodsPrice[i] = scanner.nextDouble();
				// System.out.println("\t"+name+"\t"+cardId+"\t"+point);
				total += goodsPrice[i] * goodsNumber[i];
				i++;
				System.out.println("�Ƿ���Ҫ��������y/n��");
				isBuy = scanner.next();
			} while (isBuy.endsWith("y"));
			System.out.println("����Ҫ����" + total + "Ԫ");
			System.out.println("�����ˣ�");
			payMoney = scanner.nextDouble();
			while (true) {
				if (payMoney < total) {
					System.out.println("�������㣬�����¸��");
					payMoney = scanner.nextDouble();

				} else {
					break;
				}
			}
			System.out.println("����:" + (payMoney - total) + "Ԫ");
			System.out.println("\t\t+++++��ӡСƱ+++++");
			System.out.println("\t\t��Ʒ����\t��Ʒ����\t��Ʒ����");
			for (i = 0; i < goodsName.length; i++) {
				if (goodsName[i] != null) {
					System.out.println("\t\t" + goodsName[i] + "\t"
							+ goodsNumber[i] + "\t" + goodsPrice[i]);
				}
			}
			System.out.println("\t\t����" + total + "Ԫ");
			System.out.println("\t\tʵ��" + payMoney + "Ԫ");	
			System.out.println("\t\t����" + (payMoney - total) + "Ԫ");
			System.out.println("\t\t����ɹ���лл�ݹˣ�");
			break;
		default:
			System.out.println("������������");
		}
	}
}
