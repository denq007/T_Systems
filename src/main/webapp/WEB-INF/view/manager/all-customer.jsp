<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Customer</h2>
<br>

<table>
    <tr>
        <th>Name</th>  <!--th заголовки -->
        <th>Surname</th>
        <th>BirthDate</th>
        <th>Passport</th>
        <th>Address</th>

    </tr>
    <c:forEach var="customer" items="${allCustomer}">
        <tr>
            <td>${customer.customerName}</td>
            <td>${customer.customerSurname}</td>
            <td>${customer.customerBirthDate}</td>
            <td>${customer.customerPassportDetails}</td>
            <td>${customer.customerAdress}</td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
