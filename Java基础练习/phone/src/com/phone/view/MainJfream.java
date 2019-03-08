package com.phone.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * �ֻ������˵�����������
 * @author Administrator
 *
 */
public abstract class MainJfream extends JFrame {
	//�������
	protected JLabel jl1;
	protected JButton jb1,jb2,jb3,jb4;
	public MainJfream() {
		//��ʼ������ķ���
		init();
		//��ť�����¼�
		listener();
	}

	private void listener() {
		//�˻�����ť����
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				account();
			}
		});
		//��Ӧ�̹���ť����
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				supplier();
			}
		});
		//�û�����ť����
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userManager();
			}
		});
		//�˳���ť����
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}
	//�˻��������
	public abstract void account();
	//��Ӧ�̹������
	public abstract void supplier();
	//�û��������
	public abstract void userManager();
	//�˳�ϵͳ
	public abstract void exit();
	
	private void init() {
		//��ʼ�����
		jl1 = new JLabel("�ֻ������˵�����ϵͳ");
		jl1.setFont(new Font("dialog", 1,18));//���������ֺš��Ӵ֡���С
//		jl1.setForeground(Color.green);//����������ɫ
		jl1.setBounds(130, 20, 190, 40);
		jb1 = new JButton("�˵�����");
		jb1.setBounds(150, 80, 120, 40);
		jb2 = new JButton("��Ӧ�̹���");
		jb2.setBounds(150, 140, 120, 40);
		jb3 = new JButton("�û�����");
		jb3.setBounds(150, 200, 120, 40);
		jb4 = new JButton("�˳�");
		jb4.setBounds(150, 260, 120, 40);
		//������
		this.add(jl1);
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		this.add(jb4);
		
		//���ô��ڲ��ַ�ʽΪnull
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//���ô���ı���ɫ
		this.getContentPane().setVisible(true);//true��ʾ��ɫ��false����ʾ
		//���ô��ڴ�С
		this.setSize(410, 380);
		//���ô���λ��
//		this.setLocation(500, 20);
		//���ô������
		this.setLocationRelativeTo(null);
		//���ô��ڱ���
		this.setTitle("�ֻ������˵�����ϵͳ");
		//���ô����Ƿ�ɼ�
		this.setVisible(true);
		//���ô���Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
