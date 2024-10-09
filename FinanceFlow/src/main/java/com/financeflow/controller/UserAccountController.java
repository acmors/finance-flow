package com.financeflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financeflow.model.UserAccount;
import com.financeflow.services.UserAccountService;

@RestController
@RequestMapping("api/users")
public class UserAccountController {
	
	@Autowired
	private UserAccountService userAccountService;
	
	//create an user
	@PostMapping
	public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user){
		UserAccount newUser = userAccountService.createUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	//get all users from database
	@GetMapping
	public ResponseEntity<List<UserAccount>> getAllUsers(){
		List<UserAccount> user = userAccountService.getAllUsers();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//get user by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
		UserAccount user = userAccountService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserAccount> updateUser(@PathVariable Long id,@RequestBody UserAccount updateUser){
		UserAccount user = userAccountService.updateUser(id, updateUser);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		UserAccountService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/email")
	public ResponseEntity<UserAccount> getUserByEmail(@RequestParam String email){
		UserAccount user = userAccountService.getUserByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
