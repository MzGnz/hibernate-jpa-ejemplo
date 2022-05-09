package com.ibm.academia.hibernate.entidades.onetoone;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "carnets", schema = "hibernate")
@Getter
@Setter
@NoArgsConstructor
public class Carnet implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "numero_membresia", nullable = false, length = 10)
	private String numeroMembresia;
	
	@OneToOne
	@JoinColumn(name= "socio_id",foreignKey = @ForeignKey(name = "FK_SOCIO_ID"))
	private Socio socio;
	
	
	
	public Carnet(Integer id, String numeroMembresia) 
	{
		this.id = id;
		this.numeroMembresia = numeroMembresia;
	}



	private static final long serialVersionUID = -5002207903334571417L;

}
