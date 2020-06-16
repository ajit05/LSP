package com.infosys.LSP.Bean;

public class Address {
	
	private String rgdt;
	private String tradeNam;
	public Address() {
		
	}
	public Address(String rgdt, String tradeNam) {
		super();
		this.rgdt = rgdt;
		this.tradeNam = tradeNam;
	}
	public String getRgdt() {
		return rgdt;
	}
	public void setRgdt(String rgdt) {
		this.rgdt = rgdt;
	}
	public String getTradeNam() {
		return tradeNam;
	}
	public void setTradeNam(String tradeNam) {
		this.tradeNam = tradeNam;
	}
	

}
