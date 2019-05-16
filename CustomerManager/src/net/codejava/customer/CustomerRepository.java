package net.codejava.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public class CustomerRepository {
	
	public static List<Customer> m1() {
		List<Customer> customerList=new ArrayList<Customer>();
				Customer cust=new Customer(1000L,"RAM", "RAM@gmail.com"," RAM Colony");
				Customer cust1=new Customer(1001L,"RAM1", "RAM1@gmail.com"," RAM1 Colony");
				Customer cust2=new Customer(1002L,"RAM2", "RAM2@gmail.com"," RAM2 Colony");
				customerList.add(cust);
				customerList.add(cust1);
				customerList.add(cust2);
				return customerList;
	}
	
	
	
}

/*public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'"
			+ " OR c.address LIKE '%' || :keyword || '%'")
	public List<Customer> search(@Param("keyword") String keyword);
}*/
