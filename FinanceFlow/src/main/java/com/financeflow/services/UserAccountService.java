package com.financeflow.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financeflow.exceptions.ResourceNotFoundException;
import com.financeflow.model.UserAccount;
import com.financeflow.repository.UserAccountRepository;

@Service
public class UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	public UserAccount createUser(UserAccount user) {
		return userAccountRepository.save(user);
	}

	public List<UserAccount> getAllUsers(){
		return userAccountRepository.findAll();
	}
	
	public UserAccount getUserById(Long id) {
		return userAccountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrado"));
	}
	
	public UserAccount updateUser(Long id, UserAccount updatedUser) {
	    UserAccount user = getUserById(id);  
	    user.setName(updatedUser.getName()); 
	    user.setEmail(updatedUser.getEmail()); 
	    user.setPassword(updatedUser.getPassword()); 
	    return userAccountRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userAccountRepository.deleteById(id);
	}

	public UserAccount getUserByEmail(String email) {
		return userAccountRepository.getUserByEmail(email);
	}
}
