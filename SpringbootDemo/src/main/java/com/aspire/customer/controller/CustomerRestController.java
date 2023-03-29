package com.aspire.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.customer.model.Customer;
import com.aspire.customer.service.CustomerService;

@RestController
//@RequestMapping("Customer")
@CrossOrigin(origins = "*")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getCustomerList() {
		return new ResponseEntity<List<Customer>>(service.listAll(), HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return new ResponseEntity<Customer>(service.get(id),HttpStatus.OK);
	}
	
	@PostMapping("/customer/save")
	public ResponseEntity<Void> saveOrUpdateCustomer(@RequestBody Customer customer) {
		service.save(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/delete/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	@GetMapping("/customer/search")
//	public ResponseEntity<List<Customer>> customerSearch(@RequestParam String keyword) {
//		service.search(keyword);
//		return new ResponseEntity<List<Customer>>(HttpStatus.OK);
//	}
}
