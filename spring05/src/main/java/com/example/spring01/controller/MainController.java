package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.ProductDTO;

@Controller
public class MainController {
	private static final Logger logger=
		LoggerFactory.getLogger(MainController.class);
	
	
	@RequestMapping("/")
	public String main(Model model) {
		//변수명, 값
		model.addAttribute("message","홈페이지 방문을 환영합니다");
		return "main";
	}
	
	@RequestMapping(value="gugu.do", method=RequestMethod.GET)
	//RequestParam 앞에서 넘어온 변수라는것을 알려주는 것
	public String gugu(@RequestParam(defaultValue = "3")int dan, Model model) {
		
		String result="";
		for(int i=1; i<=9; i++) {
			result += dan+"x"+i+"="+dan*i+"<br/>";
		}
		model.addAttribute("result",result);
		
		return "test/gugu";
	}
	@RequestMapping("test")
	public void test() {
	}
	@RequestMapping("test/doA")
	public String doA(Model model) {
		logger.info("doA called...");
		
		model.addAttribute("message","홈페이지 방문을 환영합니다.");
		
		return "test/doB";
	}
	@RequestMapping("test/doB")
	public void doB() {
		logger.info("doB called...");
	}
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		Map<String,Object> map = new HashMap<>();
		map.put("product",new ProductDTO("샤프",1000));
		return new ModelAndView("test/doC","map",map);
	}
	@RequestMapping("test/doD")
	public String doD(){
		return "redirect:/test/doE";
	}
	@RequestMapping("test/doE")
	public void doE() {
		
	}
}