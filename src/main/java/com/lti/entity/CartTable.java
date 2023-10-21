package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CART_TABLE database table.
 * 
 */
@Entity
@Table(name="CART_TABLE")
public class CartTable implements Serializable {

	@Id
	@SequenceGenerator(name = "sequence_cart", initialValue = 801, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cart")
	@Column(name="C_ID")
	private int cId;

	@Column(name="C_QTY")
	private int cQty;

	//bi-directional many-to-one association to ProductTable
	@ManyToOne
	@JoinColumn(name="P_ID")
	private ProductTable productTable;

	//bi-directional many-to-one association to UserTable
	@ManyToOne
	@JoinColumn(name="U_ID")
	private UserTable userTable;

	public CartTable() {
	}

	public int getCId() {
		return this.cId;
	}

	public void setCId(int cId) {
		this.cId = cId;
	}

	public int getCQty() {
		return this.cQty;
	}

	public void setCQty(int cQty) {
		this.cQty = cQty;
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