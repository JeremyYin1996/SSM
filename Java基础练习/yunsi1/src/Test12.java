/**
 * @author Jeremy
 * @date 2018-12-28
 * @time обнГ4:58:52
 */

public class Test12 {
	public static void main(String[] args) {
		plus(2, 3, 5,7,8,9,10);

	}

	private static void plus(int...num) {
		// TODO Auto-generated method stub
		int total = 0;
		for (int i = 0; i < num.length; i++) {
			total += num[i];
		}
		System.out.println(total);
	}
}
