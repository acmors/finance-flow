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

import com.financeflow.model.Expense;
import com.financeflow.services.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@PostMapping
	public ResponseEntity<Expense> createExpense(@Valid @RequestBody Expense expense){
		Expense newExpense = expenseService.createExpense(expense);
		return new ResponseEntity<>(newExpense, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses(){
		List<Expense> expenses = expenseService.getAllExpenses();
		return new ResponseEntity<>(expenses, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long id){
		Expense expense = expenseService.getExpenseById(id);
		return new ResponseEntity<>(expense, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteExpense(@PathVariable Long id){
		expenseService.deleteExpense(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
