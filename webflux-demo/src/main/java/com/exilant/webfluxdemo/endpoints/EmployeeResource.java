package com.exilant.webfluxdemo.endpoints;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exilant.webfluxdemo.model.Employee;
import com.exilant.webfluxdemo.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rest")
public class EmployeeResource {

	@Autowired
	private EmployeeRepository repo;

	
	@GetMapping(path="/employees/{id}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<Employee> getEmployeeById(@PathVariable String id) {
		return repo.findById(id);
	}

	@GetMapping(path="/employees", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> getAllEmployees() {
		Flux<Long> f1 = Flux.interval(Duration.ofSeconds(2));
		Flux<Employee> f2 = repo.findAll();

		return Flux.zip(f1, f2).map(pair -> pair.getT2());
	}

	@GetMapping(path="/costly-employees", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> getCostlyEmployees() {
		Flux<Long> f1 = Flux.interval(Duration.ofSeconds(2));
		Flux<Employee> f2 = repo.getEmployeesEarningMoreThan(2000.0);

		return Flux.zip(f1, f2).map(pair -> pair.getT2());
	}

	@GetMapping(path="/employees/{min}/{max}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> getCostlyEmployees(@PathVariable Double min, @PathVariable Double max) {

		return repo.getEmployeesEarningSalaryBetween(min, max);
	}
}