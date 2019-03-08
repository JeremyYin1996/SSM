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
 * ��½����
 * @author Administrator
 *
 */
public abstract class LoginJfream extends JFrame{
	//�������
	JLabel jl1,jl2,jl3,jl4,jl22,jl33;
	protected JTextField jtf;
	protected JPasswordField jpf;
	protected JComboBox jcb;
	protected String [] array = {"����","��ͨԱ��"};
	protected JButton jb1;
	
	public LoginJfream() {
		innit();
		listener();
	}

	private void listener() {
		//�û�������Ϊ�յ�У��
		jtf.addFocusListener(new FocusListener() {
			
			//��궪ʧ�¼�
			@Override
			public void focusLost(FocusEvent e) {
				String user = jtf.getText().trim();
				if(user==null||user.length()<=0) {
					jl22.setText("�û�������Ϊ�գ�");
					jl22.setForeground(Color.red);
				}
			}
			//������¼�
			@Override
			public void focusGained(FocusEvent e) {
				jl22.setText("");
			}
		});
		//���벻��Ϊ��У��
		jpf.addFocusListener(new FocusListener() {
			//��궪ʧ�¼�
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(jpf.getPassword()).trim();
				if(password==null||password.length()<=0) {
					jl33.setText("���벻��Ϊ�գ�");
					jl33.setForeground(Color.red);
				}
			}
			//������¼�
			@Override
			public void focusGained(FocusEvent e) {
				jl33.setText("");
			}
		});
		
		//��½��ť�¼�
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
		//��ʼ�����
		jl1 = new JLabel("�ֻ������˵�����ϵͳ��½");
		jl1.setFont(new Font("dialog", 1,18));//���������ֺš��Ӵ֡���С
//		jl1.setForeground(Color.green);//����������ɫ
		jl1.setBounds(240, 30, 240, 40);
		jl2 = new JLabel("�û���");
		jl2.setBounds(155, 100, 70, 20);
		jl3 = new JLabel("��  ��");
		jl3.setBounds(155, 150, 70, 20);
		jl4 = new JLabel("Ȩ  ��");
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
		
		jb1 = new JButton("��  ½");
		jb1.setBounds(230, 270, 135, 40);
		
		//������
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
		
		//���ô��ڲ���
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//���ô���ı���ɫ
		this.getContentPane().setVisible(true);//true��ʾ��ɫ��false����ʾ
		//���ô����Ƿ�ɼ�
		this.setVisible(true);
		//���ô��ڴ�С
		this.setSize(600, 380);
		//���ô���λ��
//		this.setLocation(500, 20);
		//���ô������
		this.setLocationRelativeTo(null);
		//���ô��ڱ���
		this.setTitle("�ֻ������˵�����ϵͳ��½");
		//���ô���Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
