package com.infosys.LSP.utility;



import com.infosys.LSP.dao.CreateLoanApplicationDAOImpl;


public class LoanApplicationValidation {
	
	CreateLoanApplicationDAOImpl   appObj=new 	CreateLoanApplicationDAOImpl();
 
	
	public Boolean validatePinCode(Integer pincode) throws Exception {
		
			System.out.println("input key code"+pincode);
			Integer pinCode = (Integer) appObj.getPincode();
			System.out.println("Qury key"+pinCode);
			if( pinCode==null)
				return false;
			else
				return true;
		
		
	}
	
	public String validateLoanDuration(String date) {
		return null;
	}
		
	public Boolean validateDateOfInvoice() {
		
		return null;
		
	}
	
	public Boolean validateInvoicValue(double amount) {
		return null;
		
	}
}
