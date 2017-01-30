package com.henry.stock;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;


// This class stores data of stock from yahoo api.

@XmlRootElement
public class StockData {

	private String name;
	private String symbol;
	private double price;
	private double pe;
	private double peg;
	private double priceToBook;
	private double roe;
	private double eps;
	private double priceToSale;
	private Long volumn;
	private double priceChange;
	private double peChange;
	private double pegChange;
	private double pbChange;
	private double epsChange;
	private double psChange;
	private String sector;
	private double oneYearTarget;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPe() {
		return pe;
	}
	public void setPe(double pe) {
		this.pe = pe;
	}
	public double getPeg() {
		return peg;
	}
	public void setPeg(double peg) {
		this.peg = peg;
	}
	public double getPriceToBook() {
		return priceToBook;
	}
	public void setPriceToBook(double priceToBook) {
		this.priceToBook = priceToBook;
	}
	public double getRoe() {
		return roe;
	}
	public void setRoe(double roe) {
		this.roe = roe;
	}
	public double getEps() {
		return eps;
	}
	public void setEps(double eps) {
		this.eps = eps;
	}
	public double getPriceToSale() {
		return priceToSale;
	}
	public void setPriceToSale(double priceToSale) {
		this.priceToSale = priceToSale;
	}
	public Long getVolumn() {
		return volumn;
	}
	public void setVolumn(Long volumn) {
		this.volumn = volumn;
	}
	public double getPriceChange() {
		return priceChange;
	}
	public void setPriceChange(double priceChange) {
		this.priceChange = priceChange;
	}
	public double getPeChange() {
		return peChange;
	}
	public void setPeChange(double peChange) {
		this.peChange = peChange;
	}
	public double getPegChange() {
		return pegChange;
	}
	public void setPegChange(double pegChange) {
		this.pegChange = pegChange;
	}
	public double getPbChange() {
		return pbChange;
	}
	public void setPbChange(double pbChange) {
		this.pbChange = pbChange;
	}
	public double getEpsChange() {
		return epsChange;
	}
	public void setEpsChange(double epsChange) {
		this.epsChange = epsChange;
	}
	public double getPsChange() {
		return psChange;
	}
	public void setPsChange(double psChange) {
		this.psChange = psChange;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
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

	public double getOneYearTarget() {
		return oneYearTarget;
	}
	public void setOneYearTarget(double target) {
		this.oneYearTarget = target;
	}
	
	@Override
	public String toString() {
		return new StringBuffer("Name: ").append(this.name).append("Synmbol: ").append(this.symbol).toString();
	}
	
	
}

