package com.niit.gadgets.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.gadgets.dao.CartDAO;
import com.niit.gadgets.dao.ProductDAO;
import com.niit.gadgets.dao.UserDAO;
import com.niit.gadgets.model.Cart;
import com.niit.gadgets.model.User;
//import com.niit.gadgets.model.Product;

@Controller
public class CartController {
	
	
		@Autowired
		ProductDAO product;
		
		@Autowired
		CartDAO cart1;
		
		@Autowired
		UserDAO user1;
		
		@RequestMapping("/viewCart")
		public ModelAndView viewCart(){
			
			ModelAndView mv=new ModelAndView("viewCart");
			List<Cart> cartList=cart1.getAll();
			
			mv.addObject("cartlist", cartList);
			return mv;
		}
		
		@RequestMapping("/cart_delete")
		public ModelAndView editCart(HttpServletRequest request)
		{
			int cid=Integer.valueOf(request.getParameter("id"));
			Cart c=cart1.getId(cid);
			cart1.delete(c);
			
			ModelAndView mv=new ModelAndView("viewCart");
			List<Cart> cartList=cart1.getAll();
			
			mv.addObject("cartlist", cartList);
			return mv;
		}
		
		@RequestMapping("/customerDetails")
		public ModelAndView customer(HttpServletRequest request)
		{
			int tot=Integer.valueOf(request.getParameter("tot"));
			System.out.println(tot);
			ModelAndView mv=new ModelAndView("checkout");
			mv.addObject("tot", tot);
			return mv;
		}
		
		@RequestMapping("/invoice")
		public ModelAndView invoice(HttpServletRequest request)
		{
			String name=request.getParameter("name");
			String add=request.getParameter("add");
			String phone=request.getParameter("contact_no");
			String email=request.getParameter("email");
			String tot=request.getParameter("tot");
			User user=new User();
			user.setU_name(name);
			user.setAddress(add);
			user.setPhone(phone);
			user.setU_mail(email);
			user1.persist(user);
			
			ModelAndView mv=new ModelAndView("invoice");
			mv.addObject("name", name);
			mv.addObject("add", add);
			mv.addObject("phone", phone);
			mv.addObject("email", email);
			mv.addObject("tot", tot);
			
		
			return mv;
		}

		@RequestMapping("/Confirm")
		public String confirm()
		{
			return "Confirm";
		}
		
		
	}

