package com.infosys.LSP.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="borrower")
public class Borrower {
	@javax.persistence.Id
	@Column(name="id")
	private String Id;
	
	@Column(name="first_name")
	private String  firstName;
	
	@Column(name="middle_name")
	private String  middleName;
	
	@Column(name="last_name")
	private String  lastName;
	
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="transaction_id")
	private LoanDetail loanDetail;  
	
	
	@OneToMany(mappedBy="borrower")
	private List<ContactDetail> contactDetail=new ArrayList<ContactDetail>();
	
	
	public  Borrower() {
		
	}

	public Borrower(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LoanDetail getLoanDetail() {
		return loanDetail;
	}

	public void setLoanDetail(LoanDetail loanDetail) {
		this.loanDetail = loanDetail;
	}
	

	@Override
	public String toString() {
		return "Borrower [Id=" + Id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + " contactDetail=" + contactDetail + "]";
	}
	@OneToMany(fetch=FetchType.LAZY,mappedBy="Borrower",cascade= {CascadeType.PERSIST})
	public List<ContactDetail> getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(List<ContactDetail> contactDetail) {
		this.contactDetail = contactDetail;
	}

	/*public ContactDetail getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(ContactDetail contactDetail) {
		this.contactDetail = contactDetail;
	}*/
	
	
	
	
	

}
