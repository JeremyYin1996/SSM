/**
 * @author Jeremy
 * @date 2019-1-3
 * @time ����3:34:28
 */

package com.yunsi.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo03 extends JFrame {
	// ���Ա߽粼��
	// �������
	JButton jb1, jb2, jb3, jb4, jb5;

	public Demo03() {
		jb1 = new JButton("��");
		jb2 = new JButton("��");
		jb3 = new JButton("��");
		jb4 = new JButton("��");
		jb5 = new JButton("��");

		// ���ô��ڲ���
		this.setLayout(new BorderLayout());
		// ������������
		this.add(jb1, BorderLayout.NORTH);
		this.add(jb2, BorderLayout.SOUTH);
		this.add(jb3, BorderLayout.WEST);
		this.add(jb4, BorderLayout.EAST);
		this.add(jb5, BorderLayout.CENTER);

		// ���ô��ڱ���
		this.setTitle("��һ��ͼ�λ�����");
		// ���ô��ڴ�С
		this.setSize(400, 300);
		// ���ô���λ��
		// jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// ���ô����Ƿ�ɼ�
		this.setVisible(true);// true��ʾ�ɼ���false��ʾ���ɼ�
		// ���ô���Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Demo03();
	}
}
