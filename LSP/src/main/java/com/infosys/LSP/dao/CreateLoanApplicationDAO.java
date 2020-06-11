package com.infosys.LSP.dao;



import com.infosys.LSP.Bean.LoanApplicationStatus;
import com.infosys.LSP.entity.InvoiceDetailEntity;


public interface CreateLoanApplicationDAO {	
	
	public LoanApplicationStatus createLoanApplication(InvoiceDetailEntity invoiceDetailEntity) throws Exception;
	public Integer getPincode() throws Exception;
		
	
}
