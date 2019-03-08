/**
 * @author Jeremy
 * @date 2018-12-27
 * @time 上午9:39:55
 */

public class Test9 {
	public static void main(String[] args) {
		int i, sum = 0;
		for (i = 0; i <= 50; i=i+2) {
			if (i == 2) {
				continue;
			} else {
				sum = i + sum;
			}
		}
		System.out.println("1-50的偶数总和为" + sum);
	}
}
