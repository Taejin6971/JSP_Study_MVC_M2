package com.mysite.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysite.common.JDBCUtill;

public class ProductsDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String PRODUCTS_INSERT=
			"insert into product (p_code, p_name, p_kind, p_price, p_content, p_quantity) "
			+ "values(?, ?, ?, ?, ?, ?)";
	
	private final String PRODUCTS_LIST=
			"select * from product order by p_code";
	
	public void insertProducts(ProductsDTO dto) {
		System.out.println("insertProducts 메소드 호출");
		
		try {
			conn = JDBCUtill.getConnction();
			
			pstmt = conn.prepareStatement(PRODUCTS_INSERT);	
			
			pstmt.setInt(1, dto.getP_code());
			pstmt.setString(2, dto.getP_name());
			pstmt.setString(3, dto.getP_kind());
			pstmt.setString(4, dto.getP_price());
			pstmt.setString(5, dto.getP_content());
			pstmt.setString(6, dto.getP_quantity());
		
			pstmt.executeUpdate();
			
			System.out.println("insert 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insert 실패");
			
		} finally {
			JDBCUtill.close(pstmt, conn);
		}
	}

	public List<ProductsDTO> getProductList(ProductsDTO dto){
		System.out.println("getProductList 메소드 호출");
		List<ProductsDTO> productList = new ArrayList<ProductsDTO>();
	
		try {
			conn = JDBCUtill.getConnction();
			pstmt = conn.prepareStatement(PRODUCTS_LIST);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductsDTO product = new ProductsDTO();
				product.setP_code(rs.getInt("P_CODE"));
				product.setP_name(rs.getString("P_NAME"));
				product.setP_kind(rs.getString("P_KIND"));
				product.setP_price(rs.getString("P_PRICE"));
				product.setP_content(rs.getString("P_CONTENT"));
				product.setP_quantity(rs.getString("P_QUANTITY"));
				product.setIndate(rs.getDate("INDATE"));
				
				productList.add(product);
			}
			
			System.out.println("ProductList에 레코드 추가 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ProductList에 레코드 추가 실패");
	
		} finally {
			JDBCUtill.close(rs, pstmt, conn);
		}
		
		return productList;
	}
}
