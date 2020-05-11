package com.infosys.LSP.LSP.dao;


import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.Borrower;
import com.infosys.LSP.LSP.entity.ContactDetail;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;
import com.infosys.LSP.LSP.entity.LoanDetail;
import com.infosys.LSP.LSP.utility.DateConverter;
import com.infosys.LSP.LSP.utility.IDGenerator;



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
		String hql = "FROM  LoanApplicationDetails LAP WHERE LAP.requestId = :requestId";
		
		Query query = currentSession.createQuery(hql);
		query.setParameter("requestId", requestId);
		List results = query.list();		
		if(results==null) {
			System.out.println("null"); 
			return null;			
		}
		
		return acknowledge;
	}
	@Override
	public LoanDetail createLoanApplication(LoanDetail loanDetail) {
		Session  currentSession=entitymanager.unwrap(Session.class);
		IDGenerator idgenerate=new IDGenerator() ;


		Borrower br=new Borrower();
		ContactDetail cd=new ContactDetail();		
		String transactionId=idgenerate.idGeneration();			
		loanDetail.setTransactionId(transactionId);	
		
		br.setId(idgenerate.idGeneration());	   
		br.setContactDetail(loanDetail.getBorrower().getContactDetail());
		br.setFirstName(loanDetail.getBorrower().getFirstName());
		br.setLastName(loanDetail.getBorrower().getLastName());
		br.setLoanDetail(loanDetail);	
		
		
		cd.setType(loanDetail.getBorrower().getContactDetail().getType());
		cd.setEmail(loanDetail.getBorrower().getContactDetail().getEmail());	
		cd.setId(idgenerate.idGeneration());
	
		
		cd.setBorrower(br);
		br.setContactDetail(cd);
		br.setLoanDetail(loanDetail);
		loanDetail.setBorrower(br);
		currentSession.beginTransaction();
		currentSession.persist(cd);			
		currentSession.getTransaction().commit();
		
		currentSession.close();
		
		
		
		System.out.println("------------------------");
		return loanDetail;
	}

}
