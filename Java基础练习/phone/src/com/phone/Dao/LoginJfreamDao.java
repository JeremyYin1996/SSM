/**
 * @author Jeremy
 * @date 2019-1-9
 * @time обнГ12:05:18
 */

package com.phone.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginJfreamDao extends BaseDao{
	public List queryUserByconitions(Object...objects){
		List list=new ArrayList();
		String sql="SELECT * FROM user WHERE USER=? AND PASSWORD=?AND LEVEL=?";
		try {
			list=this.executequery(sql, new ResultsetToUser(), objects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
}

