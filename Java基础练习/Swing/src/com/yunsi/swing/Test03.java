/**
 * @author Jeremy
 * @date 2019-1-4
 * @time 下午1:47:54
 */

package com.yunsi.swing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Test03 extends JFrame {
	JTextField jtf1;
	// 创建密码组件
	JPasswordField jpf1;
	// 创建标签组件
	JLabel jl1,jl2,jl3,jl4;
	// 定义下拉框
	//JComboBox jcb1;
	// 定义单选按钮
	JRadioButton jrb1, jrb2;
	// 定义复选框
	JCheckBox jcb2, jcb3, jcb4;
	JButton jb1;

	public Test03() {
		jl1 = new JLabel(new ImageIcon("C:\\Users\\Jeremy\\Desktop\\11.png"));
		jl1.setBounds(0, 0, 427, 153);
		
		jl2 = new JLabel(new ImageIcon("C:\\Users\\Jeremy\\Desktop\\2.png"));
		jl2.setBounds(0,153,132,149);
		
		jtf1 = new JTextField(10);
		jtf1.setBounds(132, 160,173, 23);
		
		jpf1 = new JPasswordField(10);
		jpf1.setBounds(132,188,173, 23);
	
		jcb2 = new JCheckBox("记住密码");
		jcb2.setBounds(132, 225,100,23);
		
		jcb3 = new JCheckBox("自动登录");
		jcb3.setBounds(262, 225,100,23);
		
		jb1 = new JButton("登录");
		jb1.setBounds(132, 260,173, 23);
		
		jl3 = new JLabel("注册帐号");
		jl3.setBounds(315,160,100,23);
		
		jl4 = new JLabel("找回密码");
		jl4.setBounds(315,188,100,23);
		
		this.add(jl1);
		this.add(jl2);
		this.add(jtf1);
		this.add(jpf1);


		this.add(jcb2);
		this.add(jcb3);
		this.add(jb1);
		this.add(jl3);
		this.add(jl4);
		// 设置窗口布局
		this.setLayout(null);
		// 设置窗口大小
		this.setSize(430, 330);
		// 设置窗口位置
		// jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// 设置窗口是否可见
		this.setVisible(true);// true表示可见，false表示不可见
		// 设置窗口默认关闭方式
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Test03();
	}
}

