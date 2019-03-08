/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ����10:34:21
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
			// �ӽ������ĳһ��ȡֵ
			int supplierId1=rs.getInt("supplierId");	
			
			// ��ֵ��һ������
			supplierId.setSupplierId(supplierId1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supplierId;
	}
}


