package com.ibm.billing.service;

import com.ibm.billing.bean.Product;

public interface ProductServiceHandler {

	Product getProductDetails(int productCode);
}
