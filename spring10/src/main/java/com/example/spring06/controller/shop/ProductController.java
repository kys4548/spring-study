package com.example.spring06.controller.shop;

import java.io.File;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring06.model.shop.dto.ProductDTO;
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
	
	@RequestMapping("edit/{product_id}")
	public ModelAndView edit(
			@PathVariable("product_id")int product_id,
			ModelAndView mav) {
		mav.setViewName("/shop/product_edit");
		mav.addObject("dto",productService.detailProduct(product_id));
		return mav;
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "shop/product_write";
	}
	
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute ProductDTO dto) {
		String filename="-";
		if(!dto.getFile1().isEmpty()) { //첨부파일이존재하면
			filename=dto.getFile1().getOriginalFilename();
			String path="C:\\Users\\a\\Desktop\\project\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring06\\WEB-INF\\views\\images\\";
			try {
				new File(path).mkdir();
				dto.getFile1().transferTo(new File(path+filename));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		dto.setPicture_url(filename);
		productService.insertProduct(dto);
		return "redirect:/shop/product/list.do";
	}
	@RequestMapping("update.do")
	public String update(ProductDTO dto) {
		String filename="-";
		if(!dto.getFile1().isEmpty()) { //첨부파일이존재하면
			filename=dto.getFile1().getOriginalFilename();
			String path="C:\\Users\\a\\Desktop\\project\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring06\\WEB-INF\\views\\images\\";
			try {
				new File(path).mkdir();
				dto.getFile1().transferTo(new File(path+filename));
			}catch (Exception e) {
				e.printStackTrace();
			}
			dto.setPicture_url(filename);
		}else {
			ProductDTO dto2=
					productService.detailProduct(dto.getProduct_id());
			dto.setPicture_url(dto2.getPicture_url());
		}
		productService.updateProduct(dto);
		return "redirect:/shop/product/list.do";
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int product_id) {
		String filename=productService.fileInfo(product_id);
		if(filename !=null && !filename.equals("-")) {
			String path="C:\\Users\\a\\Desktop\\project\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\spring06\\WEB-INF\\views\\images\\";
			File f= new File(path+filename);
			if(f.exists()) { //파일이 존재하면 지워라
				f.delete();
			}
		}
		productService.deleteProduct(product_id);// 레코드 삭제
		return "redirect:/shop/product/list.do";
	}
}
