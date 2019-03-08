import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-28
 * @time 下午3:06:11
 */

public class Homework5 {
	private static final double Infinity = 0;
	static int[] num = new int[100];
	static String isContinue;

	public static void main(String[] args) {

		System.out.println("1+2+6=" + cal("+", 1, 2, 6));
		System.out.println("1-2-6=" + cal("-", 1, 2, 6));
		System.out.println("1*2*6=" + cal("*", 1, 2, 6));
		System.out.println("1/0/6=" + cal("/", 1, 0, 6));
	}

	private static double cal(String choice, int... num) {
		// TODO Auto-generated method stub
		double result = num[0];
		switch (choice) {
		case "+":
			for (int i = 1; i < num.length; i++) {
				result += num[i];
			}
			break;
		case "-":
			for (int i = 1; i < num.length; i++) {
				result -= num[i];
			}
			break;
		case "*":
			for (int i = 1; i < num.length; i++) {
				result *= num[i];
			}
			break;
		case "/":
			for (int i = 1; i < num.length; i++) {
				result /= num[i];
			}
			System.out.println("若结果等于Infinity则除数中有0");
			break;
		default:
			System.out.println("输入有误");
			break;
		}
		return result;
	}
}
