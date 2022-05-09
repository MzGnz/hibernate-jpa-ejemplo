package com.ibm.academia.hibernate.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "simple_entity" , schema = "hibernate")
public class SimpleEntity implements Serializable
{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "descripcion", length = 20, unique = true)
    private String descripcion;
	
	@Column(name = "usuario_creacion", length = 50)
    private String usuarioCreacion;
	
	@Column(name = "fecha_creacion")
    private Date fechaCreacion;
    
	private static final long serialVersionUID = -4140800076999077951L;

}	