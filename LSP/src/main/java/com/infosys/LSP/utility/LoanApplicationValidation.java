package com.infosys.LSP.utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.infosys.LSP.Bean.Address;
import com.infosys.LSP.dao.CreateLoanApplicationDAOImpl;
import com.infosys.LSP.entity.Pincode;



public class LoanApplicationValidation {
	
	CreateLoanApplicationDAOImpl obj=new CreateLoanApplicationDAOImpl();
	
	public LoanApplicationValidation() {
		
	}
	

	
	public Boolean validatePinCode(Integer pincode,List<Pincode> pincodeListfromDb) throws Exception {
		List<Integer> pincodeList=new ArrayList<Integer>();
		for(int i =0;i<pincodeListfromDb.size();i++)
			pincodeList.add(pincodeListfromDb.get(i).getPincode());			
		if(pincodeList.contains(pincode))
				return true;
		else
			return false;	
		
	}
	
	public  HashMap<String, String> decodeBase64ToJSON(String base64Encoded){
		HashMap<String, String> map=new HashMap<String,String>();
		byte[] base64Decoded = DatatypeConverter.parseBase64Binary(base64Encoded);
		Gson gson = new Gson(); 
		Address address = gson.fromJson(new String(base64Decoded), Address.class);		
		map.put("rgdt","05/05/2020"/*address.getRgdt()*/);
		map.put("tradeNam",address.getTradeNam());
		return map;      
		
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
