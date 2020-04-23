package com.infosys.LSP.LSP.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;
import com.infosys.LSP.LSP.utility.IDGenerator;

@Repository
public class CreateLoanDAOImpl implements CreateLoanDAO {
	private EntityManager entitymanager;	
	Date dNow = new Date( );
    SimpleDateFormat ft = 
    new SimpleDateFormat ("YYYY-MM-DD hh:mm:ss");
    
	@Autowired
	public CreateLoanDAOImpl(EntityManager theentitymanager) {
		entitymanager= theentitymanager;
	}	
	public  CreateLoanDAOImpl() {
		
	}	
	@Override
	public Acknowledge crLoanApp(LoanApplicationDetails loanApplicationDetails) {		
		Session  currentSession=entitymanager.unwrap(Session.class);		
		IDGenerator idgenerate=new IDGenerator() ;
		String requestid=idgenerate.idGeneration();	
		String traceid=idgenerate.idGeneration();
		loanApplicationDetails.setRequestId(requestid);
		loanApplicationDetails.setTraceId(traceid);
		loanApplicationDetails.setCreateDate(ft.toString());		
		Acknowledge ack=new Acknowledge();		
		ack.setId(0);		 
		ack.setLoanApplicationDetails(loanApplicationDetails);
		currentSession.saveOrUpdate(loanApplicationDetails);	
		System.out.println("in dao  its  working well");
		return ack;			
	}

}
