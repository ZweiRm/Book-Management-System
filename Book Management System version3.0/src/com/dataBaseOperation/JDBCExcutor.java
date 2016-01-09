package com.dataBaseOperation;

import java.sql.*;

public class JDBCExcutor {

	// 驱动包名+类名 或者 驱动路径
	private static String DRIVER = "com.mysql.jdbc.Driver";

	// 数据库URL
	private static String URL = "jdbc:mysql://localhost:3306/book_system?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";

	// 数据库用户名，密码
	private static String USER = "root";
	private static String PASSWORD = "5094022aA";

	// 定义对象，保存连接
	private Connection con;

	// 定义对象，保存状态
	private Statement sta;

	// 定义私有静态类型对象
	private static JDBCExcutor jDBCExtutor;

	// 私有构造函数
	private JDBCExcutor() {
		try {
			// 找驱动
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			// 创建状态
			sta = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 定义静态方法，返回该单例
	public static JDBCExcutor getJDBCExcutor() {
		if (jDBCExtutor == null) {
			jDBCExtutor = new JDBCExcutor();
		}
		return jDBCExtutor;
	}

	// 数据库查询
	public ResultSet excuteQuery(String sql){
		ResultSet result;
		try {
			result = sta.executeQuery(sql);
			return result;
		} catch (Exception e) {
			throw new QueryException("Query Error");
		}
	}

//数据库更新（增加、删除、修改）- 测试
//	public int excuteUpdate(String sql){
//		int result;
//		try {
//			result = sta.executeUpdate(sql);
//			return result;
//		} catch (SQLException e) {
//			throw new UpdateException("Update Error");
//		}
//	}
	// 数据库更新
	public int excuteUpdate(String sql) {
		int result = -1;
		try {
			// 进行更新操作
			sta.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			// 获取更新结果
			ResultSet rs = sta.getGeneratedKeys();
			
			// 对更新结果遍历，取到最后一个更新结果
			while (rs.next()) {
				result = rs.getInt(1);
			}
			return result;
		} catch (Exception e) {
			throw new UpdateException("Update Error");
		}
	}

	// 测试函数
	public static void main(String[] args) throws SQLException {
/**
 * 传统方式查询
 */
		JDBCExcutor ex = JDBCExcutor.getJDBCExcutor();
		String sql = "SELECT * FROM t_USER";
		ResultSet rs = ex.excuteQuery(sql);
		while (rs.next()) {
			String id = rs.getString("ID");
			String user_name = rs.getString("USER_NAME");
			String user_password = rs.getString("USER_PASSWORD");
			System.out.println("ID\t" + "NAME\t" + "PASS\t");
			System.out.println(id + "\t" + user_name + "\t" + user_password + "\t");
		}
	}
}
