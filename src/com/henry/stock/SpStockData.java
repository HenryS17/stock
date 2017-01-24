package com.henry.stock;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpStockData {
	private String symbol;
	private String name;
//	@JsonProperty("Sector")
	private String sector;	
	private float value;

	
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public String getSymbol() {
		return symbol;
	}
	//@JsonProperty("Symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	@Override
	public String toString() {
		return (symbol + ' ' + name + ' ' + sector);
	}
}
