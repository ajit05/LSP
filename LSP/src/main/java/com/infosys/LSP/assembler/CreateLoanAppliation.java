package com.infosys.LSP.assembler;

import com.infosys.LSP.entity.BorrowerDetailEntity;
import com.infosys.LSP.entity.InvoiceDetailEntity;
import com.infosys.LSP.utility.LoanApplicationValidation;

import ch.qos.logback.core.net.SyslogOutputStream;

public class CreateLoanAppliation {
	
	
	public CreateLoanAppliation() {
		
	}
	
	public  InvoiceDetailEntity crateInvoiceDetails(InvoiceDetailEntity invoiceDetailEntity) throws Exception {
		LoanApplicationValidation  loanApplicationValidation=new LoanApplicationValidation();	
		InvoiceDetailEntity invoiceDetailEntityTemp=new InvoiceDetailEntity();
		BorrowerDetailEntity borrowerDetailsEntity =new BorrowerDetailEntity();
		
		
		invoiceDetailEntityTemp.setBorrowerDetailEntity(invoiceDetailEntity.getBorrowerDetailEntity());
		invoiceDetailEntityTemp.setContactDetailEntity(invoiceDetailEntity.getContactDetailEntity());
		
		
		System.out.println("-----------"+invoiceDetailEntityTemp.getBorrowerDetailEntity());
		
	/*	System.out.println(invoiceDetailEntity.getBorrowerDetailEntity().getContactDetailEntity());
		System.out.println(invoiceDetailEntity.getBorrowerDetailEntity().getContactDetailEntity().getAddressDetailEntity());
		System.out.println(invoiceDetailEntity.getBorrowerDetailEntity().getContactDetailEntity().getAddressDetailEntity().getPinCode());
		*/
		return null;
		
		
		
		
		
	}
	

}
