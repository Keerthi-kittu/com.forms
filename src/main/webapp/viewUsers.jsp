<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>



<%@ taglib uri="jakarta.tags.core" prefix="c" %>





<html>

<head>

<title>Registered Users</title>

<style>
table {

    width: 100%;

    border-collapse: collapse;

}

th, td {

    border: 1px solid black;

    padding: 8px;

    text-align: center;

}

th {

    background-color: #ddd;

}
</style>

</head>

<body>



<h2 align="center">Registered Users</h2>



<table>

    <tr>

        <th>Name</th>

        <th>Email</th>

        <th>Gender</th>

        <th>Phone</th>

        <th>Village</th>
        <th>Mandal</th>

        <th>District</th>

        <th>State</th>

        <th>Degree</th>

        <th>College</th>

        <th>Year Of Pass</th>

    </tr>


<c:out value="jstl working"/>
    <c:forEach var="u" items="${users}">

        <tr>

            <td>${u.personalInfo.name}</td>

            <td>${u.personalInfo.email}</td>

            <td>${u.personalInfo.gender}</td>
            <td>${u.personalInfo.pnumber}</td>



            <td>${u.addressInfo.village}</td>

            <td>${u.addressInfo.mandal}</td>

            <td>${u.addressInfo.district}</td>

            <td>${u.addressInfo.state}</td>



            <td>${u.educationInfo.degree}</td>

            <td>${u.educationInfo.college}</td>

            <td>${u.educationInfo.yearofpass}</td>

        </tr>
        </c:forEach>

</table>



</body>

</html>