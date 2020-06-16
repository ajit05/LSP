package com.infosys.LSP.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contactDetails")
public class ContactDetailEntity implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_details_id")
	private String contactDetailId;
	
	@Column(name="contact_type")
	private String type;
	
	@Column(name="contact_number")
	private Integer phone;
	
	@Column(name="contact_email")
	private String email;
	
	
	@OneToOne(mappedBy="contactDetailEntity",fetch = FetchType.LAZY)
	private AddressDetailEntity  address;
	
	@ManyToOne(targetEntity=BorrowerDetailEntity.class,cascade=CascadeType.PERSIST)	
	@JoinColumn(name="borrower_applicant_id")	
	private BorrowerDetailEntity borrowerDetailEntity;
	
	/*@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;*/
	
	public  ContactDetailEntity() {
		System.out.println("in contact details class");
	}

	public ContactDetailEntity(String type, Integer phone, String email) {
		super();
		this.type = type;
		this.phone = phone;
		this.email = email;
	}

	public String getContactDetailId() {
		return contactDetailId;
	}

	public void setContactDetailId(String contactDetailId) {
		this.contactDetailId = contactDetailId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BorrowerDetailEntity getBorrowerDetailEntity() {
		System.out.println("form contactdetails to adress");
		return borrowerDetailEntity;
	}

	public void setBorrowerDetailEntity(BorrowerDetailEntity borrowerDetailEntity) {
		this.borrowerDetailEntity = borrowerDetailEntity;
	}
	

	public AddressDetailEntity getAddress() {
		return address;
	}

	public void setAddress(AddressDetailEntity address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ContactDetailEntity [contactDetailId=" + contactDetailId + ", type=" + type + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", borrowerDetailEntity=" + borrowerDetailEntity + "]";
	}



	

}



/*contact_details_id uuid,
	contact_type varchar(3)  NOT null,
	contact_number integer not null,
	contact_email varchar(50),
	borrower_applicant_id uuid,
	PRIMARY KEY(contact_details_id),
	FOREIGN KEY(borrower_applicant_id)
	REFERENCES borrowerDetails(borrower_applicant_id)*/