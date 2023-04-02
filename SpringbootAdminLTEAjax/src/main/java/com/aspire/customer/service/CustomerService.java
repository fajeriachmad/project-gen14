package com.aspire.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aspire.customer.model.Customer;
import com.aspire.customer.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	
	@Autowired 
	CustomerRepository repository;
	
	public List<Customer> listAll() {
		return (List<Customer>) repository.findAllByOrderByIdAsc();
	}
	
	public void save(Customer customer) {
		repository.save(customer);
	}
	
	public Customer get(int id) {
		Optional<Customer> result = repository.findById(id);
		return result.get();
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public List<Customer> search(String keyword) {
		return repository.search(keyword);
	}
}