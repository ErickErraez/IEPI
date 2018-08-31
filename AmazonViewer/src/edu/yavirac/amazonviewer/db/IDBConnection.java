package edu.yavirac.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static edu.yavirac.amazonviewer.db.DataBase.*;

public interface IDBConnection {

	default Connection connetToDB() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL + DB, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Se establecio la coneccion :)");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			return connection;
		}

	}

}
