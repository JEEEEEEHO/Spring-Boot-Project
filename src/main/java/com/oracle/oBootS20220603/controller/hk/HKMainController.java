package com.oracle.oBootS20220603.controller.hk;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.oBootS20220603.model.Product;
import com.oracle.oBootS20220603.service.hk.HKProductService;

@Controller
public class HKMainController {
	
	private static final Logger logger = LoggerFactory.getLogger(HKPaymentController.class);
	
	@Autowired
	private HKProductService ps;
	
	@RequestMapping("/")
	public String mainPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("HKMainController mainPage Start...");
		List<Product> p_list = ps.selectBestProduct();
		
		// 로그인 세션 정보 있는지 확인
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		System.out.println("HKMainController id->"+id);
		
		// 로그인 세션 정보 저장
		session.setAttribute("id", id);
		
		model.addAttribute("p_list", p_list);
		model.addAttribute("id", id);
		
		return "main";
	}
	
	
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "mypage";
	}
}
