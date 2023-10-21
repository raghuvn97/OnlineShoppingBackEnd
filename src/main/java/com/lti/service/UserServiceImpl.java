	package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.lti.repository.CartRepository;
import com.lti.repository.OTPRepository;
import com.lti.repository.PlaceOrderRepository;
import com.lti.repository.UserRepository;
import com.lti.repository.WishlistRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OTPRepository otpDAO;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;
	
	@Autowired
	private PlaceOrderRepository placeOrderRepository;
	
	
	public int generateOTP()
	{
		return this.otpDAO.addOtp();
	}
	
	@Override
	@Transactional
	public boolean forgotPassword(ForgotPassword forgotPassword) {
		// TODO Auto-generated method stub
		//Logic:- first generate new otp, then check if what user put is same then update
		int otp = this.otpDAO.getLastOTP();
		if(Integer.parseInt(forgotPassword.getOtp())==otp)
		{
			System.out.println("OTP Matched!");
			UserTable userTable = (UserTable)this.userRepository.getUserByEmail(forgotPassword.getEmail());
			userTable.setUPassword(forgotPassword.getPassword());
			this.userRepository.updateUser(userTable.getUId(), userTable);
			return true;
		}
		return false;
	}

	@Override
	public int login(Login login) throws CustomerException{
		int id = this.userRepository.getUserByEmailAndPassword(login.getEmail(),login.getPassword());
		return id;
	}

	@Override
	public UserTable getUserById(int uId) {
		// TODO Auto-generated method stub
		return this.userRepository.getUserById(uId);
	}

	@Override
	public List<Cart> getCartValues(int uId) {
		// TODO Auto-generated method stub
		return this.userRepository.getCartOfUser(uId);
	}

	@Override
	public List<Wishlist> getWishlistValues(int uId) {
		// TODO Auto-generated method stub
		return this.userRepository.getWishlistOfUser(uId);
	}

	@Override
	public boolean addToCart(int uId, int pId) {
		// TODO Auto-generated method stub
		return this.cartRepository.addToCart(uId, pId);
	}

	@Override
	public boolean updateCart(int cId, int addOrMinus) {
		// TODO Auto-generated method stub
		return this.cartRepository.updateCart(cId,addOrMinus);
	}

	@Override
	public boolean deleteCart(int cId) throws CartException {
		// TODO Auto-generated method stub
		return this.cartRepository.deleteCart(cId);
	}

	@Override
	public boolean addToWishlist(int uId, int pId) {
		// TODO Auto-generated method stub
		return this.wishlistRepository.addToWishlist(uId, pId);
	}

	@Override
	public boolean deleteWishlist(int wId) throws WishlistException {
		// TODO Auto-generated method stub
		return this.wishlistRepository.deleteWishlist(wId);
	}

	@Override
	public boolean placeOrder(List<Cart> carts, String payType) {
		// TODO Auto-generated method stub
		return this.placeOrderRepository.placeOrder(carts,payType);
	}

	@Override
	public List<PlacedOrder> getMyPlacedOrders(int uId) {
		// TODO Auto-generated method stub
		return this.placeOrderRepository.showPlacedOrders(uId);
	}

	@Override
	public int addUser(UserSignUp newUser) {
		// TODO Auto-generated method stub
		//first check if user is present or not!
		int id = 0;
		try
		{
			UserTable user = this.userRepository.getUserByEmail(newUser.getuEmail());
			return -100;
		}
		catch(NullPointerException e)
		{
			return -100;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			id = this.userRepository.addUser(newUser);
		}
		return id;
	}

	@Override
	public UserTable updateUser(UpdateUser updateUser) {
		// TODO Auto-generated method stub
		return this.userRepository.updateUser(updateUser);
	}
	
	@Override
	public int generateOTP(String uId) {
		int otp = this.userRepository.generateOTP(uId);
		return otp;
	}
}
