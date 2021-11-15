<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="assets" value="/assets"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="theme-color" content="#99004d">
    <title>KE-TRACECOVID</title>
    <link rel="stylesheet" href="${assets }/css/style-starter.css">
    <link rel="manifest" href="${assets }/manifest.json"/>
    <link rel="apple-touch-icon" href="${assets }/images/192.png">
</head>
<body>
	<!--header-->
    <jsp:include page="_header.jsp"></jsp:include>
    <!--/header-->
    <!-- hero slider Start -->
    <div class="banner-wrap">
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
            <div class="row stats-con">
                <div class="col-lg-3 col-6 stats_info counter_grid text-left mt-lg-0 mt-5">
                    <div class="icon stat-icon">
                        <i class="fab fa-keycdn"></i>
                    </div>
                    <p class="counter">1233100</p>
                    <h4>Active Cases</h4>
                </div>
                <div class="col-lg-3 col-6 stats_info counter_grid1 text-left mt-lg-0 mt-5">
                    <div class="icon stat-icon">
                        <i class="fas fa-users"></i>
                    </div>
                    <p class="counter">182020</p>
                    <h4>Recovered Cases</h4>
                </div>
                <div class="col-lg-3 col-6 stats_info counter_grid text-left mt-lg-0 mt-5">
                    <div class="icon stat-icon">
                        <i class="fas fa-skull-crossbones"></i>
                    </div>
                    <p class="counter">91912</p>
                    <h4>Total Deaths</h4>
                </div>
                <div class="col-lg-3 col-6 stats_info counter_grid text-left mt-lg-0 mt-5">
                    <div class="icon stat-icon">
                        <i class="fas fa-crutch"></i>
                    </div>
                    <p class="counter">17912</p>
                    <h4>Vaccination</h4>
                </div>
            </div>
        </div>
    </section>
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
                                <img src="assets/images/1.jpg" alt="" class="radius-image img-fluid">
                            </div>
                            <div class="col-6">
                                <img src="assets/images/2.jpg" alt="" class="radius-image img-fluid">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- //home page about section -->
    <!-- features-section -->
    <section class="w3l-features py-5" id="work">
        <div class="container py-lg-5 py-md-4 py-2">
            <div class="row main-cont-wthree-2 align-items-center">
                <div class="col-lg-6 feature-grid-left pr-lg-5">
                    <h5 class="title-subw3hny">How to Protect Yourself?</h5>
                    <h3 class="title-w3l mb-4">Prevention & advice</h3>
                    <p class="text-para"><strong> <li style="list-style-type: circle;">Clean your hands often.Use soap and water or alcoholbased sanitizer.</li>
                        <li style="list-style-type: circle;">Maintain a safe distance from anyone coughing or sneezing.</li>
                        <li style="list-style-type: circle;">Wear a mask when physical distancing is not possible.</li>
                        <li style="list-style-type: circle;">Stay home if you feel unwell.</li>
                        <li style="list-style-type: circle;">If you have fever, cough or difficulty in breathing, seek medical attention.</li>
                        <li style="list-style-type: circle;">Don't touch you eyes, nose or mouth.</li>
                        <li style="list-style-type: circle;">Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze.</li></strong>
                    </p>
                    </p>
                    <a href="https://www.who.int/westernpacific/emergencies/covid-19/information/transmission-protective-measures" class="btn btn-style btn-outline-dark mt-lg-5 mt-4">Read More</a>
                </div>
                <div class="col-lg-6 feature-grid-right mt-lg-0 mt-5 pl-lg-5">
                    <div class="call-grids-w3 d-grid">
                        <div class="grids-1 box-wrap">
                            <div class="icon">
                                <i class="fas fa-hands-wash"></i>
                            </div>
                            <h4><a href="about.html" class="title-head">Wash your hands frequently</a></h4>
                        </div>
                        <div class="grids-1 box-wrap">
                            <div class="icon">
                                <i class="fas fa-people-arrows"></i>
                            </div>
                            <h4><a href="about.html" class="title-head">Maintain social distancing, upto six feet</a></h4>
                        </div>
                        <div class="grids-1 box-wrap">
                            <div class="icon">
                                <i class="fas fa-surprise"></i>
                            </div>
                            <h4><a href="about.html" class="title-head">Avoid touching on your face</a></h4>
                        </div>
                        <div class="grids-1 box-wrap">
                            <div class="icon">
                                <i class="fas fa-temperature-high"></i>
                            </div>
                            <h4><a href="about.html" class="title-head">Practice respiratory hygiene</a></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- features section -->
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
                            <a href="#service" class="d-block zoom"><img src="assets/images/s1.jpg" alt=""
                                    class="img-fluid" /></a>
                            <div class="blog-info">
                                <a href="#service" class="title">Wear A Face Mask</a>
                                <p class="text-para"> Wearing a FACEMASK is better than wearing a VENTILATOR. </p>
                            </div>
                           
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-md-0 mt-5">
                        <div class="grids5-info">
                            <a href="#service" class="d-block zoom"><img src="assets/images/s2.jpg" alt=""
                                    class="img-fluid" /></a>
                            <div class="blog-info">
                                <a href="#service" class="title">Wash Your Hands</a>
                                <p class="text-para">Washing your hands with soap and water or using alcohol-based hand sanitizer kills viruses that may be on your hands.  </p>
                            </div>
                            
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-lg-0 mt-5">
                        <div class="grids5-info">
                            <a href="#service" class="d-block zoom"><img src="assets/images/s3.jpg" alt=""
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
    <script type="text/javascript"src="${assets}/Main.js"></script>
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