package com.infosys.LSP.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.infosys.LSP.Bean.LoanApplicationStatus;
import com.infosys.LSP.assembler.CreateLoanAppliation;
import com.infosys.LSP.entity.InvoiceDetailEntity;
import com.infosys.LSP.entity.Pincode;
import com.infosys.LSP.exception.PinCodeNotFoundException;
import com.infosys.LSP.utility.Constants;


@Repository
public class CreateLoanApplicationDAOImpl implements CreateLoanApplicationDAO {
	
	private EntityManager entitymanager; 
	
	CreateLoanAppliation createLoanAppliation=new CreateLoanAppliation();
	
	public  CreateLoanApplicationDAOImpl(){
			
	}
	
	@Autowired
	public CreateLoanApplicationDAOImpl(EntityManager theentitymanager) {
		entitymanager = theentitymanager;
	}	
	
	@Override
	public LoanApplicationStatus createLoanApplication(InvoiceDetailEntity invoiceDetailEntity) throws Exception {
		// TODO Auto-generated method stub
		
		 LoanApplicationStatus  loanApplicationStatus=new  LoanApplicationStatus();
		 createLoanAppliation.crateInvoiceDetails(invoiceDetailEntity);				
		 return loanApplicationStatus;
	}
	@Override
	public Integer getPincode() throws  PinCodeNotFoundException, Exception {
		Session  currentSession=entitymanager.unwrap(Session.class);
		Query<Pincode> theQuery=currentSession.createQuery(Constants.PINCODE_QUERY,Pincode.class);		
		Integer pincode =theQuery.executeUpdate();
		if(pincode==null)
			throw new PinCodeNotFoundException("Given picode is not allowed");	
		  return pincode;
	}	

}
