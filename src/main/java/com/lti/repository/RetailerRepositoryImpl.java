package com.lti.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.AddProduct;
import com.lti.dto.Login;
import com.lti.dto.Product;
import com.lti.dto.RetailerSignUp;
import com.lti.entity.AdminTable;
import com.lti.entity.ProductTable;
import com.lti.entity.RetailerTable;
import com.lti.exception.CustomerException;
import com.lti.service.EmailService;

@Repository

public class RetailerRepositoryImpl implements RetailerRepository {


	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EmailService emailService;
	
	private final int aId = 1;
	
	@Override
	public RetailerTable getRetailerByEmail(String email) throws CustomerException{
		// TODO Auto-generated method stub
		String query = "from RetailerTable where rEmail=:x";
		RetailerTable user = null;
		Query q = null;
		try
		{
			q = (Query) this.entityManager.createQuery(query);
			q.setParameter("x", email);
			user = (RetailerTable)q.getSingleResult();
		}
		catch(NonUniqueResultException e)
		{
			return null;
		}
		catch(Exception e)
		{
			throw new CustomerException("Customer Not Exists");
		}
		
		return user;
	}
	
	@Override
	public int getRetailerByEmailAndPassword(String email, String password) throws CustomerException{
		// TODO Auto-generated method stub
		Query q = null;
		try
		{
			String query = "select rId from RetailerTable where rEmail=:x and rPassword=:y";
			q = (Query) this.entityManager.createQuery(query);
			q.setParameter("x", email);
			q.setParameter("y", password);
			System.out.println("Result is :"+q.getSingleResult());
		}
		catch(Exception e)
		{
			throw new CustomerException("Retailer Not Found");
		}
		return (int)q.getSingleResult();
	}
	
	@Override
	@Transactional
	public int addRetailer(RetailerSignUp newRetailer) {
		// TODO Auto-generated method stub
		AdminTable admin = this.entityManager.find(AdminTable.class,this.aId);
		System.out.println(admin);
		RetailerTable user = new RetailerTable();
		user.setRName(newRetailer.getuName());
		user.setRPassword(newRetailer.getuPassword());
		user.setREmail(newRetailer.getuEmail());
		user.setRMobile(newRetailer.getuPhone());
		user.setAdminTable(admin);
		this.entityManager.persist(user);
		String q1 = "select max(r_id) from retailer_table";
		Query query1 = (Query) this.entityManager.createNativeQuery(q1);
		Number id = (Number) query1.getSingleResult();
		int uId = id.intValue();
		Login login = new Login();
		login.setEmail(newRetailer.getuEmail());
		login.setPassword(newRetailer.getuPassword());
		System.out.println(newRetailer.getuEmail()+" "+newRetailer.getuPassword());
		emailService.sendEmailForRetailerAdd(login,"You have been added on our shopping hub.Welcome to BuyZaar..!!");
		System.out.println(user);
		return uId;
	}



	@Override
	@Transactional
	public int addProduct(AddProduct product, int rId) {
		// TODO Auto-generated method stub
		RetailerTable retailer = this.entityManager.find(RetailerTable.class, rId);
		ProductTable productTable = new ProductTable();
		productTable.setPName(product.getpName());
		productTable.setPBrand(product.getpBrand());
		productTable.setPCategory(product.getpCategory());
		productTable.setPDescription(product.getpDescription());
		productTable.setPSubCategory(product.getpSubCategory());
		productTable.setPPrice(product.getpPrice());
		productTable.setPQty(product.getpQty());
		productTable.setApprove_status(0);
		productTable.setRetailerTable(retailer);
		this.entityManager.persist(productTable);
		return productTable.getPId();
	}


	@Override
	@Transactional
	public RetailerTable updateRetailer(RetailerSignUp updateRetailer) {
		// TODO Auto-generated method stub
		RetailerTable oldRetailer = this.entityManager.find(RetailerTable.class, updateRetailer.getrId());
		oldRetailer.setRName(updateRetailer.getuName());
		oldRetailer.setRPassword(updateRetailer.getuPassword());
		oldRetailer.setREmail(updateRetailer.getuEmail());
		oldRetailer.setRMobile(updateRetailer.getuPhone());
		this.entityManager.merge(oldRetailer);
		return oldRetailer;
	}


	@Override
	@Transactional
	public AddProduct updateProduct(AddProduct updateProduct, int pId) {
		// TODO Auto-generated method stub
		ProductTable oldProduct = this.entityManager.find(ProductTable.class, pId);
		oldProduct.setPName(updateProduct.getpName());
		oldProduct.setPImage1(updateProduct.getpImage1());
		oldProduct.setPImage2(updateProduct.getpImage2());
		oldProduct.setPImage3(updateProduct.getpImage3());
		oldProduct.setPImage4(updateProduct.getpImage4());
		oldProduct.setPBrand(updateProduct.getpBrand());
		oldProduct.setPCategory(updateProduct.getpCategory());
		oldProduct.setPDescription(updateProduct.getpDescription());
		oldProduct.setPSubCategory(updateProduct.getpSubCategory());
		oldProduct.setPPrice(updateProduct.getpPrice());
		oldProduct.setPQty(updateProduct.getpQty());
		oldProduct.setApprove_status(0);
		this.entityManager.merge(oldProduct);
		return updateProduct;
	}


	@Override
	public List<Product> showMyProducts(int rId) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		RetailerTable retailer = this.entityManager.find(RetailerTable.class, rId);
		String q = "from ProductTable where retailerTable=:x";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", retailer);
		List<ProductTable> productTables = query.getResultList();
		for(ProductTable p : productTables)
		{
			String pImage1 = p.getPImage1();
			String pImage2 = p.getPImage2();
			String pImage3 = p.getPImage3();
			String pImage4 = p.getPImage4();
			String pDescription = p.getPDescription();
			int pId = p.getPId();
			String pName = p.getPName();
			String pBrand = p.getPBrand();
			int pPrice = p.getPPrice();
			products.add(new Product(pImage1, pImage2, pImage3, pImage4, pDescription, pId, pName, pBrand, pPrice));
		}
		return products;
	}

	@Override
	public List<RetailerSignUp> showAllRetailers() {
		// TODO Auto-generated method stub
		List<RetailerSignUp> retailers = new ArrayList<RetailerSignUp>();
		List<RetailerTable> retailerTables = this.entityManager.find(AdminTable.class, 1).getRetailerTables();
		for(RetailerTable r : retailerTables)
		{
			int rId = r.getRId();
			String rName = r.getRName();
			String rPassword = r.getRPassword();
			String rEmail = r.getREmail();
			long rPhone = r.getRMobile();
			retailers.add(new RetailerSignUp(rName, rEmail, rPassword, rPhone, rId));
		}
		return retailers;
	}

	@Override
	public RetailerSignUp getRetailerById(int rId) {
		// TODO Auto-generated method stub
		RetailerTable r = this.entityManager.find(RetailerTable.class, rId);
		String rName = r.getRName();
		String rPassword = r.getRPassword();
		String rEmail = r.getREmail();
		long rPhone = r.getRMobile();
		RetailerSignUp actualRetailer = new RetailerSignUp(rName, rEmail, rPassword, rPhone, rId);
		return actualRetailer;
	}

	@Override
	@Transactional
	public boolean deleteRetailer(int rId) {
		RetailerTable retailer = this.entityManager.find(RetailerTable.class, rId);
		this.entityManager.remove(retailer);
		return true;
	}

	@Override
	@Transactional
	public boolean updateProductPic(int pId, String newFileName1,String newFileName2,String newFileName3,String newFileName4) {
		// TODO Auto-generated method stub
		ProductTable product=this.entityManager.find(ProductTable.class, pId);
		product.setPImage1(newFileName1);
		product.setPImage2(newFileName2);
		product.setPImage3(newFileName3);
        product.setPImage4(newFileName4);
        this.entityManager.merge(product);
        return true;
		
	}

	

}
