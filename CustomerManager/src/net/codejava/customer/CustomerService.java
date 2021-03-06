package net.codejava.customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class CustomerService {
	//@Autowired CustomerRepository repo;
	//created this by purna.
	List<Customer> customerList=CustomerRepository.m1();
	
	public void save(Customer customer) {
		//repo.save(customer);
		if(customer.getId()==null) {
			Random rand = new Random();
			System.out.printf("%04d%n", rand.nextInt(1000));
			Customer cust=customerList.get(customerList.size()-1);
			customer.setId(cust.getId()+1);
			customerList.add(customer);
		}else {
		Predicate<Customer> isEmployeeActive = e -> e.getId().equals(customer.getId());
		Customer cust=customerList.stream().filter(isEmployeeActive)
				.collect(Collectors.toList()).get(0);
		if(!cust.equals(customer))
			customerList.remove(cust);
			customerList.add(customer);
	     }
	}
	
	public List<Customer> listAll() {
		//return (List<Customer>) repo.findAll();
		customerList.sort((i,j)->i.getId().compareTo(j.getId()));
		return customerList;
	}
	
	public Customer get(Long id) {
		System.out.println(id);
		Predicate<Customer> isEmployeeActive = e -> e.getId().equals(id);
		Customer cust= customerList.stream().filter(isEmployeeActive)
				.collect(Collectors.toList()).get(0);
		if(cust!=null)return cust;
		return new Customer();
		//repo.findById(id).get();
	}
	
	public void delete(Long id) {
		Predicate<Customer> isEmployeeActive = e -> e.getId().equals(id);
		Customer cust=customerList.stream().filter(isEmployeeActive)
		.collect(Collectors.toList()).get(0);
		if(cust!=null)
		customerList.remove(cust);
		//repo.deleteById(id);
	}
	
	public List<Customer> search(String keyword) {
		Predicate<Customer> employeeName = e -> e.getName().toLowerCase().contains(keyword.toLowerCase());
		Predicate<Customer> employeAdd = e -> e.getAddress().toLowerCase().contains(keyword.toLowerCase());
		Predicate<Customer> employeEmail = e -> e.getEmail().toLowerCase().contains(keyword.toLowerCase());
		return customerList.stream().filter(employeeName.or(employeAdd).or(employeEmail))
		.collect(Collectors.toList());
		
		
		//return repo.search(keyword);
	}
}
