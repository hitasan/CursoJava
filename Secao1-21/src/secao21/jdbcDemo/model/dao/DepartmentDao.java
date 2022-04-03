package secao21.jdbcDemo.model.dao;

import java.util.List;

import secao21.jdbcDemo.model.entities.Department;

// Interface DAO para defini��o das opera��es de manipula��o de dados no DB
public interface DepartmentDao {

	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}
