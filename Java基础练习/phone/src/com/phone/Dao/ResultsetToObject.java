/**
 * @author Jeremy
 * @date 2019-1-8
 * @time ����7:00:01
 */

package com.phone.Dao;

import java.sql.ResultSet;

public interface ResultsetToObject {
	// ���������ĳһ��ת���ɶ���
	public abstract Object resultsetToObject(ResultSet rs);
}
