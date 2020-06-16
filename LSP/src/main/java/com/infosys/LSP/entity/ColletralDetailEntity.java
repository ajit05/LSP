package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="colletralDetails")
public class ColletralDetailEntity {	

	@Id
	@Column(name="collateral_Primary_id")
	private String collateralPrimaryId;	
	
	@Column(name="collateral_Primary_id_Type")
	private String collateralPrimaryIdType;
	
	@Column(name="collateral_type")
	private String type;
	
	@Column(name="collateral_additionalIdentifiers")
	private String additionalIdentifiers;
	
	@Column(name="Invoice_date")
	private String date;
	
	/*@OneToOne(mappedBy="colletralDetailEntity",fetch = FetchType.LAZY)
	private ValuationDetailEntity valuation;*/

	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="borrower_applicant_id")	
	private BorrowerDetailEntity borrowerDetailEntity;
	
	@ManyToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	
	public ColletralDetailEntity() {
		System.out.println("in colletral c entity");
		
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

	@Override
	public String toString() {
		return "ColletralDetailEntity [collateralPrimaryId=" + collateralPrimaryId + ", collateralPrimaryIdType="
				+ collateralPrimaryIdType + ", type=" + type + ", additionalIdentifiers=" + additionalIdentifiers
				+ ", date=" + date + ", borrowerDetailEntity=" + borrowerDetailEntity + ", invoiceDetailEntity="
				+ invoiceDetailEntity + "]";
	}

	
	
}

