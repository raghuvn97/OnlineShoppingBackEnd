package com.lti.repository;

import com.lti.exception.CartException;
import com.lti.exception.WishlistException;

public interface WishlistRepository {
	public boolean addToWishlist(int uId, int pId);
	public boolean deleteWishlist(int wId) throws WishlistException;
}
