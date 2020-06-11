package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoicedetails")
public class InvoiceDetailEntity {
	
	@Id
	@Column(name="loan_application_no")
	private String loanApplicationNumber;
	
	@Column(name="transaction_id")
	private String transactionId;	
	
	@Column(name="invNumber")
	private String invoiceNumber;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private BorrowerDetailEntity borrowerDetailEntity;	
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private ContactDetailEntity contactDetailEntity;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private DocumentsDetailEntity documentsDetailEntity;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private LoanTermDetailEntity loanTermDetailEntity;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private MasterLoanDetail masterLoanDetail;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private ValuationDetailEntity valuationDetailEntity;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private ColletralDetailEntity colletralDetailEntity;
	
	public InvoiceDetailEntity() {
		
	}

	public InvoiceDetailEntity(String transactionId, String invoiceNumber) {
		super();
		this.transactionId = transactionId;
		this.invoiceNumber = invoiceNumber;
	}

	public String getLoanApplicationNumber() {
		return loanApplicationNumber;
	}

	public void setLoanApplicationNumber(String loanApplicationNumber) {
		this.loanApplicationNumber = loanApplicationNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	@OneToOne(fetch=FetchType.LAZY,mappedBy="invoiceDetailEntity",cascade= {CascadeType.PERSIST})
	public BorrowerDetailEntity getBorrowerDetailEntity() {
		return borrowerDetailEntity;
	}

	public void setBorrowerDetailEntity(BorrowerDetailEntity borrowerDetailEntity) {
		this.borrowerDetailEntity = borrowerDetailEntity;
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

	public MasterLoanDetail getMasterLoanDetail() {
		return masterLoanDetail;
	}

	public void setMasterLoanDetail(MasterLoanDetail masterLoanDetail) {
		this.masterLoanDetail = masterLoanDetail;
	}
	
	public ValuationDetailEntity getValuationDetailEntity() {
		return valuationDetailEntity;
	}

	public void setValuationDetailEntity(ValuationDetailEntity valuationDetailEntity) {
		this.valuationDetailEntity = valuationDetailEntity;
	}	

	public ColletralDetailEntity getColletralDetailEntity() {
		return colletralDetailEntity;
	}

	public void setColletralDetailEntity(ColletralDetailEntity colletralDetailEntity) {
		this.colletralDetailEntity = colletralDetailEntity;
	}

	@Override
	public String toString() {
		return "InvoiceDetailEntity [loanApplicationNumber=" + loanApplicationNumber + ", transactionId="
				+ transactionId + ", invoiceNumber=" + invoiceNumber + ", borrowerDetailEntity=" + borrowerDetailEntity
				+ ", contactDetailEntity=" + contactDetailEntity + ", documentsDetailEntity=" + documentsDetailEntity
				+ ", loanTermDetailEntity=" + loanTermDetailEntity + ", masterLoanDetail=" + masterLoanDetail
				+ ", valuationDetailEntity=" + valuationDetailEntity + ", colletralDetailEntity="
				+ colletralDetailEntity + "]";
	}	
}


