package com.infosys.LSP.utility;



import java.util.UUID;
public class IDGenerator {
	public  IDGenerator() {
		
	}
	
	public  String idGeneration() {		
		UUID uniqueKey = UUID.randomUUID();
		  return  uniqueKey.toString();
	}
	
	public String  IDGeneratorUID() {	
		
		UUID uniqueKey = UUID.randomUUID();
		  return  uniqueKey.toString();
	}
	
	

}
