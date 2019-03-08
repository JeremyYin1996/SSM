/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 下午7:17:04
 */

package com.phone.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.phone.domain.User;

public class ResultsetToUser implements ResultsetToObject {

	@Override
	public Object resultsetToObject(ResultSet rs) {
		User user = new User();
		try {
			// 从结果集的某一行取值
			int userId = rs.getInt("userId");
			String USER = rs.getString("USER");
			String PASSWORD = rs.getString("PASSWORD");
			String LEVEL = rs.getString("LEVEL");

			// 赋值给一个对象
			user.setUserId(userId);
			user.setUSER(USER);
			user.setPASSWORD(PASSWORD);
			user.setLEVEL(LEVEL);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
