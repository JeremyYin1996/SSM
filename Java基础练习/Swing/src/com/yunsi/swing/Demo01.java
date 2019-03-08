/**
 * @author Jeremy
 * @date 2019-1-3
 * @time 下午2:59:28
 */

package com.yunsi.swing;

import javax.swing.JFrame;

public class Demo01 {
	// 测试窗口
	public Demo01() {
		super();
		// 创建了一个不可见的窗口
		JFrame jFrame = new JFrame();
		// 设置窗口标题
		jFrame.setTitle("第一个图形化界面");
		// 设置窗口大小
		jFrame.setSize(400, 300);
		// 设置窗口位置
		//jFrame.setLocation(450,250);
		jFrame.setLocationRelativeTo(null);
		// 设置窗口是否可见
		jFrame.setVisible(true);// true表示可见，false表示不可见
		// 设置窗口默认关闭方式
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
	}
}
