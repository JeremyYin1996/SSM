/**
 * @author Jeremy
 * @date 2019-1-9
 * @time 下午2:38:34
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
		// 进入账单管理界面需要给表格返回数据
		List list = new ArrayList();
		AccountDao accountDao = new AccountDao();
		list = accountDao.queryALL();
		// 表格里面只可以存放二维数组
		// Object[][] object = new Object[行数][列数]
		Object[][] object = new Object[list.size()][colums.length];
		for (int i = 0; i < object.length; i++) {
			// 将list的每一行数据强制转化成一个AccountAndSupplier对象
			AccountAndSupplier aas = (AccountAndSupplier) list.get(i);
			object[i] = new Object[] { aas.getAccountId(),
					aas.getAccountName(), aas.getAccountNums(),
					aas.getAccountMoney(), aas.isIsPayed() ? "是" : "否",
					aas.getSupplierName(), aas.getInfo(), aas.getAccountDate() };
		}

		// 将二维数组存放到表格中去
		jt1.setModel(new DefaultTableModel(object, colums));
	}

	@Override
	//查询
	public void query() {
			boolean ispayed=true;
			AccountDao accountDao=new AccountDao();
			String accountName=this.jtf.getText().trim();
			String ispay=jcb.getSelectedItem().toString().trim();
			if(ispay=="已付款"){
				ispayed=true;
			}else if(ispay=="未付款"){
				ispayed=false;
			}else{
				JOptionPane.showMessageDialog(this, "请选择是否付款","错误提示",JOptionPane.ERROR_MESSAGE);
				return;
			}
			List list2=new ArrayList();
			list2=accountDao.queryAccountAndSupplierByCondition("%"+accountName+"%",ispayed);
			Object[][] object=new Object[list2.size()][colums.length];
			for(int i=0;i<object.length;i++){
				//将list的每一行数据强制转换成AccountAndSupplier对象
				AccountAndSupplier aas=(AccountAndSupplier) list2.get(i);
				//为二维数组的每一行赋值
				object[i]=new Object[]{
					aas.getAccountId(),
					aas.getAccountName(),
					aas.getAccountNums(),
					aas.getAccountMoney(),
					aas.isIsPayed()?"已付款":"未付款",
					aas.getSupplierName(),
					aas.getInfo(),
					aas.getAccountDate()
				};
			}
			//将二维数组存放到表格中去
			jt1.setModel(new DefaultTableModel(object,colums));


	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		// 跳转到添加界面
		AccountAddJfreamController aac = new AccountAddJfreamController();
		aac.AccountAddJfream();
	}

	@Override
	public void modify() {
		int count = 0;
		//选择了几行
		count = jt1.getSelectedColumnCount();
		//选择要修改的行
		int row = jt1.getSelectedRow();//第一行的下标默认是从0开始的
		System.out.println(row);
		if(count >1){
			JOptionPane.showMessageDialog(this, "只能同时修改一行数据", 
					"错误提示", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(count == 0){
			JOptionPane.showMessageDialog(this, "请选择一行数据", 
					"错误提示", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		
		//定义一个object的数组用来存放从表格中获取的数据
		Object[]  objects = new Object[colums.length];
		for(int i =0;i<colums.length;i++){
			objects[i] = jt1.getValueAt(row, i);
		}
		//获取表格中的数据
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
			JOptionPane.showMessageDialog(this, "请选择要删除的行!","错误提示",JOptionPane.ERROR_MESSAGE);
		}else {
			//遍历索引，取出对应行的商品编号
			for(int i=0;i<rows;i++) {
				id[i]=Integer.parseInt(this.jt1.getValueAt(row[i],0).toString().trim());
			}
			new AccountDeleteJfreamController(id);
			this.setVisible(false);
		}
		
		// 跳转到删除界面
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
