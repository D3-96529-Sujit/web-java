package com.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entities.Product;
import com.app.utils.HibernateUtils;
public class ProductDaoImpl implements ProductDao {
	
	@Override
	
	public String addProduct(Product product)
	{
		String msg = "Product added failed";
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try
		{
			session.persist(product);
			
			tx.commit();
			
			msg = "Product added success id" +product.getProductId();
		}catch (Exception e )
		{
			if (tx !=null)
				tx.rollback();
			
			e.printStackTrace();
		}
		return msg;
	}
	
	@Override
	public Product getProductDetails(Long productId)
	{
		Product product = null;
		
		Session session = HibernateUtils.getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		
		try {
			product = session.get(Product.class, productId);
			
			tx.commit();
		}catch (Exception e)
		{
			if (tx != null)
				tx.rollback();
			
			e.printStackTrace();
		}
		
		return product;
	}
	

}
