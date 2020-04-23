package com.infosys.LSP.LSP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loanApplicationDetails")
public class LoanApplicationDetails {
	@Id
	@Column(name="requestid")
	private String requestId;
	
	@Column(name="createDate")
	private String createDate;
	
	@Column(name="traceid")
	private String traceId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="vesion")
	private float  version;
	
	public LoanApplicationDetails() {
		
	}

	public LoanApplicationDetails(String requestId, String createDate, String traceId, String type, float version) {
		super();
		this.requestId = requestId;
		this.createDate = createDate;
		this.traceId = traceId;
		this.type = type;
		this.version = version;
	}

	public String getRequestId() {
		return requestId;
		
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getVersion() {
		return version;
	}

	public void setVersion(float version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "LoanApplicationDetails [requestId=" + requestId + ", createDate=" + createDate + ", traceId=" + traceId
				+ ", type=" + type + ", version=" + version + "]";
	}

	
	
	
	
	
	  
	
	 
	
	

}
