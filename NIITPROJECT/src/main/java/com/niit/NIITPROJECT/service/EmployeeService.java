package com.niit.NIITPROJECT.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.niit.NIITPROJECT.model.Emp;
@Service
public class EmployeeService {
	EmployeeService(){
		getAllEmployee();
	}
	private static  List<Emp> empList=new CopyOnWriteArrayList<Emp>();
	
	
	public List<Emp> getAllEmp() {
		/*
		 * if(empList==null || empList.isEmpty()) { empList=getAllEmployee(); }
		 */
		return empList;
	}
	
	public List<Emp> DeleteEmployee(Integer eId){
		Emp emp=new Emp();
		/*
		 * if(empList==null || empList.isEmpty()) { empList=getAllEmployee(); }
		 */
		for(Emp e:empList) {
			if(e.geteId().equals(eId))empList.remove(e);
		}
		
		//empList.remove(emp);
		 return empList;
	}
	public List<Emp> createEmployee(Emp emp) {
		/*
		 * if(empList==null || empList.isEmpty()) { empList=getAllEmployee(); }
		 */
		empList.add(emp);
		return empList;
	}
	public List<Emp> updateEmployee(Emp emp) {
		/*
		 * if(empList==null || empList.isEmpty()) { empList=getAllEmployee(); }
		 */
		for(Emp e:empList) {
			if(e.geteId().equals(emp.geteId())) 
				empList.get(empList.indexOf(e)).setName(emp.getName());
		}
		
		
		return empList;
	}
	
	public Emp  getEmp(Integer id) {
		/*
		 * if(empList==null || empList.isEmpty()) { empList=getAllEmployee(); }
		 */
		for(Emp e:empList) {
			if(e.geteId().equals(id))return e;
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	private static void getAllEmployee(){
		//List<Emp> empList1=new ArrayList();
		Emp e1=new Emp(1,"SACHIN");
		Emp e2=new Emp(2,"PURNA");
		Emp e3=new Emp(3,"AMIT");
		Emp e4=new Emp(4,"NIHAR");
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
			
	}

	

	

}
