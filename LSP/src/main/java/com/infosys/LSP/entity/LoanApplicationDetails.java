package com.infosys.LSP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan", schema = "employee_directory")
public class LoanApplicationDetails {
	@Id
	@Column(name="requestid")
	private String requestId;
	
	@Column(name="create_date")
	private String createDate;
	
	@Column(name="traceid")
	private String traceId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="version")
	private float  version;
	
	@Column(name="error")
	private int error;
	
	public LoanApplicationDetails() {
		
	}

	public LoanApplicationDetails(String createDate, String traceId, String type, float version, int error) {
		super();
		this.createDate = createDate;
		this.traceId = traceId;
		this.type = type;
		this.version = version;
		this.error = error;
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

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "LoanApplicationDetails [requestId=" + requestId + ", createDate=" + createDate + ", traceId=" + traceId
				+ ", type=" + type + ", version=" + version + ", error=" + error + "]";
	}
	

}
