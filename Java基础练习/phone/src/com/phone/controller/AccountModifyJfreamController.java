/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ����1:54:27
 */

package com.phone.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.phone.Dao.AccountDao;
import com.phone.Dao.ResultsetToSupplierId;
import com.phone.Dao.SupplierDao;
import com.phone.domain.Supplier;
import com.phone.domain.SupplierId;
import com.phone.view.AccountModifyJfream;

public class AccountModifyJfreamController extends AccountModifyJfream {

	int accountId=0;//�˵�ID
	
	public AccountModifyJfreamController(Object[] objects) {
		Supplier supplier = null;
				SupplierDao supplierDao = new SupplierDao();
				List list = supplierDao.querySupplier();
				String[] supplierNameArray=new String[list.size()];
				
				for(int i=0;i<list.size();i++) {
					supplier = (Supplier) list.get(i);
					supplierNameArray[i]=supplier.getSupplierName().trim();
				}
				this.array2=supplierNameArray;
				this.AccountModifyJfream();
				//��ȡ�����е����ݣ�Ȼ�����Ӧ�������ֵ
				accountId= Integer.parseInt(objects[0].toString().trim());
				String accountName = objects[1].toString().trim();
				String accountNums = objects[2].toString().trim();
				String accountMoney =objects[3].toString().trim();
				String ispay = objects[4].toString().trim();
				String supplierName = objects[5].toString().trim();
				String info = objects[6].toString().trim();
				String date = objects[7].toString().trim();
				
				this.jtf1.setText(accountName);
				this.jtf2.setText(accountNums);
				this.jtf3.setText(accountMoney);
				
				int index1=0;
				for(int i=0;i<this.array.length;i++) {
					if(ispay.equals("��")) {
						index1=1;
					}
				}
				
				int index2=0;
				for(int i=0;i<this.array2.length;i++) {
					if(supplierName.equals(array2[i])) {
						index2=i;
					}
				}
				this.jcb1.setSelectedIndex(index1);
				this.jcb2.setSelectedIndex(index2);
				this.jcb2.setSelectedItem(new String[] {supplierName});
				this.jtf4.setText(info);
				this.jtf5.setText(date);
		
	}


	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		AccountJfreamController accountJfreamController = new AccountJfreamController();
	}

	@Override
	public void accountModify() {
		// TODO Auto-generated method stub
		//�������
		String accountName = this.jtf1.getText().trim();//�����Ʒ����
				if(accountName==null||accountName.length()<=0) {
					JOptionPane.showMessageDialog(this, "��Ʒ���Ʋ���Ϊ�գ�","������ʾ",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int accountNums=0;
				try {
					accountNums = Integer.parseInt(this.jtf2.getText().trim());//�����Ʒ����
					if (accountNums <= 0) {
						JOptionPane.showMessageDialog(this, "��Ʒ�����������Ϊ����0 ��������", "������ʾ", JOptionPane.ERROR_MESSAGE);
						return;
					} 
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "��Ʒ������ʽ����", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				double accountMoney=0.0;
				try {
					accountMoney = Double.parseDouble(this.jtf3.getText().trim());//�����Ʒ���׽��
					if (accountMoney <= 0) {
						JOptionPane.showMessageDialog(this, "���׽��������0 ��", "������ʾ", JOptionPane.ERROR_MESSAGE);
						return;
					} 
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "���׽���ʽ����", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String IsPaye = this.jcb1.getSelectedItem().toString().trim();//����Ƿ񸶿������ֵ
				//���Ƿ񸶿���ַ���ת�ɲ�������
				boolean IsPayed;
				if("�Ѹ���".equals(IsPaye)) {
					IsPayed = true;
				}else {
					IsPayed = false;
				}
				String supplierName = this.jcb2.getSelectedItem().toString().trim();//���������Ӧ�̵�����ֵ
//				System.out.println(supplierName);
				String dateTempt = this.jtf5.getText().trim();
				if(dateTempt==null||dateTempt.length()<=0) {
					JOptionPane.showMessageDialog(this, "�������ڲ���Ϊ�գ�", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//�����Ʒ����
				String info = this.jtf4.getText().trim();
				//����õ��ַ���ת�ɹ淶��ʽ��date���͵�����
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date;
				try {
					date = simpleDateFormat.parse(dateTempt);
//					System.out.println(date);
				} catch (ParseException e) {
					JOptionPane.showMessageDialog(this, "�������ڸ�ʽΪ��yyyy-MM-dd", "������ʾ", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//ͨ��supplierName���ҵ�supplierId
				List list = new ArrayList();
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

				try {
					AccountDao accountDao=new AccountDao();
					String sql1 = "UPDATE  account SET accountName = ? ,accountNums = ?," +
							"accountMoney = ? ,IsPayed= ? ,supplierId= ?,info= ?,accountDate= ? " +
							"WHERE accountId=?";
					
					int nums = accountDao.executeUpdate(sql1, accountName,accountNums,accountMoney,
							IsPayed,supplierId[0],info,date,accountId);
					if(nums>0) {
						JOptionPane.showMessageDialog(this, "�޸����ݳɹ�");
						this.setVisible(false);
					
						AccountJfreamController accountJfreamController = new AccountJfreamController();
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(this, "�޸�����ʧ��","������ʾ",JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}  
	}       

}


