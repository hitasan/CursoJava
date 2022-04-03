package secao21.jdbcDemo.model.dao;

import secao21.jdbcDemo.db.DB;
import secao21.jdbcDemo.model.dao.impl.DepartmentDaoJDBC;
import secao21.jdbcDemo.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
