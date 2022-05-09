package com.ibm.academia.hibernate.pruebas;

import java.util.Date;

import org.hibernate.Session;

import com.ibm.academia.hibernate.entidades.SimpleEntity;
import com.ibm.academia.hibernate.util.HibernateUtil;

public class HibernateMain {
	public static void main(String[] args) {
		
		SimpleEntity entity = null;
		
		Session session = HibernateUtil.getSeccionSessionFactory().openSession();
		session.beginTransaction();
		
		//Insert
		Date fechaActual = new Date();
		/*entity = new SimpleEntity(null,"descripcion1","alejandro",fechaActual);
		session.save(entity);
		
		//Update
		entity = new SimpleEntity();
		entity.setId(1);
		entity.setDescripcion("descripcion2");
		entity.setFechaCreacion(fechaActual);
		entity.setUsuarioCreacion("margomez21");
		session.update(entity);
		
		//Delete
		entity = new SimpleEntity();
		entity.setId(1);
		session.delete(entity);*/
		
		//Consultar
		entity = session.get(SimpleEntity.class,2);
		System.out.println(entity);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
