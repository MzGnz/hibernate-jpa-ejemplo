package com.ibm.academia.hibernate.pruebas;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.ibm.academia.hibernate.entidades.manytoone.Persona;
import com.ibm.academia.hibernate.entidades.manytoone.Telefono;
import com.ibm.academia.hibernate.util.HibernateUtil;

public class MainJPQL {
	public static void main(String[] args) {
		
		//JPQL -> Java Persistence Query Language
		
		Session session = HibernateUtil.getSeccionSessionFactory().openSession();
		
		//SQL Nativo -> select * from hibernate.personas where id = ?
		
		Query query = session.createQuery("select p from Persona where p.id = ?1");
		query.setParameter(1, Integer.parseInt("2"));
		
		Persona persona = (Persona) query.getSingleResult();
		System.out.println(persona.toString());
		
		//SQL Nativo -> select * from hibernate.personas p inner join hibernate.telefonos t on p.id = t.persona_id
		Query queryDos = session.createQuery("select p.telefonos from Persona p where p.id = :id");
		queryDos.setParameter("id", Integer.parseInt("1"));
		
		List<Telefono> telefonos = (List<Telefono>) queryDos.getResultList();
		telefonos.forEach(t -> System.out.println(t.toString()));
		
		session.close();
	
	}
}
