package secao21.jdbc5.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import secao21.jdbc5.db.DB;
import secao21.jdbc5.db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
	
			st = conn.prepareStatement( "DELETE FROM department WHERE Id = ?" );

			st.setInt(1, 5);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());	// Exceção para tratamento de erro em caso de exclusão corrompendo integridade referencial dos dados no DB
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
