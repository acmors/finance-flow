package com.financeflow.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeflow.model.Category;
import com.financeflow.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long>{
	
	List<Income> findByCategory(Category category);
	List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
