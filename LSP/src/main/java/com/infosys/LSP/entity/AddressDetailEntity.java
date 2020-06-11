package com.infosys.LSP.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="addressDetails")
public class AddressDetailEntity {
	@Id
	@Column(name="address_details_id")
	private String addressDetailId;
	
	@Column(name="borrower_phone")
	private Integer borrowerPhone;
	
	@Column(name="address_type")
	private String addressType;
	
	@Column(name="address_pincode")
	private Integer pinCode;
	
	@Column(name="address_state")
	private String addressCountry;
	
	@Column(name="address_details")
	private String adressDetail;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="contact_details_id")
	private ContactDetailEntity  contactDetailId;
	
	
	public AddressDetailEntity() {
		
	}

	public AddressDetailEntity(Integer borrowerPhone, String addressType, Integer pinCode, String addressCountry,
			String adressDetail) {
		super();
		this.borrowerPhone = borrowerPhone;
		this.addressType = addressType;
		this.pinCode = pinCode;
		this.addressCountry = addressCountry;
		this.adressDetail = adressDetail;
	}


	public String getAddressDetailId() {
		return addressDetailId;
	}


	public void setAddressDetailId(String addressDetailId) {
		this.addressDetailId = addressDetailId;
	}

	public Integer getBorrowerPhone() {
		return borrowerPhone;
	}


	public void setBorrowerPhone(Integer borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}


	public String getAddressType() {
		return addressType;
	}


	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}


	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}


	public String getAdressDetail() {
		return adressDetail;
	}


	public void setAdressDetail(String adressDetail) {
		this.adressDetail = adressDetail;
	}

	public ContactDetailEntity getContactDetailId() {
		return contactDetailId;
	}

	public void setContactDetailId(ContactDetailEntity contactDetailId) {
		this.contactDetailId = contactDetailId;
	}

	@Override
	public String toString() {
		return "AddressDetailEntity [addressDetailId=" + addressDetailId + ", borrowerPhone=" + borrowerPhone
				+ ", addressType=" + addressType + ", pinCode=" + pinCode + ", addressCountry=" + addressCountry
				+ ", adressDetail=" + adressDetail + ", contactDetailId=" + contactDetailId + "]";
	}	

}


/*addressDetails(
	address_details_id uuid unique,
	borrower_phone integer not null unique,
	address_type  varchar(2) not null, 
	address_pincode integer not null unique,
	address_state varchar(30),
	address_country varchar(30), 
	address_details json,
	contact_details_id uuid,
	PRIMARY KEY(address_details_id),
	FOREIGN KEY(contact_details_id)
	REFERENCES contactDetails(contact_details_id)	*/