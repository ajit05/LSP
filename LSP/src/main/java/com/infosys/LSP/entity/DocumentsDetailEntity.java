package com.infosys.LSP.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="documestDetails")
public class DocumentsDetailEntity   {
	
	/**
	 * 
	 */
	
	@Id
	@Column(name="document_details_id")
	private String documentDetailId;
	
	@Column(name="document_source")
	private String source;
	
	@Column(name="document_identifier")
	private String sourceIdentifier;
	
	@Column(name="document_format")
	private String documentFormat;
	
	@Column(name="document_type")
	private String type;
	
	@Column(name="document_isDataInline")
	private Boolean isDataInline;
	
	@Column(name="document_data")
	private String data;
	
	@ManyToOne(targetEntity=BorrowerDetailEntity.class,cascade=CascadeType.PERSIST)	
	@JoinColumn(name="borrower_applicant_id")	
	private BorrowerDetailEntity borrowerDetailEntity;
	
	@ManyToOne(targetEntity=InvoiceDetailEntity.class,cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")	
	private InvoiceDetailEntity invoiceDetailEntity;
	
	
	public DocumentsDetailEntity() {
		System.out.println("in docu c entity");
	}


	public DocumentsDetailEntity(String source, String sourceIdentifier, String documentFormat, String type,
			Boolean isDataInline, String data) {
		super();
		this.source = source;
		this.sourceIdentifier = sourceIdentifier;
		this.documentFormat = documentFormat;
		this.type = type;
		this.isDataInline = isDataInline;
		this.data = data;
	}


	public String getDocumentDetailId() {
		return documentDetailId;
	}


	public void setDocumentDetailId(String documentDetailId) {
		this.documentDetailId = documentDetailId;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getSourceIdentifier() {
		return sourceIdentifier;
	}


	public void setSourceIdentifier(String sourceIdentifier) {
		this.sourceIdentifier = sourceIdentifier;
	}


	public String getDocumentFormat() {
		return documentFormat;
	}


	public void setDocumentFormat(String documentFormat) {
		this.documentFormat = documentFormat;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Boolean getIsDataInline() {
		return isDataInline;
	}


	public void setIsDataInline(Boolean isDataInline) {
		this.isDataInline = isDataInline;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
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
		return "DocumentsDetailEntity [documentDetailId=" + documentDetailId + ", source=" + source
				+ ", sourceIdentifier=" + sourceIdentifier + ", documentFormat=" + documentFormat + ", type=" + type
				+ ", isDataInline=" + isDataInline + ", data=" + data + ", borrowerDetailEntity=" + borrowerDetailEntity
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
