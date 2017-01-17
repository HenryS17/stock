package com.henry.stock;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StockData {

	private String name;
	private String symbol;
//	private LocalDate date;
//	private float price;
//	private float pe;
	
//	public StockData() {
//		
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
//	public LocalDate getDate() {
//		return date;
//	}
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//	public float getPrice() {
//		return price;
//	}
//	public void setPrice(float value) {
//		this.price = value;
//	}
//	public float getPe() {
//		return pe;
//	}
//	public void setPe(float pe) {
//		this.pe = pe;
//	}
//	
	@Override
	public String toString() {
		return new StringBuffer("Name: ").append(this.name).append("Synmbol: ").append(this.symbol).toString();
	}
	
	
}

