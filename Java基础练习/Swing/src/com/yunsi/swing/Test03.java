/**
 * @author Jeremy
 * @date 2019-1-4
 * @time ����1:47:54
 */

package com.yunsi.swing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Test03 extends JFrame {
	JTextField jtf1;
	// �����������
	JPasswordField jpf1;
	// ������ǩ���
	JLabel jl1,jl2,jl3,jl4;
	// ����������
	//JComboBox jcb1;
	// ���嵥ѡ��ť
	JRadioButton jrb1, jrb2;
	// ���帴ѡ��
	JCheckBox jcb2, jcb3, jcb4;
	JButton jb1;

	public Test03() {
		jl1 = new JLabel(new ImageIcon("C:\\Users\\Jeremy\\Desktop\\11.png"));
		jl1.setBounds(0, 0, 427, 153);
		
		jl2 = new JLabel(new ImageIcon("C:\\Users\\Jeremy\\Desktop\\2.png"));
		jl2.setBounds(0,153,132,149);
		
		jtf1 = new JTextField(10);
		jtf1.setBounds(132, 160,173, 23);
		
		jpf1 = new JPasswordField(10);
		jpf1.setBounds(132,188,173, 23);
	
		jcb2 = new JCheckBox("��ס����");
		jcb2.setBounds(132, 225,100,23);
		
		jcb3 = new JCheckBox("�Զ���¼");
		jcb3.setBounds(262, 225,100,23);
		
		jb1 = new JButton("��¼");
		jb1.setBounds(132, 260,173, 23);
		
		jl3 = new JLabel("ע���ʺ�");
		jl3.setBounds(315,160,100,23);
		
		jl4 = new JLabel("�һ�����");
		jl4.setBounds(315,188,100,23);
		
		this.add(jl1);
		this.add(jl2);
		this.add(jtf1);
		this.add(jpf1);


		this.add(jcb2);
		this.add(jcb3);
		this.add(jb1);
		this.add(jl3);
		this.add(jl4);
		// ���ô��ڲ���
		this.setLayout(null);
		// ���ô��ڴ�С
		this.setSize(430, 330);
		// ���ô���λ��
		// jFrame.setLocation(450,250);
		this.setLocationRelativeTo(null);
		// ���ô����Ƿ�ɼ�
		this.setVisible(true);// true��ʾ�ɼ���false��ʾ���ɼ�
		// ���ô���Ĭ�Ϲرշ�ʽ
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Test03();
	}
}

