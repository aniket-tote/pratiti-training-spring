package com.pratiti.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pratiti.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public boolean existsByEmail(String Email);
	public boolean existsById(String Id);
	public Optional<Customer> findByEmailAndPassword(String Email,String Password);
}
