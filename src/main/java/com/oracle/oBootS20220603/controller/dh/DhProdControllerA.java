package com.oracle.oBootS20220603.controller.dh;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.oBootS20220603.model.Paging;
import com.oracle.oBootS20220603.model.Product;
import com.oracle.oBootS20220603.service.dh.DhProdServiceA;

@Controller
public class DhProdControllerA {
	private static final Logger logger = LoggerFactory.getLogger(DhProdControllerA.class);
	
	@Autowired
	private DhProdServiceA dhps;
	
	// admin 상품 조회
	@RequestMapping("prodSelect")
	public String prodList(Product product, Model model, String currentPage, HttpServletRequest request) {
		logger.info("DhProdControllerA prodSelect Start..");
		int totalc = dhps.totalC();          // admin 상품 판매상태 표시 카테고리
		int sale = dhps.totalS();			 // 판매중인 상품 개수
		int sold_out =dhps.totalSO();       // 품절된 상품 개수
		int stop_sel=dhps.totalST();        // 판매중지된 상품 개수
		System.out.println("DhProdControllerA AllProdSelect total->" +totalc);
		int total = dhps.total();      //paging 작업
			// 페이징(페이지네이션) 작업-----------------------------------------------------------
			//						40		현재페이지
			Paging pg = new Paging(total, currentPage);
			product.setStart(pg.getStart());	// 시작 시 1
			product.setEnd(pg.getEnd());		// 시작 시 10
			// --------------------------------------------------------------------------
			// 페이지네이션 다음에 리스트를 불러와야 됨! 그래야 mapper에 start, end 값이 들어감
			List<Product> prodList = dhps.listProd(product);
			System.out.println("DhProdControllerA prodSelect prodList.size() -> " + prodList.size());
		
		model.addAttribute("prodList", prodList);
		model.addAttribute("pg", pg);
		model.addAttribute("menu_num", 2);
		model.addAttribute("totalc", totalc);
		model.addAttribute("sale",sale);
		model.addAttribute("sold_out",sold_out);
		model.addAttribute("stop_sel",stop_sel);
		return "aDhProdList";
	}
	
	//keyword 조회_ 상품명,상품번호
	@RequestMapping(value="prodSearch" )
	public String list3(Product product ,String currentPage, Model model, HttpServletRequest request) {
		logger.info("DhProdControllerA list3 Start..");
		int totalc = dhps.totalC();          // admin 상품 판매상태 표시 카테고리
		int sale = dhps.totalS();			 // 판매중인 상품 개수
		int sold_out =dhps.totalSO();       // 품절된 상품 개수
		int stop_sel=dhps.totalST();        // 판매중지된 상품 개수
		System.out.println("DhProdControllerA AllProdSelect total->" +totalc);
		
		int total = dhps.keywordtotal(product);      //paging 작업
		System.out.println("DhProdControllerA keywordTotal=>" +total);
		// 페이징(페이지네이션) 작업-----------------------------------------------------------
		//								현재페이지
		
		Paging pg = new Paging(total, currentPage);
		product.setStart(pg.getStart());	// 시작 시 1
		product.setEnd(pg.getEnd());		// 시작 시 10
		// --------------------------------------------------------------------------
		System.out.println("DhProdControllerA list3 pg.getTotal()=>" +pg.getTotal());
		System.out.println("DhProdControllerA list3 pg.getStart()=>" +pg.getStart());
		System.out.println("DhProdControllerA list3 pg.getEnd()=>" +pg.getEnd());
		// product list 조건조회
		List<Product> listProduct = dhps.listProduct(product);   //keyword 조회_ 상품명,상품번호
		System.out.println("DhProdControllerA list3 listProduct.size()->" +listProduct.size());
		
		model.addAttribute("ListProd",listProduct);
		model.addAttribute("pg", pg);
		model.addAttribute("menu_num", 2);
		model.addAttribute("keyword1",product.getKeyword1());
		model.addAttribute("keyword2",product.getKeyword2());
		model.addAttribute("totalc", totalc);
		model.addAttribute("sale",sale);
		model.addAttribute("sold_out",sold_out);
		model.addAttribute("stop_sel",stop_sel);
		return "aDhProduct_listKeyword";
	}
	
	
	// 어드민 상품 상세
	@RequestMapping("prodView")
	public String prodView(Product product, Model model, HttpServletRequest request) {
		logger.info("DhProdControllerA prodView Start..");
		Product product1 = dhps.prodDetail(product.getProdno());
		model.addAttribute("product", product1);
		model.addAttribute("menu_num", 2);
		return "aDhProdView";
	}
	
	// 어드민 상품 삭제
	@RequestMapping("prodDelete")
	public String prodDelete(Product product, Model model,HttpServletRequest request) {
		logger.info("DhProdControllerA prodDelete Start..");
		int result = dhps.delete(product.getProdno());
		System.out.println("DhProdControllerA prodDelete result->"+result);
		return "redirect:prodSelect";
	}
	
//	// 어드민 상품 수정
//	@RequestMapping("prodUpdate")
//	public String prodUpdate(Product product, Model model,HttpServletRequest request) {
//		logger.info("DhProdControllerA prodDelete Start..");
//		int uptCnt= dhps.prodUpdate(product);
//		System.out.println("DhProdControllerA prodUpdate upCnt성공개수->" +uptCnt);
//		model.addAttribute("uptCnt",uptCnt);
//		return "redirect:prodSelect";
//	}
	
	// 어드민 리스트 상품삭제
	@ResponseBody
	@RequestMapping(value="adminProdDelAJAX", produces = "application/text;charset=UTF-8", method = RequestMethod.POST)
	public String adminProdDelAJAX(@RequestParam(value = "chbox[]") List<String> chArr, Product product) {
		logger.info("DhProdControllerA adminProdDelAJAX Start..");
		System.out.println("DhProdControllerA adminProdDelAJAX chArr.get(0)->"+chArr.get(0));
		
		int result=0;
		int prodno=0;
		
		for(String i : chArr ) {
			prodno=Integer.parseInt(i);
			System.out.println("DhProdControllerA adminProdDelAJAX prodno->"+prodno);
			product.setProdno(prodno);
			result=dhps.adminProdDelAJAX(product);
		}
		String result1=Integer.toString(result);
		
		return result1;
	}
	
	
}
