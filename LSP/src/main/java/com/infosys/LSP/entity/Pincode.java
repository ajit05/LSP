package com.infosys.LSP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pincode")
public class Pincode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="picode_id")
	private Integer pincode_id;
	
	@Column(name="pincode")
	private Integer pincode;
	
	public Pincode() {
		
	}

	public Pincode(Integer pincode) {
		super();
		this.pincode = pincode;
	}

	public Integer getPincode_id() {
		return pincode_id;
	}

	public void setPincode_id(Integer pincode_id) {
		this.pincode_id = pincode_id;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}	

}
