package com.infosys.LSP.rest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.DatatypeConverter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
	public InvoiceDetailEntity createLoanApplication(@RequestBody InvoiceDetailEntity invoiceDetailEntity) throws Exception{
		
			
			// Java object to JSON string
			//ObjectMapper mapper = new ObjectMapper();			
			//String jsonString = mapper.writeValueAsString(invoiceDetailEntity);
			//System.out.println(jsonString);     
			// Encode this value into Base6  
		
			
					
		createLoanApplicationService.createLoanApplication(invoiceDetailEntity);
		return invoiceDetailEntity;
	}
	

}
