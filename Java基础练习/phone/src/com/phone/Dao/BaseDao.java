package com.phone.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 高级jdbc封装
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
			//加载数据库驱动
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//公用的增删改方法
	public int executeUpdate(String sql,Object...objects) throws SQLException {
		//创建连接
		Connection conn = DriverManager.getConnection(url, user, password);
		//创建prepareStatement对象并对sql进行预编译
		PreparedStatement ps = conn.prepareStatement(sql);
		//setParams（）方法用来给prepareStatement对象传递参数为sql中的占位符赋值
		setParams(ps,objects);
		int nums = ps.executeUpdate();
		this.close(conn, ps, null);
		return nums;
	}
	//公用的查询方法
	public List executequery(String sql,ResultsetToObject rto,Object...objects) throws SQLException {
		List list = new ArrayList();
		//创建连接
		Connection conn = DriverManager.getConnection(url, user, password);
		//创建prepareStatement对象并对sql进行预编译
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
	
	//释放资源，关闭连接
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
