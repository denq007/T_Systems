<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: dennn
  Date: 05.05.2021
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Checkout example · Bootstrap v5.0</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/checkout/">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/css/bootstrap-select.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.2/js/bootstrap-select.min.js"></script>

    <script src="<c:url value="/WEB-INF/static/js/jquery.bootstrap-duallistbox.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/WEB-INF/static/css/bootstrap-duallistbox.css"/>">


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
    <link href="form-validation.css" rel="stylesheet">
    <jsp:include page="../header.jsp" />
</head>
<body class="bg-light">

<div class="container">
    <main>
        <div class="py-5 text-center">

            <h2>Your Contract</h2>
        </div>
        <%-- <c:if test="${not empty message}"><p class="bg-danger">${message}</p></c:if>--%>
        <c:if test="${not empty message}">
            <div id="error">${message}</div>
        </c:if>
        <form:form  modelAttribute="tariff" method="post" >
            <div class="row g-5">

                <div class="col-md-7 col-lg-8">
                    <h4 class="mb-3">Contract:</h4>
                    <form class="needs-validation" novalidate>
                        <div class="row g-3">

                            <div class="col-sm-6">
                                <label for="Name" class="form-label">Tariff name</label>
                                <form:input path="name" value="${tariff.name}" class="form-control" id="Name"/>
                                    <%--    <input type="text" class="form-control" id="lastName" placeholder="" value="" required>--%>

                            </div>

                            <div class="col-12">
                                <label for="price" class="form-label">Price<span class="text-muted"></span></label>
                                <form:input path="price" value="${tariff.price}" class="form-control" id="price"/>
                            </div>

                         <div class="form-group">
                                <label for="opt">Set options:</label>
                                <form:select path="tariffOption" multiple="multiple" id="opt">
                                    <c:forEach items="${tariff.allOptions}" var="item">
                                        <form:option label="${item.key}" value="${item.value}"/>
                                    </c:forEach>
                                </form:select>
                            </div>

                </div>
                <form:hidden path="id" value="${tariff.id}"/>
                <hr class="my-4">
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button class="w-100 btn btn-primary btn-lg" type="submit"  >Save</button>
            </div>
        </form:form>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2021–2021</p>
        <ul class="list-inline">
        </ul>
    </footer>
</div>

<script>
    $("#opt").bootstrapDualListbox();
</script>
</body>
</html>
