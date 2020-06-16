package com.infosys.LSP.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	
	
	public  CreateLoanApplicationDAOImpl(){
			
	}
	
	@Autowired
	public CreateLoanApplicationDAOImpl(EntityManager theEntitymanager) {
		this.entitymanager = theEntitymanager;
	}	
	
	@Override
	public LoanApplicationStatus createLoanApplication(InvoiceDetailEntity invoiceDetailEntity) throws Exception {	
		CreateLoanAppliation createLoanAppliation=new CreateLoanAppliation();
			HashMap<String,String> statusMap=new HashMap<String,String>();
			LoanApplicationStatus  loanApplicationStatus=null;
			List<InvoiceDetailEntity> invoiceDetailEntityobj=new ArrayList<InvoiceDetailEntity>();
			Session  currentSession=entitymanager.unwrap(Session.class);			
			Query<Pincode> theQuery=currentSession.createQuery(Constants.PINCODE_QUERY,Pincode.class);
			List<Pincode> pincode = theQuery.getResultList();			
			statusMap=createLoanAppliation.crateInvoiceDetails(invoiceDetailEntity,pincode);
			invoiceDetailEntityobj=createLoanAppliation.CreateLoanApplicatioSave(invoiceDetailEntity, statusMap); 
			for(int i=0;i<invoiceDetailEntityobj.size();i++) {
				System.out.println("-------oooooooooooooooo---------"+i);				
				
				currentSession.persist(invoiceDetailEntityobj.get(i));	
			}
			return loanApplicationStatus;
	}

	@Override
	public Integer getPincode() throws Exception {
		Integer pincode=null;	
		try {
			System.out.println("before  query........");
			
			Session  currentSession=entitymanager.unwrap(Session.class);
			//currentSession.beginTransaction();
			Pincode pin= currentSession.get(Pincode.class,1 );
			System.out.println("pin object --"+pin);
		//	currentSession.close();
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		  return pincode;
	}
	

}
