package com.oracle.oBootS20220603.controller.hk;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.oBootS20220603.model.Basket;
import com.oracle.oBootS20220603.model.Coupon;
import com.oracle.oBootS20220603.model.Member;
import com.oracle.oBootS20220603.model.Product;
import com.oracle.oBootS20220603.service.hk.HKBasketService;
import com.oracle.oBootS20220603.service.hk.HKCouponService;
import com.oracle.oBootS20220603.service.hk.HKMemberService;
import com.oracle.oBootS20220603.service.hk.HKProductService;

@Controller
public class HKPaymentController {
	
	private static final Logger logger = LoggerFactory.getLogger(HKPaymentController.class);
	
	@Autowired
	private HKProductService ps;
	@Autowired
	private HKMemberService ms;
	@Autowired
	private HKBasketService bs;
	@Autowired
	private HKCouponService cs;
	
	
	@RequestMapping("cart")
	public String cart(Model model) {
		String id = "testuser";
		
		List<Basket> b_list = bs.selectAll(id);
		System.out.println("b_list size->"+b_list.size());
		
		model.addAttribute("b_list", b_list);
		
		return "cart";
	}
	
	
	@RequestMapping("/payment")
	public String payment(HttpServletRequest request, Model model) {
//		String id = request.getSession().getId();
		String id = "testuser";
		int prodno = 5;
		int quantity = 2;
		
		int from = 0;	// 상품 view 구매
		
		Member member = ms.selectOne(id);
		Product product = ps.selectOne(prodno);
		
		int total_amount = product.getSale_price() * quantity;
		
		int mile_save = (int) (Math.ceil((total_amount*0.02) / 10) * 10);
		
		System.out.println("prod_price->"+product.getProd_price());
		System.out.println("dc_rate->"+product.getDc_rate());
		System.out.println("sale_price->"+product.getSale_price());
		
		model.addAttribute("product", product);
		model.addAttribute("quantity", quantity);
		model.addAttribute("member", member);
		model.addAttribute("from", from);
		model.addAttribute("total_amount", total_amount);
		model.addAttribute("mile_save", mile_save);
		
		return "payment";
	}
	
	
	@RequestMapping("/cart_payment")
	public String payment(HttpServletRequest request, int[] prodno, Model model) {
		String id = "testuser";
		
		int from = 1;	// 장바구니 구매
		
		for(int i=0;i<prodno.length;i++) {
			System.out.println("prodno->"+prodno[i]);
		}
		
		List<Basket> basket_list = new ArrayList<Basket>();
		Basket basket = null;
		for(int i=0;i<prodno.length;i++) {
			basket = new Basket();
			basket.setId(id);
			basket.setProdno(prodno[i]);
			basket_list.add(basket);
		}
		Member member = ms.selectOne(id);
		List<Product> p_list = ps.selectBasketProduct(basket_list);
		
		int total_amount = 0;
		for(Product product : p_list) {
			total_amount += product.getSale_price() * product.getBas_qty();
		}
		
		int mile_save = (int) (Math.ceil((total_amount*0.02) / 10) * 10);
		
		model.addAttribute("p_list", p_list);
		model.addAttribute("member", member);
		model.addAttribute("from", from);
		model.addAttribute("total_amount", total_amount);
		model.addAttribute("mile_save", mile_save);
		
		return "payment";
	}
	
	@GetMapping("couponList")
	public String selectCoupon(HttpServletRequest request, Model model) {
		String id = "testuser";
		
		List<Coupon> coup_list = cs.selectAll(id);
		int total = coup_list.size();
		
		model.addAttribute("coup_list", coup_list);
		model.addAttribute("total", total);
		
		return "couponList";
	}
	
	
	
	
	
	
	
}
