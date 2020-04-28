package com.infosys.LSP.LSP.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infosys.LSP.LSP.dao.CreateLoanDAO;
import com.infosys.LSP.LSP.entity.Acknowledge;
import com.infosys.LSP.LSP.entity.LoanApplicationDetails;
@Service
public class CreateLoanServiceImpl implements CreateLoanSevice {
	private  CreateLoanDAO createLoanDAO;
	
	@Autowired
	public CreateLoanServiceImpl(@Qualifier("createLoanDAOImpl")CreateLoanDAO theCreateLoanDAO) {
		createLoanDAO = theCreateLoanDAO;
		
	}
	
	@Override
	@Transactional
	public LoanApplicationDetails crLoanApp(LoanApplicationDetails loanApplicationDetails) {
		
		return createLoanDAO.crLoanApp(loanApplicationDetails);
	}

	@Override
	public Acknowledge createLoanApplicationResponse(Acknowledge acknowledge) {
		
		return createLoanDAO.createLoanApplicationResponse(acknowledge);
	}

}
