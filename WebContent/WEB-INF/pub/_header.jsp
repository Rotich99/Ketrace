<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="assets" value="/assets"></c:url>

<!--header-->
    <header id="site-header" class="fixed-top">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-dark stroke">
                <h1>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                      KE<i class="fab fa-keycdn"></i>TRACECOVID</a>
                </h1>
                <!-- if logo is image enable this   
          <a class="navbar-brand" href="#${pageContext.request.contextPath}/">
              <img src="image-path" alt="Your logo" title="Your logo" style="height:35px;" />
          </a> -->
                <button class="navbar-toggler  collapsed bg-gradient" type="button" data-toggle="collapse"
                    data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon fa icon-expand fa-bars"></span>
                    <span class="navbar-toggler-icon fa icon-close fa-times"></span>
                    </span>
                </button>
                <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav ml-lg-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item mr-lg-1">
                            <a class="nav-link" href="${pageContext.request.contextPath}/contact"> Emergency-Contact</a>
                        </li>
                         <!--/search-right-->
                            <li class="header-search mr-lg-2 mt-lg-0 mt-4 position-relative">
                                <div class="search-right">
                                    <a href="${pageContext.request.contextPath}/login" class="btn btn-style search-btn" title="search"><span
                                             aria-hidden="true"></span> LOGIN</a>
                                  
                                </div>
                            </li>
                            <!--//search-right-->
                    </ul>
                </div>
                <!-- toggle switch for light and dark theme -->
                <div class="mobile-position">
                    <nav class="navigation">
                        <div class="theme-switch-wrapper">
                            <label class="theme-switch" for="checkbox">
                                <input type="checkbox" id="checkbox">
                                <div class="mode-container py-1">
                                    <i class="gg-sun"></i>
                                    <i class="gg-moon"></i>
                                </div>
                            </label>
                        </div>
                    </nav>
                </div>
                <!-- //toggle switch for light and dark theme -->
            </nav>

        </div>
    </header>
    <!--/header-->