package com.ibm.billing.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.ibm.billing.bean.Product;
import com.ibm.billing.service.ProductServiceHandlerClass;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		ProductServiceHandlerClass serviceHandler = context.getBean("productService", ProductServiceHandlerClass.class);

		boolean flag = false;
		int productCode = 0, quantity = 0;

		HashMap<Product, Float> hm = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
				flag = false;
				do {
					System.out.println("Enter the product code (Code length - 4)");
					try {
						productCode = Integer.parseInt(br.readLine());
					} catch(NumberFormatException | IOException e) {
						System.out.println("Invalid product code. It should be an integer");
						continue;
					}
				} while (productCode < 1000 || productCode > 9999);

			do {
				System.out.println("Enter the quantity of the product (Can't be 0)");
				try {
					quantity = Integer.parseInt(br.readLine());
				} catch (NumberFormatException | IOException e) {
					System.out.println("Invalid quantity value. It should be an integer");
					continue;
				}
			} while (quantity < 1);

			try {
				Product temp = serviceHandler.getProductDetails(productCode);
				hm.put(temp, quantity * temp.getProductPrice());
				System.out.println(temp);
			} catch (EmptyResultDataAccessException e) {
				System.out.println("This product " + productCode + " doesn't exist");
			}

			String consent = null;
			boolean check = true;
			do {
				System.out.println("You wanna add more products? Y/N ?");
				try {
					consent = br.readLine();
				} catch(IOException e) {
					
				}
				if(NumberUtils.isNumber(consent)) {
					System.out.println("Invalid input. It should be either yes or no");
					continue;
				}
				if(consent.equalsIgnoreCase("Y") || consent.equalsIgnoreCase("Yes") || consent.equalsIgnoreCase("n") || consent.equalsIgnoreCase("No")) {
					check = false;
				} else {
					System.out.println("Enter yes/no only");
				}
			} while (check);
			
			if (consent.equalsIgnoreCase("Y") || consent.equalsIgnoreCase("Yes")) {
				flag = true;
			}
		} while (flag);

		if (hm.size() > 0) {

			System.out.println(
					"==========================================================================================================================");
			System.out.print("ProductCode \t");
			System.out.print("ProductName \t");
			System.out.print("ProductCategory \t");
			System.out.print("ProductDescription \t");
			System.out.print("Quantity \t");
			System.out.println("Amount");

			float totalAmount = 0.0f;
			for (Entry<Product, Float> entry : hm.entrySet()) {
				Product prod = entry.getKey();
				float tempAmount = entry.getValue();
				totalAmount += tempAmount;
				System.out.print(prod.getProductCode() + "\t");
				System.out.print(prod.getProductName() + "\t");
				System.out.print(prod.getProductCategory() + "\t");
				System.out.print(prod.getProductDescription() + "\t");
				System.out.print(quantity + "\t");
				System.out.println(tempAmount);
			}
			System.out.println(
					"==========================================================================================================================");
			System.out.println("Total Amount of bill is : " + totalAmount);
		} else {
			System.out.println("You haven't added any product into the cart");
		}

		context.close();
	}
}
