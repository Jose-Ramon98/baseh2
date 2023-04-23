package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity// para marcar una clase como una entiedad de una bd(base de datos)
@Table(name="clientes")//para configurar el nombre de la tabla y que se llame igual que en la bd(base de datos)
public class Cliente implements Serializable{

	@Id// indica que ese atributo es la llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//incrementable
	private Long id;

	private String nombre; // y esto son las columnas: nombre apellido, email y fecha
	private String apellido;
	private String email;
	
	@Column(name="create_at")// al meter @column le dices a la base de datos que se va a llamar create_at y no createAt
	@Temporal(TemporalType.DATE)// con el temporal y lo que esta entre parentesis especificas que la fecha va a ser dia mes y año, sin hora,
	                             //si quisies hora y segundo tambien lo podrias hacer con el @temporal
	private Date createAt;
	
	
	
	
	@PrePersist
	public void prePersist() {
		createAt= new Date();
		
	}
	
	
	
	
	
	private static final long serialVersionUID = 1L; // te obliga a ponerlo y es automatico



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
