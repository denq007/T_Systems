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
        <th>Email</th>
        <th>CustomerPassword</th>
        <th>Enabled</th>
    </tr>
    <c:forEach var="customer" items="${allCustomer}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.birthDate}</td>
            <td>${customer.passportDetails}</td>
            <td>${customer.address}</td>
            <td>${customer.email}</td>
            <td>${customer.password}</td>
            <td>${customer.check}</td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
