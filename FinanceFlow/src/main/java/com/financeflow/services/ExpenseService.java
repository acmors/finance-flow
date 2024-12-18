package com.financeflow.services;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financeflow.exceptions.ResourceNotFoundException;
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

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	public Expense getExpenseById(Long id) {
		return expenseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Despesa não encontrada"));
	}

	public Expense updateExpense(Long id, Expense updatedExpense) {
		Expense expense = getExpenseById(id); 
		expense.setExpenseValue(updatedExpense.getExpenseValue());
		expense.setCategory(updatedExpense.getCategory());
		expense.setDate(updatedExpense.getDate());
		expense.setDescription(updatedExpense.getDescription());
		return expenseRepository.save(expense); 
	}

	public void deleteExpense(Long id) {
		if(!expenseRepository.existsById(id)) {
			throw new RuntimeException("Despesa não encontrada.");
		}
		expenseRepository.deleteById(id);
	}

	public List<Expense> getExpenseByCategory(Category category) {
		return expenseRepository.findByCategory(category);
	}

	public List<Expense> getExpenseByDateRange(LocalDate startDate, LocalDate endDate) {
		return expenseRepository.findByDateBetween(startDate, endDate);
	}

}
