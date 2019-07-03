package com.example.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring01.model.dto.ProductDTO;

@RestController
public class SampleRestController {
	// @ResponseBody  기존 컨트롤일때 사용해야 한다.
	@RequestMapping("test/doF")
	public ProductDTO doF() {
		
		return new ProductDTO("냉장고",500000);
	}
}