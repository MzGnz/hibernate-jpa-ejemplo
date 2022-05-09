package com.ibm.academia.hibernate.pruebas;

import java.util.Arrays;

import org.hibernate.Session;

import com.ibm.academia.hibernate.entidades.manytomany.Publicacion;
import com.ibm.academia.hibernate.entidades.manytomany.Usuario;
import com.ibm.academia.hibernate.util.HibernateUtil;

public class MainManyToMany
{
	public static void main(String[] args) 
	{
		Session session = HibernateUtil.getSeccionSessionFactory().openSession();
		session.beginTransaction();
		
		/*Usuario admin = new Usuario(null,"admin");
		Usuario qa = new Usuario(null,"usuario");
		
		Publicacion publicacionUno = new Publicacion(null,"primera publicacion");
		Publicacion publicacionDos = new Publicacion(null,"segunda publicacion");
		Publicacion publicacionTres = new Publicacion(null,"tercera publicacion");
		Publicacion publicacionCuatro = new Publicacion(null,"cuarta publicacion");
		
		admin.setPublicaciones(Arrays.asList(publicacionUno,publicacionTres));
		qa.setPublicaciones(Arrays.asList(publicacionDos,publicacionCuatro,publicacionTres,publicacionUno));
		
		session.saveOrUpdate(admin);
		session.saveOrUpdate(qa);
		session.saveOrUpdate(publicacionUno);
		session.saveOrUpdate(publicacionDos);
		session.saveOrUpdate(publicacionTres);
		session.saveOrUpdate(publicacionCuatro);*/
		
		Usuario usuario = session.get(Usuario.class,2);
		usuario.getPublicaciones().forEach(p -> {
			System.out.println(usuario.getNombreUsuario());
			System.out.println(p.toString());
		});
		
		
		session.getTransaction().commit();
		session.close();
	}
}
