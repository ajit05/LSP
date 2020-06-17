package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="master_loan_details")
public class MasterLoanDetail {
	
	@Id
	@Column(name="master_loan_id")
	private String masterLoanId;
	
	@Column(name="loan_Status")
	private String loanStatus;
	
	@Column(name="lender_primary_id")
	private String lenderPrimaryId;
	
	@Column(name="lender_bank")
	private String lenderBank;
	
	@Column(name="lender_category")
	private String lendercategory;
	
	@OneToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="borrower_applicant_id")	
	private BorrowerDetailEntity borrowerDetailEntity;
	
	@OneToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	public MasterLoanDetail() {
		
		System.out.println("in master....");
		
	}

	public MasterLoanDetail(String loanStatus, String lenderPrimaryId, String lenderBank, String lendercategory) {
		super();
		this.loanStatus = loanStatus;
		this.lenderPrimaryId = lenderPrimaryId;
		this.lenderBank = lenderBank;
		this.lendercategory = lendercategory;
	}

	public String getMasterLoanId() {
		return masterLoanId;
	}

	public void setMasterLoanId(String masterLoanId) {
		this.masterLoanId = masterLoanId;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getLenderPrimaryId() {
		return lenderPrimaryId;
	}

	public void setLenderPrimaryId(String lenderPrimaryId) {
		this.lenderPrimaryId = lenderPrimaryId;
	}

	public String getLenderBank() {
		return lenderBank;
	}

	public void setLenderBank(String lenderBank) {
		this.lenderBank = lenderBank;
	}

	public String getLendercategory() {
		return lendercategory;
	}

	public void setLendercategory(String lendercategory) {
		this.lendercategory = lendercategory;
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
		return "MasterLoanDetail [masterLoanId=" + masterLoanId + ", loanStatus=" + loanStatus + ", lenderPrimaryId="
				+ lenderPrimaryId + ", lenderBank=" + lenderBank + ", lendercategory=" + lendercategory
				+ ", borrowerDetailEntity=" + borrowerDetailEntity + ", invoiceDetailEntity=" + invoiceDetailEntity
				+ "]";
	}

}
/* masterLoanDetails(
	master_loan_id uuid,
	loan_Status varchar(15) not null,
	lender_primary_id varchar(50),
	lender_bank  varchar(25)  not null,
	lender_category varchar(3) not null DEFAULT('ORG'),
	PRIMARY KEY(master_loan_id),
	loan_application_no UUID,
	borrower_applicant_id UUID,
	FOREIGN KEY(loan_application_no)
	REFERENCES invoicedetails(loan_application_no),
	FOREIGN KEY(borrower_applicant_id)
	REFERENCES borrowerDetails(borrower_applicant_id)*/