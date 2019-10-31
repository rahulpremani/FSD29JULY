package com.ibm.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.billing.bean.Product;
import com.ibm.billing.dao.ProductDataHandlerClass;

@Service("productService")
public class ProductServiceHandlerClass implements ProductServiceHandler {

	@Autowired
	@Qualifier(value="productData")
	ProductDataHandlerClass dataHandler;

	@Override
	public Product getProductDetails(int productCode) {	
		return dataHandler.getProductDetails(productCode);
	}
	
	
}
