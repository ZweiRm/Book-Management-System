package com.service;

import java.util.Collection;

import com.bean.Type;
import com.dataAccessObject.TypeDao;

public class TypeService {

	// 定义私有数据访问对象
	private TypeDao typeDao;

	// 构造方法
	public TypeService(TypeDao dao) {
		this.typeDao = dao;
	}

	// 查找所有的Type
	public Collection<Type> findAll() {
		return typeDao.findAll();
	}

	// 通过NAME查找
	public Collection<Type> findByName(String name) {
		return typeDao.findByName(name);
	}

	// 通过ID查找
	public Type findByID(String id) {
		return typeDao.findByID(id);
	}

	// 添加功能
	public Type add(Type ty) {
		String id = String.valueOf(typeDao.add(ty));
		return findByID(id);
	}
	
	// 修改功能
	public Type update(Type ty) {
		String id = String.valueOf(typeDao.update(ty));
		return findByID(id);
	}
	
	// 测试函数
	public static void main(String[] args) {
		TypeService ts = new TypeService(new TypeDao());
		Type ty = new Type();
		for(int i = 1; i < 30; i++) {
			ty.setID(i + "");
			ty.setTYPE_NAME("***" + i + "111");
			ty.setTYPE_INTRO("xxx" + i + "222");
			ts.add(ty);
		}
		
		System.out.println("Name\t" + "Introduce\t");
		Collection<Type> types = ts.findAll();
		for(Type t1 : types) {  
			System.out.print(t1.getTYPE_NAME() + "\t");
			System.out.println(t1.getTYPE_INTRO() + "\t");
		}
	}
}
