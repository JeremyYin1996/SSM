/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 下午7:00:01
 */

package com.phone.Dao;

import java.sql.ResultSet;

public interface ResultsetToObject {
	// 将结果集的某一行转化成对象
	public abstract Object resultsetToObject(ResultSet rs);
}
