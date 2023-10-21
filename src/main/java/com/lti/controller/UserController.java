package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Cart;
import com.lti.dto.ForgotPassword;
import com.lti.dto.Login;
import com.lti.dto.PlacedOrder;
import com.lti.dto.UpdateUser;
import com.lti.dto.UserSignUp;
import com.lti.dto.Wishlist;
import com.lti.entity.UserTable;
import com.lti.exception.CustomerException;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/index") 
	public String home() {
		return "Welcome, to BuyZaar.com ";
	}

	@PostMapping(path = "/login")
	public int login(@RequestBody Login login) {
		try {
			return this.userService.login(login);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -100;
		}
	}

	@GetMapping(path = "/generateOTP") 
	public int generateOTP() {
		return this.userService.generateOTP();
	}

	@GetMapping(path = "/getUserById/{uId}") 
	public UserTable getUserById(@PathVariable String uId) {
		UserTable user = this.userService.getUserById(Integer.parseInt(uId));
		return user;
	}

	@GetMapping(path = "/addToMyCart/{uId}/{pId}") 
	public String addToMyCart(@PathVariable String uId, @PathVariable String pId) {
		boolean ok = this.userService.addToCart(Integer.parseInt(uId), Integer.parseInt(pId));
		if (ok == true)
			return "Product Added to Cart Successfull";
		return "Cannot Add Product to Cart";
	}

	@GetMapping(path = "/addToMyWishlist/{uId}/{pId}") 
	public String updateMyWishlist(@PathVariable String uId, @PathVariable String pId) {
		boolean ok = this.userService.addToWishlist(Integer.parseInt(uId), Integer.parseInt(pId));
		if (ok == true)
			return "Product Added to Wishlist Successfull";
		return "Cannot Add Product to Wishlist";
	}

	@DeleteMapping(path = "/deleteMyWishlist/{wId}") 
	public ResponseEntity<HttpStatus> deleteMyWishlist(@PathVariable String wId) {
		try {
			boolean status = this.userService.deleteWishlist(Integer.parseInt(wId));
			if (status) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/updateMyCart/{cId}/{addOrMinus}") 
	public String updateMyCart(@PathVariable String cId, @PathVariable String addOrMinus) {
		boolean ok = this.userService.updateCart(Integer.parseInt(cId), Integer.parseInt(addOrMinus));
		if (ok == true)
			return "Cart Updated Successfull";
		return "Cannot Update Cart";
	}

	@DeleteMapping(path = "/deleteMyCart/{cId}")
	public ResponseEntity<HttpStatus> deleteMyCart(@PathVariable String cId) {
		try {
			boolean status = this.userService.deleteCart(Integer.parseInt(cId));
			if (status) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/getMyCart/{uId}") 
	public List<Cart> getMyCart(@PathVariable String uId) {
		return this.userService.getCartValues(Integer.parseInt(uId));
	}

	@GetMapping(path = "/getMyWishlist/{uId}") 
	public List<Wishlist> getMyWishlist(@PathVariable String uId) {
		return this.userService.getWishlistValues(Integer.parseInt(uId));
	}

	@PostMapping(path = "/forgotPassword") 
	public String login(@RequestBody ForgotPassword forgotPassword) {
		boolean ok = this.userService.forgotPassword(forgotPassword);
		if (ok == true)
			return "Password Updated Successfull";
		return "Password Updated Failure";
	}

	@PostMapping(path = "/placeOrder/{payType}") 
	public String placeOrder(@RequestBody List<Cart> carts, @PathVariable String payType) {
		boolean ok = this.userService.placeOrder(carts, payType);
		if (ok == true)
			return "Order Place Successfull";
		return "Order Place Failure";
	}

	@GetMapping(path = "/getMyPlacedOrders/{uId}") 
	public List<PlacedOrder> sortProduct(@PathVariable String uId) {
		return this.userService.getMyPlacedOrders(Integer.parseInt(uId));
	}

	@PostMapping(path = "/addNewUser")
	public int addNewUser(@RequestBody UserSignUp newUser) {
		return this.userService.addUser(newUser);
	}

	@PutMapping(path = "/updateUser")
	public UserTable updateUser(@RequestBody UpdateUser updateUser) {
		return this.userService.updateUser(updateUser);
	}

	@GetMapping(path = "/generateOTP/{uId}")
	public int generateOTP(@PathVariable String uId) {
		return this.userService.generateOTP(uId);
	}

}
