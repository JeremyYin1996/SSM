package com.phone.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * �߼�jdbc��װ
 * @author Administrator
 *
 */
public class BaseDao {
	static String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/phone";
	String user="root";
	String password="yhn1996";
	static {
		try {
			//�������ݿ�����
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//���õ���ɾ�ķ���
	public int executeUpdate(String sql,Object...objects) throws SQLException {
		//��������
		Connection conn = DriverManager.getConnection(url, user, password);
		//����prepareStatement���󲢶�sql����Ԥ����
		PreparedStatement ps = conn.prepareStatement(sql);
		//setParams��������������prepareStatement���󴫵ݲ���Ϊsql�е�ռλ����ֵ
		setParams(ps,objects);
		int nums = ps.executeUpdate();
		this.close(conn, ps, null);
		return nums;
	}
	//���õĲ�ѯ����
	public List executequery(String sql,ResultsetToObject rto,Object...objects) throws SQLException {
		List list = new ArrayList();
		//��������
		Connection conn = DriverManager.getConnection(url, user, password);
		//����prepareStatement���󲢶�sql����Ԥ����
		PreparedStatement ps = conn.prepareStatement(sql);
		setParams(ps,objects);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			Object obj = rto.resultsetToObject(rs);
			list.add(obj);
		}
		this.close(conn, ps, rs);
		return list;
	}

	private void setParams(PreparedStatement ps, Object...objects) throws SQLException {
		if(objects !=null) {
			for(int i=0;i<objects.length;i++) {
				ps.setObject(i+1, objects[i]);
			}
		}else {
			return;
		}
	}
	
	//�ͷ���Դ���ر�����
	public void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(conn !=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps !=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs !=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}	
