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
<body class="bg-logout">
<header>
    <%@ include file="/WEB-INF/views/menu.jsp" %>
</header>
<main role="main" class="container-fluid text-center">
    <div class="jumbotron semi-transparent">

    <c:choose>
        <c:when test="${ sessionScope.uvmsConnection.token == 'disconnected'}">
            <h1 class="display-4">You have been successfully logged out</h1>
        </c:when>
        <c:otherwise>
            <h1 class="display-4" style="color: red">You are still connected.</h1>
            <hr class="my-4">
            <form class="form-signin" action="./logout" method="post" >
                <h1 class="h3 mb-3 font-weight-normal">Confirm logout ?</h1>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Log Out</button>
            </form>
        </c:otherwise>
    </c:choose>
    </div>
</main>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>