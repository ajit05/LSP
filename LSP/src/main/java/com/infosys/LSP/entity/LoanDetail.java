package com.infosys.LSP.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="loan_detail")
public class LoanDetail {
	@Id
	@Column(name="transaction_id")
	private String transactionId ;
	
	@Column(name="type")
	private String type;
	
	@OneToOne(mappedBy="loanDetail",fetch = FetchType.LAZY)
	private Borrower borrower;
	
	
	public  LoanDetail() {
		
	}

	public LoanDetail(String type) {
		super();
		this.type = type;
	}
	
	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LoanDetail [transactionId=" + transactionId + ", type=" + type + "]";
	}	

}
