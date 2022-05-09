package com.ibm.academia.hibernate.entidades.manytoone;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name = "personas", schema="hibernate")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 15)
	private String nombre;

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Telefono> telefonos;

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append("]");
		return builder.toString();
	}
	private static final long serialVersionUID = 4134204427310366745L;

}