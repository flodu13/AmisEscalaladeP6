package com.escaladep6.entities;

import java.util.Date;
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
@Table(name = "Reservation_inquiry",
uniqueConstraints = { @UniqueConstraint(columnNames = { "id_inquiry" }) })

public class ReservationInquiry {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_inquiry" )
	private Long idInquiry;
    
    @Column( name = "statut", nullable=false  )    
	private String statut;
    
    @Column( name = "message" )    
	private String message;
    
    @Column( name = "lend_date", nullable=false  )
	private Date lendDate;
    
	@ManyToOne @JoinColumn( name="id_user" )
	private User user;
	
	@ManyToOne @JoinColumn( name="id_topo" )
	private Topo topo;
	
	
	
	// getter and setter
    
	public Long getIdInquiry() {
		return idInquiry;
	}
	public void setIdInquiry(Long idInquiry) {
		this.idInquiry = idInquiry;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
