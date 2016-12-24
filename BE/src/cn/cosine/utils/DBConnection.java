package cn.cosine.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static final String DBDRIVER = "";
	private static final String DBURL = "";
	private static final String DBUSER = "";
	private static final String DBPASSWORD = "";
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
