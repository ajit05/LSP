package com.infosys.LSP.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.infosys.LSP.Bean.LoanApplicationStatus;
import com.infosys.LSP.dao.CreateLoanApplicationDAO;
import com.infosys.LSP.entity.InvoiceDetailEntity;


@Service
public class CreateLoanApplicationServiceImpl implements CreateLoanApplicationService {
	
	private  CreateLoanApplicationDAO createLoanApplicationDAO;
	
	@Autowired
	public CreateLoanApplicationServiceImpl(@Qualifier("createLoanApplicationDAOImpl") CreateLoanApplicationDAO theCreateLoanDAO) {
		createLoanApplicationDAO = theCreateLoanDAO;
	}

	@Override
	@Transactional
	public LoanApplicationStatus createLoanApplication(InvoiceDetailEntity invoiceDetailEntity) throws Exception {		
		return createLoanApplicationDAO.createLoanApplication(invoiceDetailEntity);
	}
}
