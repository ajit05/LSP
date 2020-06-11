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
@Table(name="borrowerDetails")
public class BorrowerDetailEntity {
	@Id
	@Column(name="borrower_applicant_id")
	private String borrowerApplicantId;	
	
	@Column(name="borrower_phone")
	private Integer borrowerPhone;
	
	@Column(name="borrower_guarantors")
	private String borrowerGranter;
	
	@Column(name="loan_type")
	private String loanType;
	
	@Column(name="borrower_name")
	private String borrowerName;
	
	@OneToOne(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY)
	private ContactDetailEntity contactDetailEntity;
	
	@OneToOne(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY)
	private DocumentsDetailEntity documentsDetailEntity;
	
	
	@OneToOne(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY)
	private LoanTermDetailEntity loanTermDetailEntity;
	
	@OneToOne(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY)
	private ColletralDetailEntity colletralDetailEntity;
	

	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	public BorrowerDetailEntity() {
		
	}

	public BorrowerDetailEntity(Integer borrowerPhone, String borrowerGranter, String loanType, String borrowerName) {
		super();
		this.borrowerPhone = borrowerPhone;
		this.borrowerGranter = borrowerGranter;
		this.loanType = loanType;
		this.borrowerName = borrowerName;
	}

	public String getBorrowerApplicantId() {
		return borrowerApplicantId;
	}

	public void setBorrowerApplicantId(String borrowerApplicantId) {
		this.borrowerApplicantId = borrowerApplicantId;
	}

	public Integer getBorrowerPhone() {
		return borrowerPhone;
	}

	public void setBorrowerPhone(Integer borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}

	public String getBorrowerGranter() {
		return borrowerGranter;
	}

	public void setBorrowerGranter(String borrowerGranter) {
		this.borrowerGranter = borrowerGranter;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public InvoiceDetailEntity getLoanApplicationNumber() {
		return invoiceDetailEntity;
	}

	public void setLoanApplicationNumber(InvoiceDetailEntity invoiceDetailEntity) {
		this.invoiceDetailEntity = invoiceDetailEntity;
	}		

	public ContactDetailEntity getContactDetailEntity() {
		return contactDetailEntity;
	}

	public void setContactDetailEntity(ContactDetailEntity contactDetailEntity) {
		this.contactDetailEntity = contactDetailEntity;
	}	
		
	public DocumentsDetailEntity getDocumentsDetailEntity() {
		return documentsDetailEntity;
	}

	public void setDocumentsDetailEntity(DocumentsDetailEntity documentsDetailEntity) {
		this.documentsDetailEntity = documentsDetailEntity;
	}

	public LoanTermDetailEntity getLoanTermDetailEntity() {
		return loanTermDetailEntity;
	}

	public void setLoanTermDetailEntity(LoanTermDetailEntity loanTermDetailEntity) {
		this.loanTermDetailEntity = loanTermDetailEntity;
	}

	public InvoiceDetailEntity getInvoiceDetailEntity() {
		return invoiceDetailEntity;
	}

	public void setInvoiceDetailEntity(InvoiceDetailEntity invoiceDetailEntity) {
		this.invoiceDetailEntity = invoiceDetailEntity;
	}
	

	public ColletralDetailEntity getColletralDetailEntity() {
		return colletralDetailEntity;
	}

	public void setColletralDetailEntity(ColletralDetailEntity colletralDetailEntity) {
		this.colletralDetailEntity = colletralDetailEntity;
	}

	@Override
	public String toString() {
		return "BorrowerDetailEntity [borrowerApplicantId=" + borrowerApplicantId + ", borrowerPhone=" + borrowerPhone
				+ ", borrowerGranter=" + borrowerGranter + ", loanType=" + loanType + ", borrowerName=" + borrowerName
				+ ", contactDetailEntity=" + contactDetailEntity + ", documentsDetailEntity=" + documentsDetailEntity
				+ ", loanTermDetailEntity=" + loanTermDetailEntity + ", colletralDetailEntity=" + colletralDetailEntity
				+ ", invoiceDetailEntity=" + invoiceDetailEntity + "]";
	}	
	
}

