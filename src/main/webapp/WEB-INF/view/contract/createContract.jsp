<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

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

        <form:form  modelAttribute="contract" method="post">
        <div class="row g-5">

            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Contract:</h4>
                <form class="needs-validation" novalidate>
                    <div class="row g-3">

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Id Custumer</label>
                            <form:input path="customerId" value="${contract.customerId}" class="form-control" id="lastName"/>
                                <%--    <input type="text" class="form-control" id="lastName" placeholder="" value="" required>--%>
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>

                       <%-- <div class="col-12">
                            <label for="address" class="form-label">Blocked by Admin</label>
                            <form:input path="blockedByAdmin" value="${contract.blockedByAdmin}" class="form-control" id="address"/>
                                &lt;%&ndash; <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>&ndash;%&gt;
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="passport" class="form-label">User blocked <span class="text-muted"></span></label>
                            <form:input path="blockedByCustomer" value="${contract.blockedByCustomer}" class="form-control" id="passport"/>
                                &lt;%&ndash; <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">&ndash;%&gt;
                        </div>--%>

                        <div class="col-12">

                            <label for="passport" class="form-label" >Tariff <span class="text-muted"></span></label>

                                <form:select path="tariffId" id="tr" class="selectpicker"
                                             data-live-search="true" data-size="5" data-actions-box="true" data-width="75%">
                                    <c:forEach items="${contract.allTariffs}" var="item">
                                        <form:option label="${item.key}" value="${item.value}"/>
                                    </c:forEach>
                                </form:select>
                            </div>

                                <%-- <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">--%>
                        </div>

                        <div class="col-12">
                            <label for="passport" class="form-label" >Tariff <span class="text-muted"></span></label>
                            <form:input path="number" value="${contract.number}" class="form-control" id="passport" placeholder="Choose a tariff"/>
                                <%-- <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">--%>
                        </div>

                        <form:hidden path="id" value="${contract.id}"/>
                            <%--  <form:hidden path="userDTO" value="${customer.userDTO.userId}"/>--%>

                        <hr class="my-4">
                            <%-- <c:url var="updateButton"  value="/customer/editcustomer">
                              <c:param name="customerID" value="${customer.customerID}"/>
                             </c:url>--%>
                        <button class="w-100 btn btn-primary btn-lg" type="submit" href="/contract/editcontract"<%--'${updateButton}'--%> >Save</button>
                        <button class="w-100 btn btn-primary btn-lg" type="submit" href="/tariff/choose"<%--'${updateButton}'--%> >Choose a tariff</button>
                    </div>
                    </form:form>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2021–2021</p>
        <ul class="list-inline">
            <%--            <li class="list-inline-item"><a href="#">Privacy</a></li>
                        <li class="list-inline-item"><a href="#">Terms</a></li>
                        <li class="list-inline-item"><a href="#">Support</a></li>--%>
        </ul>
    </footer>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="form-validation.js"></script>
</body>
</html>
