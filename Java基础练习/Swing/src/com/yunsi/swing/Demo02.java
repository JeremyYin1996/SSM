package com.yunsi.swing;
import javax.swing.JFrame;

/**
 * @author Jeremy
 * @date 2019-1-3
 * @time ����3:24:37
 */

public class Demo02 extends JFrame {
	public Demo02() {
		// ���ô��ڱ���
		this.setTitle("��һ��ͼ�λ�����");
		// ���ô��ڴ�С
		this.setSize(400, 300);
		// ���ô���λ��
		//jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// ���ô����Ƿ�ɼ�
		this.setVisible(true);// true��ʾ�ɼ���false��ʾ���ɼ�
		// ���ô���Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Demo02();
	}
}
