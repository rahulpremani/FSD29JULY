package com.ibm.billing.bean;

import org.springframework.stereotype.Component;

@Component("productDetail")
public class Product {

	int productCode;
	String productName, productCategory, productDescription;
	float productPrice;
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "Product Code : " + productCode + ", Name :" + productName + ", Category :"
				+ productCategory + ", Description :" + productDescription + ", Price :" + productPrice;
	}
}
