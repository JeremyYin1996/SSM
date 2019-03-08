import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 上午9:20:26
 */

public class Demo1 {
	public Demo1() {
		try {
			// 1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功");
			// 2.建立连接
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sqxy", "root", "yhn1996");
			System.out.println("创建连接成功");
			// 3.创建Statement对象，用来执行SQL语句
			Statement sm = conn.createStatement();
			// 4.创建增删改的sql语句
			String sqlADD = " INSERT INTO student VALUES(0,'张三','232')";
			int number = sm.executeUpdate(sqlADD);
			if (number > 0) {
				System.out.println("插入数据成功");
			} else {
				System.out.println("插入数据失败");
			}
			// 删除
			String sqlDELETE = "DELETE FROM student WHERE sname='lisan'";
			int number1 = sm.executeUpdate(sqlDELETE);
			if (number1 > 0) {
				System.out.println("删除数据成功");
			} else {
				System.out.println("删除数据失败");
			}
			//查询并显示
			String sql = "select * from student ";
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()){
				double sno = rs.getDouble("sno");
				String sname = rs.getString("sname");
				boolean gPG = rs.getBoolean("gPG");
				System.out.println("姓名："+sname+" 学号："+sno+" 是否"+ gPG);
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("创建连接失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Demo1();
	}
}
