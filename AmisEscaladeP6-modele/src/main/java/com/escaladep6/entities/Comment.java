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
@Table(name = "Comment", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_comment" }) })

public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comment")
	private Long idComment;

	@Column(name = "comment", nullable = false)
	private String comment;

	@Column(name = "publiction_date", nullable = false)
	private Date publicationDate;

	@ManyToOne @JoinColumn( name="id_user" )
	private User user;
	
	@ManyToOne @JoinColumn( name="id_spot" )
	private Spot spot;

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

}
