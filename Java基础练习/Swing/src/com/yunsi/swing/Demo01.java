/**
 * @author Jeremy
 * @date 2019-1-3
 * @time ����2:59:28
 */

package com.yunsi.swing;

import javax.swing.JFrame;

public class Demo01 {
	// ���Դ���
	public Demo01() {
		super();
		// ������һ�����ɼ��Ĵ���
		JFrame jFrame = new JFrame();
		// ���ô��ڱ���
		jFrame.setTitle("��һ��ͼ�λ�����");
		// ���ô��ڴ�С
		jFrame.setSize(400, 300);
		// ���ô���λ��
		//jFrame.setLocation(450,250);
		jFrame.setLocationRelativeTo(null);
		// ���ô����Ƿ�ɼ�
		jFrame.setVisible(true);// true��ʾ�ɼ���false��ʾ���ɼ�
		// ���ô���Ĭ�Ϲرշ�ʽ
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
	}
}
