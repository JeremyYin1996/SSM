/**
 * @author Jeremy
 * @date 2019-1-9
 * @time ����5:23:27
 */

package com.phone.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDao extends BaseDao {
	//��ѯ������Ӧ�̷�����ӽ���
	public List querySupplier() {
		List list = new ArrayList();
		String sql = "SELECT * FROM Supplier";
		try {
			list = this.executequery(sql, new ResultsetToSupplier(), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}


