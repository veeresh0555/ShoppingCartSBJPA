package com.shopping.service;

import java.util.List;

import javax.validation.Valid;

import com.shopping.exception.RecordNotFoundException;
import com.shopping.model.Order;
import com.shopping.model.Product;
import com.shopping.model.User;

public interface ShoppingService {

	@Valid
	User saveuser(@Valid User user);

	User getUserById(Long uid) throws RecordNotFoundException;

	List<User> getaAllUsers();

	@Valid
	Product saveproduct(@Valid Product product);

	Order saveorderproduct(@Valid Long uid, Order order);

}
