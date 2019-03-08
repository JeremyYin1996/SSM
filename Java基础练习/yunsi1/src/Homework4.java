import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-27
 * @time ����4:26:04
 */

public class Homework4 {

	static String isPlus;
	static String[] bookName = new String[1024];// ����ͼ������
	static int[] bookNumber = new int[1024];// ����ͼ������
	static String[] bookAuthor = new String[1024];// ����ͼ����������
	static String[] usersName = new String[1024];
	static String[] usersCode = new String[1024];
	static int i = 0;// �����±�
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\t+++++ͼ�����ϵͳ+++++");
			System.out.println("\t    1.ע��");
			System.out.println("\t    2.��¼");
			System.out.println("\t          ��������Ľ��");
			int choice1 = scanner.nextInt();
			if (choice1 == 1) {
				resign();
			} else if (choice1 == 2) {
			upload();
			}
		} while (true);
	}

	private static void upload() {
		// TODO Auto-generated method stub
		//��¼���˵�
		Scanner scanner = new Scanner(System.in);
		System.out.println("\t+++++��¼����+++++");
		System.out.println("����������û���");
		String usersName2 = scanner.next();
		for (i = 0; i < usersName.length; i++) {
			if (usersName[i].equals(usersName2)) {
				System.out.println("�������������");
				String usersCode2 = scanner.next();
				for (i = 0; i < usersName.length; i++) {
					if (usersCode[i].equals(usersCode2)) {
						System.out.println("��½�ɹ�");
						do {
							System.out.println("\t\t+++++��¼����+++++");
							System.out.println("\t\t1.����ͼ��");
							System.out.println("\t\t2.�鿴ͼ��");
							System.out.println("\t\t3.�޸�ͼ��"); 
							System.out.println("\t\t4.ɾ��ͼ��");
							System.out.println("\t\t5.�˳�ϵͳ");
							System.out.println("���������ѡ��");
							int choice2 = scanner.nextInt();

							switch (choice2) {
							case 1:// ����ͼ��
								add();
								break;
							case 2:// �鿴ͼ��
								show();
								break;
							case 3:// �޸�ͼ��
								modify();
								break;
							case 4:// ɾ��ͼ��
								delete();
								break;
							case 5:
								System.exit(0);// �˳�ϵͳ
								break;
							default:
								System.out.println("������������");
							}
						} while (true);
					} else {
						System.out.println("���û������ڻ�����������������룡");
					}
				}
			}
		}
	}

	public static void resign() {
		// TODO Auto-generated method stub
		//ע�����
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("����������û���");
			usersName[i] = scanner.next();
			System.out.println("�������������");
			usersCode[i] = scanner.next();
			System.out.println("ע��ɹ�!");
			i++;
			System.out.println("�Ƿ���Ҫ����ע�ᣨy/n��");
			isPlus = scanner.next();
		} while (isPlus.equals("y"));
	}

	public static void add() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\t\t+++++����ͼ�����+++++");
			System.out.println("����������ͼ������");
			bookName[i] = scanner.next();
			System.out.println("����������ͼ������");
			bookNumber[i] = scanner.nextInt();
			System.out.println("���������ͼ������");
			bookAuthor[i] = scanner.next();
			System.out.println("ͼ�����ӳɹ�");
			i++;
			System.out.println("�Ƿ���Ҫ������ӣ�y/n��");
			isPlus = scanner.next();
		} while (isPlus.equals("y"));

	}

	public static void show() {
		System.out.println("\t\t+++++�鿴ͼ��+++++");
		System.out.println("\t\tͼ������\tͼ������\tͼ������");
		for (i = 0; i < bookName.length; i++) {
			if (bookName[i] != null) {
				System.out.println("\t\t" + bookName[i] + "\t" + bookNumber[i]
						+ "\t" + bookAuthor[i]);
			}
		}
		System.out.println(" ");
		System.out.println(" ");
	}

	public static void modify() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ�޸ĵ�ͼ��ı��");
		int index = scanner.nextInt();
		System.out.println("��������Ҫ�޸ĺ��ͼ������");
		bookName[index - 1] = scanner.next();
		System.out.println("���ͼ���޸ĺ��ͼ������");
		bookNumber[index - 1] = scanner.nextInt();
		System.out.println("��������Ҫ�޸ĺ��ͼ������");
		bookAuthor[index - 1] = scanner.next();
	}

	public static void delete() {
		System.out.println("��������Ҫɾ����ͼ������");
		Scanner scanner = new Scanner(System.in);

		for (i = 0; i < (bookName.length - 1); i++) {
			String bookName2 = scanner.next();
			if (bookName.length == 0) {
				System.out.println("����ͼ����ϢΪ�գ������ͼ�飡");
			} else if (bookName[i].equals(bookName2)) {
				// for (i = 0; i <
				// bookName.length; i++) {
				bookName[i] = null;
				bookNumber[i] = 0;
				System.out.println("ɾ���ɹ���");
				break;
			} else {
				System.out.println("��ͼ�鲻���ڣ����������룡");
			}
		}
	}

}
