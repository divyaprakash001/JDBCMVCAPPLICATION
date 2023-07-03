package com.divya.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private JdbcUtil() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {

		String dbLoc = "C:\\Users\\divya\\eclipse-workspace-servlet-jsp\\JDBCMVCAPPLICATION\\src\\main\\java\\com\\divya\\properties\\db.properties";
		FileInputStream fis = new FileInputStream(dbLoc);
		Properties p = new Properties();
		p.load(fis);

		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");

		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;
	}

}
