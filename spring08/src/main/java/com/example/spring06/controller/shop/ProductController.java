package com.example.spring06.controller.shop;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring06.service.shop.ProductService;

@Controller
@RequestMapping("/shop/product/*")// 공통적인 url mapping
public class ProductController {

	@Inject
	ProductService productService;
	
	@RequestMapping("list.do")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("/shop/product_list");
		mav.addObject("list",productService.listProduct());
		return mav;
	}
	
	@RequestMapping("detail/{product_id}")
	public ModelAndView detail(
			@PathVariable("product_id") int product_id,
			ModelAndView mav) {
		mav.setViewName("/shop/product_detail");
		mav.addObject("dto",productService.detailProduct(product_id));
		return mav;
	}
}
