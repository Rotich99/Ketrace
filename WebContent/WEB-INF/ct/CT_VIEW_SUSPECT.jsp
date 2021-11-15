<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<c:url var="assets" value="/assets"></c:url>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>View Suspect - CONTACT TRACER -KE TRACECOVID</title>
    <!-- google fonts -->
    <link href="//https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Template CSS -->
    <link rel="stylesheet" href="${assets}/css/style-starter.css">
</head>

<body>
    <!--header-->
    <jsp:include page="../pub/_header.jsp"></jsp:include>
    <!--/header-->
    <!-- hero slider Start -->
    <jsp:include page="_ctmenu.jsp"></jsp:include>
    <!-- hero slider Start -->
    <!--/home-stats-->
    <section class="w3l-homeblock1" id="profile-section">
 <div class="container col-md-6 py-lg-5 py-2">
    <h3 class="text-center bg-secondary text-white py-4"><strong><i></i>Suspected C</strong></h3>
    <form action="${pageContext.request.contextPath}/register" method="post" class="form form-horizontal" id="register-form">
      <div class="form-grids">

        <div class="input-group mt-3">
            <label for="idNumber" class="input-group-prepend py-2 px-1 bg-light"><strong>ID NUMBER:</strong></label>
            <input type="number" name="IDNo" id="idNumber" placeholder="" class="form-control" value="${citizenContext.IDNo }" disabled required="" />
            <input type="hidden" name="intent" value="add-new-citizen">
        </div>
        <div class="input-group">
            <label for="first name" class="input-group-prepend py-2 px-1 bg-light"><strong>First Name:</strong></label>
            <input type="text" name="firstName" id="firstName" placeholder="" class="form-control" value="${citizenContext.firstName }"  disabled required="" />
        </div>

        <div class="input-group">
            <label for="last name" class="input-group-prepend py-2 px-1 bg-light"><strong>Last Name:</strong></label>
            <input type="text" name="lastName" id="lastName" placeholder="" class="form-control" value="${citizenContext.lastName }" disabled required="" />
        </div>
        <div class="input-group">
            <label for="Phone" class="input-group-prepend py-2 px-1 bg-light"><strong>Phone:</strong></label>
            <input type="text" pattern="[0-9]{10,12}" name="phone" id="phone" placeholder="" class="form-control" value="+254${citizenContext.phone }" disabled required="" />
        </div>

        <div class="input-group">  
            <label for="Email" class="input-group-prepend py-2 px-1 bg-light"><strong>Email:</strong></label>
            <input type="email" name="email" id="email" placeholder="" class="form-control" value="${citizenContext.email }" disabled required="" />
        </div>
        <div class="input-group">
          <label for="password" class="input-group-prepend py-2 px-1 bg-light"><strong>Password:</strong></label>
          <input type="text" name="password" id="password" placeholder="" class="form-control" value="${citizenContext.password }" disabled required="" />   
      	</div><br>
      	<div class="btn btn-secondary p-1 d-block"></div>
      	
      <div class="submit-w3l-button text-lg-right">
          <button class="btn btn-style btn-secondary btn-block d-none" id="btn-update-profile">UPDATE</button>
      </div>
      </div> 
  </form>
</div> 
</section>
    <!--//home-stats-->
    
    <!-- Template JavaScript -->
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/theme-change.js"></script>
    
    <!-- disable body scroll which navbar is in active -->
    <script>
        $(function () {
            $('.navbar-toggler').click(function () {
                $('body').toggleClass('noscroll');
            })
        });
    </script>
    <!-- disable body scroll which navbar is in active -->

    <!--/MENU-JS-->
    <script>
        $(window).on("scroll", function () {
            var scroll = $(window).scrollTop();

            if (scroll >= 80) {
                $("#site-header").addClass("nav-fixed");
            } else {
                $("#site-header").removeClass("nav-fixed");
            }
        });

        //Main navigation Active Class Add Remove
        $(".navbar-toggler").on("click", function () {
            $("header").toggleClass("active");
        });
        $(document).on("ready", function () {
            if ($(window).width() > 991) {
                $("header").removeClass("active");
            }
            $(window).on("resize", function () {
                if ($(window).width() > 991) {
                    $("header").removeClass("active");
                }
            });
        });
    </script>
    <!--//MENU-JS-->
    <script src="assets/js/bootstrap.min.js"></script>

</body>

</html>