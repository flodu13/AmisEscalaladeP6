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
@Table(name = "User_account",
uniqueConstraints = { @UniqueConstraint(columnNames = { "id_user" }) })

public class User {
	
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id_user" )
	private Integer idUser;
    
    @Column( name = "name", nullable=false  )
	private String name;
    
    @Column( name = "lastname", nullable=false  )
	private String lastName;
    
    @Column( name = "email", nullable=false, unique = true  )
    
	private String email;
    
    @Column( name = "login", nullable=false, unique = true  )
	private String login;
    
    @Column( name = "password", nullable=false  )
	private String password; 
	
	@ManyToOne 
	@JoinColumn( name="code" )
	private Role role;
    
	@OneToMany ( targetEntity=Topo.class, mappedBy="user", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Topo> topos; 
	
	@OneToMany ( targetEntity=ReservationInquiry.class, mappedBy="user", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private List<ReservationInquiry> reservationInquiries;
	
	@OneToMany ( targetEntity=Comment.class, mappedBy="user" )
	private List<Comment> comments;
	
	// getter and setter
	
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Topo> getTopos() {
		return topos;
	}
	public void setTopos(List<Topo> topos) {
		this.topos = topos;
	}
	public List<ReservationInquiry> getReservationInquiries() {
		return reservationInquiries;
	}
	public void setReservationInquiries(List<ReservationInquiry> reservationInquiries) {
		this.reservationInquiries = reservationInquiries;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
