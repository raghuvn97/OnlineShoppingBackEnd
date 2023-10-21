package com.lti.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dto.Product;
import com.lti.entity.ProductTable;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Product getProductById(int pId) {
		// TODO Auto-generated method stub
		Product product = null;
		ProductTable productTable = entityManager.find(ProductTable.class, pId);
		String q = "select pImage1,pId,pName,pBrand,pPrice,pImage2,pImage3,pImage4,pDescription from ProductTable where pId=:x and approve_status=:productapprove";
		Query query = (Query)this.entityManager.createQuery(q);
		query.setParameter("x", pId);
		query.setParameter("productapprove", productTable.getApprove_status());
		List<Object []> pro = query.getResultList();
		for(Object [] p : pro)
		{
			System.out.println("Products :"+p[0]+p[1]+Arrays.toString(p));
			String pImage1 = (String) p[0];
			String pName = 	(String) p[2];
			String pBrand = (String) p[3];
			int pPrice =  Integer.parseInt(String.valueOf(p[4]));
			String pImage2 = (String) p[5];
			String pImage3 = (String) p[6];
			String pImage4 = (String) p[7];
			String pDescription = (String) p[8];
			product = new Product(pImage1,pImage2,pImage3,pImage4,pDescription,pId,pName,pBrand,pPrice);
		}
		return product;
		//return this.entityManager.find(ProductTable.class,pId); //for testing
	}

	@Override
	public List<Product> getProductBySearchKeyWord(String keyword) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		String query = "from ProductTable where approve_status=:productapprove and (pBrand=:x or pCategory=:x or pName like :y) ";
		Query q = (Query)this.entityManager.createQuery(query);
		q.setParameter("productapprove", 1);
		q.setParameter("x",keyword);
		q.setParameter("y", "%"+keyword+"%");
		
		List<ProductTable> productTables = q.getResultList();
		for(ProductTable p : productTables)
		{
			int pId = p.getPId();
			String pImage1 = p.getPImage1();
			String pName = p.getPName();
			String pBrand = p.getPBrand();
			int pPrice = p.getPPrice();
			String pImage2 = p.getPImage2();
			String pImage3 = p.getPImage3();
			String pImage4 = p.getPImage4();
			String pDescription = p.getPDescription();
			int papprove_status = p.getApprove_status();
			products.add(new Product(pImage1,pImage2,pImage3,pImage4,pDescription,pId,pName,pBrand,pPrice));
		}
		return products;
	}

	

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		String query = "select p from ProductTable p where p.approve_status=:productapprove";
		Query q = (Query)this.entityManager.createQuery(query);
		q.setParameter("productapprove", 0);
		List<ProductTable> productTables = q.getResultList();
		for(ProductTable p : productTables)
		{
			int pId = p.getPId();
			String pImage1 = p.getPImage1();
			String pName = p.getPName();
			String pBrand = p.getPBrand();
			int pPrice = p.getPPrice();
			String pImage2 = p.getPImage2();
			String pImage3 = p.getPImage3();
			String pImage4 = p.getPImage4();
			String pDescription = p.getPDescription();
			products.add(new Product(pImage1,pImage2,pImage3,pImage4,pDescription,pId,pName,pBrand,pPrice));
		}
		return products;
	}
		//return this.entityManager.find(ProductTable.class,pId); //for testing

	
	@Override
	public List<Product> sortProduct(String by, int order) {
		// TODO Auto-generated method stub
		//1 is for ascending and 0 is for descending
		//ProductTable productTable = 
		List<Product> products = new ArrayList<Product>();
		Query query = null;
		if(order==1 && by.equalsIgnoreCase("price"))
		{	
			String commonQuery = "from ProductTable where approve_status=:productapprove order by pPrice asc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
			query.setParameter("productapprove", 1);
		}
		else if(order==0 && by.equalsIgnoreCase("price"))
		{
			String commonQuery = "from ProductTable where approve_status=:productapprove order by pPrice desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
			query.setParameter("productapprove", 1);
		}
		else if(order==1 && by.equalsIgnoreCase("brand"))
		{
			String commonQuery = "from ProductTable where approve_status=:productapprove order by pBrand asc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
			query.setParameter("productapprove", 1);
		}
		else if(order==0 && by.equalsIgnoreCase("brand"))
		{
			String commonQuery = "from ProductTable  where approve_status=:productapprove order by pBrand desc ";
			query = (Query)this.entityManager.createQuery(commonQuery);
			query.setParameter("productapprove", 1);
		}
		List<ProductTable> pro = query.getResultList();
		for(ProductTable  p : pro)
		{
			int pId = 		 p.getPId();
			String pImage1 =  p.getPImage1();
			String pName = 	 p.getPName();
			String pBrand =  p.getPBrand();
			int pPrice =  	 p.getPPrice();
			String pImage2 = p.getPImage2();
			String pImage3 = p.getPImage3();
			String pImage4 = p.getPImage4();
			String pDescription = p.getPDescription();
			products.add(new Product(pImage1,pImage2,pImage3,pImage4,pDescription,pId,pName,pBrand,pPrice));
		}
		return products;
	}

	@Override
	public List<Product> filterProduct(String brand, int s, int e) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<Product>();
		if(s==0 && e==0)
		{
			System.out.println("Filtering By Brand");
			String q = "from ProductTable where pBrand=:x and approve_status=:productapprove";
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("x", brand);
			query.setParameter("productapprove", 1);
			List<ProductTable> pro = query.getResultList();
			for(ProductTable  p : pro)
			{
				int pId = 		 p.getPId();
				String pImage1 =  p.getPImage1();
				String pName = 	 p.getPName();
				String pBrand =  p.getPBrand();
				int pPrice =  	 p.getPPrice();
				String pImage2 = p.getPImage2();
				String pImage3 = p.getPImage3();
				String pImage4 = p.getPImage4();
				String pDescription = p.getPDescription();
				products.add(new Product(pImage1,pImage2,pImage3,pImage4,pDescription,pId,pName,pBrand,pPrice));
			}
		}
		else
		{
			System.out.println("Filtering By Range");
			String q = "from ProductTable where pBrand=:z and approve_status=:productapprove and pPrice between :x and :y ";
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("z", brand);
			query.setParameter("x", s);
			query.setParameter("y", e);
			query.setParameter("productapprove", 1);
			List<ProductTable> pro = query.getResultList();
			for(ProductTable  p : pro)
			{
				int pId = 		 p.getPId();
				String pImage1 =  p.getPImage1();
				String pName = 	 p.getPName();
				String pBrand =  p.getPBrand();
				int pPrice =  	 p.getPPrice();
				String pImage2 = p.getPImage2();
				String pImage3 = p.getPImage3();
				String pImage4 = p.getPImage4();
				String pDescription = p.getPDescription();
				products.add(new Product(pImage1,pImage2,pImage3,pImage4,pDescription,pId,pName,pBrand,pPrice));
			}
		}
		return products;
	}

	@Override
	@Transactional
	public boolean deleteProduct(int pId) {
		ProductTable product = this.entityManager.find(ProductTable.class, pId);
		this.entityManager.remove(product);
		return true;
	}

}
