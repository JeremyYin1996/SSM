import java.util.Scanner;


public class Test {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("请输入您的姓名：");
	String name = scanner.next();
	System.out.println(name);
	System.out.println("请输入您的学号：");
	int id = scanner.nextInt();
	System.out.println(id);
	System.out.println("请输入您的分数：");
	double score = scanner.nextDouble();
	System.out.println(score);
	System.out.println("请输入您是否已婚（true/false）：");
	boolean marry = scanner.nextBoolean();
	System.out.println(marry);
}
}


/**
 * @author Jeremy
 * @date 2018-12-25
 * @time 下午5:20:56
 */