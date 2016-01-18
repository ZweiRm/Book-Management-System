package cn.dao;

import java.sql.ResultSet;
import java.util.Collection;

import cn.bean.ValueObject;
import cn.common.DataUtil;

import cn.dbop.JDBCExcutor;

public class CommonDao {

	public JDBCExcutor getJDBCExcutor() {
		return JDBCExcutor.getJDBCExcutor();
	}

	public Collection getDatas(String sql, Collection<ValueObject> result, Class clazz) {
		ResultSet rs = getJDBCExcutor().excuteQuery(sql);
		return DataUtil.getDatas(result, rs, clazz);
	}

}
