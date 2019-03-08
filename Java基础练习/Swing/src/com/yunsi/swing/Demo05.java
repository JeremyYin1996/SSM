/**
 * @author Jeremy
 * @date 2019-1-3
 * @time 下午4:20:26
 */

package com.yunsi.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo05 extends JFrame {
	// 创建网格布局
	// 创建组件
	JButton jb1, jb2, jb3, jb4, jb5,jb6;

	public Demo05() {
		jb1 = new JButton("1");
		jb2 = new JButton("2");
		jb3 = new JButton("3");
		jb4 = new JButton("4");
		jb5 = new JButton("5");
		jb6 = new JButton("6");

		// 设置网格布局
		this.setLayout(new GridLayout(3,2));
		// 添加组件到窗口
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jb5);
		this.add(jb6);
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
		new Demo05();
	}
}


