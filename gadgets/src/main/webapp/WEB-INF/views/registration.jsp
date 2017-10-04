<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>REGISTRAION PAGE</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      height:200px;
  }
  
 

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 400px) {
    .carousel-caption {
      display: none; 
    }
  }
  
 form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password],input[type=email],input[type=number] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 30%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}


.container {
    padding: 8px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
  
</head>
<body style="background-color:Aquamarine ">
<jsp:include page="header.jsp" />
<!-- <form action="register" method="post"> -->

<form action="register">

  <div class="container-">
    <label><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required="required">
     <label><b>Age</b></label>
    <input type="number" placeholder="Enter Age" name="age"  pattern="[18-99]" title="enter age between 18-99" required="required" >
     <label><b>email</b></label>
    <input type="email" placeholder="Enter email" name="mail" required="required" >
	 <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="passwd" maxlength="10" title="enter valid password" required="required" >
     <label><b>Phone Number</b></label>
      <input type="number" placeholder="Enter Phone-Number" name="phone" maxlength="16" pattern="/^+91(7\d|8\d|9\d)\d{9}$/" title="enter valid number" required="required">
      <label><b>Address</b></label><br>
    <textarea rows="4" cols="112" name="address"></textarea>
     <button type="submit">Login</button>
      <!-- <input type="submit" name="butSubmit" value="Register" /> -->
    <!-- <input type="checkbox" checked="checked"> Remember me
  </div>
  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">New User <a href="#">Register</a></span>
  </div> -->
</form>
<br/>
<br/>
<br/>
<br/>
<jsp:include page="footer.jsp" />
</body>
</html>


