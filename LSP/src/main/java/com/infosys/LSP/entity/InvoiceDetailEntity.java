package com.infosys.LSP.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoice_details")
public class InvoiceDetailEntity  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loan_application_no")
	private String loanApplicationNumber;
	
	@Column(name="transaction_id")
	private String transactionId;	
	
	@Column(name="inv_number")
	private String invoiceNumber;
	
	@Column(name="loan_type")
	private String loanType;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private BorrowerDetailEntity borrower;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private ContactDetailEntity contactDetail;
	
	@OneToMany(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<DocumentsDetailEntity> documents=new  ArrayList<DocumentsDetailEntity>();
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private LoanTermDetailEntity terms;
	
	@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private MasterLoanDetail master;
	
	/*@OneToOne(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY)
	private ValuationDetailEntity valuation;	*/
	
	@OneToMany(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ColletralDetailEntity> collaterals=new ArrayList<ColletralDetailEntity>();
	
	
	
	public InvoiceDetailEntity() {
		System.out.println("in iNvoie c entity");
		
	}

	
	public InvoiceDetailEntity(String transactionId, String invoiceNumber, String loanType) {
		super();
		this.transactionId = transactionId;
		this.invoiceNumber = invoiceNumber;
		this.loanType = loanType;
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

	public BorrowerDetailEntity getBorrower() {
		return borrower;
	}

	public void setBorrower(BorrowerDetailEntity borrower) {
		this.borrower = borrower;
	}	

	
	@OneToMany(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	public List<DocumentsDetailEntity> getDocuments() {
		return documents;
	}


	public void setDocuments(List<DocumentsDetailEntity> documents) {
		this.documents = documents;
	}


	public LoanTermDetailEntity getTerms() {
		return terms;
	}

	public void setTerms(LoanTermDetailEntity terms) {
		this.terms = terms;
	}

	public MasterLoanDetail getMaster() {
		return master;
	}

	public void setMaster(MasterLoanDetail master) {
		this.master = master;
	}

	/*public ValuationDetailEntity getValuation() {
		return valuation;
	}

	public void setValuation(ValuationDetailEntity valuation) {
		this.valuation = valuation;
	}
	*/
	@OneToMany(mappedBy="invoiceDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	public List<ColletralDetailEntity> getCollaterals() {
		return collaterals;
	}


	public void setCollaterals(List<ColletralDetailEntity> collaterals) {
		this.collaterals = collaterals;
	}


	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	

	public ContactDetailEntity getContactDetail() {
		return contactDetail;
	}


	public void setContactDetail(ContactDetailEntity contactDetail) {
		this.contactDetail = contactDetail;
	}


	@Override
	public String toString() {
		return "InvoiceDetailEntity [loanApplicationNumber=" + loanApplicationNumber + ", transactionId="
				+ transactionId + ", invoiceNumber=" + invoiceNumber + ", loanType=" + loanType + ", borrower="
				+ borrower + ", contactDetail=" + contactDetail + ", documents=" + documents + ", terms=" + terms
				+ ", master=" + master + ", collaterals=" + collaterals + "]";
	}

	
}


