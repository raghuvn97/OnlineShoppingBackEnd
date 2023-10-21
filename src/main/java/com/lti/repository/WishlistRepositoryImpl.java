package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.CartTable;
import com.lti.entity.ProductTable;
import com.lti.entity.UserTable;
import com.lti.entity.WishlistTable;
import com.lti.exception.CartException;
import com.lti.exception.WishlistException;

@Repository
public class WishlistRepositoryImpl implements WishlistRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean addToWishlist(int uId, int pId)
	{
		UserTable user = 	   this.entityManager.find(UserTable.class, uId);
		ProductTable product = this.entityManager.find(ProductTable.class, pId);
		WishlistTable wishlist = new WishlistTable();
		wishlist.setUserTable(user);
		wishlist.setProductTable(product);
		this.entityManager.persist(wishlist);
		return true;
	}
	
	
	@Override
	@Transactional
	public boolean deleteWishlist(int wId) throws WishlistException
	{
		WishlistTable cart = this.entityManager.find(WishlistTable.class, wId);
		this.entityManager.remove(cart);
		return true;
	}
}
