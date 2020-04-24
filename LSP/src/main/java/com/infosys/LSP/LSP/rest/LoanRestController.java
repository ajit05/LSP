package com.infosys.LSP.LSP.rest;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;
import com.infosys.LSP.LSP.service.CreateLoanSevice;


@RestController
@RequestMapping("/api")
public class LoanRestController {
	
	private CreateLoanSevice  createLoanService;
	
	public LoanRestController(CreateLoanSevice thecreateLoanService) {
		createLoanService= thecreateLoanService;
	}
	@RequestMapping(value ="/createLoan", method = RequestMethod.POST, produces = "application/json")	
	public LoanApplicationDetails createLoanApplication(@RequestBody LoanApplicationDetails loanApplicationDetails ) {
		System.out.println("inside createloan");
		LoanApplicationDetails ack=new LoanApplicationDetails();
		LoanApplicationDetails ack1=new LoanApplicationDetails();
		ack= createLoanService.crLoanApp(loanApplicationDetails);
		if(ack==null) {
			ack1.setVersion(1.0f);
			ack1.setError(0);
			return ack1;			
		}
		
		return  ack;
	}
}
