package com.niit.gadgets.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.niit.gadgets.dao.CategoryDAO;
import com.niit.gadgets.dao.ProductDAO;
import com.niit.gadgets.model.Cart;
import com.niit.gadgets.model.Category;
import com.niit.gadgets.model.Product;
import com.niit.gadgets.model.Supplier;
import com.niit.gadgets.model.User;
import com.niit.gadgets.dao.SupplierDAO;
import com.niit.gadgets.dao.UserDAO;
import com.niit.gadgets.dao.CartDAO;

@Controller
public class HomeController {
	
	@Autowired
	ProductDAO productDao;
	public void ProductDAO(ProductDAO productDao)
	{
		this.productDao=productDao;
	}
	
	@Autowired
	UserDAO userDao;
	public void UserDAO(UserDAO userDao)
	{
		this.userDao=userDao;
	}
	
	@Autowired
	CartDAO cart1;
	public void CartDAO(CartDAO cart1)
	{
		this.cart1=cart1;
	}
	
	@Autowired
	CategoryDAO categoryDao;
	  public void CategoryDAO(CategoryDAO categoryDao)
	{
		this.categoryDao=categoryDao;
	}
	
	@Autowired
	SupplierDAO supplierDao;
       public void SupplierDAO(SupplierDAO supplierDao)
	{
		this.supplierDao=supplierDao;
	}
	
	
   @RequestMapping("/")
	public ModelAndView index() { 
	   List<Category> list=categoryDao.getAllCategories();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("catlist",list);
		return mv;
	}
   @RequestMapping("/register")
	public ModelAndView reg(HttpServletRequest request)
	{
	   ModelAndView mv=null;
	   try{
       String mail=request.getParameter("mail");
       String name=request.getParameter("name");
		String add=request.getParameter("address");
		int age=Integer.parseInt(request.getParameter("age"));
		String phone=request.getParameter("phone");
		String pass=request.getParameter("passwd");
		System.out.println("haoiii"+name+"mail"+"add"+add+"age"+age+"phone"+phone+"pass"+pass);
		User u=new User();
		u.setU_mail(mail);
		u.setAge(age);
		u.setU_password(pass);
		u.setPhone(phone);
		u.setRole("role");
		userDao.persist(u);
		System.out.println("Mother Earth");
		
		 mv = new ModelAndView("index");
	   }catch(Exception ex)
	   {
		   mv=new ModelAndView("ErrorPage","error",ex);
	   }finally
	   {
		return mv;
	   }
	}
   @ModelAttribute
   public void addAttributes(Model m){
	   m.addAttribute("catlist",categoryDao.getAllCategories());
   }
   
   
	@RequestMapping("/admin/product")
	public ModelAndView product(HttpServletRequest request1) {
		 int id=Integer.valueOf(request1.getParameter("id"));
	        Product p=productDao.findById(id);
		ModelAndView mv = new ModelAndView("productDetails");
		List<Category> c=categoryDao.getAllCategories();
		mv.addObject("list",c);
		mv.addObject("product", p);
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request1) {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
/*	@RequestMapping("/userlogged")
	public ModelAndView userLogged() { 
		ModelAndView mv = new ModelAndView("/");
		
		return mv;
	}*/
	@RequestMapping("/userlogged")
	public String userLogged() { 
		return "redirect:/";	
	}
	
	@RequestMapping("/category")
	public ModelAndView category() { 
		ModelAndView mv = new ModelAndView("ProductTable");
		
		return mv;
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin(){
ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
	@RequestMapping("/admin/add")
	public ModelAndView adding(){
		ModelAndView m=null;
		try
		{
		List<Category> list=categoryDao.getAllCategories();
		List<Supplier> list1=supplierDao.getAllSuppliers();
		m = new ModelAndView("adding");
		m.addObject("list",list);
		m.addObject("slist",list1);
		
		}catch(Exception ex)
		{
			m=new ModelAndView("ErrorPage","error",ex);
		}finally
		{
		return m;	
		}
	   }
	    
	@RequestMapping("admin/categorylist")
	public ModelAndView adding1(){
		List<Category> list=categoryDao.getAllCategories();
		ModelAndView m = new ModelAndView("categorylist");
		m.addObject("list", list);
	     return m;
	    		 }
	@RequestMapping("admin/supplierlist")
	public ModelAndView adding2(){
		List<Supplier> list=supplierDao.getAllSuppliers();
		ModelAndView m = new ModelAndView("supplierlist");
		m.addObject("list", list);
	     return m;
	    		 }
	@RequestMapping("admin/productlist")
	public ModelAndView adding3(){
		List<Product> list=productDao.getAllProducts();
		ModelAndView m = new ModelAndView("productlist");
		m.addObject("list", list);
	     return m;
	    		 }
	@RequestMapping("/productfilter")
	public ModelAndView productListFilter(HttpServletRequest request)
	{ 
		List<Product> list=productDao.getFilterProducts(Integer.valueOf(request.getParameter("id")));
		//List<Product> list=productDao.getProducts();
		ModelAndView mv = new ModelAndView("productfilter");	
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("/admin/add_category")
	public ModelAndView add_category(HttpServletRequest request)
	{
		
		ModelAndView m=null;
		try{
		int c_id=Integer.valueOf(request.getParameter("C_ID"));
		String str=request.getParameter("C_NAME");
		System.out.println(c_id+str);
		Category cat = new Category(c_id, str);
		categoryDao.persist(cat);
		List<Category> list=categoryDao.getAllCategories();
		List<Supplier> list1=supplierDao.getAllSuppliers();
		m = new ModelAndView("adding");
		m.addObject("list",list);
		m.addObject("slist",list1);
		}catch(Exception ex)
		{
			m=new ModelAndView("ErrorPage","error",ex);
		}finally{
		return m;
		
	    }
	}
	    		 
	@RequestMapping("/admin/add_supplier")
	public ModelAndView add_supplier(HttpServletRequest request)
	{
		ModelAndView m=null;
		try{
		int s_id=Integer.valueOf(request.getParameter("S_ID"));
		String str=request.getParameter("S_NAME");
		System.out.println(s_id+str);
		Supplier sap = new Supplier(s_id, str);
		supplierDao.persist(sap);
		List<Category> list=categoryDao.getAllCategories();
		List<Supplier> list1=supplierDao.getAllSuppliers();
		m = new ModelAndView("adding");
		m.addObject("list",list);
		m.addObject("slist",list1);
		}catch(Exception ex)
		{
			m=new ModelAndView("ErrorPage","error",ex);
		}finally{
		return m;
		}
	  }
	@RequestMapping("/admin/add_product")
	public ModelAndView add_product(@RequestParam("file") MultipartFile file ,HttpServletRequest request)
	{
		ModelAndView m=null;
		try{
		System.out.println(request.getParameter("pId"));
		System.out.println(request.getParameter("pName"));
		System.out.println(request.getParameter("pPrice"));
		System.out.println(request.getParameter("pCategory"));
		System.out.println(request.getParameter("pSupplier"));
		System.out.println(request.getParameter("pImg"));
		Product product=new Product();
		product.setP_id(Integer.parseInt(request.getParameter("pId")));
		product.setP_name(request.getParameter("pName"));
		product.setP_price(Integer.parseInt(request.getParameter("pPrice")));
		product.setCategory(categoryDao.findById(Integer.parseInt(request.getParameter("pCategory").toString())));
		product.setSupplier(supplierDao.findById(Integer.parseInt(request.getParameter("pSupplier").toString())));
		/*product.setP_image(request.getParameter("pImg"));*/
		String originalfile = file.getOriginalFilename();
		product.setP_image(originalfile);
		productDao.persist(product);
		
String filepath = request.getSession().getServletContext().getRealPath("/") + "/resources/images/product/" + file.getOriginalFilename();
		

		System.out.println(filepath);
		try {
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath));
			fos.write(imagebyte);
			fos.close();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

			m = new ModelAndView("adding");
			m.getModelMap().addAttribute("list", categoryDao.getAllCategories());
			m.getModelMap().addAttribute("slist",supplierDao.getAllSuppliers() );
			
		}catch(Exception ex)
		{
			m=new ModelAndView("ErrorPage","error",ex);
		}finally{
	     return m;
		}
	   }
	@RequestMapping(value="/admin/product_delete")
	public ModelAndView deleteProduct(HttpServletRequest request){
		
		Product p=productDao.findById(Integer.valueOf(request.getParameter("id")));
		System.out.print(p);
	productDao.delete(p);
	List<Product> list=productDao.getAllProducts();
	ModelAndView mv = new ModelAndView("productlist");	
	mv.addObject("list",list);
	return mv;
	}
	
	@RequestMapping(value="/admin/product_edit")
	public ModelAndView editProducts(HttpServletRequest request){	
	int id=Integer.parseInt(request.getParameter("id"));
	ModelAndView mv=new ModelAndView("productEdit");
	List<Category> list=categoryDao.getAllCategories();
	List<Supplier> slist=supplierDao.getAllSuppliers();	
	mv.addObject("product",productDao.findById(id) );	
	mv.addObject("slist", slist);
	mv.addObject("clist", list);
	return mv;
	}
	
	@RequestMapping(value="/admin/product_update")
	public ModelAndView product_update(HttpServletRequest request)
	{
	    System.out.println("In Product Update....");
		System.out.println(request.getParameter("pId"));
		System.out.println(request.getParameter("pName"));
		System.out.println(request.getParameter("pPrice"));
		System.out.println(request.getParameter("pCategory"));
		System.out.println(request.getParameter("pSupplier"));
		System.out.println(request.getParameter("pImg"));
		Product product=new Product();
		product.setP_id(Integer.parseInt(request.getParameter("pId")));
		product.setP_name(request.getParameter("pName"));
		product.setP_price(Integer.parseInt(request.getParameter("pPrice")));
		product.setCategory(categoryDao.findById(Integer.parseInt(request.getParameter("pCategory").toString())));
		product.setSupplier(supplierDao.findById(Integer.parseInt(request.getParameter("pSupplier").toString())));
		product.setP_image(request.getParameter("file"));
		productDao.update(product);
		List<Product> list=productDao.getAllProducts();
		ModelAndView mv = new ModelAndView("productlist"); 	
		mv.addObject("list", list);
		
	     return mv;
	   }
	
	/*@RequestMapping(value = "/product_update", method = RequestMethod.POST)
	public  ModelAndView updateProduct(@RequestParam("file") MultipartFile file ,HttpServletRequest request) 
	{ 
		System.out.println("in Products Controller");
		int id=Integer.valueOf(request.getParameter("p_id"));
		String pname=request.getParameter("p_name");
		String pdesc=request.getParameter("p_desc");
		int price=Integer.valueOf(request.getParameter("p_price"));
		int cid=Integer.valueOf(request.getParameter("c_id"));
		int sid=Integer.valueOf(request.getParameter("s_id"));
		Category c=categoryDao.findById(cid);
		Supplier s=supplierDao.findById(sid);
		Product p=new Product();
		p.setCategory(c);
		p.setP_description(pdesc);
		p.setP_name(pname);
		p.setP_price(price);
		p.setP_id(id);	
		String originalfile = file.getOriginalFilename();
		p.setP_image(originalfile);
		p.setSupplier(s);
		
		productDao.update(p);
		String filepath = request.getSession().getServletContext().getRealPath("/");
		System.out.println(filepath+originalfile);
		try {
			byte imagebyte[] = file.getBytes();
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"/resources/images/"+originalfile));
			fos.write(imagebyte);
			fos.close();
			} catch (IOException e) {
			e.printStackTrace();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		String filepath1 = request.getSession().getServletContext().getRealPath("/");
		String originalfile1 = file.getOriginalFilename();
		System.out.println(filepath1+originalfile1);
		//String filename = filepath + "\\" + product.getProductId() + ".jpg";
		//System.out.println("File Path File "+filepath);
		try {
		byte imagebyte[] = file.getBytes();
		BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath1+"/resources/images/"+originalfile1));
		fos.write(imagebyte);
		fos.close();
		} catch (IOException e) {
		e.printStackTrace();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		List<Category> list=categoryDao.getAllCategories();
		List<Supplier> slist=supplierDao.getAllSuppliers();
		
	
		ModelAndView mv = new ModelAndView("productList");
		mv.addObject("slist", slist);
		mv.addObject("clist", list);
		return mv;
	}
*/
	
	@RequestMapping("/productdetails")
	public ModelAndView addCarttable(HttpServletRequest request) 
	{
		
		int id=Integer.valueOf(request.getParameter("prodid"));
		
		int quan=Integer.valueOf(request.getParameter("prodquantity"));
		
		//int price=Integer.valueOf(request.getParameter("prodprice"));
		/*int uid=Integer.valueOf(request.getParameter("userid"));
		int sid=Integer.valueOf(request.getParameter("suplierid"));*/
		
		/*UserModel c=user1.findById(uid);
		SupplierModel s=supplierDAO.findById(sid);*/
		System.out.println(""+id+""+quan+"");
		Product p=productDao.findById(id);
		int price=p.getP_price();
		Cart g=new Cart();
		g.setPrices(price);
		g.setQuantity(quan);
		g.setProductid(p);
		/*g.setSuplierid(s);
		g.setUserid(c);*/
		
		List<Cart> list=cart1.checkExistance(id);
		int count=list.size();
		System.out.println("no of times"+count);
		if(count==0)
		{
			cart1.save(g);
		}else
		{
			Cart cart=cart1.findById(list.get(0).getCartid());
			int ex=g.getQuantity();
			System.out.println("------------");
			int tot=ex+quan;
			cart.setQuantity(tot);
			cart1.update(cart);
		}
		System.out.println(g);
		
		List<Cart> cartList=cart1.getAll();
		ModelAndView mv = new ModelAndView("display");//productDetails
		mv.addObject("cartlist",cartList);
		return mv;
	}
	}

