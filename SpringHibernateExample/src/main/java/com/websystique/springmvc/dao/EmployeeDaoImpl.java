package com.websystique.springmvc.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Employee;


@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
	List<Employee> empList=SupportingEmplist.getEmployeeList();
	public Employee findById(int id) {
		//return getByKey(id);
		
		Predicate<Employee> isEmployeeActive = e -> e.getId()==id;
		
		return  empList.stream().filter(isEmployeeActive).collect(Collectors.toList()).get(0);
	}

	public void saveEmployee(Employee employee) {
		/*if(((Integer)(employee.getId()))==null ){
			employee.setId(empList.get(empList.size()-1).getId()+1);
		}else{*/
		
		try{
			Predicate<Employee> isEmployeeActive = e -> e.getId()==(employee.getId());
		Employee e= empList.stream().filter(isEmployeeActive).collect(Collectors.toList()).get(0);
		if(e!=null)
		empList.remove(e);
		}catch(Exception e){
			employee.setId(empList.get(empList.size()-1).getId()+1);
		}
		//}
		
		empList.add(employee);
		//persist(employee);
	}

	public void deleteEmployeeBySsn(String ssn) {
		/*Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();*/
Predicate<Employee> isEmployeeActive = e -> e.getSsn().equals(ssn);
		
		Employee e= empList.stream().filter(isEmployeeActive).collect(Collectors.toList()).get(0);
		empList.remove(e);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		/*Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();*/
		return empList;
	}

	public Employee findEmployeeBySsn(String ssn) {
		/*Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();*/
Predicate<Employee> isEmployeeActive = e -> e.getSsn().equals(ssn);
		
		return empList.stream().filter(isEmployeeActive).collect(Collectors.toList()).get(0);
	}
}
