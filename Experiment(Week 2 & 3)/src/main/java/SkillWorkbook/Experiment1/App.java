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

        StandardServiceRegistry ssr =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();

        // Insert items
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

        // Retrieve product using ID
        Query q = s.createQuery("FROM Product where id = 1");
        List<Product> list = q.list();
        for (Product p : list) {
            System.out.println(
                "Id :" + p.getId() +
                "\nName :" + p.getName() +
                "\nDescription :" + p.getDescription() +
                "\nPrice :" + p.getPrice() +
                "\nQuantity :" + p.getQuatity()
            );
        }

        // Update quantity
        Transaction t1 = s.beginTransaction();
        Product p6 = s.find(Product.class, 5);
        if (p6 != null) {
            System.out.println("Before updation quantity: " + p6.getQuatity());
            p6.setQuatity(10);
            System.out.println("After updation quantity: " + p6.getQuatity());
        }
        t1.commit();

        // Delete product
        Transaction t2 = s.beginTransaction();
        Product p7 = s.find(Product.class, 11);
        if (p7 != null) {
            s.delete(p7);
            System.out.println("Item deleted successfully");
        }
        t2.commit();

        // HQL sort by price
        Query q1 = s.createQuery("FROM Product p ORDER BY p.price DESC");
        List<Product> list1 = q1.list();
        for (Product p : list1) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        // Sort by quantity
        Query q2 = s.createQuery("FROM Product p ORDER BY p.quatity DESC");
        List<Product> list2 = q2.list();
        for (Product p : list2) {
            System.out.println(p.getName() + " " + p.getQuatity());
        }

        // Pagination
        Query q3 = s.createQuery("FROM Product p ORDER BY p.id");
        q3.setFirstResult(0);
        q3.setMaxResults(3);
        List<Product> list3 = q3.list();
        System.out.println("First 3 products");
        for (Product p : list3) {
            System.out.println(p.getName());
        }

        Query q4 = s.createQuery("FROM Product p ORDER BY p.id");
        q4.setFirstResult(3);
        q4.setMaxResults(3);
        List<Product> list4 = q4.list();
        System.out.println("Next 3 products");
        for (Product p : list4) {
            System.out.println(p.getName());
        }

        // Aggregation
        Query q5 = s.createQuery("SELECT COUNT(p) FROM Product p");
        long count = (long) q5.uniqueResult();
        System.out.println("Total products: " + count);

        Query q6 = s.createQuery("SELECT MIN(p.price) FROM Product p");
        double min = (double) q6.uniqueResult();
        System.out.println("Min price: " + min);

        Query q7 = s.createQuery("SELECT MAX(p.price) FROM Product p");
        double max = (double) q7.uniqueResult();
        System.out.println("Max price: " + max);

        // Between
        Query q8 = s.createQuery("FROM Product p WHERE p.price BETWEEN 1000 AND 5000");
        List<Product> list5 = q8.list();
        for (Product p : list5)
            System.out.println(p.getName() + " " + p.getPrice());

        // Like
        Query q9 = s.createQuery("FROM Product p WHERE p.name LIKE 'A%'");
        List<Product> list6 = q9.list();
        for (Product p : list6)
            System.out.println(p.getName());

        s.close();
        sf.close();
    }
}
