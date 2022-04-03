package secao21.jdbcDemo.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import secao21.jdbcDemo.db.DB;
import secao21.jdbcDemo.db.DbException;
import secao21.jdbcDemo.model.dao.SellerDao;
import secao21.jdbcDemo.model.entities.Department;
import secao21.jdbcDemo.model.entities.Seller;


// Classe para implementação dos metodos que a INTERFACE SELLERDAO obriga
public class SellerDaoJDBC implements SellerDao {

	// Atributos da classe
	private Connection conn;	// Criado para ter acesso em todos metodos da classe e nao especifico por metodo
	
	
	// Construtor da classe
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	// Demais metodos
	@Override
	public void insert(Seller obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement( "INSERT INTO seller "
									  + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
									  + "VALUES "
									  + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			// Repassando os dados do Obj Seller que veio por parametro para suas respectivas interrogações na query de insert
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);	// Como o obj Seller que esta vindo, ainda nao tem o ID indicando, apos a gravação no banco eu pego o ID especificado e populo no campo ID do obj Seller 
				}

				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	
	@Override
	public void update(Seller obj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement( "UPDATE seller "
									  + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
									  + "WHERE Id = ?");
			
			// Repassando para a query nas substituições os valores vindos por parametro no obj Seller
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			st.setInt(6, obj.getId());
			
			st.executeUpdate();	// Executando a atualização dos registros
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	
	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
			
			st.setInt(1, id);	// Substituindo na query a interrogação pelo valor vindo por parametro
			
			st.executeUpdate();	// Executando a query. 	// Caso necessidade, fazer condicional para tratar deleção de registro nao existente e propagar exceção do tipo para informar registro nao deletado por nao existir
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());	// Lançando exceção personalizada
		}
		finally {
			DB.closeStatement(st);
		}
	}

	
	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement(	"SELECT seller.*"
										   + ", department.Name as DepName"
									   + " FROM seller"
									  + " INNER JOIN department "
										 + " ON seller.DepartmentId = department.Id "
									  + " WHERE seller.Id = ?");
			
			st.setInt(1, id);	// especificando o valor do where

			rs = st.executeQuery();	// Executando a query
			if (rs.next()) {
				// independente do retorno do banco vir em formato de tabela, para POO o ideal é manipular esses registros em forma de objetos
				// Desse modo podemos criar as funções auxiliaires abaixo recebendo o RS/DEP e retornando o OBJ para otimizar o codigo desse metodo 
				Department dep = instantiateDepartment(rs);
				Seller seller = instantiateSeller(rs, dep);

				return seller;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));

		return dep;
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setDepartment(dep);

		return seller;
	}

	
	@Override
	public List<Seller> findAll() {
		// Esta função tem o mesmo comportamento da findByDepartment porem sem restrição de registros
		// Cada Seller instanciado não deve esta associado a um novo department instanciado. Como o department é um obj generalizador de sellers (1 Dep -> N Seller ou vice-versa)
		// podemos reaproveitar os deps armazenados em um obj auxiliar MAP para evitar tanta instanciação desnecessaria. 

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement( "SELECT seller.*,department.Name as DepName "
									  + "FROM seller INNER JOIN department "
									  + "ON seller.DepartmentId = department.Id "
									  + "ORDER BY Name");
			
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller obj = instantiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement( "SELECT seller.*,department.Name as DepName "
									  + "FROM seller "
									  + "INNER JOIN department "
									  + "ON seller.DepartmentId = department.Id "
									  + "WHERE DepartmentId = ? "
									  + "ORDER BY Name");
			
			st.setInt(1, department.getId());	// Passando para a substituição da query o id que veio do objeto department por paramentro do metodo
			
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();	// O controle da da nao repetição do departamento será usando o MAP, integer pq é o id do departamento e o segundo parametro é o do proprio tipo Department
			
			while (rs.next()) {
				
				// Caso ja tenha criado um obj dep com o departamento 1 por exemplo, não tem logica ficar recriando ele simplesmente para associar ao seller
				// Por isso criaremos um MAP para armazenar os departamentos listados 
				Department dep = map.get(rs.getInt("DepartmentId"));	// Testando se o registro do rs.getInt() ja existe dentro do map usando o metodo get
				
				// Com essa validação, instanciamos o objeto departamento somente se ele nao existir no MAP. Se existir, reaproveitamos o dep encontrado e pula direto para o retorno dos dados do Seller
				if (dep == null) {	// Se nao existe o departamento pesquisado no map.get()
					dep = instantiateDepartment(rs);			// instancio um novo obj de Department
					map.put(rs.getInt("DepartmentId"), dep);	// Armazeno no map esse novo departamento com seu id no MAP
				}
				
				Seller seller = instantiateSeller(rs, dep);
				list.add(seller);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
