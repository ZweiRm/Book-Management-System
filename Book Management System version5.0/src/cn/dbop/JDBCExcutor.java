package cn.dbop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.dbop.QueryException;

import cn.dbop.JDBCExcutor;

public class JDBCExcutor {

	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/book_system";
	private static String USER = "root";
	private static String PASS = "5094022aA";
	private Connection conn;
	private Statement stmt;
	private static JDBCExcutor jdbcExcutor;

	private JDBCExcutor() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static JDBCExcutor getJDBCExcutor() {
		if (jdbcExcutor == null) {
			jdbcExcutor = new JDBCExcutor();
		}
		return jdbcExcutor;
	}

	public ResultSet excuteQuery(String sql) {
		ResultSet result;
		try {
			result = stmt.executeQuery(sql);
			return result;
		} catch (Exception e) {
			throw new QueryException("Query Error");
		}
	}

	public int excuteUpdate(String sql) {
		int result = -1;
		try {
			stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet res = stmt.getGeneratedKeys();
			while (res.next())
				result = res.getInt(1);
			res.close();
			return result;
		} catch (Exception e) {
			throw new QueryException("Update Error");
		}
	}
}
