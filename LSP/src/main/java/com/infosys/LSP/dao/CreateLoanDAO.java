package com.infosys.LSP.dao;




import com.infosys.LSP.entity.Acknowledge;
import com.infosys.LSP.entity.LoanApplicationDetails;
import com.infosys.LSP.entity.LoanDetail;

public interface CreateLoanDAO {
	
	public  LoanApplicationDetails crLoanApp(LoanApplicationDetails loanApplicationDetails);
	
	public  Acknowledge  createLoanApplicationResponse(Acknowledge acknowledge);
	
	public LoanDetail createLoanApplication(LoanDetail loanDetail);
	
	public LoanDetail getCreateLoanApplicationDetails(String transactionId);
	

}
