package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerService {
	
	private SellerDao dao = DaoFactory.createSellerDao();

	public List<Seller> findAll(){
		return dao.findAll();
	}
	
	// Metodo para verificar se precisa inserir um novo Seller no banco ou atualizar um existente
	public void saveOrUpdate(Seller obj) {
		if (obj.getId() == null) {	// Não tem ID entao esta efetuando uma inclusao de registro
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	// Metodo para exclusão do Seller
	public void remove(Seller obj) {
		dao.deleteById(obj.getId());
	}
}
