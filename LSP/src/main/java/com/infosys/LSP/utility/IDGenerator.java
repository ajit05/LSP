package com.infosys.LSP.utility;



import java.util.UUID;
public class IDGenerator {
	public  IDGenerator() {
		
	}
	
	public  String idGeneration() {		
		UUID uniqueKey = UUID.randomUUID();
		  return  uniqueKey.toString();
	}
	
	public UUID  IDGeneratorUID() {	
		
		UUID uniqueKey = UUID.randomUUID();
		  return  uniqueKey;
	}
	
	

}
