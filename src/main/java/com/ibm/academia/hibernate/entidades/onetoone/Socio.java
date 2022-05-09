package com.ibm.academia.hibernate.entidades.onetoone;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "socios", schema = "hibernate")
@Getter
@Setter
@NoArgsConstructor
public class Socio implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column (name = "numero_documento", nullable = false, length = 10, unique = true)
	private String numeroDocumento;
	
	@OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
	private Carnet carnet;
	
	public Socio(Integer id, String nombre, String numeroDocumento) {
		this.id = id;
		this.nombre = nombre;
		this.numeroDocumento = numeroDocumento;
	}

	private static final long serialVersionUID = 6589760335554357967L;

}
