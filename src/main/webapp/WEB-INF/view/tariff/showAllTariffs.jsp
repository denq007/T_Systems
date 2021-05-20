<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<span class="pull-right"><a href="/" class="btn btn-info" role="button">Back</a></span>
<h2>All Tarifs</h2>
<br>
<c:if test="${not empty message}">
    <div id="error">${message}</div>
</c:if>
<table>
    <tr>
        <th>Id</th>
        <th>Tariff name</th>
        <th>Price</th>
        <th>Enabled</th>
        <th>Options</th>
    </tr>
    <c:forEach var="allTarifs" items="${allTarifs}">
    <tr>
        <td>${allTarifs.id}</td>
        <td>${allTarifs.name}</td>
        <td>${allTarifs.price}</td>
        <td>${allTarifs.old}</td>
   <%--     <td>
            <c:forEach var="option" items="${allTarifs.optionName}">
        <td>${option}</td>
        </c:forEach>
        </td>--%>
        <td>
            <form action="/employee/delete-tariff" method="get">
                <input hidden name="name" value=${allTarifs.name}>
                <button class="w-100 btn btn-primary btn-lg" type="submit">Delete</button>
            </form>
        </td>
        <td>
            <form action="/employee/edit-tariff" method="get">
                <input hidden name="name" value=${allTarifs.name}>
                <button class="w-100 btn btn-primary btn-lg" type="submit">Edit tariff</button>
            </form>
        </td>
        </c:forEach>
    </tr>

</table>

</body>

</html>
