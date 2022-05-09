package com.ibm.academia.hibernate.pruebas;

import java.util.Arrays;

import org.hibernate.Session;

import com.ibm.academia.hibernate.entidades.manytoone.Persona;
import com.ibm.academia.hibernate.entidades.manytoone.Telefono;
import com.ibm.academia.hibernate.util.HibernateUtil;

public class MainManyToOne {
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSeccionSessionFactory().openSession();
		session.beginTransaction();
		
		/*Telefono celularAlex = new Telefono(null,"5543434343");
		Telefono oficinaAlex = new Telefono(null,"5535252525");
		
		Telefono celularMiguel = new Telefono(null,"2222222222");
		Telefono oficinaMiguel = new Telefono(null,"4444444444");
		
		Persona alex = new Persona(null,"Alex", Arrays.asList(celularAlex,oficinaAlex));
		Persona miguel = new Persona(null,"Miguel", Arrays.asList(celularMiguel,oficinaMiguel));
		
		celularAlex.setPersona(alex);
		oficinaAlex.setPersona(alex);
		celularMiguel.setPersona(miguel);
		oficinaMiguel.setPersona(miguel);
		
		session.saveOrUpdate(alex);
		session.saveOrUpdate(miguel);*/
		
		Persona persona = session.get(Persona.class, 6);
		System.out.println(persona.getNombre());
		persona.getTelefonos().forEach(t -> System.out.println(t.toString()));
		
		
		
		session.getTransaction().commit();
		session.close();
	}
}
