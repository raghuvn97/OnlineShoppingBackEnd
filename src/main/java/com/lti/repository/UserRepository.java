package com.lti.repository;

import java.util.List;

import com.lti.dto.Cart;
import com.lti.dto.UpdateUser;
import com.lti.dto.UserSignUp;
import com.lti.dto.Wishlist;
import com.lti.entity.CartTable;
import com.lti.entity.UserTable;
import com.lti.exception.CustomerException;

public interface UserRepository {
	public List<UserTable> getAllUsers(); //for testing
	public UserTable getUserById(int uId); //for testing
	public int getUserByEmailAndPassword(String email, String password) throws CustomerException;
	public UserTable getUserByEmail(String email) throws CustomerException;
	public UserTable updateUser(long uId, UserTable user);
	public List<Cart> getCartOfUser(int uId);
	public List<Wishlist> getWishlistOfUser(int uId);
	public int addUser(UserSignUp newUser);
	public UserTable updateUser(UpdateUser updateUser);
	public int generateOTP(String uId);
}
