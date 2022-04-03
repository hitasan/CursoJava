package secao21.jdbc1.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static Connection conn = null;		// Criando um objeto de conexão JDBC com o banco de dados 
	
	// Metodo para conexão com o banco de dados
	public static Connection getConnection() {
		if (conn == null) {	// Se obj nulo, conecta no banco de dados
			try {
				Properties props = loadProperties();				// Pegando as propriedades do banco de dados
				String url = props.getProperty("dburl");			// Repassando URL do banco de dados para variavel
				conn = DriverManager.getConnection(url, props);		// Obtendo a conexão com o Banco de Dados
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	// Metodo para encerrar conexão com o banco de dados
	public static void closeConnection() {
		if (conn != null) {		// Se a conexão esta ativa, fecha conexão
			try {
				conn.close();	// Fechando conexão
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	// Metodo para carregamento dos dados do arquivo db.properties e armazenamento em objeto especifico
	private static Properties loadProperties() {

		// Realiza o carregamento e abertura do arquivo de propriedades
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();	// Instanciando objeto Properties para armazenamento de dados
			props.load(fs);		// Fazendo a leitura dos dados armazenados no arquivo de propriedade que foi carregado no FileInputStream fs e armazena na PROPERTIES props
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
