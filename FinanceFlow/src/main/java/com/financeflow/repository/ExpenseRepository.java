package com.financeflow.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeflow.model.Category;
import com.financeflow.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	List<Expense> findByCategory(Category category);
	List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
