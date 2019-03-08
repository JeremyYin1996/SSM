import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 下午1:40:05
 */

public class Test extends Demo3 {
	public static void main(String[] args) {
		Test test = new Test();
		test.add();
		// test.delete();
		// test.query();
	}

	// 增加的方法
	public void add(Object... objects) {
		String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
		int number = this.executeUpdate(sql, objects);
		if (number > 0) {
			System.out.println("添加数据成功");
		} else {
			System.out.println("添加数据失败");
		}
	}

	public void delete(Object... objects) {
		String sql = "DELETE FROM student WHERE sname='四四';";
		int number = this.executeUpdate(sql, objects);
		if (number > 0) {
			System.out.println("数据删除成功！");
		} else {
			System.out.println("数据删除失败！");
		}
		this.close(conn, ps, null);
	}

	// 查询的方法
	public void query() {
		String sql = " SELECT * FROM student";
		List list = this.executeQuery(sql, new ResultsetToStudent());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
}
