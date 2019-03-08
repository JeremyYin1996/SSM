package com.phone.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 根据商品编号删除account表中数据确认界面
 * @author Administrator
 *
 */
public abstract class AccountDeleteJfream extends JFrame{
	//定义组件
	protected JButton jb1,jb2;
	public AccountDeleteJfream() {
		init();
		listener();
	}

	private void listener() {
		jb1.addActionListener(new ActionListener() {
			
			//确认删除按钮监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				confirm();
			}
		});
		jb2.addActionListener(new ActionListener() {
			
			//取消按钮监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
	}
	public abstract void confirm();
	public abstract void cancel();

	private void init() {
		//初始化组件
		jb1 = new JButton("确认删除");
		jb1.setBounds(40, 60, 100, 30);
		jb2 = new JButton("取  消");
		jb2.setBounds(240, 60, 100, 30);
		
		//添加组件
		this.add(jb1);
		this.add(jb2);
		//设置窗口布局
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//设置窗体的背景色
		this.getContentPane().setVisible(true);//true显示红色，false则不显示
		//设置窗口可见
		this.setVisible(true);
		//设置窗口大小
		this.setSize(390,150);
		//设置窗口位置
//		this.setLocation(496, 173);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		//设置默认关闭方式
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}


}
