import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time ����10:56:49
 */

public class Demo2 {
	public Demo2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ�");
			// 2.��������
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sqxy", "root", "yhn1996");
			System.out.println("�������ӳɹ�");
			String sqlADD = " INSERT INTO student VALUES(0,'����','2122')";
			// 3.���� PreparedStatement����
			PreparedStatement ps = conn.prepareStatement(sqlADD);
			// ����ִ����ɾ�ķ���
			int number = ps.executeUpdate(sqlADD);
			if (number > 0) {
				System.out.println("�������ݳɹ�");
			} else {
				System.out.println("��������ʧ��");
			}
			
			String sql = "select * from student ";
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				double sno = rs.getDouble("sno");
				String sname = rs.getString("sname");
				boolean gPG = rs.getBoolean("gPG");
				System.out.println("������"+sname+" ѧ�ţ�"+sno+" �Ƿ�"+ gPG);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Demo2();
	}
}
