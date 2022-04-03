package secao21.jdbc2.application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import secao21.jdbc2.db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DB.getConnection();		// Conectando no banco de dados
	
			st = conn.createStatement();	// instanciando o Statement com base na conexão realizada
			
			rs = st.executeQuery("select * from department");	// Executando a query no Statement e armazenando o resultado no RESULTSET
			
			while (rs.next()) {	// Percorrendo cada registro obtido da consulta
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));	// imprimindo em tela o ID e NAME retornado da consulta na tabela DEPARTMENT
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);	// Encerrando o ResultSet
			DB.closeStatement(st);	// Encerrando o Statement
			DB.closeConnection();	// Encerrando a conexão com o DB
		}
	}
}
