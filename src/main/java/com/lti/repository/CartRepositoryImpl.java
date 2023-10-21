package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.CartTable;
import com.lti.entity.ProductTable;
import com.lti.entity.UserTable;
import com.lti.exception.CartException;

@Repository
public class CartRepositoryImpl implements CartRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public boolean addToCart(int uId, int pId)
	{
		UserTable user = 	   this.entityManager.find(UserTable.class, uId);
		ProductTable product = this.entityManager.find(ProductTable.class, pId);
		CartTable cart = new CartTable();
		cart.setCQty(1); //by default set qty as 1
		cart.setUserTable(user);
		cart.setProductTable(product);
		this.entityManager.persist(cart);
		return true;
	}
	
	@Override
	@Transactional
	public boolean updateCart(int cId, int addOrMinus)
	{
		if(addOrMinus==1)
		{
			CartTable cart = this.entityManager.find(CartTable.class, cId);
			int productQty = cart.getProductTable().getPQty();
			if(cart.getCQty()+1 <= productQty)
			{
				//update it!
				int oldQty = cart.getCQty();
				int newQty = oldQty+1;
				cart.setCQty(newQty);
				this.entityManager.merge(cart);
				return true;
			}
			return false;
		}
		else
		{
			CartTable cart = this.entityManager.find(CartTable.class, cId);
			if(cart.getCQty()-1 >= 1)
			{
				//update it!
				int oldQty = cart.getCQty();
				int newQty = oldQty-1;
				cart.setCQty(newQty);
				this.entityManager.merge(cart);
				return true;
			}
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean deleteCart(int cId) throws CartException
	{
		CartTable cart = this.entityManager.find(CartTable.class, cId);
		this.entityManager.remove(cart);
		return true;
	}
	
}
