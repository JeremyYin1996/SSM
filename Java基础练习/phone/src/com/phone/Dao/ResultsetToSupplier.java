/**
 * @author Jeremy
 * @date 2019-1-9
 * @time 下午6:20:53
 */

package com.phone.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.phone.domain.AccountAndSupplier;
import com.phone.domain.Supplier;

public class ResultsetToSupplier implements ResultsetToObject {

	@Override
	public Object resultsetToObject(ResultSet rs) {
		Supplier supplier = new Supplier();
		try {
			// 从结果集的某一行取值
			int supplierId=rs.getInt("supplierId");
			String supplierName=rs.getString("supplierName");
			String linkMan=rs.getString("linkMan");
			String linkPhone=rs.getString("linkPhone");
			String linkAddress=rs.getString("linkAddress");
			
			
			// 赋值给一个对象
			supplier.setLinkAddress(linkAddress);
			supplier.setLinkMan(linkMan);
			supplier.setLinkPhone(linkPhone);
			supplier.setSupplierId(supplierId);
			supplier.setSupplierName(supplierName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplier;
	}

}


