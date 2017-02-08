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
	private Double pe;
	private Double peg;
	private Double priceToBook;
	private Double roe;
	private Double eps;
	private Double priceToSale;
	private Long volumn;
	private Double priceChange;
	private Double peChange;
	private Double pegChange;
	private Double pbChange;
	private Double epsChange;
	private Double psChange;
	private String sector;
	private Double oneYearTarget;
	private Double beginPrice;
	private Double diffToTarget;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Double getPe() {
		return pe;
	}
	public void setPe(Double pe) {
		this.pe = pe;
	}
	public Double getPeg() {
		return peg;
	}
	public void setPeg(Double peg) {
		this.peg = peg;
	}
	public Double getPriceToBook() {
		return priceToBook;
	}
	public void setPriceToBook(Double priceToBook) {
		this.priceToBook = priceToBook;
	}
	public Double getRoe() {
		return roe;
	}
	public void setRoe(Double roe) {
		this.roe = roe;
	}
	public Double getEps() {
		return eps;
	}
	public void setEps(Double eps) {
		this.eps = eps;
	}
	public Double getPriceToSale() {
		return priceToSale;
	}
	public void setPriceToSale(Double priceToSale) {
		this.priceToSale = priceToSale;
	}
	public Long getVolumn() {
		return volumn;
	}
	public void setVolumn(Long volumn) {
		this.volumn = volumn;
	}
	public Double getPriceChange() {
		return priceChange;
	}
	public void setPriceChange(Double priceChange) {
		this.priceChange = priceChange;
	}
	public Double getPeChange() {
		return peChange;
	}
	public void setPeChange(Double peChange) {
		this.peChange = peChange;
	}
	public Double getPegChange() {
		return pegChange;
	}
	public void setPegChange(Double pegChange) {
		this.pegChange = pegChange;
	}
	public Double getPbChange() {
		return pbChange;
	}
	public void setPbChange(Double pbChange) {
		this.pbChange = pbChange;
	}
	public Double getEpsChange() {
		return epsChange;
	}
	public void setEpsChange(Double epsChange) {
		this.epsChange = epsChange;
	}
	public Double getPsChange() {
		return psChange;
	}
	public void setPsChange(Double psChange) {
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

	public Double getOneYearTarget() {
		return oneYearTarget;
	}
	public void setOneYearTarget(Double target) {
		this.oneYearTarget = target;
	}
	
	public Double getBeginPrice() {
		return beginPrice;
	}
	public void setBeginPrice(Double beginPrice) {
		this.beginPrice = beginPrice;
	}
	public Double getDiffToTarget() {
		return diffToTarget;
	}
	public void setDiffToTarget(Double diffToTarget) {
		this.diffToTarget = diffToTarget;
	}
	@Override
	public String toString() {
		return new StringBuffer("Name: ").append(this.name).append("Synmbol: ").append(this.symbol).toString();
	}
	
	
}

