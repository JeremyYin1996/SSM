import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 上午10:56:49
 */

public class Demo2 {
	public Demo2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功");
			// 2.建立连接
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sqxy", "root", "yhn1996");
			System.out.println("创建连接成功");
			String sqlADD = " INSERT INTO student VALUES(0,'李三','2122')";
			// 3.创建 PreparedStatement对象
			PreparedStatement ps = conn.prepareStatement(sqlADD);
			// 调用执行增删改方法
			int number = ps.executeUpdate(sqlADD);
			if (number > 0) {
				System.out.println("插入数据成功");
			} else {
				System.out.println("插入数据失败");
			}
			
			String sql = "select * from student ";
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				double sno = rs.getDouble("sno");
				String sname = rs.getString("sname");
				boolean gPG = rs.getBoolean("gPG");
				System.out.println("姓名："+sname+" 学号："+sno+" 是否"+ gPG);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Demo2();
	}
}
