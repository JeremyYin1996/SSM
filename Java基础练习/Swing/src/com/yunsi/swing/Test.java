/**
 * @author Jeremy
 * @date 2019-1-3
 * @time ����4:52:05
 */

package com.yunsi.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test extends JFrame {
	
	
	JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11, jb12,
			jb13, jb14, jb15, jb16;
	JPanel jp1;
	JTextField jtf1;

	public Test() {
		jb1 = new JButton("7");
		jb2 = new JButton("8");
		jb3 = new JButton("9");
		jb4 = new JButton("+");
		jb5 = new JButton("4");
		jb6 = new JButton("5");
		jb7 = new JButton("6");
		jb8 = new JButton("-");
		jb9 = new JButton("1");
		jb10 = new JButton("2");
		jb11 = new JButton("3");
		jb12 = new JButton("*");
		jb13 = new JButton("0");
		jb14 = new JButton(".");
		jb15 = new JButton("=");
		jb16 = new JButton("/");
		jp1 = new JPanel();
		jtf1 = new JTextField();

		// ���ô��ڲ���
		this.setLayout(new BorderLayout());
		this.add(jtf1, BorderLayout.NORTH);
		this.add(jp1, BorderLayout.CENTER);

		// ������ʽ����
		jp1.setLayout(new GridLayout(4, 4));
		// ������������
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(jb5);
		jp1.add(jb6);
		jp1.add(jb7);
		jp1.add(jb8);
		jp1.add(jb9);
		jp1.add(jb10);
		jp1.add(jb11);
		jp1.add(jb12);
		jp1.add(jb13);
		jp1.add(jb14);
		jp1.add(jb15);
		jp1.add(jb16);
		// ���ô��ڱ���
		this.setTitle("������");
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
		new Test();
	}
}
