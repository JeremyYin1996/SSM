/**
 * @author Jeremy
 * @date 2018-12-26
 * @time ����6:17:54
 */

public class Homework3 {
	public static void main(String[] args) {
		// ����1-100��ż���ܺ�
		int i, sum = 0;
		for (i = 0; i <= 100; i=i+2) {
			sum = i + sum;
		}
		System.out.println("1-100��ż���ܺ�Ϊ" + sum);
	}
}
