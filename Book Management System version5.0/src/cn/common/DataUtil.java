package cn.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.common.DataException;

import cn.bean.User;
import cn.dbop.*;

public class DataUtil {

	public static Collection getDatas(Collection result, ResultSet rs, Class clazz) {
		try {
			while (rs.next()) {
				Object vo = clazz.newInstance();
				Field[] fields = clazz.getDeclaredFields();
				Field[] superFields = clazz.getSuperclass().getDeclaredFields();
				List<Field> l = new ArrayList<Field>();
				for (Field f : fields) {
					l.add(f);
				}

				for (Field f : superFields) {
					l.add(f);
				}
				Field[] allFields = l.toArray(new Field[fields.length + superFields.length]);
				for (Field f : allFields) {
					String setterName = getSetterName(f.getName());
					Method setterMethod = clazz.getMethod(setterName, f.getType());
					invokeMethod(rs, f, vo, setterMethod);
				}
				result.add(vo);
			}
		} catch (Exception e) {
			throw new DataException(e.getMessage());
		}

		return result;
	}

	private static void invokeMethod(ResultSet rs, Field f, Object vo, Method setterMethod) {
		try {
			String value = rs.getString(f.getName());
			setterMethod.invoke(vo, value);
		} catch (Exception e) {
			throw new DataException(e.getMessage());
		}
	}

	private static String getSetterName(String name) {
		String begin = name.substring(0, 1).toUpperCase();
		String end = name.substring(1, name.length());
		return "set" + begin + end;
	}

}
