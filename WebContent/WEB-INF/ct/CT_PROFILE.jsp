<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<c:url var="assets" value="/assets"></c:url>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>CONTACT TRACER_PROFILE -KE TRACECOVID</title>
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
    <section class="w3l-stats-main py-5" id="profile-CT">
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
                    <p class="counter">71912</p>
                    <h4>Total Deaths</h4>
                </div>
                <div class="col-lg-3 col-6 stats_info counter_grid text-left mt-lg-0 mt-5">
                    <div class="icon stat-icon">
                        <i class="fas fa-crutch"></i>
                    </div>
                    <p class="counter">11912</p>
                    <h4>Vaccination</h4>
                </div>
            </div>
        </div>
    </section>
    <!--//home-stats-->
    <!-- home page about section -->
    <section class="w3l-homeblock1" id="about">
         <div class="container col-md-6 py-lg-5 py-2">
    <h3 class="text-center bg-primary text-white py-4"><strong>My Profile</strong></h3>
    <form action="${pageContext.request.contextPath}/register" method="post" class="form form-horizontal" id="ct-profile">
      <div class="form-grids">
        <div class="input-group">
            <label for="id number" class="input-group-prepend py-2 px-1 bg-light"><strong>ID NUMBER:</strong></label>
            <input type="number" name="idNumber" id="idNumber" placeholder="" class="form-control" value="${ctContext.contactTracerID }" disabled required="" />
        </div>
        <div class="input-group">
            <label for="first name" class="input-group-prepend py-2 px-1 bg-light"><strong>First Name:</strong></label>
            <input type="text" name="firstName" id="firstName" placeholder="" class="form-control" value="${ctContext.firstName }" disabled required="" />
        </div>

        <div class="input-group">
            <label for="last name" class="input-group-prepend py-2 px-1 bg-light"><strong>Last Name:</strong></label>
            <input type="text" name="lastName" id="lastName" placeholder="" class="form-control" value="${ctContext.lastName }" disabled required="" />
        </div>
        <div class="input-group">
            <label for="Phone" class="input-group-prepend py-2 px-1 bg-light"><strong>CenterID:</strong></label>
            <input type="text" pattern="[0-9]{10,12}" name="phone" id="phone" placeholder="" class="form-control" value="${ctContext.centerID }" disabled required="" />
        </div>

        <div class="input-group">  
            <label for="Email" class="input-group-prepend py-2 px-1 bg-light"><strong>Reg Date:</strong></label>
            <input type="email" name="email" id="email" placeholder="" class="form-control" value="${ctContext.regDate }" disabled required="" />
        </div>
        <div class="input-group">
          <label for="password" class="input-group-prepend py-2 px-1 bg-light"><strong>Password:</strong></label>
          <input type="text" name="password" id="password" placeholder="" class="form-control" value="${ctContext.password }" disabled required="" />   
      </div><br>
      <div class="submit-w3l-button text-lg-right">
          <button class="btn btn-style btn-secondary btn-block">Update Profile</button>
      </div>
  </form>
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