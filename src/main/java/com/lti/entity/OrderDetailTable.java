package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ORDER_DETAIL_TABLE database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAIL_TABLE")
public class OrderDetailTable implements Serializable {


	@Id
	@SequenceGenerator(name = "seq_orderDetails", initialValue = 2301, allocationSize = 1) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orderDetails")
	@Column(name="OD_ID")
	private int odId;

	@Temporal(TemporalType.DATE)
	@Column(name="OD_DELIEVERY_DATE")
	private Date odDelieveryDate;

	@Column(name="OD_PRICE")
	private int odPrice;

	@Temporal(TemporalType.DATE)
	@Column(name="OD_PURCHASE_DATE")
	private Date odPurchaseDate;

	@Column(name="OD_QTY")
	private int odQty;

	//bi-directional many-to-one association to OrderTable
	@ManyToOne
	@JoinColumn(name="O_ID")
	private OrderTable orderTable;

	//bi-directional many-to-one association to ProductTable
	@ManyToOne
	@JoinColumn(name="P_ID")
	private ProductTable productTable;

	public OrderDetailTable() {
	}

	public int getOdId() {
		return this.odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public Date getOdDelieveryDate() {
		return this.odDelieveryDate;
	}

	public void setOdDelieveryDate(Date odDelieveryDate) {
		this.odDelieveryDate = odDelieveryDate;
	}

	public int getOdPrice() {
		return this.odPrice;
	}

	public void setOdPrice(int odPrice) {
		this.odPrice = odPrice;
	}

	public Date getOdPurchaseDate() {
		return this.odPurchaseDate;
	}

	public void setOdPurchaseDate(Date odPurchaseDate) {
		this.odPurchaseDate = odPurchaseDate;
	}

	public int getOdQty() {
		return this.odQty;
	}

	public void setOdQty(int odQty) {
		this.odQty = odQty;
	}

	public OrderTable getOrderTable() {
		return this.orderTable;
	}

	public void setOrderTable(OrderTable orderTable) {
		this.orderTable = orderTable;
	}

	public ProductTable getProductTable() {
		return this.productTable;
	}

	public void setProductTable(ProductTable productTable) {
		this.productTable = productTable;
	}

}