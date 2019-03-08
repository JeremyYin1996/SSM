package com.yunsi.swing;
import javax.swing.JFrame;

/**
 * @author Jeremy
 * @date 2019-1-3
 * @time 下午3:24:37
 */

public class Demo02 extends JFrame {
	public Demo02() {
		// 设置窗口标题
		this.setTitle("第一个图形化界面");
		// 设置窗口大小
		this.setSize(400, 300);
		// 设置窗口位置
		//jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// 设置窗口是否可见
		this.setVisible(true);// true表示可见，false表示不可见
		// 设置窗口默认关闭方式
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Demo02();
	}
}
