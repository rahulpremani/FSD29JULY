package com.ibm.billing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.billing.bean.Product;

@Repository("productData")
public class ProductDataHandlerClass implements ProductDataHandler{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	@Qualifier(value="namedParamJDBCTemplate")
	NamedParameterJdbcTemplate namedTemplate;
	
	@Autowired
	@Qualifier(value="productDetail")
	Product product;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public Product getProductDetails(int productCode) {
		
		String fetchProductQry = "Select * from product_details where productCode = :prodCode";
		
		return namedTemplate.queryForObject(fetchProductQry, new MapSqlParameterSource("prodCode",productCode), new ProductMapper());
	}
	
	class ProductMapper implements RowMapper<Product>{

		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			product.setProductCode(rs.getInt("productCode"));
			product.setProductName(rs.getString("productName"));
			product.setProductCategory(rs.getString("productCategory"));
			product.setProductDescription(rs.getString("productDescription"));
			product.setProductPrice(rs.getFloat("productPrice"));
			
			return product;
		}
	}
}
