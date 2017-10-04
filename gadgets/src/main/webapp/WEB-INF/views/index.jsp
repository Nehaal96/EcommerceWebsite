
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="image" value="/resources/image" />
<html>
<head>
<title>Women collection store</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
  <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <link href="./resources/css/Details.css" rel="stylesheet" type="text/css"/>
  <link href="./resources/css/adding.css" rel="stylesheet" type="text/css"/>
  
   
 <style>.carousel-inner > .item > img { width:100%; height:350px; } </style>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"/>
</head>
<br>
<body style="background-color:Aquamarine">
<jsp:include page="header.jsp"/>
	<div class="container">
	<div class="row">
	<div class="col-md-12">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="${pageContext.request.contextPath}/resources/images/fig1.jpg" alt=" " />
			</div>

			<div class="item">
				<img src="${pageContext.request.contextPath}/resources/images/fig2.jpg" alt=" "/>
			</div>

			<div class="item">
				<img src="${pageContext.request.contextPath}/resources/images/fig3.jpg" alt=" "/>
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
</div>
</div>
</div>
<br>
<table class="table table-bordered table-striped">
<tr>
<td><a href="sareeproductinformation"><img src="${pageContext.request.contextPath}/resources/images/fig4.jpg" width="200" height="200"></a></td>
<td><a href="ProductDetails2"><img src="${pageContext.request.contextPath}/resources/images/fig5.jpg" height="200"></a></td>
<td><a href="ProductDetails3"><img src="${pageContext.request.contextPath}/resources/images/fig6.jpg" width="200" height="200"></a></td>
<td><a href="ProductDetails4"><img src="${pageContext.request.contextPath}/resources/images/fig3.jpg" height="200"></a></td>
</tr>
</table>
		
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
					 	
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        
 <div class="container-wrapper">
    <div class="login-container">
        <div id="login-box">
 
            <h2>Login with Username and Password</h2>
 
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>
 
            <form name="loginForm" action="<c:url value="/admin" />" method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>
 
                <input type="submit" value="Submit" class="btn btn-default">
 				<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                            </c:if>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
 
        </div>
    </div>
</div>
 
 </div>
 </div>
  </div> 
 </div>
 <br>
 <br>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>