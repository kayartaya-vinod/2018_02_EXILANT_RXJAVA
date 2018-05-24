package com.exilant.webfluxdemo.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.exilant.webfluxdemo.model.Employee;

import reactor.core.publisher.Flux;

// we are not implementing this interface, but spring will provide a
// default implementation for the same
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{

	// @Query("{salary : { $gt: ?0 }}")
	@Query("{ $where: 'this.salary > ?0 '}")
	public Flux<Employee> getEmployeesEarningMoreThan(Double salary);
	
	@Query("{$and: [ { salary : { $gte: ?0} },{ salary : { $lte: ?1} }]}")
	public Flux<Employee> getEmployeesEarningSalaryBetween(Double min, Double max);
}