package com.infosys.LSP.entity;

i
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="colletral_details")
public class ColletralDetailEntity {	

	@Id
	@Column(name="collateral_Primary_id")
	private String collateralPrimaryId;	
	
	@Column(name="collateral_Primary_id_Type")
	private String collateralPrimaryIdType;
	
	@Column(name="collateral_type")
	private String type;
	
	@Column(name="collateral_additional_identifiers")
	private String additionalIdentifiers;
	
	@Column(name="Invoice_date")
	private String date;
	
	/*@OneToOne(mappedBy="colletralDetailEntity",fetch = FetchType.LAZY)
	private ValuationDetailEntity valuation;*/
	
	
	@ManyToOne(cascade=CascadeType.ALL)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	@OneToMany(mappedBy="colletralDetailEntity",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<DocumentsDetailEntity> documents;
	
	
	public ColletralDetailEntity() {
		super();
		
	}

	public ColletralDetailEntity(String collateralPrimaryIdType, String type, String additionalIdentifiers,
			String date) {
		super();
		this.collateralPrimaryIdType = collateralPrimaryIdType;
		this.type = type;
		this.additionalIdentifiers = additionalIdentifiers;
		this.date = date;
	}





	public String getCollateralPrimaryId() {
		return collateralPrimaryId;
	}


	public void setCollateralPrimaryId(String collateralPrimaryId) {
		this.collateralPrimaryId = collateralPrimaryId;
	}


	public String getCollateralPrimaryIdType() {
		return collateralPrimaryIdType;
	}


	public void setCollateralPrimaryIdType(String collateralPrimaryIdType) {
		this.collateralPrimaryIdType = collateralPrimaryIdType;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAdditionalIdentifiers() {
		return additionalIdentifiers;
	}


	public void setAdditionalIdentifiers(String additionalIdentifiers) {
		this.additionalIdentifiers = additionalIdentifiers;
	}


	/*public BorrowerDetailEntity getBorrowerDetailEntity() {
		return borrowerDetailEntity;
	}


	public void setBorrowerDetailEntity(BorrowerDetailEntity borrowerDetailEntity) {
		this.borrowerDetailEntity = borrowerDetailEntity;
	}*/


	public InvoiceDetailEntity getInvoiceDetailEntity() {
		return invoiceDetailEntity;
	}


	public void setInvoiceDetailEntity(InvoiceDetailEntity invoiceDetailEntity) {
		this.invoiceDetailEntity = invoiceDetailEntity;
	}
	
	

	/*public ValuationDetailEntity getValuation() {
		return valuation;
	}


	public void setValuation(ValuationDetailEntity valuation) {
		this.valuation = valuation;
	}*/


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
	
	@OneToMany(mappedBy="colletralDetailEntity",fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	public List<DocumentsDetailEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentsDetailEntity> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "ColletralDetailEntity [collateralPrimaryId=" + collateralPrimaryId + ", collateralPrimaryIdType="
				+ collateralPrimaryIdType + ", type=" + type + ", additionalIdentifiers=" + additionalIdentifiers
				+ ", date=" + date + ", invoiceDetailEntity="
				+ invoiceDetailEntity + ", documents=" + documents + "]";
	}
	
	

	
	
}

