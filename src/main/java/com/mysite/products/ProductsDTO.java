package com.mysite.products;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductsDTO {

	private int p_code;
	private String p_name;
	private String p_kind;
	private	String p_price;
	private	String p_content;
	private	String p_quantity;
	private	Date indate;
}
