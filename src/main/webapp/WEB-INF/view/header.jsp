<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: dennn
  Date: 07.05.2021
  Time: 15:09
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="divsec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Pricing example · Bootstrap v5.0</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/pricing/">

    <!-- Bootstrap core CSS -->
    &lt;%&ndash; <link href="<c:url value="../static/css/bootstrap.min.css"/>" rel="stylesheet">&ndash;%&gt;

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="<c:url value="../static/css/pricing.css"/>" rel="stylesheet">
</head>
<body>

<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check" viewBox="0 0 16 16">
        <title>Check</title>
        <path d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z"/>
    </symbol>
</svg>

<div class="container py-3">
    <header class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
        <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">


            <sec:authorize access="isAuthenticated()">
                <form action="/mylogout">

                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="logout">

                </form>
            </sec:authorize>

            &lt;%&ndash;<form action="/mylogout">
                <a class="me-3 py-2 text-dark text-decoration-none" href="/">Sign-out</a>
            </form>&ndash;%&gt;



           &lt;%&ndash;<a href="<c:url value="/logout" />">Logout</a>&ndash;%&gt;
        </nav>
    </header>


    </main>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>
--%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header class="navbar">
    <div class="nav-right">

        <sec:authorize access="isAuthenticated()" method="GET">
            <div class="login_container logout_container">
                <a href="<%--${pageContext.request.contextPath}--%>/logout <%--?${_csrf.parameterName}=${_csrf.token}--%>">Logout</a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </sec:authorize>

    </div>
</header>