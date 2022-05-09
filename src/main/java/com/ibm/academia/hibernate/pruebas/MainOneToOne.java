package com.ibm.academia.hibernate.pruebas;

import org.hibernate.Session;

import com.ibm.academia.hibernate.entidades.onetoone.*;
import com.ibm.academia.hibernate.util.HibernateUtil;

public class MainOneToOne {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSeccionSessionFactory().openSession();
		session.beginTransaction();
		
		Socio socio = new Socio(null,"Carlos","12345678");
		Carnet carnet = new Carnet(null, "00005");
		
		socio.setCarnet(carnet);
		
		session.save(socio);
		
		session.getTransaction().commit();
		session.close();
	}
}
