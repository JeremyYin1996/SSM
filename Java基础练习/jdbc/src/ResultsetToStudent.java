import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 下午3:43:39
 */

public class ResultsetToStudent implements ResultsetToObject {

	@Override
	public Object resultsetToObject(ResultSet rs) {
		Student student = new Student();
		try {
			//从结果集的某一行取值
			int stuNo = rs.getInt("stuNo");
			String phoneNumber = rs.getString("phoneNumber");
			String stuName = rs.getString("stuName");
			double score = rs.getDouble("score");
			
			//赋值给一个对象
			student.setStuNo(stuNo);
			student.setPhoneNumber(phoneNumber);
			student.setStuName(stuName);
			student.setScore(score);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

}

