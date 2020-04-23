package com.infosys.LSP.LSP.service;

import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;

public interface CreateLoanSevice {
	public Acknowledge crLoanApp(LoanApplicationDetails loanApplicationDetails);

}
