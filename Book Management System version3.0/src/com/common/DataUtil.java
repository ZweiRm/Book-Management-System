package com.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;

import com.bean.User;
import com.dataBaseOperation.JDBCExcutor;

/**
 * @introduce 将数据库查询结果集ResultSet转换成对象集合
 * @author huangduo
 *
 */
public class DataUtil {

	// 将ResultSet封装为对象集合

	public static Collection getDatas(Collection result, ResultSet rs, Class clazz) {
		try {
			while (rs.next()) {
				// 创建类的实例
				Object ob = clazz.newInstance();

				// 获取对象中包含的属性
				Field[] fields = clazz.getDeclaredFields();

				// 获取父类中包含的属性
				Field[] superFields = clazz.getSuperclass().getDeclaredFields();

				// 将子类和父类中的属性组合到一起
				List<Field> li = new ArrayList<Field>();
				for (Field f : fields) {
					li.add(f);
				}
				for (Field f : superFields) {
					li.add(f);
				}
				Field[] allFields = li.toArray(new Field[fields.length + superFields.length]);

				// 遍历所有属性，找到setter方法，调用其并进行赋值
				for (Field f : allFields) {
					String setterName = getSetterName(f.getName());

					// 调用Setter方法，给对象其赋值
					Method setterMethod = clazz.getMethod(setterName, f.getType());

					invokeMethod(rs, f, ob, setterMethod);
				}
				// 将对象添加到集合中
				result.add(ob);
			}
		} catch (Exception e) {
			throw new DataException(e.getMessage());
		}
		return result;
	}

	private static void invokeMethod(ResultSet rs, Field f, Object ob, Method setterMethod) {
		String value;
		try {
			value = rs.getString(f.getName());
			setterMethod.invoke(ob, value);
		} catch (Exception e) {
			throw new DataException(e.getMessage());
		}
	}

	// 创建 获取getter方法名称 方法
	private static String getSetterName(String name) {
		String begin = name.substring(0, 1).toUpperCase();
		String end = name.substring(1, name.length());
		return "set" + begin + end;
	}

	public static void main(String[] args) throws SQLException {
		JDBCExcutor ex = JDBCExcutor.getJDBCExcutor();
		String sql = "SELECT * FROM T_USER";
		ResultSet rs = ex.excuteQuery(sql);
		Collection<User> users = DataUtil.getDatas(new ArrayList<User>(), rs, User.class);
		for (User u : users) {
			System.out.println("ID\t" + "NAME\t" + "PASS\t");
			System.out.println(u.getID() + "\t" + u.getUSER_NAME() + "\t"  + u.getUSER_PASSWORD() + "\t");
		}
	}
}
