package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDao dao = DaoFactory.createDepartmentDao();

	public List<Department> findAll(){
		return dao.findAll();
	}
	
	// Metodo para verificar se precisa inserir um novo departamento no banco ou atualizar um existente
	public void saveOrUpdate(Department obj) {
		if (obj.getId() == null) {	// Não tem ID entao esta efetuando uma inclusao de registro
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	// Metodo para exclusão do departamento
	public void remove(Department obj) {
		dao.deleteById(obj.getId());
	}
}
