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
 * �˵������޸����ݽ���
 * @author Administrator
 *
 */
public abstract class AccountModifyJfream extends JFrame{
	//�������
	protected JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	protected JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
	protected JComboBox jcb1,jcb2;
	protected String[] array = {"�Ѹ���","δ����"};
	protected String[] array2= {};
	protected JButton jb1,jb2;
			
	public  void AccountModifyJfream() {
		init();
		listener();
	}

	private void listener() {
		//�޸İ�ť�����¼�
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				accountModify();
			}
		});
		//ȡ����ť�����¼�
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
		
		
		//��ʼ�����
		jl1 = new JLabel("��Ʒ����");
		jl1.setBounds(30, 30, 90, 20);
		jl2 = new JLabel("��������");
		jl2.setBounds(30, 80, 90, 20);
		jl3 = new JLabel("���׽��");
		jl3.setBounds(30, 130, 90, 20);
		jl4 = new JLabel("�Ƿ񸶿�");
		jl4.setBounds(30, 180, 90, 20);
		jl5 = new JLabel("������Ӧ��");
		jl5.setBounds(30, 230, 90, 20);
		jl6 = new JLabel("��Ʒ����");
		jl6.setBounds(30, 280, 90, 20);
		jl7 = new JLabel("����ʱ��");
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
		jb1 = new JButton("�޸�");
		jb1.setBounds(60, 380, 70, 30);
		jb2 = new JButton("ȡ��");
		jb2.setBounds(205, 380, 70, 30);
		
		//������
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
		
		//���ò��ַ�ʽ
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//���ô���ı���ɫ
		this.getContentPane().setVisible(true);//true��ʾ��ɫ��false����ʾ
		//���ô����Ƿ�ɼ�
		this.setVisible(true);
		//���ô��ڱ���
		this.setTitle("�޸�");
		//���ô��ڴ�С
		this.setSize(310, 470);
		//���ô���λ��
//		this.setLocation(500, 20);
		//���ô������
		this.setLocationRelativeTo(null);
		//���ô���Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
	}
}
