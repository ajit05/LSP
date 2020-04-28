package com.infosys.LSP.LSP.service;


import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;

public interface CreateLoanSevice {
	
	public  LoanApplicationDetails crLoanApp(LoanApplicationDetails loanApplicationDetails);	
	public Acknowledge createLoanApplicationResponse(Acknowledge acknowledge );

}
