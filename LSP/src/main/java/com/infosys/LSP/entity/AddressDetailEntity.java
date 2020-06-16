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
	
	@Column(name="address_type")
	private String addressType;
	
	@Column(name="address_pincode")
	private Integer pincode;
	
	@Column(name="address_country")
	private String country;
	
	@Column(name="address_state")
	private String state;
	
	@Column(name="address_details")
	private String adressDetail;
	
	@OneToOne(cascade=CascadeType.PERSIST)	
	@JoinColumn(name="contact_details_id")
	private ContactDetailEntity  contactDetailEntity;
	
	
	public AddressDetailEntity() {
		
	}


	public AddressDetailEntity(String addressType, Integer pincode, String country, String adressDetail) {
		super();
		this.addressType = addressType;
		this.pincode = pincode;
		this.country = country;
		this.adressDetail = adressDetail;
	}


	public String getAddressDetailId() {
		return addressDetailId;
	}


	public void setAddressDetailId(String addressDetailId) {
		this.addressDetailId = addressDetailId;
	}


	public String getAddressType() {
		return addressType;
	}


	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}


	public Integer getPincode() {
		return pincode;
	}


	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getAdressDetail() {
		return adressDetail;
	}


	public void setAdressDetail(String adressDetail) {
		this.adressDetail = adressDetail;
	}


	public ContactDetailEntity getContactDetailEntity() {
		return contactDetailEntity;
	}


	public void setContactDetailEntity(ContactDetailEntity contactDetailEntity) {
		this.contactDetailEntity = contactDetailEntity;
	}

	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddressDetailEntity [addressDetailId=" + addressDetailId + ", addressType=" + addressType + ", pincode="
				+ pincode + ", country=" + country + ", state=" + state + ", adressDetail=" + adressDetail
				+ ", contactDetailEntity=" + contactDetailEntity + "]";
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