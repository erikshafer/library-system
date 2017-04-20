package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Checkout;

public interface checkoutDao extends CrudRepository<Checkout, Long>{

	List<Checkout> findAll();
	
}
