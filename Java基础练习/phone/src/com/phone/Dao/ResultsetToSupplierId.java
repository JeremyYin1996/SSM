/**
 * @author Jeremy
 * @date 2019-1-9
 * @time 下午10:34:21
 */

package com.phone.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.phone.domain.SupplierId;

public class ResultsetToSupplierId implements ResultsetToObject {

	@Override
	public Object resultsetToObject(ResultSet rs) {
		SupplierId supplierId = new SupplierId();
		try {
			// 从结果集的某一行取值
			int supplierId1=rs.getInt("supplierId");	
			
			// 赋值给一个对象
			supplierId.setSupplierId(supplierId1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplierId;
	}
}


