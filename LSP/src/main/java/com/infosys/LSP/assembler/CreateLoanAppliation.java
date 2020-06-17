package com.infosys.LSP.assembler;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import com.infosys.LSP.entity.AddressDetailEntity;
import com.infosys.LSP.entity.BorrowerDetailEntity;
import com.infosys.LSP.entity.ColletralDetailEntity;
import com.infosys.LSP.entity.ContactDetailEntity;
import com.infosys.LSP.entity.DocumentsDetailEntity;
import com.infosys.LSP.entity.InvoiceDetailEntity;
import com.infosys.LSP.entity.LoanTermDetailEntity;
import com.infosys.LSP.entity.MasterLoanDetail;
import com.infosys.LSP.entity.Pincode;
import com.infosys.LSP.utility.Constants;
import com.infosys.LSP.utility.IDGenerator;
import com.infosys.LSP.utility.LoanApplicationValidation;

import ch.qos.logback.classic.pattern.DateConverter;


public class CreateLoanAppliation {


	public CreateLoanAppliation() {

	}

	//Validation
	public  HashMap<String,String> crateInvoiceDetails(InvoiceDetailEntity invoiceDetailEntity,List<Pincode> pinocde) throws Exception {
		LoanApplicationValidation  loanApplicationValidation =new  LoanApplicationValidation();
		List<DocumentsDetailEntity> documentsDetailEntityObj=new ArrayList<DocumentsDetailEntity>();
		List<ContactDetailEntity> contactDetailEntity =new ArrayList<ContactDetailEntity>();
		contactDetailEntity=invoiceDetailEntity.getBorrower().getContactDetail();
		List<ColletralDetailEntity> colletral= new ArrayList<ColletralDetailEntity>();
		HashMap<String,String>  invoiceStatus=new HashMap<String,String>();	
		/* TODO 
		 * run loop 
		*/
		documentsDetailEntityObj=invoiceDetailEntity.getBorrower().getDocuments();
		HashMap<String, String> map=loanApplicationValidation.decodeBase64ToJSON(documentsDetailEntityObj.get(0).getData());	
	   
		java.util.Date date = Calendar.getInstance().getTime();	
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		 java.util.Date docDate = formatter.parse(map.get("rgdt"));			
		long miminumBusinessVinatge= (date.getTime()-docDate.getTime());
		//System.out.println("-------MONTS"+miminumBusinessVinatge);
		for(int i=0;i<contactDetailEntity.size();i++) {			
			if(loanApplicationValidation.validatePinCode(contactDetailEntity.get(i).getAddress().getPincode(),pinocde)==true){			
				//TODO
				if(true) {					
					if(map.get("tradeNam").equals("ALTON PLASTIC PRIVATE LTD") || map.get("tradeNam").equals("") || map.get("tradeNam").equals("LLP/Private Limited Comapny")) {						
						for(int j=0;j<colletral.size();j++) {							
							 java.util.Date firstDate = formatter.parse(colletral.get(i).getDate().toString());
							 long diffInMillies = Math.abs(date.getTime() - firstDate.getTime());
							 long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
							   System.out.println("---"+diff);
							if(diff>30)
								invoiceStatus.put(Constants.SUCCESS,colletral.get(i).getCollateralPrimaryId());					
							else {					
								invoiceStatus.put(Constants.ERROR_INVALID_COLLATERAL_DATA,colletral.get(i).getCollateralPrimaryId());
							}

						}
					}
					else
					{
						invoiceStatus.put(Constants.ERROR_BUSINESS_TYPE_NOT_SUPPORTED,invoiceDetailEntity.getTransactionId().toString());
						return  invoiceStatus;
					}

				}
				
				{
					invoiceStatus.put(Constants.ERROR_MINIMUM_VINTAGE_TIME_PEROID_EXCCEEDED,invoiceDetailEntity.getTransactionId().toString());
					return  invoiceStatus;
				}
			}
			else{
				invoiceStatus.put(Constants.ERROR_INVALID_BORROWER_DATA,invoiceDetailEntity.getTransactionId().toString());
				return  invoiceStatus;
			}

		}	

		return invoiceStatus;

	}


	//Seting Entity objects  to persist

	public List<InvoiceDetailEntity> CreateLoanApplicatioSave(InvoiceDetailEntity invoiceDetailEntity,HashMap<String,String> statusMap) throws Exception {
		
		BorrowerDetailEntity borrowerDetailEntityObj=new BorrowerDetailEntity();
		List<ContactDetailEntity> contactDetailEntityObj=new ArrayList<ContactDetailEntity>();
		
		List<ColletralDetailEntity> colletralDetailEntityObj=null;
		
		List<InvoiceDetailEntity> invoiceDetailEntityListObj=new ArrayList<InvoiceDetailEntity>();
		
		AddressDetailEntity address=new AddressDetailEntity();
		
		List<DocumentsDetailEntity> documentsDetailEntityListObj=new ArrayList<DocumentsDetailEntity>();
		List<DocumentsDetailEntity> documentsDetailEntityInsideBorrowerObj=new ArrayList<DocumentsDetailEntity>();
		List<DocumentsDetailEntity> documentsDetailEntityInsideInvoiceObj=new ArrayList<DocumentsDetailEntity>();
		
		
		LoanTermDetailEntity loanTermDetailEntityObj=new  LoanTermDetailEntity();
		MasterLoanDetail masterLoanDetail=new MasterLoanDetail();		
		colletralDetailEntityObj=invoiceDetailEntity.getCollaterals();
		IDGenerator idGen=new IDGenerator();
		if(colletralDetailEntityObj!=null) {
			for( int i=0; i<colletralDetailEntityObj.size();i++ ) {
				InvoiceDetailEntity invoiceDetailEntityTobj=new InvoiceDetailEntity();
				invoiceDetailEntityTobj.setTransactionId(invoiceDetailEntity.getTransactionId());
				invoiceDetailEntityTobj.setInvoiceNumber(colletralDetailEntityObj.get(i).getCollateralPrimaryId());
				invoiceDetailEntityTobj.setLoanApplicationNumber(idGen.idGeneration());
				invoiceDetailEntityTobj.setLoanType("CASHFLOW");
				invoiceDetailEntityListObj.add(invoiceDetailEntityTobj);	
				
			}
		}
		else
		{

		}
		if(invoiceDetailEntity.getBorrower()!=null) {
			borrowerDetailEntityObj.setBorrowerApplicantId(idGen.idGeneration());
			borrowerDetailEntityObj.setName(invoiceDetailEntity.getBorrower().getName());
			borrowerDetailEntityObj.setGuarantors(invoiceDetailEntity.getBorrower().getGuarantors());
			borrowerDetailEntityObj.setTransactionId(invoiceDetailEntity.getTransactionId());	
			//todo
			borrowerDetailEntityObj.setInvoiceDetailEntity(invoiceDetailEntityListObj.get(0));


		}
		else {

		}
		
		contactDetailEntityObj=invoiceDetailEntity.getBorrower().getContactDetail();		
		if(contactDetailEntityObj!=null) {
			for(int i=0;i<contactDetailEntityObj.size();i++) {
				contactDetailEntityObj.get(i).setContactDetailId(idGen.idGeneration());
				contactDetailEntityObj.get(i).setPhone(contactDetailEntityObj.get(i).getPhone());
				contactDetailEntityObj.get(i).setEmail(contactDetailEntityObj.get(i).getEmail());
				contactDetailEntityObj.get(i).setType(contactDetailEntityObj.get(i).getType());
				address.setAddressType("AO"/*contactDetailEntityObj.get(i).getAddress().getAddressType()*/);
				address.setAddressDetailId(idGen.idGeneration());
				address.setPincode(contactDetailEntityObj.get(i).getAddress().getPincode());
				address.setCountry(contactDetailEntityObj.get(i).getAddress().getCountry());
				address.setState(contactDetailEntityObj.get(i).getAddress().getState());
				//Todo 
				//address.setAdressDetail(contactDetailEntityObj.get(i).getAddress().getAddressDetailId());
				contactDetailEntityObj.get(i).setAddress(address);
				contactDetailEntityObj.get(i).setBorrowerDetailEntity(borrowerDetailEntityObj);
				contactDetailEntityObj.get(i).setInvoiceDetailEntity(invoiceDetailEntityListObj.get(0));
						
			}
		}
		else
		{

		}		
		borrowerDetailEntityObj.setContactDetail(contactDetailEntityObj);
		System.out.println(" ----------cccccccccccccccccccccccc--------"+contactDetailEntityObj.size());
		documentsDetailEntityInsideBorrowerObj=invoiceDetailEntity.getBorrower().getDocuments();
		documentsDetailEntityInsideInvoiceObj=invoiceDetailEntity.getCollaterals().get
		for(int i=0;i<invoiceDetailEntityListObj.size();i++) {
			DocumentsDetailEntity documentsDetailEntityObj=new DocumentsDetailEntity();
		if(documentsDetailEntityObj!=null) {	
			
				documentsDetailEntityObj.setDocumentDetailId(idGen.idGeneration());
				documentsDetailEntityObj.setData(invoiceDetailEntity.getCollaterals().get(i).getd);
				documentsDetailEntityObj.setDocumentFormat("json"/*documentsDetailEntityObj.get(i).getDocumentFormat()*/);		
				documentsDetailEntityObj.setType(invoiceDetailEntity.getCollaterals().get(i).getType());
				documentsDetailEntityObj.setSourceIdentifier(invoiceDetailEntity.getCollaterals().get(i);
				documentsDetailEntityObj.setIsDataInline(documentsDetailEntityObj.get(i).getIsDataInline());			
				documentsDetailEntityObj.setBorrowerDetailEntity(borrowerDetailEntityObj);
				documentsDetailEntityObj.setInvoiceDetailEntity(invoiceDetailEntityListObj.get(0));
			
			
		}
		}
		
		if(invoiceDetailEntity.getTerms()!=null) {			
			loanTermDetailEntityObj.setLoanTermId(idGen.idGeneration());
			loanTermDetailEntityObj.setCurrency(invoiceDetailEntity.getTerms().getCurrency());
			loanTermDetailEntityObj.setRequestAmount(invoiceDetailEntity.getTerms().getRequestAmount());
			loanTermDetailEntityObj.setBorrowerDetailEntity(borrowerDetailEntityObj);			
			loanTermDetailEntityObj.setInvoiceDetailEntity(invoiceDetailEntityListObj.get(0));	

		}
			
			masterLoanDetail.setMasterLoanId(idGen.idGeneration());
			if(statusMap.size()!=0) 
				masterLoanDetail.setLoanStatus("REJECTED");
			else
				masterLoanDetail.setLoanStatus("PROCESSING");
			//TODO
			//masterLoanDetail.setLenderBank(lenderBank);
			//masterLoanDetail.setLenderPrimaryId(lenderPrimaryId);
			masterLoanDetail.setLendercategory("ORG");	
			masterLoanDetail.setBorrowerDetailEntity(borrowerDetailEntityObj);
			masterLoanDetail.setInvoiceDetailEntity(invoiceDetailEntityListObj.get(0));		

		

		ColletralDetailEntity colletralDetailEntityTemp=new ColletralDetailEntity();
		List<ColletralDetailEntity>  cObj=null;
		
			for(int j=0;j<colletralDetailEntityObj.size();j++) {
				colletralDetailEntityObj.get(j).setCollateralPrimaryId(colletralDetailEntityObj.get(j).getCollateralPrimaryId());
				
				colletralDetailEntityObj.get(j).setDate("05/05/2017"/*colletralDetailEntityObj.get(j).getDate()*/);
				colletralDetailEntityObj.get(j).setAdditionalIdentifiers(colletralDetailEntityObj.get(j).getAdditionalIdentifiers());
				colletralDetailEntityObj.get(j).setType(colletralDetailEntityObj.get(j).getType());
				colletralDetailEntityObj.get(j).setCollateralPrimaryIdType(colletralDetailEntityObj.get(j).getCollateralPrimaryIdType());
				colletralDetailEntityObj.get(j).setInvoiceDetailEntity(invoiceDetailEntityListObj.get(j));
				
				//cObj.add(colletralDetailEntityTemp);
			}
			
			
		
		if(invoiceDetailEntity.getTerms()!=null) {
			loanTermDetailEntityObj.setLoanTermId(idGen.idGeneration());
			loanTermDetailEntityObj.setCurrency(invoiceDetailEntity.getTerms().getCurrency());
			loanTermDetailEntityObj.setRequestAmount(invoiceDetailEntity.getTerms().getRequestAmount());
			loanTermDetailEntityObj.setBorrowerDetailEntity(borrowerDetailEntityObj);
			loanTermDetailEntityObj.setInvoiceDetailEntity(invoiceDetailEntityListObj.get(0));
		};
		for(int i=0;i<invoiceDetailEntityListObj.size();i++){			
			invoiceDetailEntityListObj.get(i).setCollaterals(colletralDetailEntityObj);
			invoiceDetailEntityListObj.get(i).setBorrower(borrowerDetailEntityObj);						
			invoiceDetailEntityListObj.get(i).setMaster(masterLoanDetail);
			invoiceDetailEntityListObj.get(i).setTerms(loanTermDetailEntityObj);
			invoiceDetailEntityListObj.get(i).setDocuments(documentsDetailEntityObj);		
			invoiceDetailEntityListObj.get(i).setTerms(loanTermDetailEntityObj);
			invoiceDetailEntityListObj.get(i).setContactDetail(contactDetailEntityObj.get(0));
		}		
		System.out.println("SIZE-->"+invoiceDetailEntityListObj.size());
		for(int i=0;i<invoiceDetailEntityListObj.size();i++) {
			System.out.println(" before prnting");			   
			System.out.println("In Assembler-->"+invoiceDetailEntityListObj.get(i).getInvoiceNumber());
			System.out.println(" After prnting");
		}
		return invoiceDetailEntityListObj;

	}



}

