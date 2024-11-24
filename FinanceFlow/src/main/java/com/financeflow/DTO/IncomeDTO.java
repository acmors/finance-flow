package com.financeflow.DTO;

import java.time.LocalDate;

import com.financeflow.model.Category;
import com.financeflow.model.Income;

public class IncomeDTO {
	
	private Long id;
	private Double incomeValue;
	private Category category;
	private LocalDate date;
	private String description;
	private UserDTO user;
	
	public IncomeDTO() {
	}

	public IncomeDTO(Long id, Double incomeValue, Category category, LocalDate date, String description, UserDTO user) {
		this.id = id;
		this.incomeValue = incomeValue;
		this.category = category;
		this.date = date;
		this.description = description;
		this.user = user;
	}
		
	public IncomeDTO(Income income) {
		id = income.getId();
		incomeValue = income.getIncomeValue();
		category = income.getCategory();
		date = income.getDate();
		description = income.getDescription();
		
		this.user = new UserDTO(
			income.getUser().getId(),
			income.getUser().getName(),
			income.getUser().getEmail()
		);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getIncomeValue() {
		return incomeValue;
	}

	public void setIncomeValue(Double incomeValue) {
		this.incomeValue = incomeValue;
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
