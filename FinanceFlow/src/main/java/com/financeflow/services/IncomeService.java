package com.financeflow.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeflow.exceptions.ResourceNotFoundException;
import com.financeflow.model.Category;
import com.financeflow.model.Income;
import com.financeflow.repository.IncomeRepository;

@Service
public class IncomeService {
	
	@Autowired
	private IncomeRepository incomeRepository;
	
	public Income createIncome(Income income) {
		return incomeRepository.save(income);
	}
	
	public List<Income> getAllIncomes(){
		return incomeRepository.findAll();
	}
	
	public Income getIncomeById(Long id) {
		return incomeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ganho não encontrado"));
	}
	
	public Income updateIncome(Long id, Income updatedIncome) {
		Income income = getIncomeById(id);
		income.setIncomeValue(updatedIncome.getIncomeValue());
		income.setCategory(updatedIncome.getCategory());
		income.setDate(updatedIncome.getDate());
		income.setDescription(updatedIncome.getDescription());
		return incomeRepository.save(income);
	}
	
	public void deleteIncome(Long id) {
		if(!incomeRepository.existsById(id)) {
			throw new RuntimeException("Receita não encontrada.");
		}
		incomeRepository.deleteById(id);
	}
	
	public List<Income> getIncomeByCategory(Category category){
		return incomeRepository.findByCategory(category);
	}
	
	public List<Income> getIncomeByDateRange(LocalDate startDate, LocalDate endDate){
		return incomeRepository.findByDateBetween(startDate, endDate);
	}
}
