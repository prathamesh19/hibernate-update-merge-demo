package com.prathamesh.hibernate.hibernatedemowithannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestProductInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*------------update() and merge() demonstration example-------------*/

		Product p1 = new Product(101, "mobile", 10000);

		SessionFactory sf = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
		// Session session=new
		// Configuration().configure("/hibernate.cfg.xml").buildSessionFactory().getCurrentSession();
		Session session1 = sf.openSession();
		Transaction tr1 = session1.beginTransaction();
		session1.save(p1);// mem --- mobile, DB---- mobile
		session1.flush();
		tr1.commit();
		session1.close();// mem --- mobile, DB---- mobile

		p1.setProdName("dddddd");
		System.out.println(p1);// mem---dddddd, DB----mobile

		Session session2 = sf.openSession();
		Transaction tr2 = session2.beginTransaction();
		Product p2 = session2.get(Product.class, 101);
		// System.out.println(p2);//mem---mobile
		// session2.update(p1);//mem---dddddd
		// DB----mobile-----NonUniqueObjectException
		// session2.update(p2);//Works fine----- mem--mobile, DB---mobile
		// session2.merge(p1);// Works fine---mem---dddddd, DB----dddddd
		// session2.merge(p2);// Works fine----mem----mobile, DB---mobile
		// p1.setProdName("ffffff");//mem---ffffff
		// System.out.println(p1);
		// session2.update(p1);// mem----ffffff,
		// DB----mobile----NonUniqueObjectException
		// session2.update(p2);// works fine---- mem----mobile ,DB---mobile
		// session2.merge(p1);// Works fine----mem----ffffff, DB-----fffffff
		// session2.merge(p2);// Works fine----mem----mobile, DB---mobile
		p2.setProdName("hhhhhhh");
		// System.out.println(p2);// mem---hhhhhhh, DB---hhhhhh
		// session2.update(p1);//NonUniqueObjectException
		// session2.update(p2);//Works fine----- mem---hhhhhh, DB---hhhhhh
		// session2.merge(p1);// Works fine----mem----dddddd, DB----ddddddd
		session2.merge(p2);// Works fine----mem------hhhhhhh, DB----hhhhhhh
		session2.flush();
		tr2.commit();
		session2.close();

	}

}
