package com.agha.comp_store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agha.comp_store.dto.CartItemDTO;
import com.agha.comp_store.model.CartItem;
import com.agha.comp_store.model.Computer;
import com.agha.comp_store.model.User;
import com.agha.comp_store.repository.CartItemRepository;
import com.agha.comp_store.repository.ComputerRepository;
import com.agha.comp_store.repository.UserRepository;
import com.agha.comp_store.utility.ConverterUtility;

@Service
public class CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ComputerRepository computerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void addToCard(Integer computerId, int quantity, String username) {
		User user = userRepository.findByUsername(username);
		Computer computer = computerRepository.getReferenceById(computerId);
		CartItem cartItem = new CartItem();
		cartItem.setUser(user);
		cartItem.setComputer(computer);
		cartItem.setQuantity(quantity);
		
		cartItemRepository.save(cartItem);
	}
	
	public List<CartItemDTO> getAllCartItems(String username) {
		User user = userRepository.findByUsername(username);
		return cartItemRepository.findByUser(user).stream().map(ConverterUtility::convertEntityToDTO).collect(Collectors.toList());
	}

	public double getTotalPrice(String username) {
		User user = userRepository.findByUsername(username);
		double sum = 0;
		for (CartItem cartItem : cartItemRepository.findByUser(user)) {
			sum += cartItem.getQuantity() * cartItem.getComputer().getPrice();
		}
		return sum;
	}

    public void deleteCartItem(Integer id, String remoteUser) {
		CartItem cartItem = cartItemRepository.getReferenceById(id);
		if (cartItem.getUser().getUsername().equals(remoteUser)) {
			cartItemRepository.delete(cartItem);
		}
    }
}
