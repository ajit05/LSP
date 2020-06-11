package com.infosys.LSP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ack")
public class Acknowledge {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="request_id")
	private String requestId;	
	
	@Column(name="loan_application_id")
	private String loanApplicationId;
	
	@Column(name="lender_name")
	private String lenderName;
	
	@Column(name="rejection_details")
	private String rejectionDetails;
	
	@Column(name="action_required")
	private String actionRequired;
	
	@Column(name="loan_application_status")
	private String loanApplicationStatus;
	
	@Column(name="trace_id")
	private String traceId;
	
	@Column(name="create_date")
	private String createDate;
	
	@Column(name="org_id")
	private String orgId;
	
	@Column(name="version")
	private float version;
	
	@Column(name="error")
	private int error;
	
	
	public Acknowledge() {
		
	}

	public Acknowledge(String requestId, String loanApplicationId, String lenderName, String rejectionDetails,
			String actionRequired, String loanApplicationStatus, String traceId, String createDate, String orgId,
			float version, int error) {
		super();
		this.requestId = requestId;
		this.loanApplicationId = loanApplicationId;
		this.lenderName = lenderName;
		this.rejectionDetails = rejectionDetails;
		this.actionRequired = actionRequired;
		this.loanApplicationStatus = loanApplicationStatus;
		this.traceId = traceId;
		this.createDate = createDate;
		this.orgId = orgId;
		this.version = version;
		this.error=error;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(String loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public String getLenderName() {
		return lenderName;
	}

	public void setLenderName(String lenderName) {
		this.lenderName = lenderName;
	}

	public String getRejectionDetails() {
		return rejectionDetails;
	}

	public void setRejectionDetails(String rejectionDetails) {
		this.rejectionDetails = rejectionDetails;
	}

	public String getActionRequired() {
		return actionRequired;
	}

	public void setActionRequired(String actionRequired) {
		this.actionRequired = actionRequired;
	}

	public String getLoanApplicationStatus() {
		return loanApplicationStatus;
	}

	public void setLoanApplicationStatus(String loanApplicationStatus) {
		this.loanApplicationStatus = loanApplicationStatus;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
		return "Acknowledge [id=" + id + ", requestId=" + requestId + ", loanApplicationId=" + loanApplicationId
				+ ", lenderName=" + lenderName + ", rejectionDetails=" + rejectionDetails + ", actionRequired="
				+ actionRequired + ", loanApplicationStatus=" + loanApplicationStatus + ", traceId=" + traceId
				+ ", createDate=" + createDate + ", orgId=" + orgId + ", version=" + version + ", error=" + error + "]";
	}

	
	
}
