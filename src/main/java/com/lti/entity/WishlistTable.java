package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WISHLIST_TABLE database table.
 * 
 */
@Entity
@Table(name="WISHLIST_TABLE")
public class WishlistTable implements Serializable {
	

	@Id
	@SequenceGenerator(name = "seq_wishlist", initialValue = 301, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_wishlist")
	@Column(name="W_ID")
	private int wId;

	//bi-directional many-to-one association to ProductTable
	@ManyToOne
	@JoinColumn(name="P_ID")
	private ProductTable productTable;

	//bi-directional many-to-one association to UserTable
	@ManyToOne
	@JoinColumn(name="U_ID")
	private UserTable userTable;

	public WishlistTable() {
	}

	public int getWId() {
		return this.wId;
	}

	public void setWId(int wId) {
		this.wId = wId;
	}

	public ProductTable getProductTable() {
		return this.productTable;
	}

	public void setProductTable(ProductTable productTable) {
		this.productTable = productTable;
	}

	public UserTable getUserTable() {
		return this.userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

}