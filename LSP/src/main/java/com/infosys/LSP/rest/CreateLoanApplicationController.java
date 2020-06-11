package com.infosys.LSP.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.infosys.LSP.Bean.LoanApplicationStatus;
import com.infosys.LSP.entity.InvoiceDetailEntity;
import com.infosys.LSP.service.CreateLoanApplicationService;

@RestController
@RequestMapping("/api")
public class CreateLoanApplicationController {
	
	private CreateLoanApplicationService createLoanApplicationService;
	
	public CreateLoanApplicationController(CreateLoanApplicationService theCreateLoanApplicationService) {
			this.createLoanApplicationService=theCreateLoanApplicationService;
	}
	
	@RequestMapping(value ="/createLoanApp", method = RequestMethod.POST, produces = "application/json")	
	public LoanApplicationStatus createLoanApplication(@RequestBody InvoiceDetailEntity invoiceDetailEntity) throws Exception{
		
		
		//   returnng null
		System.out.println("in controller or json " + invoiceDetailEntity);
		System.out.println("in controller or json " +invoiceDetailEntity.getBorrowerDetailEntity());
		//System.out.println("in controller orrr json "+invoiceDetailEntity.getBorrowerDetailEntity().getContactDetailEntity());
		
		createLoanApplicationService.createLoanApplication(invoiceDetailEntity);
		return null;
	}
	

}
