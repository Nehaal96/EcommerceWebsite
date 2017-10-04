package com.niit.gadgets.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {

	@RequestMapping("/sareeproductinformation")
	public String image1()
	{
		return "sareeproductinformation";
	}
	@RequestMapping("/ProductDetails2")
	public String image2()
	{
		return "ProductDetails2";
	}
	@RequestMapping("/ProductDetails3")
	public String image3()
	{
		return "ProductDetails3";
	}
	@RequestMapping("/ProductDetails4")
	public String image4()
	{
		return "ProductDetails4";
	}
}
