package com.dataAccessObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.bean.Type;

public class TypeDao extends CommonDao {

	// 查询得到的所有种类
	public Collection<Type> findAll() {
		String sql = "SELECT * FROM T_TYPE";
		return getDatas(sql, new Vector<>(), Type.class);
	}

	// 按照名称进行模糊查询
	public Collection<Type> findByName(String name) {
		String sql = "SELECT * FROM T_TYPE WHERE TYPE_NAME LIKE '% + " + name + "%'";
		return getDatas(sql, new Vector<>(), Type.class);
	}

	// 通过主键ID进行查询
	public Type findByID(String id) {
		String sql = "SELECT * FROM T_TYPE WHERE ID = '" + id + "'";
		List<Type> datas = (List<Type>) getDatas(sql, new ArrayList<>(), Type.class);
		return datas.get(0);
	}

	// 添加类型信息功能
	public int add(Type t) {
		String sql = "INSERT INTO T_TYPE VALUES (ID, '" + t.getTYPE_NAME() + "', '" + t.getTYPE_INTRO() + "')";
		return getJDBCExcutor().excuteUpdate(sql);
	}
	
	// 修改类型信息功能
	public String update(Type t) {
		String sql = "UPDATE T_TYPE SET TYPE_NAME = '" + t.getTYPE_NAME() + "', TYPE_INTRO = '" + t.getTYPE_INTRO() +  "' WHERE ID = '" + t.getID() + "'";
		getJDBCExcutor().excuteUpdate(sql);
		return t.getID();
	}

	// 测试函数
	public static void main(String[] args) {
		TypeDao td = new TypeDao();
		Type t = new Type("1", "Computer", "SXAU PRESS");
		td.add(t);
		System.out.println("Operation Success.");
	}
}
