package com.financeflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeflow.model.Income;
import com.financeflow.services.IncomeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/income")
public class IncomeController {

	@Autowired
	private IncomeService incomeService;
	
	@PostMapping
	public ResponseEntity<Income> createIncome(@Valid @RequestBody Income income){
		Income newIncome = incomeService.createIncome(income);
		return new ResponseEntity<>(newIncome, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Income>> getAllIncomes(){
		List<Income> income = incomeService.getAllIncomes();
		return new ResponseEntity<>(income, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Income> getIncomeById(@PathVariable Long id){
		Income income = incomeService.getIncomeById(id);
		return new ResponseEntity<>(income, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteIncome(@PathVariable Long id){
		incomeService.deleteIncome(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
