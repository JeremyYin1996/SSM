import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-27
 * @time 下午4:26:04
 */

public class Homework4 {

	static String isPlus;
	static String[] bookName = new String[1024];// 定义图书名称
	static int[] bookNumber = new int[1024];// 定义图书数量
	static String[] bookAuthor = new String[1024];// 定义图书作者名称
	static String[] usersName = new String[1024];
	static String[] usersCode = new String[1024];
	static int i = 0;// 数组下标
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\t+++++图书管理系统+++++");
			System.out.println("\t    1.注册");
			System.out.println("\t    2.登录");
			System.out.println("\t          请输入你的结果");
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
		//登录及菜单
		Scanner scanner = new Scanner(System.in);
		System.out.println("\t+++++登录界面+++++");
		System.out.println("请输入你的用户名");
		String usersName2 = scanner.next();
		for (i = 0; i < usersName.length; i++) {
			if (usersName[i].equals(usersName2)) {
				System.out.println("请输入你的密码");
				String usersCode2 = scanner.next();
				for (i = 0; i < usersName.length; i++) {
					if (usersCode[i].equals(usersCode2)) {
						System.out.println("登陆成功");
						do {
							System.out.println("\t\t+++++登录界面+++++");
							System.out.println("\t\t1.增加图书");
							System.out.println("\t\t2.查看图书");
							System.out.println("\t\t3.修改图书"); 
							System.out.println("\t\t4.删除图书");
							System.out.println("\t\t5.退出系统");
							System.out.println("请输入你的选择");
							int choice2 = scanner.nextInt();

							switch (choice2) {
							case 1:// 增加图书
								add();
								break;
							case 2:// 查看图书
								show();
								break;
							case 3:// 修改图书
								modify();
								break;
							case 4:// 删除图书
								delete();
								break;
							case 5:
								System.exit(0);// 退出系统
								break;
							default:
								System.out.println("您的输入有误");
							}
						} while (true);
					} else {
						System.out.println("该用户不存在或密码错误，请重新输入！");
					}
				}
			}
		}
	}

	public static void resign() {
		// TODO Auto-generated method stub
		//注册界面
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("请输入你的用户名");
			usersName[i] = scanner.next();
			System.out.println("请输入你的密码");
			usersCode[i] = scanner.next();
			System.out.println("注册成功!");
			i++;
			System.out.println("是否需要继续注册（y/n）");
			isPlus = scanner.next();
		} while (isPlus.equals("y"));
	}

	public static void add() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\t\t+++++增加图书界面+++++");
			System.out.println("请输入您的图书名称");
			bookName[i] = scanner.next();
			System.out.println("请输入您的图书数量");
			bookNumber[i] = scanner.nextInt();
			System.out.println("请输入你的图书作者");
			bookAuthor[i] = scanner.next();
			System.out.println("图书增加成功");
			i++;
			System.out.println("是否需要继续添加（y/n）");
			isPlus = scanner.next();
		} while (isPlus.equals("y"));

	}

	public static void show() {
		System.out.println("\t\t+++++查看图书+++++");
		System.out.println("\t\t图书名称\t图书数量\t图书作者");
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
		System.out.println("请输入你要修改的图书的编号");
		int index = scanner.nextInt();
		System.out.println("请输入你要修改后的图书名称");
		bookName[index - 1] = scanner.next();
		System.out.println("请该图书修改后的图书数量");
		bookNumber[index - 1] = scanner.nextInt();
		System.out.println("请输入你要修改后的图书作者");
		bookAuthor[index - 1] = scanner.next();
	}

	public static void delete() {
		System.out.println("请输入你要删除的图书名称");
		Scanner scanner = new Scanner(System.in);

		for (i = 0; i < (bookName.length - 1); i++) {
			String bookName2 = scanner.next();
			if (bookName.length == 0) {
				System.out.println("所有图书信息为空，请添加图书！");
			} else if (bookName[i].equals(bookName2)) {
				// for (i = 0; i <
				// bookName.length; i++) {
				bookName[i] = null;
				bookNumber[i] = 0;
				System.out.println("删除成功！");
				break;
			} else {
				System.out.println("该图书不存在，请重新输入！");
			}
		}
	}

}
