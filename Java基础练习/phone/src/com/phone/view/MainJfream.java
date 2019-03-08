package com.phone.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 手机出售账单管理主界面
 * @author Administrator
 *
 */
public abstract class MainJfream extends JFrame {
	//定义组件
	protected JLabel jl1;
	protected JButton jb1,jb2,jb3,jb4;
	public MainJfream() {
		//初始化组件的方法
		init();
		//按钮监听事件
		listener();
	}

	private void listener() {
		//账户管理按钮监听
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				account();
			}
		});
		//供应商管理按钮监听
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				supplier();
			}
		});
		//用户管理按钮监听
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userManager();
			}
		});
		//退出按钮监听
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}
	//账户管理入口
	public abstract void account();
	//供应商管理入口
	public abstract void supplier();
	//用户管理入口
	public abstract void userManager();
	//退出系统
	public abstract void exit();
	
	private void init() {
		//初始化组件
		jl1 = new JLabel("手机出售账单管理系统");
		jl1.setFont(new Font("dialog", 1,18));//设置字体字号、加粗、大小
//		jl1.setForeground(Color.green);//设置字体颜色
		jl1.setBounds(130, 20, 190, 40);
		jb1 = new JButton("账单管理");
		jb1.setBounds(150, 80, 120, 40);
		jb2 = new JButton("供应商管理");
		jb2.setBounds(150, 140, 120, 40);
		jb3 = new JButton("用户管理");
		jb3.setBounds(150, 200, 120, 40);
		jb4 = new JButton("退出");
		jb4.setBounds(150, 260, 120, 40);
		//添加组件
		this.add(jl1);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		
		//设置窗口布局方式为null
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//设置窗体的背景色
		this.getContentPane().setVisible(true);//true显示红色，false则不显示
		//设置窗口大小
		this.setSize(410, 380);
		//设置窗口位置
//		this.setLocation(500, 20);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		//设置窗口标题
		this.setTitle("手机出售账单管理系统");
		//设置窗口是否可见
		this.setVisible(true);
		//设置窗口默认关闭方式
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
