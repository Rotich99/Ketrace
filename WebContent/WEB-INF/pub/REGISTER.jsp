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
    <!-- home page about section -->
<section class="w3l-homeblock1" id="register-section">
 <div class="container col-md-6 py-lg-5 py-2">
    <h3 class="text-center bg-secondary text-white py-4"><strong>CREATE ACCOUNT</strong></h3>
    <form action="${pageContext.request.contextPath}/register" method="post" class="form form-horizontal" id="register-form">
      <div class="form-grids">
      	<div class="input-group mt-3">
            <label for="id number" class="input-group-prepend py-2 px-1 bg-light"><strong>SELECT ROLE:</strong></label>
            <select name="userRole" id="userRole" class="custom-select form-control">
            	<option value="citizen" selected>CITIZEN</option>
            	<option value="to">TEST OFFICER</option>
            	<option value="ct">CONTACT TRACER</option>
            </select>
            <input type="hidden" name="intent" value="add-new-citizen">
        </div>
        
        <div class="input-group mt-3">
            <label for="id number" class="input-group-prepend py-2 px-1 bg-light"><strong>ID NUMBER:</strong></label>
            <input type="number" name="IDNo" id="idNumber" placeholder="" class="form-control" required="" />
            <input type="hidden" name="intent" value="add-new-citizen">
        </div>
        <div class="input-group">
            <label for="first name" class="input-group-prepend py-2 px-1 bg-light"><strong>First Name:</strong></label>
            <input type="text" name="firstName" id="firstName" placeholder="" class="form-control" required="" />
        </div>

        <div class="input-group">
            <label for="last name" class="input-group-prepend py-2 px-1 bg-light"><strong>Last Name:</strong></label>
            <input type="text" name="lastName" id="lastName" placeholder="" class="form-control" required="" />
        </div>
        <div class="input-group">
            <label for="Phone" class="input-group-prepend py-2 px-1 bg-light"><strong>Phone:</strong></label>
            <input type="text" pattern="[0-9]{10,12}" name="phone" id="phone" placeholder="" class="form-control" required="" />
        </div>

        <div class="input-group">  
            <label for="Email" class="input-group-prepend py-2 px-1 bg-light"><strong>Email:</strong></label>
            <input type="email" name="email" id="email" placeholder="" class="form-control" required="" />
        </div>
        <div class="input-group">
          <label for="password" class="input-group-prepend py-2 px-1 bg-light"><strong>Password:</strong></label>
          <input type="password" name="password" id="password" placeholder="" class="form-control" required="" />   
      	</div><br>
      <div class="submit-w3l-button text-lg-right">
          <button class="btn btn-style btn-secondary btn-block">Create Account</button>
          
          <div class='bg-light d-none card border-danger p-2 font-weight-bold mt-1' id='feedback-card'>${feedback}</div>
      </div>
      </div>
  </form>
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
    
    <script>
    	$(document).ready(function(){    		
    		$("#register-form").on('submit', function(ev){
    			event.preventDefault();
    			//alert('You say you are [' + $("#userRole").val() + ']');
    			var userType = $("#userRole").val();
    			var intention = "add-new-citizen";
    			
    			if(userType == 'to'){
    				intention = "add-new-testOfficer";
    			} else if(userType == 'ct'){
    				intention = "add-new-contactTracer";
    			}
    			$.post('${pageContext.request.contextPath}/register', 
    		        {
    				intent : intention,
    				userRole : $("#userRole").val(),
					IDNo : $("#idNumber").val(),
					firstName : $("#firstName").val(),
					lastName : $("#lastName").val(),
					phone : $("#phone").val(),
					email : $("#email").val(),
					password : $("#password").val()
    		        	}, function(data){
    		        		//alert('HELLO: ' + data);							
    		        		
    		        		if(data == "FAIL"){
    		        			//scrollTopFunc();
    		        			$('#feedback-card').removeClass('d-none').empty().html("<strong>Hey, sorry. I got a problem trying to log you in please try again.<hr>"
    									+ "<strong class='text-dark'>(I will contact the administrator to address such issue. <br>Thank you for staying with me)</strong></strong>");
    		        		} else if(data == "FILL_DETAILS"){
    		        			//scrollTopFunc();
    		        			$('#feedback-card').removeClass('d-none').empty().html("<strong class='font-weight-bold'>Please enter your Email/Phone and Password.</strong>");
    		        			
    		        		}    		
    		        		else if(data == "SUCCESS") {
    		        			$('#feedback-card').removeClass('d-none').html("<strong class='text-success font-weight-bold'>Logged in successfully. Taking you there");
    		        			var nextURL = $('#nextURL').val();
    		        			
    		        			/*
    		        			if(nextURL !== "") {
    		        				$(location).attr('href', '' + nextURL);	
    		        			} else if(nextURL === '') {
    		        				$(location).attr('href', "/citizen/");
    		        			}
    		        			*/
    		        			
    		        			if(userType == 'to'){
    		        				nextURL = '${pageContext.request.contextPath}/to';
    		        			} else if(userType == 'ct'){
    		        				nextURL = '${pageContext.request.contextPath}/ct';
    		        			} if(userType == 'citizen'){
    		        				nextURL = '${pageContext.request.contextPath}/citizen';
    		        			}
    		        			
    		        			$(location).attr('href', nextURL);
    		        			
    		        			//$(location).attr('href', $('#nextURL').val());
    		        		} else {
    		        			$('#feedback-card').removeClass('d-none').empty().html('<strong class="text-primary"><i class="fa fa-info-circle"></i>Could not contact server. Please check your Data or Wi-Fi connection</strong> <br><hr>');
    		        		}
    		        	});
    		});
    	});
    </script>

</body>

</html>