/**
 * @author Jeremy
 * @date 2019-1-3
 * @time ����4:20:26
 */

package com.yunsi.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo05 extends JFrame {
	// �������񲼾�
	// �������
	JButton jb1, jb2, jb3, jb4, jb5,jb6;

	public Demo05() {
		jb1 = new JButton("1");
		jb2 = new JButton("2");
		jb3 = new JButton("3");
		jb4 = new JButton("4");
		jb5 = new JButton("5");
		jb6 = new JButton("6");

		// �������񲼾�
		this.setLayout(new GridLayout(3,2));
		// ������������
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
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
		new Demo05();
	}
}


