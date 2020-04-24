package com.infosys.LSP.LSP.utility;

public  class DateConverter {
	
	public DateConverter()
	{
		
	}	
	public String JavaDateObjectToSQLDate() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());  
		return sqlTS.toString();
	}

}
