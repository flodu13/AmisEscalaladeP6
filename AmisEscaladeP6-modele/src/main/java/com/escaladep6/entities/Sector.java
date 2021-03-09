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
@Table(name = "Sector", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_sector" }) })

public class Sector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sector")
	private Long idSector;

	@Column(name = "name", nullable=false )
	private String name;
	
	@Column(name = "path_number", nullable=false )
	private Integer numberOfPath;

	@OneToMany ( targetEntity=Path.class, mappedBy="sector", cascade = CascadeType.ALL, fetch= FetchType.EAGER )
	private List<Path> paths;
	
	@ManyToOne 
	@JoinColumn( name="id_spot" )
	private Spot spot;

	public Long getIdSector() {
		return idSector;
	}

	public void setIdSector(Long idSector) {
		this.idSector = idSector;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfPath() {
		return numberOfPath;
	}

	public void setNumberOfPath(Integer numberOfPath) {
		this.numberOfPath = numberOfPath;
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	

}
