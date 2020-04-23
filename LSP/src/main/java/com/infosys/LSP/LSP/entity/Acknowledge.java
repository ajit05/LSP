package com.infosys.LSP.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ack")
public class Acknowledge {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="error")
	private int error;
	
	
	
	@Column(name="createDate")
	private String createDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "traceid")
	private LoanApplicationDetails loanApplicationDetails;
	
	public  Acknowledge() {
		
	}

	public Acknowledge(int error, String traceId, String createDate, LoanApplicationDetails loanApplicationDetails) {
		super();
		this.error = error;
		
		this.createDate = createDate;
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public LoanApplicationDetails getLoanApplicationDetails() {
		return loanApplicationDetails;
	}

	public void setLoanApplicationDetails(LoanApplicationDetails loanApplicationDetails) {
		this.loanApplicationDetails = loanApplicationDetails;
	}

	@Override
	public String toString() {
		return "Acknowledge [id=" + id + ", error=" + error + ", createDate=" + createDate + ", loanApplicationDetails="
				+ loanApplicationDetails + "]";
	}	

}
