package com.infosys.LSP.LSP.utility;

import java.util.Random;

public class IDGenerator {
	public  IDGenerator() {
		
	}
	
	public String idGeneration() {			
		Random random = new Random();
        int val = random.nextInt();
        String Hex = new String();
        Hex = Integer.toHexString(val);       
		return Hex ;
	}

}
