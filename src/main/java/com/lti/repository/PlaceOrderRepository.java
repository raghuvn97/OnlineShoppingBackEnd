package com.lti.repository;

import java.util.List;

import com.lti.dto.Cart;
import com.lti.dto.PlacedOrder;

public interface PlaceOrderRepository {
	public boolean placeOrder(List<Cart> carts, String payType);
	public List<PlacedOrder> showPlacedOrders(int uId);
}
