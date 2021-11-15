<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<c:url var="assets" value="/assets"></c:url>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Notifications (Public)-KE TRACECOVID</title>
    <!-- google fonts -->
   <!-- <link href="//https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap" rel="stylesheet"> -->
    <!-- Template CSS -->
    <link rel="stylesheet" href="${assets}/css/style-starter.css">
</head>
<body>
     <!--header-->
	<jsp:include page="../pub/_header.jsp"></jsp:include>
	<!--/header-->
    
    
    <!-- hero slider Start -->
    <jsp:include page="_citizenmenu.jsp"></jsp:include>
            <!-- hero slide end -->
    <!--home-stats-->
    <section class="row container" id="notifications">
        <div class="container col-md-6 py-lg-5 py-2">
            <div class="bg-white" id="chatbox">
                <div class="py-2 py-md-5">
                    <div class="card-header text-center bg-secondary font-weight-normal text-white mb-1">
                    <strong><i class="far fa-bell fa-lg fa-fw text-green "></i> Notifications.</strong>
                </div>
                <div>
                	<c:forEach items="${notificationList }" var="n">
                    <div class="card col-md-12 px-0 mx-0 border border-secondary mb-3">
                    	<div class="card-header bg-secondary text-white font-weight-bold font-italic">
                    		<i class="fa fa-map-marker-alt"></i> ${n.county.county }
                    	</div>
                        <div class="card-body">
                            <p class="text-dark">${n.details}</p>
                        </div>
                        <div class=" bg-light text-right pr-2">
                            <small class="font-weight-bold">${n.dateOccured.toLocaleString() }</small>
                        </div>
                        <span class="btn btn-block btn-warning"></span>
                    </div>
                    </c:forEach>
                </div>

            </div>
        </div>
    </section>
    <!--//home-stats-->
    <!--  services section -->
    <div class="w3l-servicesblock2" id="services">
        <section id="grids5-block" class="py-5">
            <div class="container py-lg-5 py-md-4 py-2">
                <h5 class="title-subw3hny text-center">Protect Yourself?</h5>
                <h3 class="title-w3l text-center">Take Steps To Protect
                    Yourself</h3>
                <div class="row mt-lg-5 mt-4 text-center">
                    <div class="col-lg-4 col-md-6">
                        <div class="grids5-info">
                            <a href="#service" class="d-block zoom"><img src="${assets}/images/s1.jpg" alt=""
                                    class="img-fluid" /></a>
                            <div class="blog-info">
                                <a href="#service" class="title">Wear A Face Mask</a>
                                <p class="text-para"> Wearing a FACEMASK is better than wearing a VENTILATOR. </p>
                            </div>
                           
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-md-0 mt-5">
                        <div class="grids5-info">
                            <a href="#service" class="d-block zoom"><img src="${assets}/images/s2.jpg" alt=""
                                    class="img-fluid" /></a>
                            <div class="blog-info">
                                <a href="#service" class="title">Wash Your Hands</a>
                                <p class="text-para">Washing your hands with soap and water or using alcohol-based hand sanitizer kills viruses that may be on your hands.  </p>
                            </div>
                            
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-lg-0 mt-5">
                        <div class="grids5-info">
                            <a href="#service" class="d-block zoom"><img src="${assets}/images/s3.jpg" alt=""
                                    class="img-fluid" /></a>
                            <div class="blog-info">
                                <a href="#service" class="title">Avoid Close Contact</a>
                                <p class="text-para"> Keep your distance: Stay atleast one and a half metres from others, even if they don't appear to be sick, since the people can have virus without having symptoms. </p>
                            </div>
                           
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    </section>
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


        $('#btn-send-message').on('click', function(e){
            e.preventDefault();
            var newMsg = $('#new-msg').val();
            $(this).addClass('bg-danger');
            console.log('Message by user:\n' + newMsg);
            $('#chatbox').append('<div class="row px-3 mb-1">' +
                    ' <div class="card col-md-12 px-0 mx-0 border-dark"> ' +
                       ' <div class="card-body"> ' +
                          '  <p class="text-dark">' + newMsg + '</p> ' +
                        ' </div> ' +
                        '<div class=" bg-light text-right pr-2">' + 
                            ' <small class="font-weight-bold">' + new Date() + '</small> ' +
                        ' </div> ' + 
                    ' </div> ' +
                '</div>');

            //$('#new-msg').attr('val', '');
            $('#new-msg').val('');
        });

    </script>
    <!--//MENU-JS-->
    <script src="${assets}/js/bootstrap.min.js"></script>

</body>

</html>