package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="documestDetails")
public class DocumentsDetailEntity {
	
	@Id
	@Column(name="document_details_id")
	private String documentDetailId;
	
	@Column(name="document_source")
	private String documnetsource;
	
	@Column(name="document_identifier")
	private String documentIndentifier;
	
	@Column(name="document_format")
	private String documentFormat;
	
	@Column(name="document_type")
	private String documentType;
	
	@Column(name="document_isDataInline")
	private Boolean documnetIsDateInLine;
	
	@Column(name="document_data")
	private String documentData;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="borrower_applicant_id")	
	private BorrowerDetailEntity borrowerDetailEntity;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	
	public DocumentsDetailEntity() {
		
	}
	public DocumentsDetailEntity(String documnetsource, String documentIndentifier, String documentFormat,
			String documentType, Boolean documnetIsDateInLine, String documentData) {
		super();
		this.documnetsource = documnetsource;
		this.documentIndentifier = documentIndentifier;
		this.documentFormat = documentFormat;
		this.documentType = documentType;
		this.documnetIsDateInLine = documnetIsDateInLine;
		this.documentData = documentData;
	}


	public String getDocumentDetailId() {
		return documentDetailId;
	}


	public void setDocumentDetailId(String documentDetailId) {
		this.documentDetailId = documentDetailId;
	}


	public String getDocumnetsource() {
		return documnetsource;
	}


	public void setDocumnetsource(String documnetsource) {
		this.documnetsource = documnetsource;
	}


	public String getDocumentIndentifier() {
		return documentIndentifier;
	}


	public void setDocumentIndentifier(String documentIndentifier) {
		this.documentIndentifier = documentIndentifier;
	}


	public String getDocumentFormat() {
		return documentFormat;
	}


	public void setDocumentFormat(String documentFormat) {
		this.documentFormat = documentFormat;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	public Boolean getDocumnetIsDateInLine() {
		return documnetIsDateInLine;
	}


	public void setDocumnetIsDateInLine(Boolean documnetIsDateInLine) {
		this.documnetIsDateInLine = documnetIsDateInLine;
	}


	public String getDocumentData() {
		return documentData;
	}


	public void setDocumentData(String documentData) {
		this.documentData = documentData;
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
		return "DocumentsDetailEntity [documentDetailId=" + documentDetailId + ", documnetsource=" + documnetsource
				+ ", documentIndentifier=" + documentIndentifier + ", documentFormat=" + documentFormat
				+ ", documentType=" + documentType + ", documnetIsDateInLine=" + documnetIsDateInLine
				+ ", documentData=" + documentData + ", borrowerDetailEntity=" + borrowerDetailEntity
				+ ", invoiceDetailEntity=" + invoiceDetailEntity + "]";
	}	

}

/*documestDetails(
	document_details_id uuid, 
	document_source varchar(3) not null DEFAULT('FIU'),
	document_identifier varchar(35)   not null,
	document_format varchar(3) not null, 
	document_type  varchar(6) not null,
	document_isDataInline  boolean not null,
	document_data  varchar(1000000) not null,	
	borrower_applicant_id uuid,
	loan_application_no uuid,
	PRIMARY KEY(document_details_id),
	FOREIGN KEY(borrower_applicant_id)
	REFERENCES borrowerDetails(borrower_applicant_id),
	FOREIGN KEY(loan_application_no)
	REFERENCES invoicedetails(loan_application_no)	
);*/
