package com.phone.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * 账户管理主界面
 * @author Administrator
 *
 */
public abstract class AccountJfream extends JFrame {
	//定义组件
	protected JLabel jl1,jl2,jl3;
	protected JTextField jtf,jtf2,jtf3;
	protected JComboBox jcb;
	protected String[] array = {"未选择","已付款","未付款"};
	public JTable jt1;
	public String[] colums= {"编号","商品名称","商品数量","交易金额","是否付款","供应商名称","商品信息","账单时间"};
	protected JScrollPane jsp;
	protected JButton jb1,jb2,jb3,jb4,jb11,jb22,jb33,jb44;
	
	public AccountJfream() {
		init();
		listener();
	}

	private void listener() {
		//查询按钮监听事件
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				query();
			}
		});
		//增加按钮监听事件
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		//修改按钮监听事件
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		//删除按钮监听事件
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		

		//当前页的光标离开监听事件
			jtf2.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					curPageExit();
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});

		//首页按钮动作监听事件
			jb11.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					homePage();
				}
			});
		
		//上一页按钮动作监听事件
			jb22.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					prePage();
				}
			});
		//下一页按钮动作监听事件
			jb33.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					nextPage();
				}
			});
		//尾页按钮动作监听事件
			jb44.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tailPage();
				}
			});
		
	}

	public abstract void query();
	public abstract void add();
	public abstract void modify();
	public abstract void delete();
	public abstract void curPageExit();
	public abstract void homePage();
	public abstract void prePage();
	public abstract void nextPage();
	public abstract void tailPage();
	
	private void init() {
		//初始化组件
		jl1 = new JLabel("商品名称");
		jl1.setBounds(110, 30, 90, 20);
		jl2 = new JLabel("是否付款");
		jl2.setBounds(380, 30, 90, 20);
		jtf = new JTextField();
		jtf.setBounds(200, 30, 160, 30);
		jcb = new JComboBox(array);
		jcb.setBounds(470, 30, 110, 30);
		jt1 = new JTable();
//		jt1.setBounds(20, 90, 800, 105);
		jsp = new JScrollPane(jt1);
		//设置垂直滚动条不可见
//		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER );
		jsp.setBounds(20, 90, 800, 105);
		jb11 = new JButton("首页");
		jb11.setBounds(125, 215, 110, 30);
		jb22 = new JButton("上一页");
		jb22.setBounds(245, 215, 110, 30);
		jtf2 = new JTextField();
		jtf2.setText("1");
		jtf2.setBounds(365, 215, 42, 30);
		jl3 = new JLabel("/");
		jl3.setBounds(408, 215, 5, 30);
		jtf3 = new JTextField();
		jtf3.setEditable(false);
		jtf3.setBounds(420, 215, 42, 30);
		jb33 = new JButton("下一页");
		jb33.setBounds(472, 215, 110, 30);
		jb44 = new JButton("尾页");
		jb44.setBounds(592, 215, 110, 30);
		jb1 = new JButton("查询");
		jb1.setBounds(660, 30, 110, 30);
		jb2 = new JButton("增加");
		jb2.setBounds(190, 265, 110, 30);
		jb3 = new JButton("修改");
		jb3.setBounds(350, 265, 110, 30);
		jb4 = new JButton("删除");
		jb4.setBounds(510, 265, 110, 30);
		
		//添加组件
		this.add(jl1);
		this.add(jl2);
		this.add(jtf);
		this.add(jcb);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		this.add(jsp);
		this.add(jb11);
		this.add(jb22);
		this.add(jb33);
		this.add(jb44);
		this.add(jl3);
		this.add(jtf2);
		this.add(jtf3);
//		this.add(jt1);
		
		//设置窗口布局
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//设置窗体的背景色
		this.getContentPane().setVisible(true);//true显示红色，false则不显示
		//设置窗口是否可见
		this.setVisible(true);
		//设置窗口标题
		this.setTitle("账单管理");
		//设置窗口大小
		this.setSize(850, 340);
		//设置窗口位置
//		this.setLocation(300,20);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		//设置窗口默认关闭方式
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	}
}
