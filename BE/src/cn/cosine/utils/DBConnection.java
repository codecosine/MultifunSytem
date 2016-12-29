package cn.cosine.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	// 考虑封装 数据库连接池代理
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/cosine";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "cosine";
	private Connection conn = null;
	public DBConnection() throws Exception {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {
		return this.conn;
	}
	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
