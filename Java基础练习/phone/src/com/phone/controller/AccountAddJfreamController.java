/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ����5:04:37
 */

package com.phone.controller;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.phone.Dao.AccountDao;
import com.phone.Dao.BaseDao;
import com.phone.Dao.ResultsetToSupplier;
import com.phone.Dao.ResultsetToSupplierId;
import com.phone.Dao.ResultsetToUser;
import com.phone.Dao.SupplierDao;
import com.phone.domain.Supplier;
import com.phone.domain.SupplierId;
import com.phone.view.AccountAddJfream;

public class AccountAddJfreamController extends AccountAddJfream {

	public AccountAddJfreamController() {
		// �����˵����������Ҫ����񷵻�����
		List list = new ArrayList();
		SupplierDao supplierDao = new SupplierDao();
		list = supplierDao.querySupplier();
		String[] supplierNames = new String[list.size()];
		for (int i = 0; i < supplierNames.length; i++) {
			// ��list��ÿһ������ǿ��ת����һ��AccountAndSupplier����
			Supplier aas = (Supplier) list.get(i);
			supplierNames[i] = aas.getSupplierName();
		}
		// �������ŵ�������Ӧ�̵�������
		array2 = supplierNames;
	
	}

	@Override
	public void accountAdd() {
		List list = new ArrayList();
		// TODO Auto-generated method stub
		// ��õ�ǰ��Ʒ����
		String accountName = this.jtf1.getText().trim();
		if (accountName == null || accountName.length() <= 0) {
			JOptionPane.showMessageDialog(this, "��Ʒ���Ʋ���Ϊ�գ�", "������ʾ",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// jtextfiled��ȡInteger���ͣ�Integer.parseInt(jtf2.getText())
		int accountNums = 0;
		try {
			accountNums = Integer.parseInt(this.jtf2.getText().trim());
			if (accountNums <= 0) {
				JOptionPane.showMessageDialog(this, "��Ʒ�����������Ϊ����0 ��������",
						"������ʾ", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "��Ʒ������ʽ����", "������ʾ",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		double accountMoney = 0.0;
		// jtextfiled��ȡdouble���ͣ�Double.parseDouble(jtf3.getText())
		try {
			accountMoney = Double.parseDouble(this.jtf3.getText());
			if (accountMoney <= 0) {
				JOptionPane.showMessageDialog(this, "���׽��������0 ", "������ʾ",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "���׽���ʽ����", "������ʾ",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// IsPayed1
		String IsPayed1 = this.jcb1.getSelectedItem().toString();
		// ת���ɲ���ֵ����Ϊ���ݿ����ǲ���ֵ����
		boolean IsPayed2;
		if ("�Ѹ���".equals(IsPayed1)) {
			IsPayed2 = true;
		} else {
			IsPayed2 = false;
		}
		// supplierName
		String supplierName = this.jcb2.getSelectedItem().toString();
		// info
		String info = this.jtf4.getText();
		// date
		String date1 = this.jtf5.getText();
		if (date1 == null || date1.length() <= 0) {
			JOptionPane.showMessageDialog(this, "�������ڲ���Ϊ��", "������ʾ",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// ��ʱ��ȡ����ʱ����string�ģ���ҪתΪdate���� simpleDateFormat
		// �ж��ָ�ʽ�� SimpleDateFormat aDate=new
		// SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
		// SimpleDateFormat bDate=new SimpleDateFormat("yyyy-mmmmmm-dddddd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date2 = simpleDateFormat.parse(date1);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "�������ڸ�ʽΪ��yyyy-mm-dd", "������ʾ",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
		// ͨ��supplierName��ѯ��supplierId
		String sql = "SELECT supplierId FROM supplier WHERE supplierName= ?";
		SupplierDao sid = new SupplierDao();
		try {
			list = sid.executequery(sql, new ResultsetToSupplierId(),
					supplierName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int[] supplierId = new int[list.size()];
		for (int i = 0; i < supplierId.length; i++) {
			SupplierId sid1 = (SupplierId) list.get(i);
			supplierId[i] = sid1.getSupplierId();
		}

		int record = 0;
		List list1 = new ArrayList();
		AccountDao accountDao = new AccountDao();
		record = accountDao.queryAdd(accountName, accountNums, accountMoney,
				IsPayed2, supplierId[0], info, date1);
		if (record > 0) {
			JOptionPane.showMessageDialog(this, "������ݳɹ�");
			this.setVisible(false);
			AccountJfreamController accountJfreamController = new AccountJfreamController();
		}
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		new AccountJfreamController();
	}

}
