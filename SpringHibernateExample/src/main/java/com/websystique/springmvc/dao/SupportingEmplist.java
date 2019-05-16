package com.websystique.springmvc.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import com.websystique.springmvc.model.Employee;

public class SupportingEmplist {
	
	static List<Employee>  getEmployeeList(){
	
	List<Employee> empList=new ArrayList<Employee>();
	LocalDate date=new LocalDate();
	Employee emp1=new Employee(111, "PURNA1", date , new BigDecimal(1111), "AAA");
	Employee emp2=new Employee(112, "PURNA12", date , new BigDecimal(1112), "BBB");
	Employee emp3=new Employee(113, "PURNA3", date , new BigDecimal(1113), "CCC");
	Employee emp4=new Employee(114, "PURNA4", date , new BigDecimal(1114), "DDD");
	Employee emp5=new Employee(115, "PURNA5", date , new BigDecimal(1115), "EEE");
	Employee emp6=new Employee(116, "PURNA6", date , new BigDecimal(1116), "FFF");
	empList.add(emp1);
	empList.add(emp2);
	empList.add(emp3);
	empList.add(emp4);
	empList.add(emp5);
	empList.add(emp6);
return empList;
	}
}
