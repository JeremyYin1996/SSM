package com.phone.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * ������Ʒ���ɾ��account��������ȷ�Ͻ���
 * @author Administrator
 *
 */
public abstract class AccountDeleteJfream extends JFrame{
	//�������
	protected JButton jb1,jb2;
	public AccountDeleteJfream() {
		init();
		listener();
	}

	private void listener() {
		jb1.addActionListener(new ActionListener() {
			
			//ȷ��ɾ����ť�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				confirm();
			}
		});
		jb2.addActionListener(new ActionListener() {
			
			//ȡ����ť�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
	}
	public abstract void confirm();
	public abstract void cancel();

	private void init() {
		//��ʼ�����
		jb1 = new JButton("ȷ��ɾ��");
		jb1.setBounds(40, 60, 100, 30);
		jb2 = new JButton("ȡ  ��");
		jb2.setBounds(240, 60, 100, 30);
		
		//������
		this.add(jb1);
		this.add(jb2);
		//���ô��ڲ���
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//���ô���ı���ɫ
		this.getContentPane().setVisible(true);//true��ʾ��ɫ��false����ʾ
		//���ô��ڿɼ�
		this.setVisible(true);
		//���ô��ڴ�С
		this.setSize(390,150);
		//���ô���λ��
//		this.setLocation(496, 173);
		//���ô������
		this.setLocationRelativeTo(null);
		//����Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}


}
