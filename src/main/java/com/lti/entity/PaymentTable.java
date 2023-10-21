package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the PAYMENT_TABLE database table.
 * 
 */
@Entity
@Table(name="PAYMENT_TABLE")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","orderTables"})
public class PaymentTable implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="PAY_ID")
	private int payId;

	@Column(name="PAY_TYPE" , length=50)
	private String payType;

	//bi-directional many-to-one association to OrderTable
	@OneToMany(mappedBy="paymentTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL) //this is OneToOne actually!
	private List<OrderTable> orderTables;

	public PaymentTable() {
	}

	public int getPayId() {
		return this.payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public List<OrderTable> getOrderTables() {
		return this.orderTables;
	}

	public void setOrderTables(List<OrderTable> orderTables) {
		this.orderTables = orderTables;
	}

	public OrderTable addOrderTable(OrderTable orderTable) {
		getOrderTables().add(orderTable);
		orderTable.setPaymentTable(this);

		return orderTable;
	}

	public OrderTable removeOrderTable(OrderTable orderTable) {
		getOrderTables().remove(orderTable);
		orderTable.setPaymentTable(null);

		return orderTable;
	}

}