package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contactDetails")
public class ContactDetailEntity {
	
	@Id
	@Column(name="contact_details_id")
	private String contactDetailId;
	
	@Column(name="contact_type")
	private String contactType;
	
	@Column(name="contact_number")
	private Integer contactNumber;
	
	@Column(name="contact_email")
	private String contactEmail;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="borrower_applicant_id")	
	private BorrowerDetailEntity borrowerDetailEntity;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
/*	@OneToOne(mappedBy="contactDetailEntity",fetch = FetchType.LAZY)
	private AddressDetailEntity addressDetailEntity;*/
	
	public ContactDetailEntity() {
		
	}

	public ContactDetailEntity(String contactType, Integer contactNumber, String contactEmail) {
		super();
		this.contactType = contactType;
		this.contactNumber = contactNumber;
		this.contactEmail = contactEmail;
	}

	public String getContactDetailId() {
		return contactDetailId;
	}

	public void setContactDetailId(String contactDetailId) {
		this.contactDetailId = contactDetailId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public BorrowerDetailEntity getBorrowerDetailEntity() {
		return borrowerDetailEntity;
	}

	public void setBorrowerDetailEntity(BorrowerDetailEntity borrowerDetailEntity) {
		this.borrowerDetailEntity = borrowerDetailEntity;
	}

	public InvoiceDetailEntity getInvoiceDetailEntity() {
		return invoiceDetailEntity;
	}

	public void setInvoiceDetailEntity(InvoiceDetailEntity invoiceDetailEntity) {
		this.invoiceDetailEntity = invoiceDetailEntity;
	}	

	/*public AddressDetailEntity getAddressDetailEntity() {
		return addressDetailEntity;
	}

	public void setAddressDetailEntity(AddressDetailEntity addressDetailEntity) {
		this.addressDetailEntity = addressDetailEntity;
	}
	@Override
	public String toString() {
		return "ContactDetailEntity [contactDetailId=" + contactDetailId + ", contactType=" + contactType
				+ ", contactNumber=" + contactNumber + ", contactEmail=" + contactEmail + ", borrowerDetailEntity="
				+ borrowerDetailEntity + ", invoiceDetailEntity=" + invoiceDetailEntity + ", addressDetailEntity="
				+ addressDetailEntity + "]";
	}*/

	
}

/*contactDetails(
		contact_details_id uuid unique,
		contact_type varchar(3)  NOT null,
		contact_number integer not null,
		contact_email varchar(50),
		borrower_applicant_id uuid,
		loan_application_no uuid,
		PRIMARY KEY(contact_details_id),
		FOREIGN KEY(borrower_applicant_id)
		REFERENCES borrowerDetails(borrower_applicant_id),
		FOREIGN KEY(loan_application_no)
		REFERENCES invoicedetails(loan_application_no)


*/