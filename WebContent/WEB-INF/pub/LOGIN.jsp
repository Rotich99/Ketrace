<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="assets" value="/assets"></c:url>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>KE_TRACECOVID</title>
    <!-- google fonts -->
    <link href="//https://fonts.googleapis.com/css2?family=Kumbh+Sans:wght@300;400;700&display=swap" rel="stylesheet">
    <!-- Template CSS -->
    <link rel="stylesheet" href="${assets }/css/style-starter.css">
    <link rel="stylesheet" type="text/css" href="${assets }/css/Login.css">
    
    <style type="text/css">
    	header .container{
    		background-color: #99004d;
    	}
    </style>
</head>

<body>
    <!--header-->
    <jsp:include page="_header.jsp"></jsp:include>
    <!--/header-->

    <!-- hero slider Start -->
    <div class="banner-wrap d-none">
        <div class="banner-slider">
            <!-- hero slide start -->
            <div class="banner-slide bg1">
                <div class="container">
                    <div class="hero-content">
                        <h1 data-animation="flipInX" data-delay="0.8s" data-color="#fff">
                            Prevent the Spread
                            Stay at Home, Stay Safe</h1>
                        <p data-animation="fadeInDown" class="mt-4"><strong>Corona Virus is a disease mainly spread from persons to persons through  contact with droplets or fluids from an infected person.To protect our loved ones and the community, it is rather advised to stay at home and be safe.</strong></p>
                        <div class="cta-btn" data-animation="fadeInUp" data-delay="1s">
                            <a href="https://www.health.go.ke" class="btn btn-style btn-primary">Read More</a>
                        </div>
                    </div>
                </div>
                <div class="hero-overlay"></div>
            </div>
            <!-- hero slide end -->
           
        </div>
    </div>
    <!-- hero slider end -->
    <!--/home-stats-->
    <section class="w3l-stats-main py-5">
        <div class="container py-lg-5 py-2">
        	<div class="border-danger text-danger bg-light">${feedback }</div>
            <form class="form" action="${pageContext.request.contextPath}/login" method="post">
				<div class="title">Login</div>
				<div class="input-box underline">
					<input type="number" placeholder="Enter ID Card Number" name="idNumber" required>
					<div class="underline"></div>
				</div>
				<div class="input-box">
					<input type="password" placeholder="Enter Your Password" name="password" required>
					<div class="underline"></div>
				</div>
				<div class="input-box button">
					<input type="submit" formaction="${pageContext.request.contextPath}/login" value="Login">
				</div>
				<div class="signup-link">Not a member? <a href="${pageContext.request.contextPath}/register#register-section">Create an Account</a></div>
			</form>
        </div>
    </section>
    <!--//home-stats-->
    
   
    <!-- Template JavaScript -->
    <script src="${assets}/js/jquery-3.3.1.min.js"></script>
    <script src="${assets}/js/theme-change.js"></script>
    
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