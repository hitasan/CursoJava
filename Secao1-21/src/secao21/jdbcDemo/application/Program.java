package secao21.jdbcDemo.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import secao21.jdbcDemo.model.dao.DaoFactory;
import secao21.jdbcDemo.model.dao.SellerDao;
import secao21.jdbcDemo.model.entities.Department;
import secao21.jdbcDemo.model.entities.Seller;

// Programa teste para operações com base no vendedor (Seller)
public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();		// instanciando o obj SellerDao atraves do DAOFactory no meotod createSellerDao que vai instanciar o SellerDaoJDBC()
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);	// Buscando no banco de dados o Seller que possua o codigo '3' e retonando como um objeto do tipo Seller para uso
		System.out.println(seller);				// Imprimindo os dados do obj retornado pelo metodo toString da classe Seller
		
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);	// função de pesquisa requer um obj do tipo departamento por isso instanciamos acima somente indicando a chave(Id) dele que é o necessario para a busca nesse caso.
		for (Seller obj : list) {		// laço para impressao de todos registros listados
			System.out.println(obj);
		}

		System.out.println("\n==== TEST 3: seller findAll ====");
		list = sellerDao.findAll();	// Reaproveitando a variavel list somente pq ja foi usada para impressao acima
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n==== TEST 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department); // ID nulo pq ainda nao tem valor que passa a ser sabido apos autoincremento do DB
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		
		System.out.println("\n==== TEST 5: seller update ====");
		seller = sellerDao.findById(1);	// Inicialmente pesquisando se existe o Seller de ID = 1
		seller.setName("Martha Waine");	// Alterando a propriedade nome do obj seller
		sellerDao.update(seller);		// Atualizando o registro
		System.out.println("Update completed");

		
		System.out.println("\n==== TEST 6: seller delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
