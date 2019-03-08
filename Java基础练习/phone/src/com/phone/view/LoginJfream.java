package com.phone.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 登陆界面
 * @author Administrator
 *
 */
public abstract class LoginJfream extends JFrame{
	//定义组件
	JLabel jl1,jl2,jl3,jl4,jl22,jl33;
	protected JTextField jtf;
	protected JPasswordField jpf;
	protected JComboBox jcb;
	protected String [] array = {"主管","普通员工"};
	protected JButton jb1;
	
	public LoginJfream() {
		innit();
		listener();
	}

	private void listener() {
		//用户名不能为空的校验
		jtf.addFocusListener(new FocusListener() {
			
			//光标丢失事件
			@Override
			public void focusLost(FocusEvent e) {
				String user = jtf.getText().trim();
				if(user==null||user.length()<=0) {
					jl22.setText("用户名不能为空！");
					jl22.setForeground(Color.red);
				}
			}
			//光标获得事件
			@Override
			public void focusGained(FocusEvent e) {
				jl22.setText("");
			}
		});
		//密码不能为空校验
		jpf.addFocusListener(new FocusListener() {
			//光标丢失事件
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(jpf.getPassword()).trim();
				if(password==null||password.length()<=0) {
					jl33.setText("密码不能为空！");
					jl33.setForeground(Color.red);
				}
			}
			//光标获得事件
			@Override
			public void focusGained(FocusEvent e) {
				jl33.setText("");
			}
		});
		
		//登陆按钮事件
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public  abstract void login() throws SQLException;
	
	private void innit() {
		//初始化组件
		jl1 = new JLabel("手机出售账单管理系统登陆");
		jl1.setFont(new Font("dialog", 1,18));//设置字体字号、加粗、大小
//		jl1.setForeground(Color.green);//设置字体颜色
		jl1.setBounds(240, 30, 240, 40);
		jl2 = new JLabel("用户名");
		jl2.setBounds(155, 100, 70, 20);
		jl3 = new JLabel("密  码");
		jl3.setBounds(155, 150, 70, 20);
		jl4 = new JLabel("权  限");
		jl4.setBounds(155, 200, 70, 20);
		
		jtf = new JTextField();
		jtf.setBounds(245, 100, 210, 30);
		jl22 = new JLabel("");
		jl22.setBounds(460, 100, 120, 30);
		
		jpf = new JPasswordField();
		jpf.setBounds(245, 150, 210, 30);
		jl33 = new JLabel("");
		jl33.setBounds(460, 150, 120, 30);
		
		jcb = new JComboBox(array);
		jcb.setBounds(245, 200, 210, 30);
		
		jb1 = new JButton("登  陆");
		jb1.setBounds(230, 270, 135, 40);
		
		//添加组件
		this.add(jl1);
		this.add(jl2);
		this.add(jl3);
		this.add(jl4);
		this.add(jl22);
		this.add(jl33);
		this.add(jtf);
		this.add(jpf);
		this.add(jcb);
		this.add(jb1);
		
		//设置窗口布局
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//设置窗体的背景色
		this.getContentPane().setVisible(true);//true显示红色，false则不显示
		//设置窗口是否可见
		this.setVisible(true);
		//设置窗口大小
		this.setSize(600, 380);
		//设置窗口位置
//		this.setLocation(500, 20);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		//设置窗口标题
		this.setTitle("手机出售账单管理系统登陆");
		//设置窗口默认关闭方式
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
