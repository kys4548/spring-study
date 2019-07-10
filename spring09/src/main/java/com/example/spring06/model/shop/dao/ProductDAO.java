package com.example.spring06.model.shop.dao;

import java.util.List;

import com.example.spring06.model.shop.dto.ProductDTO;

public interface ProductDAO {
	List<ProductDTO> listProduct(); //상품목록 R
	ProductDTO detailProduct(int product_id); //상세정보 R
	void updateProduct(ProductDTO dto); //수정 U
	void deleteProduct(int product_id); //상품 삭제 D
	void insertProduct(ProductDTO dto); // 추가 C
	String fileInfo(int product_id); //파일 정보 R
}

//CRUD
// CREATE, READ, UPDATE, DELETE => 사용자 입장에서 생성,읽기, 수정, 삭제