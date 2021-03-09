package com.escaladep6.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Path", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_path" }) })

public class Path {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_path")
	private Long idPath;

	@Column(name = "name", nullable=false )
	private String name;

	@Column(name = "height", nullable=false )
	private Float height;

	@Column(name = "cotation", nullable=false )
	private String cotation;

	@Column(name = "point_number")
	private Integer pointNumber;
	
	@Column(name = "lenght_number")
	private Integer numberOfLengh;	

	@OneToMany ( targetEntity=Lenght.class, mappedBy="path")
	private List<Lenght> lenghts;
	
	@ManyToOne @JoinColumn( name="id_sector" )
	private Sector sector;
	
	// getter and setter

	public Long getIdPath() {
		return idPath;
	}

	public void setIdPath(Long idPath) {
		this.idPath = idPath;
	}
	public List<Lenght> getLenghts() {
		return lenghts;
	}
	public void setLenghts(List<Lenght> lenghts) {
		this.lenghts = lenghts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public Integer getPointNumber() {
		return pointNumber;
	}
	public void setPointNumber(Integer pointNumber) {
		this.pointNumber = pointNumber;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public Integer getNumberOfLengh() {
		return numberOfLengh;
	}

	public void setNumberOfLengh(Integer numberOfLengh) {
		this.numberOfLengh = numberOfLengh;
	}


}
