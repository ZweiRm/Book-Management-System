package com.dataAccessObject;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Vector;

import com.bean.User;
import com.bean.ValueObject;
import com.common.DataUtil;
import com.dataBaseOperation.JDBCExcutor;

public class CommonDao {
	public JDBCExcutor getJDBCExcutor() {
		return JDBCExcutor.getJDBCExcutor();
	}

	// 根据参数的SQL语句，获取并存放结果
	public Collection getDatas(String sql, Collection<ValueObject> result, Class clazz) {
		ResultSet rs = getJDBCExcutor().excuteQuery(sql);
		return DataUtil.getDatas(result, rs, clazz);
	}
	
	// 测试函数
	public static void main(String[] args) {
		String sql = "SELECT * FROM T_USER";
		CommonDao cd = new CommonDao();
		Collection<User> users = cd.getDatas(sql, new Vector<>(), User.class);
		for (User u : users) {
			System.out.println("ID\t" + "Account\t" + "Password\t");
			System.out.print(u.getID() + "\t");
			System.out.print(u.getUSER_NAME() + "\t");
			System.out.println(u.getUSER_PASSWORD() + "\t");
		}
	}
}
