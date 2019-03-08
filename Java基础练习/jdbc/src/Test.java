import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time ����1:40:05
 */

public class Test extends Demo3 {
	public static void main(String[] args) {
		Test test = new Test();
		test.add();
		// test.delete();
		// test.query();
	}

	// ���ӵķ���
	public void add(Object... objects) {
		String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
		int number = this.executeUpdate(sql, objects);
		if (number > 0) {
			System.out.println("������ݳɹ�");
		} else {
			System.out.println("�������ʧ��");
		}
	}

	public void delete(Object... objects) {
		String sql = "DELETE FROM student WHERE sname='����';";
		int number = this.executeUpdate(sql, objects);
		if (number > 0) {
			System.out.println("����ɾ���ɹ���");
		} else {
			System.out.println("����ɾ��ʧ�ܣ�");
		}
		this.close(conn, ps, null);
	}

	// ��ѯ�ķ���
	public void query() {
		String sql = " SELECT * FROM student";
		List list = this.executeQuery(sql, new ResultsetToStudent());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
}
