/**
 * @author Jeremy
 * @date 2018-12-26
 * @time 下午6:17:54
 */

public class Homework3 {
	public static void main(String[] args) {
		// 计算1-100中偶数总和
		int i, sum = 0;
		for (i = 0; i <= 100; i=i+2) {
			sum = i + sum;
		}
		System.out.println("1-100中偶数总和为" + sum);
	}
}
