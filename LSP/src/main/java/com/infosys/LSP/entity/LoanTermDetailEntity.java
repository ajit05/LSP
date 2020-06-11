package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="loanTermDetails")
public class LoanTermDetailEntity {
	
	@Id
	@Column(name="loan_term_id")
	private String loanTermId;
	
	@Column(name="request_amount")
	private double requestAmount;
	
	@Column(name="currency")
	private String currency;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="transaction_id")	
	private InvoiceDetailEntity invoiceDetailEntityTrx;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="borrower_applicant_id")
	private BorrowerDetailEntity borrowerDetailEntity;
	
	public LoanTermDetailEntity(){
		
	}

	public LoanTermDetailEntity(double requestAmount, String currency) {
		super();
		this.requestAmount = requestAmount;
		this.currency = currency;
	}

	public String getLoanTermId() {
		return loanTermId;
	}

	public void setLoanTermId(String loanTermId) {
		this.loanTermId = loanTermId;
	}

	public double getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public InvoiceDetailEntity getInvoiceDetailEntity() {
		return invoiceDetailEntity;
	}

	public void setInvoiceDetailEntity(InvoiceDetailEntity invoiceDetailEntity) {
		this.invoiceDetailEntity = invoiceDetailEntity;
	}

	public InvoiceDetailEntity getInvoiceDetailEntityTrx() {
		return invoiceDetailEntityTrx;
	}

	public void setInvoiceDetailEntityTrx(InvoiceDetailEntity invoiceDetailEntityTrx) {
		this.invoiceDetailEntityTrx = invoiceDetailEntityTrx;
	}

	public BorrowerDetailEntity getBorrowerDetailEntity() {
		return borrowerDetailEntity;
	}

	public void setBorrowerDetailEntity(BorrowerDetailEntity borrowerDetailEntity) {
		this.borrowerDetailEntity = borrowerDetailEntity;
	}

	@Override
	public String toString() {
		return "LoanTermDetailEntity [loanTermId=" + loanTermId + ", requestAmount=" + requestAmount + ", currency="
				+ currency + ", invoiceDetailEntity=" + invoiceDetailEntity + ", invoiceDetailEntityTrx="
				+ invoiceDetailEntityTrx + ", borrowerDetailEntity=" + borrowerDetailEntity + "]";
	}
	
	

}

/*loanTermDetails(
	loan_term_id uuid,
	request_amount numeric not null,
	currency varchar not null,
	loan_application_no UUID,
	transaction_id VARCHAR(40),
	borrower_applicant_id UUID,	
	PRIMARY KEY(loan_term_id),
	FOREIGN KEY(loan_application_no)
	REFERENCES invoicedetails(loan_application_no),
	FOREIGN KEY(borrower_applicant_id)
	REFERENCES borrowerDetails(borrower_applicant_id)*/