/**
 * @author Jeremy
 * @date 2018-12-29
 * @time 下午3:16:56
 */

public class Computer {
	String name;// 姓名
	int score=0;// 分数

	public int style() {
		// 出拳方式
		int choice = (int) Math.ceil(Math.random() * 3);// 随机产生 1-3
		switch (choice) {
		case 1:
			System.out.println(name+"出了石头");
			break;
		case 2:
			System.out.println(name+"出了剪刀");
			break;
		case 3:
			System.out.println(name+"出了布");
			break;
		default:
			break;
		}
		return choice;
	}
}
