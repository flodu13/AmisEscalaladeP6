package com.escaladep6.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Role")

public class Role {
	
    @Id
    @Column( name = "code", nullable=false  )
	private Integer code;
    
    @Column( name = "label", nullable=false  )
	private String label;  
    
	@OneToMany ( targetEntity=User.class, mappedBy="role", cascade = CascadeType.ALL, fetch= FetchType.EAGER )
	private List<User> users;
    
    // getter and setter
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
