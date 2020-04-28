package com.infosys.LSP.LSP.dao;




import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;

public interface CreateLoanDAO {
	
	public  LoanApplicationDetails crLoanApp(LoanApplicationDetails loanApplicationDetails);
	
	public  Acknowledge  createLoanApplicationResponse(Acknowledge acknowledge);

}
