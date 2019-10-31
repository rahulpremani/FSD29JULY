package com.ibm.billing.dao;

import com.ibm.billing.bean.Product;

public interface ProductDataHandler{

	Product getProductDetails(int productCode);
}
