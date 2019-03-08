/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ÏÂÎç2:40:36
 */

package com.phone.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends BaseDao {

	public List queryALL() {
		List list = new ArrayList();
		String sql = "SELECT accountId,accountName,accountNums,accountMoney,IsPayed,supplier.supplierName,info,accountDate "
				+ "FROM account JOIN supplier"
				+ " WHERE supplier.supplierId=account.supplierId";
		try {
			list = this.executequery(sql, new ResultsetToAccountAndSupplier(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int queryAdd(String accountName, int accountNums,
			double accountMoney, boolean isPayed2, int supplierId, String info,
			String date1) {
		int count=0;
		String sql = "INSERT INTO account(accountName,accountNums,accountMoney,IsPayed,supplierid,info,accountDate) VALUES (?,?,?,?,?,?,?)";
		try {
			count = this.executeUpdate(sql, accountName, accountNums,accountMoney, isPayed2,supplierId, info,date1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public List queryAccountAndSupplierByCondition(String accountName,
			boolean ispayed) {
		String sql="SELECT a.accountID,a.accountName,a.accountNums," +
				"a.accountMoney,a.IsPayed,b.supplierName,a.info," +
				"a.accountDate FROM account a,supplier b WHERE a.accountName LIKE ? " +
				"AND a.supplierId=b.supplierId AND a.IsPayed=? ";
		List list=null;
		try {
			list=this.executequery(sql,new ResultsetToAccountAndSupplier(),"%"+accountName+"%",ispayed);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int deleteAccount(int id) {
		int count=0;
		String sql = "DELETE FROM account WHERE accountId = ?";
		try {
			count = this.executeUpdate(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	
	
	
}
