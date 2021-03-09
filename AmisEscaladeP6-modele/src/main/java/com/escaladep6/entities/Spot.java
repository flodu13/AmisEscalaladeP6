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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "spot",
uniqueConstraints = { @UniqueConstraint(columnNames = { "id_spot" }) })

public class Spot {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_spot" ) 
	private Integer idSpot;    
	
	@Column( name = "name", nullable=false  )
	private String name;
	
	@Column( name = "nombre_voie")
	private Integer numberOfPath;
	
	@Column( name = "niveau_difficulte")
	private String difficultLevel;
	
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id_address" )    
	private Address address;   
	
	@Column( name = "tag" )
	private Boolean tag;	
	
	@OneToMany ( targetEntity=Sector.class, mappedBy="spot" )
	private List<Sector> sectors;	
	
	@OneToMany ( targetEntity=Comment.class, mappedBy="spot")
	private List<Comment> comments;

	
	// getter and setter	     
    
	public Integer getIdSpot() {
		return idSpot;
	}
	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Boolean isTag() {
		return tag;
	}
	public void setTag(Boolean tag) {
		this.tag = tag;
	}
	public Boolean getTag() {
		return tag;
	}
	public Integer getNumberOfPath() {
		return numberOfPath;
	}
	public void setNumberOfPath(Integer numberOfPath) {
		this.numberOfPath = numberOfPath;
	}
	public String getDifficultLevel() {
		return difficultLevel;
	}
	public void setDifficultLevel(String difficultLevel) {
		this.difficultLevel = difficultLevel;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Sector> getSectors() {
		return sectors;
	}
	public void setSectors(List<Sector> sectors) {
		this.sectors = sectors;
	}

}
