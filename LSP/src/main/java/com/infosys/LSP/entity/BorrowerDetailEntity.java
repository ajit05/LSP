package com.infosys.LSP.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="borrower_details")
public class BorrowerDetailEntity  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="borrower_applicant_id")
	private String borrowerApplicantId;		
	
	@Column(name="borrower_guarantors")
	private String guarantors;	
	
	@Column(name="borrower_name")
	private String name;
	
	@Column(name="transaction_id")
	private String  transactionId; 
	
	
	@OneToMany(mappedBy="borrowerDetailEntity")
	private List<ContactDetailEntity> contactDetail=new ArrayList<ContactDetailEntity>();
	
	@OneToMany(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<DocumentsDetailEntity> documents=new ArrayList<DocumentsDetailEntity>();
	
	
	@OneToOne(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private LoanTermDetailEntity terms;
	
	@OneToOne(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private MasterLoanDetail masterLoanDetail;
	
	
	// YET NOT  CONFIRM ABOUT REATIONSHIP WITH COLLETRALS AND BORRWOER
	/*@OneToOne(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY)
	private ColletralDetailEntity collaterals;*/
	

	@OneToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	public BorrowerDetailEntity() {
		System.out.println("in borr c entity");
		
	}

	public BorrowerDetailEntity(String guarantors, String name) {
		super();
		this.guarantors = guarantors;
		this.name = name;
	}

	public String getBorrowerApplicantId() {
		return borrowerApplicantId;
	}

	public void setBorrowerApplicantId(String borrowerApplicantId) {
		this.borrowerApplicantId = borrowerApplicantId;
	}

	public String getGuarantors() {
		return guarantors;
	}

	public void setGuarantors(String guarantors) {
		this.guarantors = guarantors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	@OneToMany(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	public List<ContactDetailEntity> getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(List<ContactDetailEntity> contactDetail) {
		this.contactDetail = contactDetail;
	}	
	@OneToMany(mappedBy="borrowerDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
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
	
	
	/*public ColletralDetailEntity getCollaterals() {
		return collaterals;
	}

	public void setCollaterals(ColletralDetailEntity collaterals) {
		this.collaterals = collaterals;
	}*/

	public InvoiceDetailEntity getInvoiceDetailEntity() {
		return invoiceDetailEntity;
	}

	public void setInvoiceDetailEntity(InvoiceDetailEntity invoiceDetailEntity) {
		this.invoiceDetailEntity = invoiceDetailEntity;
	}	

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}	

	public MasterLoanDetail getMasterLoanDetail() {
		return masterLoanDetail;
	}

	public void setMasterLoanDetail(MasterLoanDetail masterLoanDetail) {
		this.masterLoanDetail = masterLoanDetail;
	}

	@Override
	public String toString() {
		return "BorrowerDetailEntity [borrowerApplicantId=" + borrowerApplicantId + ", guarantors=" + guarantors
				+ ", name=" + name + ", transactionId=" + transactionId + ", contactDetail=" + contactDetail
				+ ", documents=" + documents + ", terms=" + terms + ", masterLoanDetail=" + masterLoanDetail
				+ ", invoiceDetailEntity=" + invoiceDetailEntity + "]";
	}
	
}

