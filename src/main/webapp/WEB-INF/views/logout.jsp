<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 06/11/2020
  Time: 10:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored ="false" %>
<jsp:useBean id="uvmsConnection" scope="request" type="com.webops.duas.UvmsConnection"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Michael Checler, adapted from Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">

    <title>Main page</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./styles/bootstrap.min.css" crossorigin="anonymous" type="text/css" >

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="./styles/custom.css" crossorigin="anonymous" type="text/css" >
    <link href="./styles/signin.css" rel="stylesheet" type="text/css">

</head>
<body>
<header>
    <%@ include file="/WEB-INF/views/menu.jsp" %>
</header>
<main role="main" class="container-fluid text-center">
    <c:choose>
        <c:when test="${ sessionScope.uvmsConnection.token == 'disconnected'}">
            <h1>You have been successfully logged out</h1>
        </c:when>
        <c:otherwise>
            <h1 style="color: red">You are still connected.</h1>
            <form class="form-signin" action="./logout" method="post" >
                <h1 class="h3 mb-3 font-weight-normal">Confirm logout ?</h1>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Log Out</button>
            </form>
        </c:otherwise>
    </c:choose>

</main>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="./scripts/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</html>