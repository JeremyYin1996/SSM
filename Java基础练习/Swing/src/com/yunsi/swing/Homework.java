/**
 * @author Jeremy
 * @date 2019-1-4
 * @time 上午9:11:34
 */

package com.yunsi.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Homework extends JFrame implements MouseListener {

	int i = 0;
	String[] array = { "经理", "普通员工" };
	String[] username = new String[10];// 存放用户名的数组
	String[] password = new String[10];// 存放密码的数组
	// 判断数组中是否存在该值的标志
	int count = 0;

	JTextField jtf1;
	// 创建密码组件
	JPasswordField jpf1, jpf2;
	// 创建标签组件
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9;
	// 定义下拉框
	JComboBox jcb1;
	// 定义单选按钮
	JRadioButton jrb1, jrb2;
	JButton jb1, jb2;
	ButtonGroup bg;

	public Homework() {
		jl1 = new JLabel("用户名：");
		jl1.setBounds(93, 51, 62, 20);
		jl2 = new JLabel("密码：");
		jl2.setBounds(93, 97, 50, 20);
		jl3 = new JLabel("注册登录界面");
		jl3.setBounds(150, 10, 87, 20);
		jl4 = new JLabel("再次输入:");
		jl4.setBounds(93, 143, 62, 20);
		jl5 = new JLabel("权限：");
		jl5.setBounds(93, 188, 50, 20);
		jl6 = new JLabel("性别：");
		jl6.setBounds(93, 238, 50, 20);
		jl7 = new JLabel("");
		jl7.setBounds(266, 51, 100, 20);
		jl8 = new JLabel("");
		jl8.setBounds(266, 97, 100, 20);
		jl9 = new JLabel("");
		jl9.setBounds(266, 143, 100, 20);

		jtf1 = new JTextField(10);
		// 设置文本框背景色
		jtf1.setBounds(148, 51, 113, 21);
		jtf1.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				String username1 = jtf1.getText();
				if (!username1.equals("") && username1 != null) {
					jl7.setText("");
				} else {
					jl7.setText("用户名不能为空");
					jl7.setForeground(Color.RED);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		jpf1 = new JPasswordField(10);
		jpf1.setBounds(148, 97, 113, 21);
		jpf1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				String password1 = new String(jpf1.getPassword());
				if (!password1.equals("") && password1 != null) {
					jl8.setText("");
				} else {
					jl8.setText("密码不能为空");
					jl8.setForeground(Color.RED);
				}
			}
		});

		jpf2 = new JPasswordField(10);
		jpf2.setBounds(148, 144, 113, 21);
		jpf2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				String password1 = new String(jpf1.getPassword());
				String password2 = new String(jpf2.getPassword());
				if (!password2.equals("") && password2 != null) {
					jl9.setText("");
					for (int j = 0; j < password.length; j++) {
						if (!password1.equals(password2)) {
							jl9 = new JLabel("密码不一致");
							jl9.setForeground(Color.RED);
						}
					}
				} else {
					jl9.setText("密码不能为空");
					jl9.setForeground(Color.RED);
				}
			}
		});

		jcb1 = new JComboBox(array);
		jcb1.setBounds(148, 188, 113, 21);

		jrb1 = new JRadioButton("男", true);
		jrb1.setBounds(148, 240, 40, 20);

		jrb2 = new JRadioButton("女");
		jrb2.setBounds(211, 240, 40, 20);

		jb1 = new JButton("注册");
		jb1.setBounds(93, 288, 66, 30);
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username1 = jtf1.getText();
				for (int j = 0; j < username.length; j++) {
					if (username1.equals(username[j])) {
						jl7 = setText("该用户名已被注册！");
						jl7.setForeground(Color.RED);
					}
				}
				if (!username1.equals("") && username1 != null) {
					username[i] = jtf1.getText();
					password[i] = new String(jpf1.getPassword());
					JOptionPane.showMessageDialog(null, "注册成功", "提示",
							JOptionPane.INFORMATION_MESSAGE);
					jtf1.setText("");
					jpf1.setText("");
					jpf2.setText("");
					i++;
				}
			}

			private JLabel setText(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});

		jb2 = new JButton("登录");
		jb2.setBounds(200, 288, 66, 30);
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username1 = jtf1.getText();
				String password1 = new String(jpf1.getPassword());
				for (int j = 0; j < username.length; j++) {
					if (username[j] != null) {
						if (username1.equals(username[j])
								&& password1.equals(password[j])) {
							count++;
						}
					}
				}
				if (count > 0) {
					JOptionPane.showMessageDialog(null, "登陆成功", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "账号或密码错误", "提示",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		this.add(jl3);
		this.add(jl1);
		this.add(jtf1);
		this.add(jl2);
		this.add(jpf1);
		this.add(jl4);
		this.add(jpf2);
		this.add(jl5);
		this.add(jl6);
		this.add(jl7);
		this.add(jl8);
		this.add(jl9);
		this.add(jcb1);
		this.add(jrb1);
		this.add(jrb2);
		this.add(jb1);
		this.add(jb2);
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);

		// 设置窗口背景色
		this.getContentPane().setBackground(Color.white);
		// 设置窗口布局
		this.setLayout(null);
		// 设置窗口标题
		this.setTitle("注册登录界面");
		// 设置窗口大小
		this.setSize(380, 400);
		// 设置窗口位置
		// jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// 设置窗口是否可见
		this.setVisible(true);// true表示可见，false表示不可见
		// 设置窗口默认关闭方式
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jtf1.setBackground(Color.black);
	}

	public static void main(String[] args) {
		new Homework();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
