package com.escaladep6.entities;

import java.util.Date;
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
@Table(name = "Topo",
uniqueConstraints = { @UniqueConstraint(columnNames = { "id_topo" }) })

public class Topo {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_topo" )
	private Integer idTopo; 
	
	@Column( name = "name", nullable=false  )
	private String name;
	
	@Column( name = "available", nullable=false  )
	private Boolean available;
	
	@Column( name = "description", nullable=false  )
	private String description;
	
	@Column( name = "location", nullable=false  )
	private String location;
	
	@Column( name = "publication_date", nullable=false  )
	private Date publicationDate;
	
	@OneToMany ( targetEntity=ReservationInquiry.class, mappedBy="topo", cascade = CascadeType.ALL, fetch= FetchType.EAGER )
	private List<ReservationInquiry> reservationInquiries;
	
	@ManyToOne @JoinColumn( name="id_user" )
	private User user;
	
	// getter and setter
	
	public Integer getIdTopo() {
		return idTopo;
	}
	public void setIdTopo(Integer idTopo) {
		this.idTopo = idTopo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public List<ReservationInquiry> getReservationInquiries() {
		return reservationInquiries;
	}
	public void setReservationInquiries(List<ReservationInquiry> reservationInquiries) {
		this.reservationInquiries = reservationInquiries;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
