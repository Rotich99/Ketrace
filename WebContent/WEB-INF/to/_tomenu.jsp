<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="assets" value="/assets"></c:url>
_<!-- hero slider Start -->
    <div class="banner-wrap">
        <div class="banner-slider">
            <!-- hero slide start -->
            <div class="banner-slide bg1">
                <div class="container">
                    <div class="hero-content">
                        <h1 data-animation="flipInX" data-delay="0.8s" data-color="#fff">Welcome, ${toContext.firstName } ${toContext.lastName }</h1>
                        <p data-animation="fadeInDown" class="mt-4"><strong>What do you want to do today?</strong></p>
                        <div class="cta-btn" data-animation="fadeInUp" data-delay="1s">
                            <a href="${pageContext.request.contextPath }/to/alert#alert" class="btn btn-style btn-primary"><i class="fas fa-exclamation-triangle fa-lg"></i>  Record an Alert</a>
                            <a href="${pageContext.request.contextPath }/to/profile#to-profile" class="btn btn-style btn-info"><i class="fa fa-user fa-lg"></i> View Profile</a><br><br>
                            <a href="${pageContext.request.contextPath }/to/contact/choose#medic" class="btn btn-style btn-secondary"><i class="fas fa-phone-alt fa-lg"></i> Contact Medical Center</a>
                            <a href="${pageContext.request.contextPath }/to/chat#TO_chat" class="btn btn-style btn-light"><i class="far fa-comment fa-lg"></i> View Chat</a>
                        </div>
                    </div>
                </div>
                <div class="hero-overlay"></div>
            </div>
            <!-- hero slide end -->
           
        </div>
    </div>
    <!-- hero slider end -->
    