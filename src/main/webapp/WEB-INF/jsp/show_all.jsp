<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Emloyee List</title>
</head>
<body>
<h1>Employee List</h1>

<br/><br/>
<div>
    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Department Id</th>
            <th>Job Title</th>
            <th>Date of birth</th>
            <th>Gender</th>
        </tr>
        <c:forEach  items="${}" var ="person">
            <tr>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>