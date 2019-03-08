/**
 * @author Jeremy
 * @date 2019-1-9
 * @time 下午1:52:33
 */

package com.phone.controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.phone.Dao.AccountDao;
import com.phone.view.AccountDeleteJfream;

public class AccountDeleteJfreamController extends AccountDeleteJfream{
	int nums = 0;
	int[] accountId=null;
	public AccountDeleteJfreamController(int[] id) {
		// TODO Auto-generated constructor stub
		accountId = id;
	}

	@Override
	public void confirm() {
		AccountDao accountDao= new AccountDao();
		// TODO Auto-generated method stub
		for(int i=0;i<accountId.length;i++) {
			nums = accountDao.deleteAccount(accountId[i]);
		}
		if(nums>0) {
			JOptionPane.showMessageDialog(this, "删除数据成功");
			this.setVisible(false);
			new AccountJfreamController();
		}
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		new AccountJfreamController();
	}

}


