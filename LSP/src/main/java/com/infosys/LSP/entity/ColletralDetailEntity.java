package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="colletralDetails")
public class ColletralDetailEntity {	

	@Id
	@Column(name="collateral_Primary_id")
	private String colletralId;	
	
	@Column(name="collateral_Primary_id_Type")
	private String colletralIdType;
	
	@Column(name="collateral_type")
	private String colletralType;
	
	@Column(name="collateral_additionalIdentifiers")
	private String colletralAdditioanlIdentifiers;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="borrower_applicant_id")	
	private BorrowerDetailEntity borrowerDetailEntity;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	
	public ColletralDetailEntity() {
		
	}


	public ColletralDetailEntity(String colletralIdType, String colletralType, String colletralAdditioanlIdentifiers) {
		super();
		this.colletralIdType = colletralIdType;
		this.colletralType = colletralType;
		this.colletralAdditioanlIdentifiers = colletralAdditioanlIdentifiers;
	}


	public String getColletralId() {
		return colletralId;
	}


	public void setColletralId(String colletralId) {
		this.colletralId = colletralId;
	}


	public String getColletralIdType() {
		return colletralIdType;
	}


	public void setColletralIdType(String colletralIdType) {
		this.colletralIdType = colletralIdType;
	}


	public String getColletralType() {
		return colletralType;
	}


	public void setColletralType(String colletralType) {
		this.colletralType = colletralType;
	}


	public String getColletralAdditioanlIdentifiers() {
		return colletralAdditioanlIdentifiers;
	}


	public void setColletralAdditioanlIdentifiers(String colletralAdditioanlIdentifiers) {
		this.colletralAdditioanlIdentifiers = colletralAdditioanlIdentifiers;
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


	@Override
	public String toString() {
		return "ColletralDetailEntity [colletralId=" + colletralId + ", colletralIdType=" + colletralIdType
				+ ", colletralType=" + colletralType + ", colletralAdditioanlIdentifiers="
				+ colletralAdditioanlIdentifiers + ", borrowerDetailEntity=" + borrowerDetailEntity
				+ ", invoiceDetailEntity=" + invoiceDetailEntity + "]";
	}		

}

/*colletralDetails(
	collateral_Primary_id varchar(50),
	collateral_Primary_id_Type varchar(10) not null,
	collateral_type varchar(8) not null DEFAULT('GST_INV'),
	collateral_additionalIdentifiers VARCHAR(10000),
	loan_application_no UUID,
	borrower_applicant_id UUID,
	PRIMARY KEY(collateral_Primary_id),
	FOREIGN KEY(loan_application_no)
	REFERENCES invoicedetails(loan_application_no),
	FOREIGN KEY(borrower_applicant_id)
	REFERENCES borrowerDetails(borrower_applicant_id)	*/