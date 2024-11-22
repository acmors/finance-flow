package com.financeflow.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Positive
	private Double expenseValue;
	
	@NotNull
	private Category category;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	@NotNull
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserAccount user;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {	
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
	
	
}
