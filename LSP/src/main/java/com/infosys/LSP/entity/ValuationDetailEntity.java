package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="valuationDetails")
public class ValuationDetailEntity {
	
	
	@Id
	@Column(name="valuation_details_id")
	private String valuationId;
	
	@Column(name="value")
	private String value;

	@Column(name="currency")
	private double currency;
	
	@Column(name="valauation_date")
	private String valuatonDate;
	
	@Column(name="source")
	private String source;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="loan_application_no")
	private InvoiceDetailEntity invoiceDetailEntity;
	
	public ValuationDetailEntity() {
		
	}

	public ValuationDetailEntity(String value, double currency, String valuatonDate, String source) {
		super();
		this.value = value;
		this.currency = currency;
		this.valuatonDate = valuatonDate;
		this.source = source;
	}

	public String getValuationId() {
		return valuationId;
	}

	public void setValuationId(String valuationId) {
		this.valuationId = valuationId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public double getCurrency() {
		return currency;
	}

	public void setCurrency(double currency) {
		this.currency = currency;
	}

	public String getValuatonDate() {
		return valuatonDate;
	}

	public void setValuatonDate(String valuatonDate) {
		this.valuatonDate = valuatonDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public InvoiceDetailEntity getInvoiceDetailEntity() {
		return invoiceDetailEntity;
	}

	public void setInvoiceDetailEntity(InvoiceDetailEntity invoiceDetailEntity) {
		this.invoiceDetailEntity = invoiceDetailEntity;
	}

	@Override
	public String toString() {
		return "ValuationDetailEntity [valuationId=" + valuationId + ", value=" + value + ", currency=" + currency
				+ ", valuatonDate=" + valuatonDate + ", source=" + source + ", invoiceDetailEntity="
				+ invoiceDetailEntity + "]";
	}
}

/*valuationDetails(
	valuation_details_id uuid ,
	value varchar(20),
	currency  numeric(20,4),
	valauation_date timestamp,
	source varchar(6),
	collateral_Primary_id varchar(50),
	loan_application_no UUID ,
	PRIMARY KEY(valuation_details_id),
	FOREIGN KEY(loan_application_no)
	REFERENCES invoicedetails(loan_application_no)
 */
