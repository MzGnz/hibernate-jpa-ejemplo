package com.ibm.academia.hibernate.entidades.manytomany;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios", schema = "hibernate")
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements Serializable
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nombreUsuario", nullable = false, length = 50, unique = true)
	private String nombreUsuario;
	
	public Usuario(Integer id, String nombreUsuario) 
	{
		this.id = id;
		this.nombreUsuario = nombreUsuario;
	}
	
	@ManyToMany
	@JoinTable(
			name = "usuario_publicacion", 
			schema = "hibernate", 
			joinColumns = @JoinColumn(name = "usuario_id"), 
			inverseJoinColumns = @JoinColumn(name = "publicacion_id"))
	private List<Publicacion> publicaciones;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=");
		builder.append(id);
		builder.append(", nombreUsuario=");
		builder.append(nombreUsuario);
		builder.append("]");
		return builder.toString();
	}
	
	private static final long serialVersionUID = -1624925478501540247L;

}
