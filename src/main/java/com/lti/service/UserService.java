package com.lti.service;

import java.util.List;

import com.lti.dto.Cart;
import com.lti.dto.ForgotPassword;
import com.lti.dto.Login;
import com.lti.dto.PlacedOrder;
import com.lti.dto.UpdateUser;
import com.lti.dto.UserSignUp;
import com.lti.dto.Wishlist;
import com.lti.entity.UserTable;
import com.lti.exception.CartException;
import com.lti.exception.CustomerException;
import com.lti.exception.WishlistException;

public interface UserService {
	public int generateOTP();
	public int login(Login login) throws CustomerException; //passed
	public boolean forgotPassword(ForgotPassword forgotPassword); //passed
	public UserTable getUserById(int uId); //only for testing purpose
	public List<Cart> getCartValues(int uId); //passed
	public List<Wishlist> getWishlistValues(int uId);
	public boolean addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cId) throws CartException;
	public boolean addToWishlist(int uId, int pId);
	public boolean deleteWishlist(int wId) throws WishlistException;
	public boolean placeOrder(List<Cart> carts, String payType);
	public List<PlacedOrder> getMyPlacedOrders(int uId);
	public int addUser(UserSignUp newUser);
	public UserTable updateUser(UpdateUser updateUser);
	int generateOTP(String uId);
}
