package com.lti.exception;

public class WishlistException extends Exception {
	private static final long serialVersionUID = 1L;

	public WishlistException(String message)
	{
		super("WishlistException :"+message);
	}
}
