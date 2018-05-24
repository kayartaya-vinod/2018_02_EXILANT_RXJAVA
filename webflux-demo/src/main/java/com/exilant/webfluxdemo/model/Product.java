package com.exilant.webfluxdemo.model;

public class Product {
	private int id;
	private String name;
	private String description;
	private Double unitPrice;
	
	public Product() {
	}

	public Product(int id, String name, String description, Double unitPrice) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}
