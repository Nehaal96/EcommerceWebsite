<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product List</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
	<link href="./resources/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<body>
<jsp:include page="header.jsp" />
<h2>Edit Product Details</h2>
<hr/>
  <form action="product_update" enctype="multipart/form-data">
    <div class="form-group">
      <label for="pId">Product  ID :</label>
      <input type="number" class="form-control" id="pId" placeholder="Enter Product ID" name="pId" value="${product.p_id}" readonly="true">
    </div>
    <div class="form-group">
      <label for="pName">Product Name :</label>
      <input type="text" class="form-control" id="pName" placeholder="Enter Product Name " name="pName" value="${product.p_name}">
    </div>
    <div class="form-group">
      <label for="p_description">Product Description :</label>
      <input type="text" class="form-control" id="p_description"  name="p_description" value="${product.p_description}" >
    </div>
    <div class="form-group">
      <label for="pPrice">Product Price :</label>
      <input type="number" class="form-control" id="pPrice" placeholder="Enter Product Price " name="pPrice" value="${product.p_price}" >
    </div>
    <div class="form-group">
  <label class="col-md-4 control-label" for="pCategory" >Select Category</label>
  <div class="col-md-4">
    <select id="pCategory" class="form-control" name="pCategory">
      <c:forEach var="clist" items="${clist}">

                <option value="${clist.c_id}">${clist.c_name}</option>

            </c:forEach>
    </select>
  </div>
</div>
<br/>
<br/>
<div class="form-group">
  <label class="col-md-4 control-label" for="s_id" >Select Supplier</label>
  <div class="col-md-4">
    <select id="s_id" class="form-control" name="pSupplier">
      <c:forEach var="slist" items="${slist}">

                <option value="${slist.s_id}">${slist.s_name}</option>

            </c:forEach>
    </select>
  </div>
</div>
<br/>
<br/>
<br/>

<div class="form-group">
      <label for="img">Upload Image:</label>
      <input type="file" id="img" name="file">
    </div>
    <button type="submit" class="btn btn-primary" >Save</button>
  </form>
  <jsp:include page="footer.jsp" />
</body>
</html>