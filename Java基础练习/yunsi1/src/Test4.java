import java.util.Scanner;

/**
 * @author Jeremy
 * @date 2018-12-26
 * @time ����2:02:18
 */

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������·ݣ�");
		int yue = scanner.nextInt();
		// if((yue>=3)&&(yue<=5)){
		// System.out.println("����");
		// }else if(yue>=6&&yue<=7){
		// System.out.println("�ļ�");
		// }else if(yue>=8&&yue<=11){
		// System.out.println("�＾");
		// }else if( (yue>=11&&yue<=12)||(yue==1) ){
		// System.out.println("����");
		// }

		switch (yue) {
		case 1:
		case 2:
			System.out.println("����");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("����");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("�ļ�");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("�＾");
			break;
		case 12:
			System.out.println("����");
			break;
		default:
			System.out.println("��������·ݳ���");
			break;
		}

	}
}
