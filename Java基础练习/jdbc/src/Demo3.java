import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 上午11:21:36
 */

public class Demo3 {
	final String driveName = "com.mysql.jdbc.Driver";
	final String url = "jdbc:mysql://localhost:3306/sqxy";
	final String user = "root";
	final String password = "yhn1996";
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public Demo3() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功");
			// 2.建立连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}

	// 通用的增删改的方法
	public int executeUpdate(String sql, Object... objects) {

		int number = 0;
		try {
			// 创建ps对象，用来执行sql语句
			ps = conn.prepareStatement(sql);
			setParams(ps, objects);
			number = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close(conn, ps, null);
		return number;

	}

	// 通用的给占位符赋值的方法
	private void setParams(PreparedStatement ps2, Object[] objects) {
		// 给占位符赋值
		for (int i = 0; i < objects.length; i++) {
			try {
				ps.setObject(i + 1, objects[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 通用的查询的方法
	public List executeQuery(String sql, ResultsetToObject rto,
			Object... objects) {
		// 定义一个list集合用来存放对象
		List list = new ArrayList();
		try {
			// 创建ps对象，用来执行sql语句
			PreparedStatement ps = conn.prepareStatement(sql);
			setParams(ps, objects);
			rs = ps.executeQuery();
			while (rs.next()) {
				Object object = rto.resultsetToObject(rs);
				// 向集合中添加对象，用add()方法
				list.add(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close(conn, ps, rs);
		return list;
	}

	// 通用的释放空间的方法
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		// 如果Connection对象不为空，需要释放资源
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 如果PreparedStatement对象不为空，需要释放资源
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 如果ResultSet对象不为空，需要释放资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
