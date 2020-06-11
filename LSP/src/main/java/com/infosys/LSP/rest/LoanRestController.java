package com.infosys.LSP.rest;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infosys.LSP.Bean.BorrowerBO;
import com.infosys.LSP.Bean.ContactDetailBO;
import com.infosys.LSP.Bean.LoanDetailBO;
import com.infosys.LSP.entity.Acknowledge;
import com.infosys.LSP.entity.LoanApplicationDetails;
import com.infosys.LSP.entity.LoanDetail;
import com.infosys.LSP.service.CreateLoanSevice;

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
	
	@RequestMapping(value ="/createLoanResponse", method = RequestMethod.POST, produces = "application/json")	
	public  Acknowledge createLoanApplicationResponse(@RequestBody Acknowledge  acknowledge) {
		Acknowledge  ack=new Acknowledge();
		ack=createLoanService.createLoanApplicationResponse(acknowledge);
		if(ack==null) {
		   acknowledge.setRejectionDetails("null value");
		   return  acknowledge;
		}
		return acknowledge;
	}
	
	@RequestMapping(value ="/createloanapplication", method = RequestMethod.POST, produces = "application/json")
	public LoanDetailBO createLoanApplication(@RequestBody LoanDetail  loanDetail) {
		LoanDetail newloanDetail=new LoanDetail();
		System.out.println("------------------"+  loanDetail);
		System.out.println("---------Borrower object---------"+  loanDetail.getBorrower());
	//	System.out.println("------------------"+  loanDetail.getBorrower().getLoanDetail().getType());
		
		LoanDetailBO  loanDetailBO= new LoanDetailBO();
		
	/*
		
		BorrowerBO   borrower=new BorrowerBO();
		ContactDetailBO  contactDetailBO=new ContactDetailBO();
		newloanDetail=createLoanService.createLoanApplication(loanDetail);	
		loanDetailBO.setTransactionId(newloanDetail.getTransactionId());
		loanDetailBO.setType(newloanDetail.getType());
		borrower.setId(newloanDetail.getBorrower().getId());
		borrower.setFirstName(newloanDetail.getBorrower().getFirstName());
		contactDetailBO.setId(newloanDetail.getBorrower().getContactDetail().get(0).getId());
		contactDetailBO.setEmail(newloanDetail.getBorrower().getContactDetail().get(0).getEmail());
		borrower.setContactDetailBO(contactDetailBO);
		loanDetailBO.setBorrowerBO(borrower);	*/
		return loanDetailBO;
		
	}
	@RequestMapping(value ="/getcreateloanapplication/{transactionId}", method = RequestMethod.GET, produces = "application/json")
	public LoanDetail getCreateLoanApplicationDetails( @PathVariable String transactionId) {
		
		return  createLoanService.getCreateLoanApplicationDetails(transactionId);
		
	}
	
}
