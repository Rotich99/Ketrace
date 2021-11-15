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
                        <h1 data-animation="flipInX" data-delay="0.8s" data-color="#fff">Welcome, ${citizenContext.firstName } ${citizenContext.lastName }</h1>
                        <p data-animation="fadeInDown" class="mt-4"><strong>Stay home stay safe. <br>Better Together || Safer Together.</strong></p>
                        <div class="cta-btn" data-animation="fadeInUp" data-delay="1s">
                            <a href="${pageContext.request.contextPath}/citizen/profile#profile-section" class="btn btn-style btn-info"><i class="fa fa-user fa-lg"></i>View Profile</a>
                            <a href="${pageContext.request.contextPath}/citizen/notifications#notifications" class="btn btn-style btn-secondary"><i class="fa fa-bell fa-lg"></i> Get Notifications</a>
                            <a href="${pageContext.request.contextPath}/citizen/updates#citizen-updates" class="btn btn-style btn-light"><i class="fas fa-newspaper fa-lg"></i> Browse Updates</a>
                            <a href="${pageContext.request.contextPath}/citizen/consents#consent-section" class="btn btn-style btn-secondary"><i class="fas fa-pen-nib fa-lg"></i> Make Consent</a>
                        </div>
                    </div>
                </div>
                <div class="hero-overlay"></div>
            </div>
            <!-- hero slide end -->
           
        </div>
    </div>
    <!-- hero slider end -->