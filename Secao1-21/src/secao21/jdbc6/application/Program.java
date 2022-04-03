package secao21.jdbc6.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import secao21.jdbc6.db.DB;
import secao21.jdbc6.db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;

		try {
			conn = DB.getConnection();		// Conectando no DB
	
			conn.setAutoCommit(false);		// Com parametro FALSE, somos obrigados a confirmar a transa��o apos finaliza��o do processamento necessario

			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

			//int x = 1;
			//if (x < 2) {
			//	throw new SQLException("Fake error");
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit();	// Efetuando a confirma��o do commit encerrando a transa��o
			
			System.out.println("rows1 = " + rows1);
			System.out.println("rows2 = " + rows2);
		}
		catch (SQLException e) {
			try {
				conn.rollback();	// Retornando o status de processameno devido a erro e cancelado o commit da transa��o
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
