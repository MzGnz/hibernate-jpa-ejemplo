package com.ibm.academia.hibernate.entidades.manytoone;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "telefonos", schema="hibernate")
@Setter
@Getter
@NoArgsConstructor
public class Telefono implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero_telefono", unique = true, length =  10)
	private String numeroTelefonico;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "persona_id", foreignKey = @ForeignKey(name = "FK_PERSONA_ID"))
	private Persona persona;

	public Telefono(Integer id, String numeroTelefonico) {
		this.id = id;
		this.numeroTelefonico = numeroTelefonico;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Telefono [id=");
		builder.append(id);
		builder.append(", numeroTelefonico=");
		builder.append(numeroTelefonico);
		builder.append("]");
		return builder.toString();
	}

	private static final long serialVersionUID = 4207884590844469221L;

}
