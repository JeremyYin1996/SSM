import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-25
 * @time 下午2:08:09
 */
public class Menu {
	/**
	 * @param args
	 */
	static String isBuy;
	static double payMoney;

	public static void main(String[] args) {
		String[] goodsName = new String[1024];// 定义商品名称
		int[] goodsNumber = new int[1024];// 定义商品数量
		double[] goodsPrice = new double[1024];// 定义商品单价
		int i = 0;// 数组下标
		System.out.println("\t+++++好又多超市+++++");
		System.out.println("\t    1.查看积分");
		System.out.println("\t    2.结算");
		System.out.println("\t          请输入你的结果");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:// 查看积分模块
			String name = "张三";
			int cardId = 1234566;
			double point = 100.05;
			System.out.println("\t+++++查看积分+++++");
			System.out.println("\t姓名\t卡号\t积分");
			System.out.println("\t" + name + "\t" + cardId + "\t" + point);
			break;
		case 2:// 结算模块
			double total = 0.0;
			do {
				System.out.println("\t+++++结算界面+++++");
				System.out.println("请输入您的商品名称");
				goodsName[i] = scanner.next();
				System.out.println("请输入您的商品数量");
				goodsNumber[i] = scanner.nextInt();
				System.out.println("请输入您的商品单价");
				goodsPrice[i] = scanner.nextDouble();
				// System.out.println("\t"+name+"\t"+cardId+"\t"+point);
				total += goodsPrice[i] * goodsNumber[i];
				i++;
				System.out.println("是否需要继续购买（y/n）");
				isBuy = scanner.next();
			} while (isBuy.endsWith("y"));
			System.out.println("您需要付款" + total + "元");
			System.out.println("您付了：");
			payMoney = scanner.nextDouble();
			while (true) {
				if (payMoney < total) {
					System.out.println("您的余额不足，请重新付款！");
					payMoney = scanner.nextDouble();

				} else {
					break;
				}
			}
			System.out.println("找零:" + (payMoney - total) + "元");
			System.out.println("\t\t+++++打印小票+++++");
			System.out.println("\t\t商品名称\t商品数量\t商品单价");
			for (i = 0; i < goodsName.length; i++) {
				if (goodsName[i] != null) {
					System.out.println("\t\t" + goodsName[i] + "\t"
							+ goodsNumber[i] + "\t" + goodsPrice[i]);
				}
			}
			System.out.println("\t\t共计" + total + "元");
			System.out.println("\t\t实付" + payMoney + "元");	
			System.out.println("\t\t找零" + (payMoney - total) + "元");
			System.out.println("\t\t付款成功，谢谢惠顾！");
			break;
		default:
			System.out.println("您的输入有误");
		}
	}
}
