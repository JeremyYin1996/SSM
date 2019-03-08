/**
 * @author Jeremy
 * @date 2018-12-26
 * @time 下午6:15:52
 */

public class Homework2 {
	public static void main(String[] args) {
		//计算1-100的总和
		int i, sum = 0;
		for (i = 1; i <= 100; i++) {
			sum = i + sum;
		}
		System.out.println("1-100的总和为" + sum);
	}
}
