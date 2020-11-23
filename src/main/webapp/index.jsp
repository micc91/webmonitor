<%@ page pageEncoding="UTF-8" isELIgnored ="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Michael Checler, adapted from Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">

        <title>Welcome</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="./styles/bootstrap.min.css" crossorigin="anonymous" type="text/css" >

        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="./styles/custom.css" crossorigin="anonymous" type="text/css" >
        <style>
                .themed-grid-col {
                        padding-top: 15px;
                        padding-bottom: 15px;
                        background-color: rgba(86, 61, 124, .15);
                        border: 1px solid rgba(86, 61, 124, .2);
                }
        </style>
</head>
<body>
<header>
        <%@ include file="/WEB-INF/views/static-menu.jsp" %>
</header>
<main role="main" class="container">
        <div class="jumbotron">
                <h1 class="display-4">Welcome to Web Ops</h1>
                <p class="lead">User interface on the monitoring features of Dollar Universe Scheduling Suite</p>
                <hr class="my-4">
                <p>Monitor your job runs, server engines and batch queues directly in your favourite web browser</p>
                <c:if test="${ empty sessionScope.uvmsConnection || sessionScope.uvmsConnection == 'disconnected'}">
                        <a class="btn btn-primary btn-lg" href="./login" role="button">Login to UVMS</a>
                </c:if>
        </div>
        <div class="py-4">
                <h2>Dollar Universe Web Services</h2>
                <div class="row mb-3">
                        <div class="col-md-4 themed-grid-col">Status</div>
                        <div class="col-md-8 themed-grid-col">${duwsStatus}</div>
                </div>
                <div class="row mb-3">
                        <div class="col-md-4 themed-grid-col">Version</div>
                        <div class="col-md-8 themed-grid-col">${duwsVersion}</div>
                </div>
                <c:if test="${ empty duwsStatus || duwsStatus != 'available'}">
                        <a class="btn btn-primary btn-lg" href="./index?check=true" role="button">Check</a>
                </c:if>
        </div>
</main>
<footer class="fixed-bottom bg-dark footer mt-auto py-3">
        <div class="container">
        <span class="text-muted">
            <p class="mt-5 mb-3 text-muted">Dollar Universe Web Ops 1.0 - 11/2020</p>
        </span>
        </div>
</footer>
</body>
<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="./scripts/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</html>

