package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.Cart;
import com.lti.dto.UpdateUser;
import com.lti.dto.UserSignUp;
import com.lti.dto.Wishlist;
import com.lti.entity.CartTable;
import com.lti.entity.UserTable;
import com.lti.entity.WishlistTable;
import com.lti.exception.CustomerException;
import com.lti.service.EmailService;


@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	

	@Autowired
	EmailService emailService;
	
	@Autowired
	OTPRepository otprepository;
	
	@Override //for testing
	public List<UserTable> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTable getUserById(int uId) {
		// TODO Auto-generated method stub
		UserTable user = this.entityManager.find(UserTable.class, uId);
		System.out.println("User is :"+user);
		return user;
	}

	@Override
	public int getUserByEmailAndPassword(String email, String password) throws CustomerException{
		// TODO Auto-generated method stub
		Query q = null;
		try
		{
			String query = "select uId from UserTable where uEmail=:x and uPassword=:y";
			q = (Query) this.entityManager.createQuery(query);
			q.setParameter("x", email);
			q.setParameter("y", password);
			System.out.println("Result is :"+q.getSingleResult());
		}
		catch(Exception e)
		{
			throw new CustomerException("Customer Not Found");
		}
		return (int)q.getSingleResult();
	}

	@Override
	public UserTable getUserByEmail(String email) throws CustomerException{
		// TODO Auto-generated method stub
		String query = "from UserTable where uEmail=:x";
		UserTable user = null;
		Query q = null;
		try
		{
			q = (Query) this.entityManager.createQuery(query);
			q.setParameter("x", email);
			user = (UserTable)q.getSingleResult();
		}
		catch(NonUniqueResultException e)
		{
			return null;
		}
		catch(Exception e)
		{
			throw new CustomerException("Customer Not Exists");
		}
		
		return user;
	}
	

	@Override //for testing
	public UserTable updateUser(long uId, UserTable user) {
		// TODO Auto-generated method stub
		this.entityManager.merge(user);
		return null;
	}


	@Override
	public List<Cart> getCartOfUser(int uId) {
		// TODO Auto-generated method stub
		int totalPrice = 0;
		List<Cart> carts = new ArrayList<Cart>();
		UserTable user = (UserTable)this.entityManager.find(UserTable.class, uId);
		System.out.println("User is :"+user);
		String q = "from CartTable where userTable=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", user);
		List<CartTable> cartTables = query.getResultList();
		//System.out.println("Cart values are :"+query.getResultList().toString());
		for(CartTable c : cartTables)
		{
			int cId = c.getCId();
			int pId = c.getProductTable().getPId();
			int cQty = c.getProductTable().getPQty()>=c.getCQty() ? c.getCQty() : 0;
			String pName = c.getProductTable().getPName();
			String pBrand = c.getProductTable().getPBrand();
			int pPrice = c.getProductTable().getPPrice();
			totalPrice += pPrice*cQty;
			String pImage1 = c.getProductTable().getPImage1();
			carts.add(new Cart(pId,cQty,pName,pBrand,pPrice,cId,totalPrice,pImage1));
		}
		return carts;
	}

	@Override
	public List<Wishlist> getWishlistOfUser(int uId) {
		// TODO Auto-generated method stub
		List<Wishlist> wishlists = new ArrayList<Wishlist>();
		UserTable user = (UserTable)this.entityManager.find(UserTable.class, uId);
		System.out.println("User is :"+user);
		String q = "from WishlistTable where userTable=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", user);
		List<WishlistTable> wishlistTables = query.getResultList();
		//System.out.println("Cart values are :"+query.getResultList().toString());
		for(WishlistTable w : wishlistTables)
		{
			int wId = w.getWId();
			int pId = w.getProductTable().getPId();
			String pName = w.getProductTable().getPName();
			String pBrand = w.getProductTable().getPBrand();
			int pPrice = w.getProductTable().getPPrice();
			String pImage1 = w.getProductTable().getPImage1();
			wishlists.add(new Wishlist(pId,pName,pBrand,pPrice,wId,pImage1));
		}
		return wishlists;
	}
	
	@Override
	@Transactional
	public int addUser(UserSignUp newUser)
	{
		UserTable user = new UserTable();
		user.setUName(newUser.getuName());
		user.setUPassword(newUser.getuPassword());
		user.setUAddress(newUser.getuAddress());
		user.setUEmail(newUser.getuEmail());
		user.setUMobile(newUser.getuPhone());
		this.entityManager.persist(user);
		String q1 = "select max(u_id) from user_table";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number id = (Number) query1.getSingleResult();
		int uId = id.intValue();
		return uId;
	}

	@Override
	@Transactional
	public UserTable updateUser(UpdateUser updateUser) {
		// TODO Auto-generated method stub
		int uId = updateUser.getuId();
		UserTable existingUser = this.entityManager.find(UserTable.class, uId);
		existingUser.setUName(updateUser.getuName());
		existingUser.setUPassword(updateUser.getuPassword());
		existingUser.setUAddress(updateUser.getuAddress());
		existingUser.setUEmail(updateUser.getuEmail());
		existingUser.setUMobile(updateUser.getuPhone());
		this.entityManager.merge(existingUser);
		return existingUser;
	}

	@Override
	public int generateOTP(String uId) {
		//UserTable user = this.entityManager.find(UserTable.class,uId);
		String subject="Register Successful";
		String email = uId;
		int otp =otprepository.addOtp();
		String otps = String.valueOf(otp);
		emailService.sendEmailForOTP(email, otps, subject);
		System.out.println("email sent");
		return otp;
	}

}
