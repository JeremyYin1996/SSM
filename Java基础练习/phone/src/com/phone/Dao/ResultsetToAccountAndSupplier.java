/**
 * @author Jeremy
 * @date 2019-1-9
 * @time 下午2:23:47
 */

package com.phone.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.phone.domain.AccountAndSupplier;

public class ResultsetToAccountAndSupplier implements ResultsetToObject {

	@Override
	public Object resultsetToObject(ResultSet rs) {
		// TODO Auto-generated method stub
		AccountAndSupplier accountAndSupplier = new AccountAndSupplier();
		try {
			// 从结果集的某一行取值
			int accountId = rs.getInt("accountId");
			String accountName = rs.getString("accountName");
			int accountNums = rs.getInt("accountNums");
			double accountMoney = rs.getDouble("accountMoney");
			boolean IsPayed = rs.getBoolean("IsPayed");
			String supplierName = rs.getString("supplierName");
			String info = rs.getString("info");
			Date accountDate = rs.getDate("accountDate");

			// 赋值给一个对象
			accountAndSupplier.setAccountDate(accountDate);
			accountAndSupplier.setAccountId(accountId);
			accountAndSupplier.setAccountMoney(accountMoney);
			accountAndSupplier.setAccountName(accountName);
			accountAndSupplier.setAccountNums(accountNums);
			accountAndSupplier.setInfo(info);
			accountAndSupplier.setIsPayed(IsPayed);
			accountAndSupplier.setSupplierName(supplierName);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountAndSupplier;

	}

}
