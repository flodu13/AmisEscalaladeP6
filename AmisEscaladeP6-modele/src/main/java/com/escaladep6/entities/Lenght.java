package com.escaladep6.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Lenght",
uniqueConstraints = { @UniqueConstraint(columnNames = { "id_lenght" }) })


public class Lenght {	
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_lenght" )
	private Long idLenght;
	
	@Column( name = "name" )
	private String Name;
	
	@Column( name = "height" )
	private float height;
	
	@Column( name = "cotation" )
	private String cotation;
	
	@ManyToOne @JoinColumn( name="id_path" )
	private Path path;
	
	// getter and setter
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}	
	public Long getIdLenght() {
		return idLenght;
	}
	public void setIdLenght(Long idLenght) {
		this.idLenght = idLenght;
	}
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	
}
