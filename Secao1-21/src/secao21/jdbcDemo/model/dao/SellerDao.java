package secao21.jdbcDemo.model.dao;

import java.util.List;

import secao21.jdbcDemo.model.entities.Department;
import secao21.jdbcDemo.model.entities.Seller;

//Interface DAO para definição das operações de manipulação de dados no DB
public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
}
