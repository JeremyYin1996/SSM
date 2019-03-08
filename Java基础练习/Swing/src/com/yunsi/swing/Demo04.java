/**
 * @author Jeremy
 * @date 2019-1-3
 * @time 下午4:12:05
 */

package com.yunsi.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo04 extends JFrame {
	// 创建流式布局
	// 创建组件
	JButton jb1, jb2, jb3, jb4, jb5;

	public Demo04() {
		jb1 = new JButton("北");
		jb2 = new JButton("南");
		jb3 = new JButton("西");
		jb4 = new JButton("东");
		jb5 = new JButton("中");

		// 设置流式布局
		this.setLayout(new FlowLayout());
		// 添加组件到窗口
		this.add(jb1, BorderLayout.NORTH);
		this.add(jb2, BorderLayout.SOUTH);
		this.add(jb3, BorderLayout.WEST);
		this.add(jb4, BorderLayout.EAST);
		this.add(jb5, BorderLayout.CENTER);

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
		new Demo04();
	}
}
