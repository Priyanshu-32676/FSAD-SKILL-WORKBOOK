package SkillWorkbook.Experiment1;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class App {
    public static void main(String[] args) {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory sf = md.getSessionFactoryBuilder().build();
    	Session s = sf.openSession();
    	Transaction t; 
    	
    	t = s.beginTransaction();
    	
   // 	Insert the items
    	Product p1 = new Product();
    	p1.setName("washing Machine");
    	p1.setDescription("Electronics Item");
    	p1.setPrice(20000.0);
    	p1.setQuatity(5);
    	
    	s.save(p1);
    	
    	Product p2 = new Product();
    	p2.setName("Refrigerator");
    	p2.setDescription("Electronics item");
    	p2.setPrice(75000);
    	p2.setQuatity(4);
    	
    	s.save(p2);
    	
    	Product p3 = new Product();
    	p3.setName("Microwave");
    	p3.setDescription("Electronics item");
    	p3.setPrice(65000);
    	p3.setQuatity(2);
    	
    	s.save(p3);
    	
    	Product p4 = new Product();
    	p4.setName("TV");
    	p4.setDescription("Electronics item");
    	p4.setPrice(35000);
    	p4.setQuatity(1);
    	
    	s.save(p4);
    	
     	Product p5 = new Product();
   	    p5.setName("Mixer");
    	p5.setDescription("Electronics item");
    	p5.setPrice(7000);
    	p5.setQuatity(4);
    	
    	s.save(p5);
    	
   	
   	t.commit();
    	System.out.println("Data inserted successfully");
    	
//    	Retrieve the product using Id
    	
    	Query q = s.createQuery("FROM Product where id =1");
    	List<Product> list = q.list();
    	for(Product p:list) {
    		System.out.println("id :"+p.getId()+"\n Name :"+p.getName()+"\n Description :"+p.getDescription()+
    		         "Price :" +p.getPrice()+"\n Quantity :"+p.getQuatity());
    	}
    	
//    	Update the product quantity
    	Product p6 = s.find(Product.class, 5);
    	System.out.println("Before updation, The total quantity of product whose id is 5 is :"+p6.getQuatity());
    	p6.setQuatity(10);
    	System.out.println("After updation, The total quantity of product whose id is 5 is :"+p6.getQuatity());
    	System.out.println("Quantity updated successfully");
    	
    	
//    	Delete the product by its ID
    	Product p7 = s.find(Product.class, 11);
    	    s.delete(p7);
    	    System.out.println("Item deleted successfully");
    	
    	 
    	

    }
}
