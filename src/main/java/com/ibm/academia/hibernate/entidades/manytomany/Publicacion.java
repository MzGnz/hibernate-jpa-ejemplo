package com.ibm.academia.hibernate.entidades.manytomany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "publicaciones", schema = "hibernate")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Publicacion implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "texto", nullable = false, length = 50)
	private String texto;
	
	@ManyToMany(mappedBy = "publicaciones")
	
	private List<Usuario> usuarios;
	
	public Publicacion(Integer id, String texto) {
		this.id = id;
		this.texto = texto;
	}

	private static final long serialVersionUID = -3401341969012112518L;

}
