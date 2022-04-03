package secao21.jdbc1.application;

import java.sql.Connection;

import secao21.jdbc1.db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = DB.getConnection(); 	// Realizando o inicio da conexao com o Banco de Dados
		
		DB.closeConnection();					// Realizando o fechamento da conexão com o Banco de Dados
	}
}
