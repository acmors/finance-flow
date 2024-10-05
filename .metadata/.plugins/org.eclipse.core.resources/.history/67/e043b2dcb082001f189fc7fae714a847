package com.financeflow.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeflow.model.Category;
import com.financeflow.model.Expense;
import com.financeflow.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public List<Expense> getAllExpenses(){
		return expenseRepository.findAll();
	}
	
	public Expense getExpenseById(Long id) {
		return expenseRepository.findById(id);
	}
	
	public Expense updateExpense(Long id, Expense updatedExpense) {
		
	}
	
	public void deleteExpense(Long id) {
		return expenseRepository.deleteById(id);
	}
	
	public List<Expense> getExpenseByCategory(Category category){
		return expenseRepository.findByCategory(category);
	}
	
	public List<Expense> getExpenseByDateRange(LocalDate startDate, LocalDate endDate){
		return expenseRepository.findByDateBetween(startDate, endDate);
	}
	
}
