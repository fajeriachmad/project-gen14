package com.aspire.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aspire.customer.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {	
	@Query(value = "SELECT c FROM Customer c WHERE LOWER(c.name) LIKE LOWER('%' || :keyword || '%')"
			+ " OR LOWER(c.email) LIKE LOWER('%' || :keyword || '%')"
			+ " OR LOWER(c.city) LIKE LOWER('%' || :keyword || '%') ORDER BY c.id ASC")
	public List<Customer> search(@Param("keyword") String keyword);
	
	public List<Customer> findAllByOrderByIdAsc();
}