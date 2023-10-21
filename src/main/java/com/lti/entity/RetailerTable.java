package com.lti.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the RETAILER_TABLE database table.
 * 
 */
@Entity
@Table(name="RETAILER_TABLE")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productTables"})
public class RetailerTable implements Serializable {

	@Id
	@SequenceGenerator(name = "seq_retailer",initialValue = 9001,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_retailer")
	@Column(name="R_ID")
	private int rId;

	@Column(name="R_EMAIL", length=50)
	private String rEmail;

	@Column(name="R_MOBILE")
	private long rMobile;

	@Column(name="R_NAME", length=50)
	private String rName;

	@Column(name="R_PASSWORD", length=50)
	private String rPassword;

	//bi-directional many-to-one association to ProductTable
	@OneToMany(mappedBy="retailerTable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ProductTable> productTables;

	//bi-directional many-to-one association to AdminTable
	@ManyToOne
	@JoinColumn(name="A_ID")
	private AdminTable adminTable;

	public RetailerTable() {
	}

	public int getRId() {
		return this.rId;
	}

	public void setRId(int rId) {
		this.rId = rId;
	}

	public String getREmail() {
		return this.rEmail;
	}

	public void setREmail(String rEmail) {
		this.rEmail = rEmail;
	}

	public long getRMobile() {
		return this.rMobile;
	}

	public void setRMobile(long rMobile) {
		this.rMobile = rMobile;
	}

	public String getRName() {
		return this.rName;
	}

	public void setRName(String rName) {
		this.rName = rName;
	}

	public String getRPassword() {
		return this.rPassword;
	}

	public void setRPassword(String rPassword) {
		this.rPassword = rPassword;
	}

	public List<ProductTable> getProductTables() {
		return this.productTables;
	}

	public void setProductTables(List<ProductTable> productTables) {
		this.productTables = productTables;
	}

	public ProductTable addProductTable(ProductTable productTable) {
		getProductTables().add(productTable);
		productTable.setRetailerTable(this);

		return productTable;
	}

	public ProductTable removeProductTable(ProductTable productTable) {
		getProductTables().remove(productTable);
		productTable.setRetailerTable(null);

		return productTable;
	}

	public AdminTable getAdminTable() {
		return this.adminTable;
	}

	public void setAdminTable(AdminTable adminTable) {
		this.adminTable = adminTable;
	}

}