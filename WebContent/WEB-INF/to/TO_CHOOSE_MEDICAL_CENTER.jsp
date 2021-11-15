<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="assets" value="/assets"></c:url>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Test Officer (Choose Medical Center) -KE TRACECOVID</title>
    <!-- google fonts -->
    <!-- <link href="//https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet">-->
    <!-- CSS -->
    <link rel="stylesheet" href="${assets}/css/style-starter.css">
</head>
<body>
   <!-- header -->
<jsp:include page="../pub/_header.jsp"></jsp:include>
    <!--/header-->
    
    <!-- hero slider Start -->
    <jsp:include page="_tomenu.jsp"></jsp:include>
    <!-- hero slider end -->
    <!--/home-stats-->
    <section class="w3l-stats-main">
        <div class="container" id="medic">
            <div class="mx-0 p-0">
            	<div class="col-12 px-3 font-weight-bold h2 text-center text-secondary">Choose Medical Center.</div>
                <c:forEach items="${medList}" var="m" varStatus="loop">
                <div class="card col-12 mb-2">
                	<div class="card-header h3 font-weight-bold font-italic text-info bg-white" >${m.name }</div>
                	<div class="card-body">${m.about }</div>
                	<div class="card-footer btn-group">
                		<a href="${pageContext.request.contextPath }/to/chat/center?center=${m.centerID}#TO_chat" class="btn btn-outline-dark font-weight-bold">Chat with ${m.name }</a>
                	</div>
                	<span class="btn btn-block btn-warning"></span>
                </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <div class="bg-primary btn-block py-2"></div>
    <!--//home-stats-->
    <!-- home page about section -->
    <section class="w3l-homeblock1" id="about">
        <div class="midd-w3 py-5">
            <div class="container py-lg-5 py-md-3">
                <div class="row align-items-center">
                    <div class="col-lg-6">
                        <span class="title-subw3hny">About the disease</span>
                        <h3 class="title-w3l">Coronavirus Disease 
                            Outbreak Situation</h3>
                        <p class="mt-md-4 mt-3"><strong>The virus that causes COVID-19 is mainly transmitted through droplets generated when an infected person coughs , sneezes, or exhales.These droplets are too heavy to hang in the air, and quickly fall on floors or surfaces.<br>
                        You can be infected by breathing in the virus if you are in close proximity of someone who has COVID-19,or by touching a contaminated surface annd then your eyes, nose or mouth.</strong></p>
                        <ul class="service-list pt-lg-2 mt-4">
                            <li class="service-link"><a href="#url"><span class="fas fa-check"></span> Avoid touching your face.</a></li>
                            <li class="service-link"><a href="#url"><span class="fas fa-check"></span> Cover your mouth and nose when coughing.</a></li>
                            <li class="service-link"><a href="#url"><span class="fas fa-check"></span> Stay home if you feel unwell.</a></li>
                        </ul>
                    </div>
                    <div class="HomeAboutImages col-lg-6 mt-lg-0 mt-5 pl-lg-5">
                        <div class="row position-relative">
                            <div class="col-6">
                                <img src="${assets}/images/1.jpg" alt="" class="radius-image img-fluid">
                            </div>
                            <div class="col-6">
                                <img src="${assets}/images/2.jpg" alt="" class="radius-image img-fluid">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- //home page about section -->
    
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
    <script src="${assets}/js/bootstrap.min.js"></script>

</body>

</html>