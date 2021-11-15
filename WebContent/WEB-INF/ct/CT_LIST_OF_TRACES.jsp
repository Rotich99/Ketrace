<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<c:url var="assets" value="/assets"></c:url>

<!doctype html>
    <html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>CONTACT TRACER LIST TRACES-KE TRACECOVID</title>
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
<section class="w3l-stats-main py-5" id="traces">
    <h3 class="container d-flex bg-light "><strong>Consents</strong></h3>
        <div class="row container py-lg-5 py-2">            
            <div class="col-lg-12">
            	<c:forEach items="${consentList }" var="c">
                <div class="card my-1">
                    <div class="card-header bg-secondary text-warning font-weight-bold">
                        <strong>${c.citizen.firstName } ${c.citizen.lastName } <span class="float-right"><i class="fa fa-map-marker"></i>
							<c:forEach items="${countyList }" var="county">
								<c:choose>
									<c:when test="${c.locationID == county.countyID }">
										${county.county }
									</c:when>
								</c:choose>
							</c:forEach>
						</span></strong>
                    </div>
                    <div class="card-body">
                    	<q class="font-weight-bold font-italic">${c.description }</q>
                    </div>
                    <div class="card-footer btn-sm d-flex">
                        <a href="${pageContext.request.contextPath }/ct/alerts/suspect?id=456789" class="btn btn-sm btn-info">View profile</a>
                        <small class="text-right ml-auto">${c.dateRecorded.toLocaleString() }</small>
                    </div>
                    <span class="btn btn-block btn-warning"></span>
                </div>
				</c:forEach>
				
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
            <a href="about.html" class="btn btn-style btn-primary mt-lg-5 mt-4">Read More</a>
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
    </script>
    <!--//MENU-JS-->
    <script src="${assets}/js/bootstrap.min.js"></script>

</body>

</html>