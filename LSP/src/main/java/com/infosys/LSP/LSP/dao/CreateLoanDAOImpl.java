package com.infosys.LSP.LSP.dao;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;
import com.infosys.LSP.LSP.utility.DateConverter;
import com.infosys.LSP.LSP.utility.IDGenerator;
import java.util.*;



@Repository
public class CreateLoanDAOImpl implements CreateLoanDAO {
	private EntityManager entitymanager; 
	
	@Autowired
	public CreateLoanDAOImpl(EntityManager theentitymanager) {
		entitymanager= theentitymanager;
	}	
	public  CreateLoanDAOImpl() {
		
	}	
	@Override
	public LoanApplicationDetails crLoanApp(LoanApplicationDetails loanApplicationDetails) {		
		Session  currentSession=entitymanager.unwrap(Session.class);
		DateConverter dateconverter=new DateConverter();
		IDGenerator idgenerate=new IDGenerator() ;
		String requestid=idgenerate.idGeneration();	
		String traceid=idgenerate.idGeneration();
		loanApplicationDetails.setRequestId(requestid);
		loanApplicationDetails.setTraceId(traceid);
		loanApplicationDetails.setCreateDate(dateconverter.JavaDateObjectToSQLDate());	
		currentSession.saveOrUpdate(loanApplicationDetails);			
		System.out.println("in dao  its  working well");
		return loanApplicationDetails;			
	}
	@Override
	public Acknowledge createLoanApplicationResponse(Acknowledge acknowledge) {
		Session  currentSession=entitymanager.unwrap(Session.class);
		String  requestId= acknowledge.getRequestId();
		System.out.println(requestId);
		String hql = "FROM  LoanApplicationDetails LAP WHERE LAP.requestId = "+requestId;
		Query query = currentSession.createQuery(hql);
		List results = query.list();
		
		if(results==null) {
			System.out.println("nulllllllllll");
			return null;
			
		}
		
		return acknowledge;
	}

}
