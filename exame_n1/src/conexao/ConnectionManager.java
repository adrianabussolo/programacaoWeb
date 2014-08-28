package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author senai
 */
public class ConnectionManager {

	private static ConnectionManager cm = null;

	// Caminho para o driver
	private static final String PATH_DRIVER = "com.mysql.jdbc.Driver";
	// Usuario para o banco de dados
	private static final String USR_BANCO = "root";
	// Senha para o usuario do bando de dados
	private static final String PASS_BANCO = "";
	// Url de conexao para o banco de dados
	private static final String CONN = "jdbc:mysql://localhost:3306/examen1";

	public static ConnectionManager getInstance() {
		if (cm == null) {
			cm = new ConnectionManager();
		}
		return cm;
	}

	ConnectionManager() {
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(PATH_DRIVER);
			connection = DriverManager.getConnection(CONN, USR_BANCO,
					PASS_BANCO);
			System.out.println("conctado a base");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionManager.class.getName()).log(
					Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionManager.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		return connection;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionManager.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}
}
