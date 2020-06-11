package com.infosys.LSP.service;

import com.infosys.LSP.Bean.LoanApplicationStatus;
import com.infosys.LSP.entity.InvoiceDetailEntity;

public interface CreateLoanApplicationService {
	
	public 	LoanApplicationStatus  createLoanApplication(InvoiceDetailEntity invoiceDetailEntity) throws Exception;

}
