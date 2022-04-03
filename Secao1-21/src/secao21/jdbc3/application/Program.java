package secao21.jdbc3.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import secao21.jdbc3.db.DB;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DB.getConnection();

			// EXAMPLE 1:
			st = conn.prepareStatement( "INSERT INTO seller "
										+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
										+ "VALUES "
										+ "(?, ?, ?, ?, ?)", 
										Statement.RETURN_GENERATED_KEYS );	// Somente a query como parametro é o contrutor principal da classe porem podemos usar a sobrecarga passando esse comando para nos retornar a chave do registro incluido

			// Atribuindo os valores em cada posição da query por substituição pos montagem da query
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));	// Quando se manipula datas par envio ao DB, usamos o JAVA.SQL.DATE e nao o java.util.date
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);

			// EXAMPLE 2:
			//st = conn.prepareStatement(
			//		"insert into department (Name) values ('D1'),('D2')", 
			//		Statement.RETURN_GENERATED_KEYS);

			int rowsAffected = st.executeUpdate();		// Executando o update e retornando em variavel a quantidade de linhas alteradas
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();	// Retorna no ResultSet quais as chaves que fora incluidas em cada registro de inclusão
				while (rs.next()) {
					int id = rs.getInt(1);				// Recuperando a chave do registro. O parametro 1 indica que é a coluna 1 retornado que é o campo ID (chave)
					System.out.println("Done! Id: " + id);
				}
			}
			else {
				System.out.println("No rows affected!");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
