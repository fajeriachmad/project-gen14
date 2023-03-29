package com.aspire.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aspire.customer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {	
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'"
			+ " OR c.city LIKE '%' || :keyword || '%'")
	public List<Customer> search(@Param("keyword") String keyword);
	
	public List<Customer> findAllByOrderByIdAsc();
}
