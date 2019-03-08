import java.sql.ResultSet;

/**
 * @author Jeremy
 * @date 2019-1-8
 * @time 下午3:14:58
 */

public interface ResultsetToObject {
	//将结果集的某一行转化成对象
	public abstract Object resultsetToObject(ResultSet rs);
	}


