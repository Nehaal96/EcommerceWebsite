<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Women Collection Store</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
  <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="./resources/css/Details.css" rel="stylesheet" type="text/css"/>
  <link href="./resources/css/adding.css" rel="stylesheet" type="text/css"/>
  <style>.carousel-inner > .item > img { width:100%; height:350px; } </style>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"/>
 
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />
 
 
 <%@page import="com.niit.gadgets.model.Category" %>
    <%@page import="com.niit.gadgets.model.Supplier" %>
    <%@page import="java.util.List" %>
   
   <style>
   		#cat{ width:400px;height:280px;position:relative;left:450px;top:-30px; }
  		#sup{ width:400px;height:280px;position:relative;left:450px;top:-50px; }
   		#pt{ width:600px;height:500px;position:relative;left:450px;top:-80px; }
   	
   	/* style for label and button */
   		#panel1{ width:400px;height:700px;display:inline;border:3px solid black;padding:250px 200px;position:relative;top:250px;background:grey;}
   		#lc{ position:absolute;left:90px;top:50px; }
   		#addc{ position:absolute;left:100px;top:120px; }
   		#ls{ position:absolute;left:90px;top:170px; }
   		#adds{ position:absolute;left:100px;top:250px; }
   		#lp{ position:absolute;left:90px;top:300px; }
   		#addp{ position:absolute;left:100px;top:370px; }
   		
   		
   		.sty
   		{
   		color:black;
   		text-decoration: underline;
   		font-family: serif;
   		font-size: x-large;
   		}
   		
   		
   </style>
    <script>
    $(document).ready(function() {$("#cat").hide();$("#sup").hide();$("#pt").hide();

    	   $("#addc").click(function() { $("#cat").show();$("#sup").hide();$("#pt").hide(); });
    	   
    	   $("#adds").click(function() { $("#cat").hide();$("#sup").show();$("#pt").hide(); });
    	   
    	   $("#addp").click(function() { $("#cat").hide();$("#sup").hide();$("#pt").show(); });
    	   });	
    </script>
<script>
$(function () {
    'use strict';

    function confirmDialog(title, message, success) {
        var confirmdialog = $('<div></div>').appendTo('body')
            .html('<div><h6>' + message + '</h6></div>')
            .dialog({
                modal: true,
                title: title,
                zIndex: 10000,
                autoOpen: false,
                width: 'auto',
                resizable: true,
                buttons: {
                    Yes: function () {
                        success();
                        $(this).dialog("close");
                    },
                    No: function () {
                        $(this).dialog("close");
                    }
                },
                close: function() {
                    $(this).remove();
                }
            });

        return confirmdialog.dialog("open");
    }

    $('form').on('submit', function (e) {
        e.preventDefault();
        var form = this;

        confirmDialog('Confirm', 'Shell i Get the Data? ', function () {
            form.submit();
        });
    });
});

</script>

<script>
function validateAdd()
{
	
var pid=document.addform.pId.value;
var pname=document.addform.pName.value;
var pdesc=document.addform.pdesc.value;
var price=document.addform.pPrice.value;


if(pid==null||pid==" ")
	{
	alert("enter the id ");
	return false;
	}
else if(pname==null||pname==" ")
	{
	alert("Please enter the product name");
	return false;
	}else if(price==null || price==" ")
		{
		alert("enter the price ")
		}
}

</script>
<script>
function validatecat()
{
	
var cid=document.addcat.C_ID.value;
var cname=document.addcat.C_NAME.value;
if(cid==null||cid==" ")
	{
	alert("enter the id ");
	return false;
	}
else if(cname==null||cname==" ")
	{
	alert("Please enter the category name");
	return false;
	}
}

</script>
<script>
function validatesup()
{
	
var sid=document.addsup.S_ID.value;
var sname=document.formsup.S_NAME.value;



if(sid==null||sid==" ")
	{
	alert("enter the id ");
	return false;
	}
else if(sname==null||sname==" ")
	{
	alert("Please enter the product name");
	return false;
	}
}

</script>


 </head>

<body style="background-color:Aquamarine">
<jsp:include page="header.jsp"/>
							<nav>
							<a class="sty" href="supplierlist">SupplierList||</a>
							<a  class="sty" href="categorylist">CategoryList||</a>
							<a  class="sty" href="productlist">ProductList||</a>
							</nav><br>
<div id="panel1">
<label id="lc"><h2>Category</h2></label>
<button id="addc">Add Category</button>

<label id="ls"><h2>Supplier</h2></label>
<button id="adds">Add Supplier</button>

<label id="lp"><h2>Product</h2></label>
<button id="addp">Add Product</button>
</div>
<div class="container">
<div id="cat">
<h3>Category Table</h3>
  <form action="add_category" class="form-horizontal" role="form" name="addcat">
        <div class="container">
            <div class="form-group">
		        <label for="C_ID" class ="control-label col-sm-3"><b>Category_Id</b></label>
		    <div class="col-sm-4">
		         <input type="text" class="form-control" name="C_ID" /></div></div>
		    <div class="form-group">
		         <label for="C_NAME" class ="control-label col-sm-3"><b>Category_Name</b></label>
		    <div class="col-sm-4">
		         <input type="text"  class="form-control" name="C_NAME" /></div></div>
		    <button type="submit" onclick="validatecat()">Add</button>
		        <button type="button" class="cancelbtn">Cancel</button>
	      </div>
	  </form>
	  
	  </div>
	  <br>
	  <div id="sup">
	  <h3>Supplier Table</h3>
	  <form action="add_supplier" class="form-horizontal" role="form" name="addsup">
	     <div class="container">
	           <div class="form-group">
			        <label for="S_ID" class ="control-label col-sm-3"><b>Supplier_Id</b></label>
			    <div class="col-sm-4">
			        <input type="text" class="form-control" name="S_ID" /></div></div>
			   <div class="form-group">
			       <label for="S_NAME" class ="control-label col-sm-3"><b>Supplier_Name</b></label>
			    <div class="col-sm-4">
			        <input type="text" class="form-control"name="S_NAME" /></div></div>
			   <button type="submit" onclick="validatesup">Add</button>
			        <button type="button" class="cancelbtn">Cancel</button>
	     </div>
	 </form>
	  </div>
	  <br>
	  
	  <div id="pt">
	   <h3>Product Table</h3>
	  <form action="add_product" name="addform" class="form-horizontal" role="form" method="post" enctype="multipart/form-data"> 
	  <!-- <form action="add_product" class="form-horizontal" role="form"> -->
	           <div class="form-group">
			        <label for="pId" class ="control-label col-sm-3"><b>Product_Id</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control" name="pId" /></div></div>
			        
			   <div class="form-group">
			       <label for="pName" class ="control-label col-sm-3"><b>Product_Name</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control" name="pName" /></div></div>
			        
			            <div class="form-group">
			       <label for="pdesc" class ="control-label col-sm-3"><b>Product_Desc</b></label>
			    <div class="col-sm-8">
			    <textarea rows="2" cols="2" class="form-control" name="pdesc"></textarea>
			      <!--   <input type="text" class="form-control" name="pPrice" /> --></div></div>
			        
			    <div class="form-group">
			       <label for="pPrice" class ="control-label col-sm-3"><b>Product_Price</b></label>
			    <div class="col-sm-8">
			        <input type="text" class="form-control" name="pPrice" /></div></div>
			        
			   
			    <div class="form-group">
		            <label for="pCategory" class ="control-label col-sm-3"><b>Product_Category</b></label>
		         <div class="col-sm-4">
		             <select class="form-control" name="pCategory">
		                  <option value="0">Select</option>
		                    <%
             	   List<Category> clist=(List<Category>) request.getAttribute("list");
    			   for(Category c : clist){
    				out.println("<option value='"+ c.getC_id() +"'>"+ c.getC_name() + "</option>");
    			}
    			
             %>
	                </select></div></div>
		              
		         <div class="form-group">
		            <label for="pSupplier" class ="control-label col-sm-3"><b>Product_Suppliers</b></label>
		         <div class="col-sm-4">
		             <select class="form-control" name="pSupplier">
		                  <option value="0">Select</option>
		                <%
             	List<Supplier> slist=(List<Supplier>) request.getAttribute("slist");
    			for(Supplier c : slist){
    				out.println("<option value='"+ c.getS_id() +"'>"+ c.getS_name() + "</option>");
    			}
    			
             %>      
                   </select>
                     </div></div>
                     <div class="form-group">
                               <label for="img">Upload Image:</label>
                                <input type="file" id="img" name="file">
                       </div>
                          <button type="submit" class="btn btn-primary" onclick="validateAdd()" >Save</button>
                         
 </div>                        
	
	  <br>
	  <br>
	  <br>
</div>
<br>
<br>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>