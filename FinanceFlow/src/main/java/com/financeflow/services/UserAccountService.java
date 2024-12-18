package com.financeflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeflow.DTO.UserDTO;
import com.financeflow.exceptions.ResourceNotFoundException;
import com.financeflow.model.UserAccount;
import com.financeflow.repository.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	public UserDTO createUser(UserDTO user) {
		UserAccount entity = new UserAccount();
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		
		entity = userAccountRepository.save(entity);
		return new UserDTO(entity);
	}

	public List<UserDTO> getAllUsers(){
		List<UserAccount> entities = userAccountRepository.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		
		for (UserAccount entity : entities) {
			dtos.add(new UserDTO(entity));
		}
		
		return dtos;
	}
	
	public UserDTO findById(Long id) {
		UserAccount entity = userAccountRepository.findById(id).get();
		UserDTO dto = new UserDTO(entity);
		return dto;
		
	}
	
	public UserDTO updateUser(Long id, UserDTO updatedUser) {
	    UserAccount entity = userAccountRepository.findById(id)
	    		.orElseThrow(() -> new ResourceNotFoundException("User not found")); 
	    
		entity.setName(updatedUser.getName());
		entity.setEmail(updatedUser.getEmail());
		entity.setPassword(updatedUser.getPassword());
		
		UserAccount updatedEntity = userAccountRepository.save(entity);
		
		return new UserDTO(entity);
	    
	}
	
	public void deleteUser(Long id) {
		if(!userAccountRepository.existsById(id)) {
			throw new RuntimeException("Usuário não encontrado.");
		}
		userAccountRepository.deleteById(id);
	}

	public UserDTO getUserByEmail(String email) {
		UserAccount entity = userAccountRepository.findUserByEmail(email);
		UserDTO dto = new UserDTO(entity);
		return dto;
	}
}
