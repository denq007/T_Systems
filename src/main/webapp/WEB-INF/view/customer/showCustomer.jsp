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

<%--<div class="container">
    <main>
        <div class="py-5 text-center">

            <h2>Personal Information</h2>
        </div>
       <form:form  modelAttribute="customer">
        <div class="row g-5">

            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">Your data:</h4>
                <form class="needs-validation" novalidate>
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">First name</label>
                            <form:input path="customerName" value="${customer.customerName}" class="form-control" id="firstName"/>
                          &lt;%&ndash;  <input type="text" class="form-control" id="firstName" placeholder="" value="" required>&ndash;%&gt;
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Last name</label>
                            <form:input path="customerSurname" value="${customer.customerSurname}" class="form-control" id="lastName"/>
                        &lt;%&ndash;    <input type="text" class="form-control" id="lastName" placeholder="" value="" required>&ndash;%&gt;
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="address" class="form-label">Address</label>
                            <form:input path="customerAdress" value="${customer.customerAdress}" class="form-control" id="address"/>
                           &lt;%&ndash; <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>&ndash;%&gt;
                            <div class="invalid-feedback">
                                Please enter your shipping address.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="passport" class="form-label">Passport <span class="text-muted"></span></label>
                            <form:input path="customerPassportDetails" value="${customer.customerPassportDetails}" class="form-control" id="passport"/>
                           &lt;%&ndash; <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">&ndash;%&gt;
                        </div>


                    <hr class="my-4">

                      &lt;%&ndash;  <form action="/customer/editcustomer" method="post">
                            <form:hidden path="customerID" value="${customer.customerID}"/>&ndash;%&gt;
                     &lt;%&ndash;   <form action="" method="get">
                            <input type="hidden" name="id" value=${customer.customerID}>&ndash;%&gt;
                        <form action="/customer/editcustomer" method="get">
                            <input type="hidden" name="customerID" value=${customer.customerID}>
                            <input type="submit" value="Edit info" class="btn btn-warning"></form>

                        <a class="me-3 py-2 text-dark text-decoration-none" name="customerID" value=${customer.customerID} href="/customer/editcustomer">Edit info</a>
                           &lt;%&ndash; <input type="submit" value="Edit info" class="btn btn-warning" href ="/customer/editcustomer"></form>&ndash;%&gt;
                      &lt;%&ndash;  </form>&ndash;%&gt;
            </div>
                    </form:form>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2021–2021</p>
        <ul class="list-inline">
&lt;%&ndash;            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>&ndash;%&gt;
        </ul>
    </footer>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="form-validation.js"></script>
</body>
</html>--%>
<div class="container">
    <span class="pull-right"><a href="clients" class="btn btn-info" role="button">Back to clients</a></span>
    <h3>Client details</h3>
    <table class="table table-striped">
        <thead>
        <th style="width:20%"></th>
        <th style="width:80%"></th>
        </thead>
        <tbody>
        <tr>
            <td >Id:</td>
            <td>${customer.id} </td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${customer.name} </td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td>${customer.surname} </td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td>${customer.birthDate} </td>
        </tr>

        <tr>
            <td>Address:</td>
            <td>${customer.address} </td>
        </tr>
        <tr>
            <td>Passport:</td>
            <td>${customer.passportDetails} </td>
        </tr>
        </tbody>
    </table>

    <form action="/customer/editcustomer" method="get">
        <input type="hidden" name="customerID" value=${customer.id}>
      <%--  <input type="hidden" name="userDTO.userId" value=${customer.userDTO.userId}>--%>
        <input type="submit" value="Edit info" class="btn btn-warning"></form>
    <h3>Client contracts</h3>
    <td></td>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Phone number</th>
            <th>Name of the tariff</th>
            <th>Blocked Number</th>
            <th>Blocked Number by Admin</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customer.contractIdList}" var="contract">
            <tr>
                <td>${contract.number} </td>
                <td>${contract.tariffId.name}</td>
                <td>${contract.blockedByUser}></td>
                <td>${contract.blockedByAdmin}></td>
                <td>
                    <form action="/contract/editcontract" method="get">
                        <input type="hidden" name="id" value=${contract.id} >
                        <input type="submit" value="Edit" class="btn btn-warning"></form>
                </td>
                <td>
                    <form action="showContract" method="get">
                        <input type="hidden" name="id" value=${contract.id} >
                        <input type="submit" value="Show details" class="btn btn-info"></form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form action="/contract/createcontract" method="get">
        <input type="hidden" name="customerID" value=${customer.id}>
        <input type="submit" value="Create contract" class="btn btn-warning" ></form>
    <br>

</div>
</body>
</html>