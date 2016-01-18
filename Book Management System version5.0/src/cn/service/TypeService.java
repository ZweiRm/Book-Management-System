package cn.service;

import java.util.Collection;

import cn.bean.Type;

import cn.dao.TypeDao;

public class TypeService {

	private TypeDao typeDao;

	public TypeService(TypeDao dao) {
		this.typeDao = dao;
	}

	public Collection<Type> findAll() {
		return typeDao.findAll();
	}

	public Collection<Type> findByName(String name) {
		return typeDao.findByName(name);
	}

	public Type findByID(String id) {
		return typeDao.findByID(id);
	}

	public Type add(Type t) {
		String id = String.valueOf(typeDao.add(t));
		return findByID(id);
	}

	public Type update(Type t) {
		String id = typeDao.update(t);
		return findByID(id);
	}
}
