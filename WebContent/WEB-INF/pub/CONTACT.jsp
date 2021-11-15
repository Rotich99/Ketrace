<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="assets" value="/assets"></c:url>
<!doctype html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>KE TRACECOVID | Contact</title>
  <!-- google fonts -->
  <!--<link href="fonts.googleapis.com/css2?family=Kumbh+Sans:wght@300;400;700&display=swap" rel="stylesheet">-->
  <!-- Template CSS -->
  <link rel="stylesheet" href="${assets }/css/style-starter.css">
  <script src="${assets}/Main.js"></script>
</head>
<body>
    <!--header-->
    <jsp:include page="_header.jsp"></jsp:include>
    <!--/header-->
<!-- breadcrumb -->
<section class="w3l-about-breadcrumb text-center">
  <div class="breadcrumb-bg breadcrumb-bg-about py-5">
      <div class="container py-lg-5 py-md-4">
        <div class="w3breadcrumb-gids">
          <div class="w3breadcrumb-left text-left">
                    <h2 class="title AboutPageBanner">
                Contact Us   </h2>
                              <p class="inner-page-para mt-2">
                                Prevent the Spread
                                Stay at Home, Stay Safe</p>
          </div>
          <div class="w3breadcrumb-right">
                <ul class="breadcrumbs-custom-path">
                  <li><a href="index.html">Home</a></li>
                  <li class="active"><span class="fas fa-angle-double-right mx-2"></span> Contact Us</li>
                </ul>
          </div>
    </div>
      </div>
      <div class="hero-overlay"></div>
  </div>
</section>
<!--//breadcrumb-->
 <!-- contact-form 2 -->
 <section class="w3l-contact-2 py-5" id="contact">
  <div class="container py-lg-4 py-md-3 py-2">
    <div class="title-content text-center">
      <span class="title-subw3hny">Get in touch</span>
      <h3 class="title-w3l mb-lg-4">Contact with our support <br>
        during emergency!</h3>

    </div>
    <div class="contact-grids d-grid mt-5 mx-lg-5">
      <div class="contact-left">
        <div class="cont-details">
          <div class="cont-top margin-up">
            <div class="cont-left text-center">
              <span class="fas fa-map-marked-alt"></span>
            </div>
            <div class="cont-right">
              <h6>Our head office address:</h6>
              <p> Afya House, Cathedral Road <br>
              PO BOX:30016-00100, Kenya.</p>
            </div>
          </div>
          <div class="cont-top margin-up">
            <div class="cont-left text-center">
              <span class="fas fa-blender-phone"></span>
            </div>
            <div class="cont-right">
              <h6>Call for help :</h6>
              <p><a href="tel:+1(21) 234 4567">+254-20 2717077</a></p>
              <p><a href="tel:+1(21) 234 4567">0729471414</a></p>
              <p>Or dial *719#</a></p>
            </div>
          </div>
          <div class="cont-top margin-up">
            <div class="cont-left text-center">
              <span class="fas fa-envelope-open-text"></span>
            </div>
            <div class="cont-right">
              <h6>
                Mail us:</h6>
              <p><a href="mailto:support@mail.com" class="mail">ps@health.go.ke</a></p>
              <p><a href="mailto:contact@mail.com" class="mail">ps@health.go.ke</a></p>
            </div>
          </div>
        </div>
      </div>
      <div class="contact-right">
        <form action="#" method="post" class="signin-form">
          <div class="input-grids">
            <input type="text" name="Name" placeholder="Your Name*" class="contact-input"
              required="" />
            <input type="email" name="Email" placeholder="Your Email*" class="contact-input"
              required="" />
            <input type="text" name="Subject" placeholder="Subject*" class="contact-input"
              required="" />
          </div>
          <div class="form-input">
            <textarea name="Message" placeholder="Type your message here*" required=""></textarea>
          </div>
          <div class="submit-w3l-button text-lg-right">
              <button class="btn btn-style btn-secondary">Send Message</button>
          </div>
        </form>
      </div>
    </div>
</section>
<!-- /contact-form-2 -->
<div class="map-iframe">
    <iframe src="https://www.google.com/maps/embed?pb=!1m16!1m12!1m3!1d3988.807922634523!2d36.8104470644496!3d-1.289485349059485!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!2m1!1sMinistry%20Of%20Health%2C%20Kilimani%20CATHEDRAL%2C%20Nairobi!5e0!3m2!1sen!2ske!4v1630928780674!5m2!1sen!2ske" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
</div>
  <!-- /contact1 -->
<!-- copyright -->
<section class="w3l-copyright">
  <div class="container">
    <div class="row bottom-copies">
      <p class="col-lg-12 copy-footer-29" style="color: lightgoldenrodyellow;" ><bold>© 2021 KE-TRACECOVID.Designed by REUBEN KIPKEMBOI ROTICH [SC212/1237/2017] MURANG'A UNIVERSITY OF TECHNOLOGY[B.SE].</bold></p>
    </div>
  </div>
</section>
<!-- //copyright -->
<!--//footer-->
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