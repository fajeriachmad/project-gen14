package com.aspire.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aspire.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {	
	@Query(value = "SELECT c FROM Customer c WHERE c.name ILIKE '%' || :keyword || '%'"
			+ " OR c.email ILIKE '%' || :keyword || '%'"
			+ " OR c.city ILIKE '%' || :keyword || '%' ORDER BY c.id ASC")
	public List<Customer> search(@Param("keyword") String keyword);
	
	public List<Customer> findAllByOrderByIdAsc();
}