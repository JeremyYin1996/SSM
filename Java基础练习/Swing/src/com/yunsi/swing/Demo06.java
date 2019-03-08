/**
 * @author Jeremy
 * @date 2019-1-3
 * @time 下午4:32:01
 */

package com.yunsi.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Demo06 extends JFrame {
	JButton jb1, jb2, jb3, jb4, jb5, jb6;
	JPanel jp1, jp2;
	JTextField jtf1;
	public Demo06() {
		jb1 = new JButton("1");
		jb2 = new JButton("2");
		jb3 = new JButton("3");
		jb4 = new JButton("4");
		jb5 = new JButton("5");
		jb6 = new JButton("6");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jtf1 = new JTextField();

		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);

		// 设置窗口布局
		this.setLayout(new BorderLayout());
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
	//	this.add(jb6, BorderLayout.SOUTH);
		this.add(jtf1, BorderLayout.SOUTH);
		
		// 设置窗口标题
		this.setTitle("第一个图形化界面");
		// 设置窗口大小
		this.setSize(400, 300);
		// 设置窗口位置
		// jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// 设置窗口是否可见
		this.setVisible(true);// true表示可见，false表示不可见
		// 设置窗口默认关闭方式
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Demo06();
	}

}
