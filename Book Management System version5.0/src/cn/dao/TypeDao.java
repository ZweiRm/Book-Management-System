package cn.dao;

import java.util.Collection;
import java.util.Vector;

import cn.bean.Type;

public class TypeDao extends CommonDao {

	public Collection<Type> findAll() {
		String sql = "select * from t_type ";
		return getDatas(sql, new Vector(), Type.class);
	}

	public Collection<Type> findByName(String name) {
		String sql = "select * from t_type where type_name" + " like '%" + name + "%'";
		return getDatas(sql, new Vector(), Type.class);
	}

	public Type findByID(String id) {
		String sql = "select * from t_type where ID='" + id + "'";
		Vector<Type> datas = (Vector<Type>) getDatas(sql, new Vector(), Type.class);
		return datas.get(0);
	}

	public int add(Type t) {
		String sql = "insert into t_type(TYPE_NAME,TYPE_INTRO)" + " values('" + t.getTYPE_NAME() + "','"
				+ t.getTYPE_INTRO() + "')";
		System.out.println(sql);
		return getJDBCExcutor().excuteUpdate(sql);
	}

	public String update(Type t) {
		String sql = "update t_type set TYPE_NAME='" + t.getTYPE_NAME() + "',TYPE_INTRO='" + t.getTYPE_INTRO()
				+ "' where ID='" + t.getID() + "'";
		getJDBCExcutor().excuteUpdate(sql);
		return t.getID();
	}
	
}
