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
 * @time ����11:21:36
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
			System.out.println("���������ɹ�");
			// 2.��������
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}

	// ͨ�õ���ɾ�ĵķ���
	public int executeUpdate(String sql, Object... objects) {

		int number = 0;
		try {
			// ����ps��������ִ��sql���
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

	// ͨ�õĸ�ռλ����ֵ�ķ���
	private void setParams(PreparedStatement ps2, Object[] objects) {
		// ��ռλ����ֵ
		for (int i = 0; i < objects.length; i++) {
			try {
				ps.setObject(i + 1, objects[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ͨ�õĲ�ѯ�ķ���
	public List executeQuery(String sql, ResultsetToObject rto,
			Object... objects) {
		// ����һ��list����������Ŷ���
		List list = new ArrayList();
		try {
			// ����ps��������ִ��sql���
			PreparedStatement ps = conn.prepareStatement(sql);
			setParams(ps, objects);
			rs = ps.executeQuery();
			while (rs.next()) {
				Object object = rto.resultsetToObject(rs);
				// �򼯺�����Ӷ�����add()����
				list.add(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close(conn, ps, rs);
		return list;
	}

	// ͨ�õ��ͷſռ�ķ���
	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		// ���Connection����Ϊ�գ���Ҫ�ͷ���Դ
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ���PreparedStatement����Ϊ�գ���Ҫ�ͷ���Դ
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ���ResultSet����Ϊ�գ���Ҫ�ͷ���Դ
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
