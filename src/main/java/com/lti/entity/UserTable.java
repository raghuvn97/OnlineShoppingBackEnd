package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the USER_TABLE database table.
 * 
 */
@Entity
@Table(name="USER_TABLE")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cartTables","orderTables","wishlistTables"})
public class UserTable implements Serializable {

	

	@Id
	@SequenceGenerator(name="seq_user",initialValue=1111,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user")
	@Column(name="U_ID")
	private int uId;

	@Column(name="U_ADDRESS", length=50)
	private String uAddress;

	@Column(name="U_EMAIL", length=50)
	private String uEmail;

	@Column(name="U_MOBILE")
	private long uMobile;

	@Column(name="U_NAME", length=50)
	private String uName;

	@Column(name="U_PASSWORD", length=50)
	private String uPassword;

	//bi-directional many-to-one association to CartTable
	@OneToMany(mappedBy="userTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CartTable> cartTables;

	//bi-directional many-to-one association to OrderTable
	@OneToMany(mappedBy="userTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<OrderTable> orderTables;

	//bi-directional many-to-one association to WishlistTable
	@OneToMany(mappedBy="userTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<WishlistTable> wishlistTables;

	public UserTable() {
	}

	public int getUId() {
		return this.uId;
	}

	public void setUId(int uId) {
		this.uId = uId;
	}

	public String getUAddress() {
		return this.uAddress;
	}

	public void setUAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getUEmail() {
		return this.uEmail;
	}

	public void setUEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public long getUMobile() {
		return this.uMobile;
	}

	public void setUMobile(long uMobile) {
		this.uMobile = uMobile;
	}

	public String getUName() {
		return this.uName;
	}

	public void setUName(String uName) {
		this.uName = uName;
	}

	public String getUPassword() {
		return this.uPassword;
	}

	public void setUPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public List<CartTable> getCartTables() {
		return this.cartTables;
	}

	public void setCartTables(List<CartTable> cartTables) {
		this.cartTables = cartTables;
	}

	public CartTable addCartTable(CartTable cartTable) {
		getCartTables().add(cartTable);
		cartTable.setUserTable(this);

		return cartTable;
	}

	public CartTable removeCartTable(CartTable cartTable) {
		getCartTables().remove(cartTable);
		cartTable.setUserTable(null);

		return cartTable;
	}

	public List<OrderTable> getOrderTables() {
		return this.orderTables;
	}

	public void setOrderTables(List<OrderTable> orderTables) {
		this.orderTables = orderTables;
	}

	public OrderTable addOrderTable(OrderTable orderTable) {
		getOrderTables().add(orderTable);
		orderTable.setUserTable(this);

		return orderTable;
	}

	public OrderTable removeOrderTable(OrderTable orderTable) {
		getOrderTables().remove(orderTable);
		orderTable.setUserTable(null);

		return orderTable;
	}

	public List<WishlistTable> getWishlistTables() {
		return this.wishlistTables;
	}

	public void setWishlistTables(List<WishlistTable> wishlistTables) {
		this.wishlistTables = wishlistTables;
	}

	public WishlistTable addWishlistTable(WishlistTable wishlistTable) {
		getWishlistTables().add(wishlistTable);
		wishlistTable.setUserTable(this);

		return wishlistTable;
	}

	public WishlistTable removeWishlistTable(WishlistTable wishlistTable) {
		getWishlistTables().remove(wishlistTable);
		wishlistTable.setUserTable(null);

		return wishlistTable;
	}

	@Override
	public String toString() {
		return "UserTable [uId=" + uId + ", uAddress=" + uAddress + ", uEmail=" + uEmail + ", uMobile=" + uMobile
				+ ", uName=" + uName + ", uPassword=" + uPassword + "]";
	}
}