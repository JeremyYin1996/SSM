/**
 * @author Jeremy
 * @date 2018-12-26
 * @time ����6:15:52
 */

public class Homework2 {
	public static void main(String[] args) {
		//����1-100���ܺ�
		int i, sum = 0;
		for (i = 1; i <= 100; i++) {
			sum = i + sum;
		}
		System.out.println("1-100���ܺ�Ϊ" + sum);
	}
}
