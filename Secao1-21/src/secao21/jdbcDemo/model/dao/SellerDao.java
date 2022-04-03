package secao21.jdbcDemo.model.dao;

import java.util.List;

import secao21.jdbcDemo.model.entities.Department;
import secao21.jdbcDemo.model.entities.Seller;

//Interface DAO para defini��o das opera��es de manipula��o de dados no DB
public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}
