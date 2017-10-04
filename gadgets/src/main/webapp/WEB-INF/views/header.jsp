<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="image" value="/resources/image" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
#ad {
	position: relative;
	left:150px;
}

#ho {
	position: absolute;
	left: 100px;
}

#pro {
	position: absolute;
	left: 150px;
}
</style>
</head>
<body>
<%-- <a class="navbar-brand" href="./">                    

                           <img src="${pageContext.request.contextPath}/resources/image/LogoNew.png"  width="100px" height="75px" class="img-responsive"/>

                     </a> --%>
	<!-- starting header navigation bar -->
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<a class="navbar-brand" href="./"> <img
			src="${pageContext.request.contextPath}/resources/images/fig8.jpg" width="40px"
			height="10px" style="position: absolute; top:0px; left: 40px;"
			class="img-responsive" />
		</a>

		<!-- Collect the nav links, forms, and other content for toggling -->

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

			<%-- <a href="<spring:url value="checkout/" />" class="btn btn-success pull-right">
<span class="glyphicon-shopping-cart glyphicon"></span>Check out</a> --%>

				<li><a href="./" id="ho">HOME</a></li><li></li><li></li>
				<c:if test="${pageContext.request.userPrincipal.name  != 'admin@gmail.com'}">
				<li class="dropdown"><a id="pro" class="dropdown-toggle"
					data-toggle="dropdown" href="#",style="color:white">CATEGORIES<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${catlist}" var="p">
							<li><a href="productfilter?id=${p.c_id}">${p.c_name}</a></li>
						</c:forEach>
					</ul></li>
					</c:if>
				 
				<li>
					<%-- <li><a href="<c:url value="/admin" />">Admin</a></li> --%> 
					<c:if test="${pageContext.request.userPrincipal.name  == 'admin@gmail.com'}">
						<li><a id="ad" style="color: white;"
							href="<c:url value="/admin/add"/>" role="button" aria-haspopup="true"
							aria-expanded="false">ADD</a></li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name  == null}">
						<li><a style="color: white;"
					href="<c:url value="/login"/>" role="button"
							aria-haspopup="true" aria-expanded="false">Login</a></li>
					</c:if>
				</li>

			</ul>


			<c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
				<li><a href="<c:url value="/admin" />">ADMIN</a></li>
			</c:if>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="cvideo">VIDEO</a>				
				</li>
				</ul>

			<ul class="nav navbar-nav navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name == null }">

					<li><a href="registration">SIGN UP<span
							class="glyphicon glyphicon-log-in"></span></a></li>
					
					 
				</c:if>
				</ul>
				<c:if test="${pageContext.request.userPrincipal.name  != null}">
					<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
					<li><a href='<c:url value="/logout" />'>SIGN OUT</a></li>
				</c:if>
		</div>
	</div>
	</nav>
	
</body>
</html>


