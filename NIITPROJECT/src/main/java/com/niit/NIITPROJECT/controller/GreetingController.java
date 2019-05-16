package com.niit.NIITPROJECT.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.NIITPROJECT.model.Emp;
import com.niit.NIITPROJECT.service.EmployeeService;

@RestController
public class GreetingController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmployeeService empService;

		@GetMapping
	public String  getwelcome() {
		logger.info("getting welcome message");
		return "Welcome to purna ka rest web service";
	}

	
	@GetMapping("/getemployees")
	public List<Emp> getAllEmp() {
		logger.info("getting All employee record");
		return empService.getAllEmp();
	}
	@GetMapping("/getemployees/{id}")
	public ResponseEntity<?> getEmp(@PathVariable(name="id") Integer eId) {
		logger.info("getting single employee record with id:"+eId);
		Emp e=empService.getEmp(eId);
		try {
			if(!e.equals(null))
				return new ResponseEntity<Emp>(e, HttpStatus.OK);//empService.getEmp(eId);	
		}
		catch(Exception e1){
		return new ResponseEntity<String>("Please pass valid employee ID", HttpStatus.OK);
		}
		return null;
		
	}
	@PutMapping("/updateemployee")
	public List<Emp> updateEmployee(@RequestBody Emp emp) {
		logger.info("updating employee record...");
		return empService.updateEmployee(emp);
	}
	@PostMapping("/saveemployee" )
	public List<Emp> createEmployee(@RequestBody Emp emp) {
		logger.info("saving employee record...");
		return empService.createEmployee(emp);
	}
	@DeleteMapping("/delete/{id}")
	public List<Emp> DeleteEmployee(@PathVariable(name="id") Integer eId) {
		logger.info("trying to deleting employee record with id"+eId+"  ...");
		return empService.DeleteEmployee(eId);
	}
	
}
