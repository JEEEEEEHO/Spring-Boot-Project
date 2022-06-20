package com.oracle.oBootS20220603.controller.hk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.oBootS20220603.model.Member;
import com.oracle.oBootS20220603.model.Payment;
import com.oracle.oBootS20220603.model.PaymentDetail;
import com.oracle.oBootS20220603.model.Product;
import com.oracle.oBootS20220603.service.hk.HKMemberService;
import com.oracle.oBootS20220603.service.hk.HKPaymentDetailService;
import com.oracle.oBootS20220603.service.hk.HKPaymentService;
import com.oracle.oBootS20220603.service.hk.HKProductService;
import com.oracle.oBootS20220603.service.hk.KakaoPay;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
public class HKKakaoController {
	
	@Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
	
	@Autowired
	private HKProductService ps;
	
	@Autowired
	private HKMemberService ms;
	
	@Autowired
	private HKPaymentService pys;
	
	@Autowired
	private HKPaymentDetailService pds;
    
    @GetMapping("/kakaoPay")
    public void kakaoPayGet() {
        
    }
    
    @PostMapping("/kakaoPay")
    public String kakaoPay(HttpServletRequest request, Payment payment, Member member, int[] prodno, int[] quantity, Model model) {
        log.info("kakaoPay post............................................");
        
        String id = "testuser";
        member.setId(id);
        payment.setId(id);

        if(member.getSubs() == 1) {
        	payment.setDelivery_fee(0);
        } else {
        	payment.setDelivery_fee(3000);
        }
        
        int result_payment = pys.insertPayment(payment);
        int payno = pys.selectPaynoById(id);
        payment.setPayno(payno);
        
        Product first_product = ps.selectOne(prodno[0]);
        String item_name = "["+first_product.getBrand_name()+"]"+first_product.getProd_name();
        
        HashMap<Product, Integer> order_list = new HashMap<Product, Integer>();
        int i = 0;
        for(int p : prodno) {
        	Product product = ps.selectOne(p);
        	PaymentDetail pd = new PaymentDetail();
        	pd.setPayno(payno);
        	pd.setProdno(product.getProdno());
        	pd.setBuy_qty(quantity[i]);
        	pd.setDc_rate(product.getDc_rate());
        	pd.setDc_price(product.getSale_price());
        	int result_detail = pds.insertPaymentDetail(pd);
        	if(result_detail >0)	System.out.println("결제상세 테이블 삽입 성공");
        	else 					System.out.println("결제상세 테이블 삽입 실패");
        	order_list.put(product, quantity[i]);
        	i++;
        }
        
//        Payment p_payment = pys.
        
        model.addAttribute("payment", payment);
        model.addAttribute("member", member);
        model.addAttribute("order_list", order_list);
        model.addAttribute("item_name", item_name);
        
        return "redirect:" + kakaopay.kakaoPayReady(model);
 
    }
    
    @GetMapping("/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, HttpServletRequest request, Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        // DB에서 결제, 결제상세테이블 정보 가져와서 kakaoPayInfo에 모델로 껴주기
        // payment payno, id, real_amount
        String id = "testuser";
        int payno = pys.selectPaynoById(id);
        Payment p_payment = new Payment();
        p_payment.setId(id);
        p_payment.setPayno(payno);
        Payment payment = pys.selectLastPayment(p_payment);
        int update_paydate = pys.updatePaydate(payment);
        if(update_paydate>0)	System.out.println("결제일 수정 성공");
        else					System.out.println("결제일 수정 실패");
        model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token, payment));
        
        
        return "kakaoPaySuccess";
    }
    
    
    @GetMapping("/kakaoPayCancel")
    public String kakaoPayCancel(HttpServletRequest request) {
    	String id = "testuser";
    	int payno = pys.selectPaynoById(id);
    	Payment p_payment = new Payment();
    	p_payment.setPayno(payno);
    	p_payment.setId(id);
    	int delete_result = pys.deleteFailPayment(p_payment);
    	if(delete_result>0)		System.out.println("실패 결제 데이터 삭제 성공");
    	else 					System.out.println("실패 결제 데이터 삭제 실패");
    	return "redirect:/cart";
    }
    
    @GetMapping("/kakaoPaySuccessFail")
    public String kakaoPaySuccessFail(HttpServletRequest request) {
    	String id = "testuser";
    	int payno = pys.selectPaynoById(id);
    	Payment p_payment = new Payment();
    	p_payment.setPayno(payno);
    	p_payment.setId(id);
    	int delete_result = pys.deleteFailPayment(p_payment);
    	if(delete_result>0)		System.out.println("실패 결제 데이터 삭제 성공");
    	else 					System.out.println("실패 결제 데이터 삭제 실패");
    	return "redirect:/cart";
    }
    
    
    
}
