/**
 * @author Jeremy
 * @date 2019-1-4
 * @time 上午9:11:34
 */

package com.yunsi.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Demo07 extends JFrame  implements MouseListener{

	String[] array = { "经理", "普通员工" };
	JTextField jtf1;
	// 创建密码组件
	JPasswordField jpf1, jpf2;
	// 创建标签组件
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7;
	// 定义下拉框
	JComboBox jcb1;
	// 定义单选按钮
	JRadioButton jrb1, jrb2;
	// 定义复选框
	JCheckBox jcb2, jcb3, jcb4;
	JButton jb1, jb2;

	public Demo07() {
		jl1 = new JLabel("用户名：");
		jl1.setBounds(93, 51, 50, 20);
		jl2 = new JLabel("密码：");
		jl2.setBounds(93, 97, 50, 20);
		jl3 = new JLabel("注册登录界面");
		jl3.setBounds(150, 0, 87, 20);
		jl4 = new JLabel("再次输入:");
		jl4.setBounds(93, 143, 62, 20);
		jl5 = new JLabel("权限");
		jl5.setBounds(93, 188, 50, 20);
		jl6 = new JLabel("性别");
		jl6.setBounds(93, 240, 50, 20);
		jl7 = new JLabel("兴趣爱好");
		jl7.setBounds(93, 284, 62, 20);
		
		jtf1 = new JTextField(10);
		//设置文本框背景色
		jtf1.setBackground(Color.gray);
		jtf1.setBounds(148, 51,113, 21);
		jtf1.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				String username = jtf1.getText();
				System.out.println("用户名是"+username);
			}

			@Override
			public void focusLost(FocusEvent e) {
				jtf1.setText("我贼帅");
				
			}});
		
		jpf1 = new JPasswordField(10);
		jpf1.setBounds(148, 97,113, 21);
		jpf1.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标点击");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("鼠标按压");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("鼠标释放");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标进入");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("鼠标离开");
			}}
		);
		
		jpf2 = new JPasswordField(10);
		jpf2.setBounds(148, 144,113, 21);
		
		jcb1 = new JComboBox(array);
		jcb1.setBounds(148,188,113, 21);
	
		jrb1 = new JRadioButton("男",true);
		jrb1.setBounds(148, 240,40, 20);	

		jrb2 = new JRadioButton("女");
		jrb2.setBounds(211, 240,40, 20);
		
		jcb2 = new JCheckBox("lol");
		jcb2.setBounds(163, 281,55, 20);
		
		jcb3 = new JCheckBox("吃鸡");
		jcb3.setBounds(223, 281,55, 20);
		
		jcb4 = new JCheckBox("荣耀");
		jcb4.setBounds(283, 281,55, 20);
		
		jb1 = new JButton("登陆");
		jb1.setBounds(107, 341,66, 30);
		jb1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = jtf1.getText();
				String password = new String(jpf1.getPassword());
				System.out.println(username+password);
			}});
		
		jb2 = new JButton("注册");
		jb2.setBounds(180,341,66, 30);
		this.add(jl3);
		this.add(jl1);
		this.add(jtf1);
		this.add(jl2);
		this.add(jpf1);
		this.add(jl4);
		this.add(jpf2);
		this.add(jl5);
		this.add(jcb1);
		this.add(jl6);
		this.add(jrb1);
		this.add(jrb2);
		this.add(jl7);
		this.add(jcb2);
		this.add(jcb3);
		this.add(jcb4);
		this.add(jb1);
		this.add(jb2);
		
		//设置窗口背景色
		this.getContentPane().setBackground(Color.lightGray);
		// 设置窗口布局
		this.setLayout(null);
		// 设置窗口标题
		this.setTitle("第一个图形化界面");
		// 设置窗口大小
		this.setSize(400, 500);
		// 设置窗口位置
		// jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// 设置窗口是否可见
		this.setVisible(true);// true表示可见，false表示不可见
		// 设置窗口默认关闭方式
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Demo07();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jtf1.setBackground(Color.black);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		jtf1.setBackground(Color.gray);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		jtf1.setBackground(Color.blue);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("我进来了");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("我出去了");
	}
}
