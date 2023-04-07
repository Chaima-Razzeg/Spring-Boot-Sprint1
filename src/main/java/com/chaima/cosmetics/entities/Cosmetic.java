package com.chaima.cosmetics.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Cosmetic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cosmeticReference;
	private String cosmeticName;
	private Double itemPrice;
	private Date expirationDate;
	
	public Cosmetic() {
		super();
	}

	public Cosmetic(String cosmeticName, Double itemPrice, Date expirationDate) {
		super();
		this.cosmeticName = cosmeticName;
		this.itemPrice = itemPrice;
		this.expirationDate = expirationDate;
	}

	public Long getCosmeticReference() {
		return cosmeticReference;
	}

	public void setCosmeticReference(Long cosmeticReference) {
		this.cosmeticReference = cosmeticReference;
	}

	public String getCosmeticName() {
		return cosmeticName;
	}

	public void setCosmeticName(String cosmeticName) {
		this.cosmeticName = cosmeticName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Cosmetic [cosmeticReference=" + cosmeticReference + ", cosmeticName=" + cosmeticName + ", itemPrice="
				+ itemPrice + ", expirationDate=" + expirationDate + "]";
	}
	
	

	
	
	

	
	

}
