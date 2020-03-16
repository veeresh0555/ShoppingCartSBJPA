package com.shopping.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.model.Order;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.repository.OrderRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.repository.UserRepository;

@Service
public class ShappingServiceImpl implements ShoppingService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public @Valid User saveuser(@Valid User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long uid) throws RecordNotFoundException {
		Optional<User> user=userRepo.findById(uid);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new RecordNotFoundException("No User record exist for given uid");
		}
	}

	@Override
	public List<User> getaAllUsers() {
		List<User> userlist=userRepo.findAll();
		if(userlist.size()>0) {
			return userlist;
		}else {
			return new ArrayList<User>();
		}
	}

	@Override
	public @Valid Product saveproduct(@Valid Product product) {
		return productRepo.save(product);
	}

	@Override
	public Order saveorderproduct(@Valid Long uid, Order order) {
		Optional<User> user=userRepo.findById(uid);
		if(user.isPresent()) {
			order.setUsr(user.get());
			order.setOrderdate(LocalDate.now());
			//Optional<Product> product=productRepo.
		}
		
		
		
		return orderRepository.save(order);
	}
	
	
	
	
}
