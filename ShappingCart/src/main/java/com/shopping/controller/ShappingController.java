package com.shopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.RecordNotFoundException;
import com.shopping.model.Order;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.service.ShoppingService;

@RestController
public class ShappingController {

	@Autowired
	ShoppingService shpservice;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userlist=shpservice.getaAllUsers();
		return new ResponseEntity<List<User>>(userlist,HttpStatus.OK);
	}
	@GetMapping("/getuserById/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable("uid") Long uid ) throws RecordNotFoundException {
		User user=shpservice.getUserById(uid);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@PostMapping("/usersave")
	public ResponseEntity<User> usersave(@Valid User user) throws Exception{
		user=shpservice.saveuser(user);
	return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@PostMapping("/prodsave")
	public ResponseEntity<Product> prodsave(@Valid Product product) throws Exception{
		product=shpservice.saveproduct(product);
	return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@PostMapping("/orderproducts/{uid}")
	public ResponseEntity<Order> orderProductsave(@Valid @PathVariable("uid") Long uid,Order order) throws Exception{
		order=shpservice.saveorderproduct(uid,order);
	return new ResponseEntity<Order>(order,HttpStatus.OK);
	} 
	
	
	
	
	
	
	
	
	
	
	
	
}
