package com.example.spring06.model.shop.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring06.model.shop.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ProductDTO> listProduct() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.list_product");
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.detail_product",product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.update("product.update_product",dto);
	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("product.product_delete",product_id);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("product.insert",dto);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.file_info",product_id);
	}

}
