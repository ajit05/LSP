package com.infosys.LSP.LSP.dao;

import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;

public interface CreateLoanDAO {
	
	public Acknowledge crLoanApp(LoanApplicationDetails loanApplicationDetails);

}
