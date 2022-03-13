package com.cg.mtb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtb.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository <Customer,Integer>{
	

}
