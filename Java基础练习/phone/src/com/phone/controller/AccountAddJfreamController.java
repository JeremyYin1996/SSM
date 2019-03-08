/**
 * @author Jeremy
 * @date 2019-1-9
 * @time 下午5:04:37
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
		// 进入账单管理界面需要给表格返回数据
		List list = new ArrayList();
		SupplierDao supplierDao = new SupplierDao();
		list = supplierDao.querySupplier();
		String[] supplierNames = new String[list.size()];
		for (int i = 0; i < supplierNames.length; i++) {
			// 将list的每一行数据强制转化成一个AccountAndSupplier对象
			Supplier aas = (Supplier) list.get(i);
			supplierNames[i] = aas.getSupplierName();
		}
		// 将数组存放到所属供应商的下拉框
		array2 = supplierNames;
	
	}

	@Override
	public void accountAdd() {
		List list = new ArrayList();
		// TODO Auto-generated method stub
		// 获得当前商品名称
		String accountName = this.jtf1.getText().trim();
		if (accountName == null || accountName.length() <= 0) {
			JOptionPane.showMessageDialog(this, "商品名称不能为空！", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// jtextfiled获取Integer类型：Integer.parseInt(jtf2.getText())
		int accountNums = 0;
		try {
			accountNums = Integer.parseInt(this.jtf2.getText().trim());
			if (accountNums <= 0) {
				JOptionPane.showMessageDialog(this, "商品数量必须大于为大于0 的整数！",
						"错误提示", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "商品数量格式错误", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		double accountMoney = 0.0;
		// jtextfiled获取double类型：Double.parseDouble(jtf3.getText())
		try {
			accountMoney = Double.parseDouble(this.jtf3.getText());
			if (accountMoney <= 0) {
				JOptionPane.showMessageDialog(this, "交易金额必须大于0 ", "错误提示",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "交易金额格式错误", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// IsPayed1
		String IsPayed1 = this.jcb1.getSelectedItem().toString();
		// 转换成布尔值，因为数据库里是布尔值类型
		boolean IsPayed2;
		if ("已付款".equals(IsPayed1)) {
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
			JOptionPane.showMessageDialog(this, "交易日期不能为空", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// 此时获取到的时间是string的，需要转为date，用 simpleDateFormat
		// 有多种格式： SimpleDateFormat aDate=new
		// SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
		// SimpleDateFormat bDate=new SimpleDateFormat("yyyy-mmmmmm-dddddd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date2 = simpleDateFormat.parse(date1);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "交易日期格式为：yyyy-mm-dd", "错误提示",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}
		// 通过supplierName查询到supplierId
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
			JOptionPane.showMessageDialog(this, "添加数据成功");
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
