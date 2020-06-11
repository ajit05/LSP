package com.infosys.LSP.Bean;

public class BorrowerBO {
	
	
	private String Id;
	private String firstName;
	private String middleName;
	private String lastName;
	
	private ContactDetailBO contactDetailBO;
	
	public BorrowerBO() {
		
	}

	public BorrowerBO(String id, String firstName, String middleName, String lastName, 
			ContactDetailBO contactDetailBO) {
		super();
		Id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;		
		this.contactDetailBO = contactDetailBO;
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

	

	public ContactDetailBO getContactDetailBO() {
		return contactDetailBO;
	}

	public void setContactDetailBO(ContactDetailBO contactDetailBO) {
		this.contactDetailBO = contactDetailBO;
	}

	
}
