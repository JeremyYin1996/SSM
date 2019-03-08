package com.phone.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 账单管理修改数据界面
 * @author Administrator
 *
 */
public abstract class AccountModifyJfream extends JFrame{
	//定义组件
	protected JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	protected JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	protected JComboBox jcb1,jcb2;
	protected String[] array = {"已付款","未付款"};
	protected String[] array2= {};
	protected JButton jb1,jb2;
			
	public  void AccountModifyJfream() {
		init();
		listener();
	}

	private void listener() {
		//修改按钮监听事件
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				accountModify();
			}
		});
		//取消按钮监听事件
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cancel();
			}
		});
	}
	public abstract void accountModify();
	public abstract void cancel();

	private void init() { 
		
		
		//初始化组件
		jl1 = new JLabel("商品名称");
		jl1.setBounds(30, 30, 90, 20);
		jl2 = new JLabel("交易数量");
		jl2.setBounds(30, 80, 90, 20);
		jl3 = new JLabel("交易金额");
		jl3.setBounds(30, 130, 90, 20);
		jl4 = new JLabel("是否付款");
		jl4.setBounds(30, 180, 90, 20);
		jl5 = new JLabel("所属供应商");
		jl5.setBounds(30, 230, 90, 20);
		jl6 = new JLabel("商品描述");
		jl6.setBounds(30, 280, 90, 20);
		jl7 = new JLabel("交易时间");
		jl7.setBounds(30, 330, 90, 20);
		jtf1 = new JTextField();
		jtf1.setBounds(130, 30, 150, 30);
		jtf2 = new JTextField();
		jtf2.setBounds(130, 80, 150, 30);
		jtf3 = new JTextField();
		jtf3.setBounds(130, 130, 150, 30);
		jtf4 = new JTextField();
		jtf4.setBounds(130, 280, 150, 30);
		jtf5 = new JTextField();
		jtf5.setBounds(130, 330, 150, 30);
		jcb1 = new JComboBox(array);
		jcb1.setBounds(130, 180, 150, 30);
		jcb2 = new JComboBox(array2);
		jcb2.setBounds(130, 230, 150, 30);
		jb1 = new JButton("修改");
		jb1.setBounds(60, 380, 70, 30);
		jb2 = new JButton("取消");
		jb2.setBounds(205, 380, 70, 30);
		
		//添加组件
		this.add(jl1);
		this.add(jl2);
		this.add(jl3);
		this.add(jl4);
		this.add(jl5);
		this.add(jl6);
		this.add(jl7);
		this.add(jtf1);
		this.add(jtf2);
		this.add(jtf3);
		this.add(jtf4);
		this.add(jtf5);
		this.add(jcb1);
		this.add(jcb2);
		this.add(jb1);
		this.add(jb2);
		
		//设置布局方式
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//设置窗体的背景色
		this.getContentPane().setVisible(true);//true显示红色，false则不显示
		//设置窗口是否可见
		this.setVisible(true);
		//设置窗口标题
		this.setTitle("修改");
		//设置窗口大小
		this.setSize(310, 470);
		//设置窗口位置
//		this.setLocation(500, 20);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		//设置窗口默认关闭方式
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}
}
