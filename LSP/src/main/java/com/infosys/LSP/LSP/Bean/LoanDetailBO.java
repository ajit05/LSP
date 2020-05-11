package com.infosys.LSP.LSP.Bean;

public class LoanDetailBO {
	
	
	private String transactionId;
	private String type;	
	private BorrowerBO  borrowerBO;
	
	public  LoanDetailBO() {
		
	}

	public LoanDetailBO(String transactionId, String type, BorrowerBO borrowerBO) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.borrowerBO = borrowerBO;
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

	public BorrowerBO getBorrowerBO() {
		return borrowerBO;
	}

	public void setBorrowerBO(BorrowerBO borrowerBO) {
		this.borrowerBO = borrowerBO;
	}
	
	
	
	
	
	

}
