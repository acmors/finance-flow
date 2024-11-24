package com.financeflow.DTO;

import java.time.LocalDate;

import com.financeflow.model.Category;
import com.financeflow.model.Expense;

public class ExpenseDTO {
	
	private Long id;
	private Double expenseValue;
	private Category category;
	private LocalDate date;
	private String description;
	private UserDTO user;
	
	public ExpenseDTO() {
	}

	public ExpenseDTO(Long id, Double expenseValue, Category category, LocalDate date, String description, UserDTO user) {
		this.id = id;
		this.expenseValue = expenseValue;
		this.category = category;
		this.date = date;
		this.description = description;
		this.user = user;
	}
	
	public ExpenseDTO(Expense expense) {
		id = expense.getId();
		expenseValue = expense.getExpenseValue();
		category = expense.getCategory();
		date = expense.getDate();
		description = expense.getDescription();
		
		this.user = new UserDTO(
				expense.getUser().getId(),
				expense.getUser().getName(),
				expense.getUser().getEmail()
		);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getExpenseValue() {
		return expenseValue;
	}

	public void setExpenseValue(Double expenseValue) {
		this.expenseValue = expenseValue;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
