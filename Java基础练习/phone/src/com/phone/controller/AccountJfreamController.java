/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ����2:38:34
 */

package com.phone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.phone.Dao.AccountDao;
import com.phone.domain.AccountAndSupplier;
import com.phone.view.AccountJfream;

public class AccountJfreamController extends AccountJfream {

	public AccountJfreamController() {
		// �����˵����������Ҫ����񷵻�����
		List list = new ArrayList();
		AccountDao accountDao = new AccountDao();
		list = accountDao.queryALL();
		// �������ֻ���Դ�Ŷ�ά����
		// Object[][] object = new Object[����][����]
		Object[][] object = new Object[list.size()][colums.length];
		for (int i = 0; i < object.length; i++) {
			// ��list��ÿһ������ǿ��ת����һ��AccountAndSupplier����
			AccountAndSupplier aas = (AccountAndSupplier) list.get(i);
			object[i] = new Object[] { aas.getAccountId(),
					aas.getAccountName(), aas.getAccountNums(),
					aas.getAccountMoney(), aas.isIsPayed() ? "��" : "��",
					aas.getSupplierName(), aas.getInfo(), aas.getAccountDate() };
		}

		// ����ά�����ŵ������ȥ
		jt1.setModel(new DefaultTableModel(object, colums));
	}

	@Override
	//��ѯ
	public void query() {
			boolean ispayed=true;
			AccountDao accountDao=new AccountDao();
			String accountName=this.jtf.getText().trim();
			String ispay=jcb.getSelectedItem().toString().trim();
			if(ispay=="�Ѹ���"){
				ispayed=true;
			}else if(ispay=="δ����"){
				ispayed=false;
			}else{
				JOptionPane.showMessageDialog(this, "��ѡ���Ƿ񸶿�","������ʾ",JOptionPane.ERROR_MESSAGE);
				return;
			}
			List list2=new ArrayList();
			list2=accountDao.queryAccountAndSupplierByCondition("%"+accountName+"%",ispayed);
			Object[][] object=new Object[list2.size()][colums.length];
			for(int i=0;i<object.length;i++){
				//��list��ÿһ������ǿ��ת����AccountAndSupplier����
				AccountAndSupplier aas=(AccountAndSupplier) list2.get(i);
				//Ϊ��ά�����ÿһ�и�ֵ
				object[i]=new Object[]{
					aas.getAccountId(),
					aas.getAccountName(),
					aas.getAccountNums(),
					aas.getAccountMoney(),
					aas.isIsPayed()?"�Ѹ���":"δ����",
					aas.getSupplierName(),
					aas.getInfo(),
					aas.getAccountDate()
				};
			}
			//����ά�����ŵ������ȥ
			jt1.setModel(new DefaultTableModel(object,colums));


	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		// ��ת����ӽ���
		AccountAddJfreamController aac = new AccountAddJfreamController();
		aac.AccountAddJfream();
	}

	@Override
	public void modify() {
		int count = 0;
		//ѡ���˼���
		count = jt1.getSelectedColumnCount();
		//ѡ��Ҫ�޸ĵ���
		int row = jt1.getSelectedRow();//��һ�е��±�Ĭ���Ǵ�0��ʼ��
		System.out.println(row);
		if(count >1){
			JOptionPane.showMessageDialog(this, "ֻ��ͬʱ�޸�һ������", 
					"������ʾ", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(count == 0){
			JOptionPane.showMessageDialog(this, "��ѡ��һ������", 
					"������ʾ", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		
		//����һ��object������������Ŵӱ���л�ȡ������
		Object[]  objects = new Object[colums.length];
		for(int i =0;i<colums.length;i++){
			objects[i] = jt1.getValueAt(row, i);
		}
		//��ȡ����е�����
		new AccountModifyJfreamController(objects);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
		int rows =0; 
		int [] row= this.jt1.getSelectedRows();
		int [] id =new int[row.length];
		rows = this.jt1.getSelectedRowCount();
		if(rows==0) {
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ������!","������ʾ",JOptionPane.ERROR_MESSAGE);
		}else {
			//����������ȡ����Ӧ�е���Ʒ���
			for(int i=0;i<rows;i++) {
				id[i]=Integer.parseInt(this.jt1.getValueAt(row[i],0).toString().trim());
			}
			new AccountDeleteJfreamController(id);
			this.setVisible(false);
		}
		
		// ��ת��ɾ������
	}

	@Override
	public void curPageExit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void homePage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void prePage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void nextPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tailPage() {
		// TODO Auto-generated method stub

	}

}
