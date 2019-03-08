/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ����1:36:26
 */

package com.phone.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.phone.Dao.BaseDao;
import com.phone.Dao.ResultsetToUser;
import com.phone.view.LoginJfream;

public class LoginJfreamController extends LoginJfream {
	
	@Override
	public void login() throws SQLException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		String USER1 = jtf.getText();
		String PASSWORD1 = new String(jpf.getPassword());
		String LEVEL1 = (String) jcb.getSelectedItem();

		String sql = "SELECT * FROM USER WHERE USER=? AND PASSWORD=? AND LEVEL= ?";
		// Jdbc jdbc = new Jdbc();
		BaseDao bd = new BaseDao();
		/*
		 * list = jdbc.executeQuery(sql, new ResultsetToPhone(), USER1,
		 * PASSWORD1, LEVEL1);
		 */
		try {
			list = bd.executequery(sql, new ResultsetToUser(), USER1,
					PASSWORD1, LEVEL1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (list.size() > 0) {
			System.out.println("�ɹ�");
			JOptionPane.showMessageDialog(null, "��½�ɹ�", "��ʾ",
					JOptionPane.INFORMATION_MESSAGE);
		new MainJfreamController();
		this.dispose();
		} else {
			System.out.println("ʧ��");
			JOptionPane.showMessageDialog(null, "�û����������Ȩ�޴���", "������ʾ",
					JOptionPane.ERROR_MESSAGE);

		}
	}
}


