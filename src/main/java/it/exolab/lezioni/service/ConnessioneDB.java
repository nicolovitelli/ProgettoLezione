package it.exolab.lezioni.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

	private Connection con;

	public Connection connect() throws SQLException, ClassNotFoundException {

		if (con != null)
			return con;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/exolab_db?serverTimezone=UTC&verifyServerCertificate=false&useSSL=false",
				"root", "vitelli01");

		return con;
	}

	public void close() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
