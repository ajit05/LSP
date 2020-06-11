package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact_detail")
public class ContactDetail {
	@javax.persistence.Id
	@Column(name="id")
	private String Id;
	
	@Column(name="email")
	private String email;

	
	@Column(name="type")
	private String type;
	
	@ManyToOne(targetEntity=Borrower.class ,cascade=CascadeType.PERSIST)
	@JoinColumn(name="borrower_id")
	private Borrower borrower;
	
	public ContactDetail() {
		
	}

	public ContactDetail(String email, String type) {
		super();
		this.email = email;
		this.type = type;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	@Override
	public String toString() {
		return "ContactDetail [Id=" + Id + ", email=" + email + ", type=" + type + ", borrower=" + borrower + "]";
	}
	
	
}
