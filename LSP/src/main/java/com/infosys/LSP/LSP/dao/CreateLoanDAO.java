package com.infosys.LSP.LSP.dao;




import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;
import com.infosys.LSP.LSP.entity.LoanDetail;

public interface CreateLoanDAO {
	
	public  LoanApplicationDetails crLoanApp(LoanApplicationDetails loanApplicationDetails);
	
	public  Acknowledge  createLoanApplicationResponse(Acknowledge acknowledge);
	
	public LoanDetail createLoanApplication(LoanDetail loanDetail);
	

}
