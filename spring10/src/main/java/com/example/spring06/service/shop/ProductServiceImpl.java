package com.example.spring06.service.shop;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring06.model.shop.dao.ProductDAO;
import com.example.spring06.model.shop.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	ProductDAO productDao;
	
	@Override
	public List<ProductDTO> listProduct() {
		// TODO Auto-generated method stub
		return productDao.listProduct();
	}

	@Override
	public ProductDTO detailProduct(int product_id) {
		// TODO Auto-generated method stub
		return productDao.detailProduct(product_id);
	}

	@Override
	public String fileInfo(int product_id) {
		// TODO Auto-generated method stub
		return productDao.fileInfo(product_id);
	}

	@Override
	public void updateProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		productDao.updateProduct(dto);
	}

	@Override
	public void deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(product_id);
	}

	@Override
	public void insertProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		productDao.insertProduct(dto);
	}

}
