package secao21.jdbcDemo.model.dao;

import java.util.List;

import secao21.jdbcDemo.model.entities.Department;

// Interface DAO para definição das operações de manipulação de dados no DB
public interface DepartmentDao {

	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}
