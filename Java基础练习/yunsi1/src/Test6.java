import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-26
 * @time 下午4:12:30
 */

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入您的选择：");
		System.out.println("A.詹姆斯    B.库里    C.姚明   D.科比  ");
		String name = scanner.next();
		switch (name) {
		case "A":
			System.out.println("詹姆斯");
			break;
		case "B":
			System.out.println("库里");
			break;
		case "C":
			System.out.println("姚明");
			break;
		case "D":
			System.out.println("科比");
			break;
		default:
			System.out.println("您的输入出错");
			break;
		}
	}
}
