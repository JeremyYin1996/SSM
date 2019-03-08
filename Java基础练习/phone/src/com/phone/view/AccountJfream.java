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
 * �˻�����������
 * @author Administrator
 *
 */
public abstract class AccountJfream extends JFrame {
	//�������
	protected JLabel jl1,jl2,jl3;
	protected JTextField jtf,jtf2,jtf3;
	protected JComboBox jcb;
	protected String[] array = {"δѡ��","�Ѹ���","δ����"};
	public JTable jt1;
	public String[] colums= {"���","��Ʒ����","��Ʒ����","���׽��","�Ƿ񸶿�","��Ӧ������","��Ʒ��Ϣ","�˵�ʱ��"};
	protected JScrollPane jsp;
	protected JButton jb1,jb2,jb3,jb4,jb11,jb22,jb33,jb44;
	
	public AccountJfream() {
		init();
		listener();
	}

	private void listener() {
		//��ѯ��ť�����¼�
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				query();
			}
		});
		//���Ӱ�ť�����¼�
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		//�޸İ�ť�����¼�
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				modify();
			}
		});
		//ɾ����ť�����¼�
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		

		//��ǰҳ�Ĺ���뿪�����¼�
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

		//��ҳ��ť���������¼�
			jb11.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					homePage();
				}
			});
		
		//��һҳ��ť���������¼�
			jb22.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					prePage();
				}
			});
		//��һҳ��ť���������¼�
			jb33.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					nextPage();
				}
			});
		//βҳ��ť���������¼�
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
		//��ʼ�����
		jl1 = new JLabel("��Ʒ����");
		jl1.setBounds(110, 30, 90, 20);
		jl2 = new JLabel("�Ƿ񸶿�");
		jl2.setBounds(380, 30, 90, 20);
		jtf = new JTextField();
		jtf.setBounds(200, 30, 160, 30);
		jcb = new JComboBox(array);
		jcb.setBounds(470, 30, 110, 30);
		jt1 = new JTable();
//		jt1.setBounds(20, 90, 800, 105);
		jsp = new JScrollPane(jt1);
		//���ô�ֱ���������ɼ�
//		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER );
		jsp.setBounds(20, 90, 800, 105);
		jb11 = new JButton("��ҳ");
		jb11.setBounds(125, 215, 110, 30);
		jb22 = new JButton("��һҳ");
		jb22.setBounds(245, 215, 110, 30);
		jtf2 = new JTextField();
		jtf2.setText("1");
		jtf2.setBounds(365, 215, 42, 30);
		jl3 = new JLabel("/");
		jl3.setBounds(408, 215, 5, 30);
		jtf3 = new JTextField();
		jtf3.setEditable(false);
		jtf3.setBounds(420, 215, 42, 30);
		jb33 = new JButton("��һҳ");
		jb33.setBounds(472, 215, 110, 30);
		jb44 = new JButton("βҳ");
		jb44.setBounds(592, 215, 110, 30);
		jb1 = new JButton("��ѯ");
		jb1.setBounds(660, 30, 110, 30);
		jb2 = new JButton("����");
		jb2.setBounds(190, 265, 110, 30);
		jb3 = new JButton("�޸�");
		jb3.setBounds(350, 265, 110, 30);
		jb4 = new JButton("ɾ��");
		jb4.setBounds(510, 265, 110, 30);
		
		//������
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
		
		//���ô��ڲ���
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);//���ô���ı���ɫ
		this.getContentPane().setVisible(true);//true��ʾ��ɫ��false����ʾ
		//���ô����Ƿ�ɼ�
		this.setVisible(true);
		//���ô��ڱ���
		this.setTitle("�˵�����");
		//���ô��ڴ�С
		this.setSize(850, 340);
		//���ô���λ��
//		this.setLocation(300,20);
		//���ô������
		this.setLocationRelativeTo(null);
		//���ô���Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	}
}
