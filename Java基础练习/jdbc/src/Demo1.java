import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time ����9:20:26
 */

public class Demo1 {
	public Demo1() {
		try {
			// 1.��������
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���������ɹ�");
			// 2.��������
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sqxy", "root", "yhn1996");
			System.out.println("�������ӳɹ�");
			// 3.����Statement��������ִ��SQL���
			Statement sm = conn.createStatement();
			// 4.������ɾ�ĵ�sql���
			String sqlADD = " INSERT INTO student VALUES(0,'����','232')";
			int number = sm.executeUpdate(sqlADD);
			if (number > 0) {
				System.out.println("�������ݳɹ�");
			} else {
				System.out.println("��������ʧ��");
			}
			// ɾ��
			String sqlDELETE = "DELETE FROM student WHERE sname='lisan'";
			int number1 = sm.executeUpdate(sqlDELETE);
			if (number1 > 0) {
				System.out.println("ɾ�����ݳɹ�");
			} else {
				System.out.println("ɾ������ʧ��");
			}
			//��ѯ����ʾ
			String sql = "select * from student ";
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()){
				double sno = rs.getDouble("sno");
				String sname = rs.getString("sname");
				boolean gPG = rs.getBoolean("gPG");
				System.out.println("������"+sname+" ѧ�ţ�"+sno+" �Ƿ�"+ gPG);
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("��������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Demo1();
	}
}
