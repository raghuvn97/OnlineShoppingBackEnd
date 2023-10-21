package com.lti.repository;

import com.lti.exception.CartException;

public interface CartRepository {
	public boolean addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cId) throws CartException;
}
