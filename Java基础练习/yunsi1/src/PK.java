import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-29
 * @time 下午3:12:46
 */

public class PK {
	static String isContinue;
	static Person person = new Person();
	static Computer computer = new Computer();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\t请输入玩家名称：");
		person.name = scanner.next();
		System.out.println("\t请输入电脑名称");
		computer.name = scanner.next();

		do {
			System.out.println("\t\t请输入你的选择：");
			System.out.println("\t\t1.比赛");
			System.out.println("\t\t2.显示玩家分数");
			System.out.println("\t\t3.退出系统");
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
				System.out.println("您的输入有错");
				;
				break;
			}
		} while (true);
	}

	private static void total() {
		int score = person.score;
		System.out.println("\t\t" + person.name + "一共得分" + score + "分");
		System.out.println();
	}

	public static void bisai() {
		// 猜拳
		do {
			System.out.println("\t请出拳：1.拳头、2.剪刀、3.布");
			int CQ = scanner.nextInt();
			int P = person.style(CQ);// 人类出拳方式
			int C = computer.style();// 电脑出拳方式
			if ((C == 1 && P == 2) || (C == 2 && P == 3) || (C == 3 && P == 1)) {
				System.out.println("\t\t辣鸡！");
				person.score -= 3;
			} else if ((C == 1 && P == 3) || (C == 2 && P == 1)
					|| (C == 3 && P == 2)) {
				System.out.println("\t\t你赢了！");
				person.score += 3;
			} else if ((C == 1 && P == 1) || (C == 2 && P == 2)
					|| (C == 3 && P == 3)) {
				System.out.println("\t\t你和电脑55开");
			}
			System.out.println();
			System.out.println("\t\t是否需要继续猜拳（y/n）");
			isContinue = scanner.next();
		} while (isContinue.equals("y"));
	}

}
