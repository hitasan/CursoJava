package secao21.jdbc4.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import secao21.jdbc4.db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();	// Iniciando conexão com o DB
	
			// Montando query para atualização dos registros
			st = conn.prepareStatement( "UPDATE seller "
										 + "SET BaseSalary = BaseSalary + ? "
									   + "WHERE (DepartmentId = ?)");

			st.setDouble(1, 200.0);	// Setando o valor para alteração pos montagem da query. Note que esta incrementando o BaseSalay
			st.setInt(2, 2);		// Setando o valor do DepartmentId do WHERE
			
			// Executando query e retornando quantidade de registros afetados
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
