package com.infosys.LSP.LSP.Bean;

public class ContactDetailBO {
	
	private String Id;
	private String type;
	private String email;
	
	
	
	public ContactDetailBO() {
		
	}


	public ContactDetailBO(String id, String type, String email) {
		super();
		Id = id;
		this.type = type;
		this.email = email;
		
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

}
