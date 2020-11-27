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
<body class="bg-welcome">
<header>
        <%@ include file="/WEB-INF/views/static-menu.jsp" %>
</header>
<main role="main" class="container">
        <div class="jumbotron slightly-transparent">
                <h1 class="display-4">Welcome to Web Ops</h1>
                <p class="lead">User interface on the monitoring features of Dollar Universe Workload Automation</p>
                <hr class="my-4">
                <p>Monitor your workflows directly in your favourite web browser</p>
                <c:choose>
                        <c:when test="${ empty sessionScope.uvmsConnection || sessionScope.uvmsConnection.token == 'disconnected'}">
                                <a class="btn btn-primary btn-lg" href="./login" role="button">Login to UVMS</a>
                        </c:when>
                        <c:otherwise>
                                <p class="font-weight-bold">You already have a valid token (${sessionScope.uvmsConnection.token})</p>
                        </c:otherwise>
                </c:choose>
        </div>
        <div class="card-deck mb-3 text-center slightly-transparent">
                <div class="card mb-4 shadow-sm slightly-transparent">
                        <div class="card-header">
                                <h4 class="my-0 font-weight-normal">Dollar Universe Web Services</h4>
                        </div>
                        <div class="card-body">
                                <div class="row mb-3">
                                        <div class="col-md-4 themed-grid-col">Status</div>
                                        <div class="col-md-8 themed-grid-col">${duwsStatus}</div>
                                </div>
                                <div class="row mb-3">
                                        <div class="col-md-4 themed-grid-col">Version</div>
                                        <div class="col-md-8 themed-grid-col">${duwsVersion}</div>
                                </div>
                                <c:choose>
                                        <c:when test="${ empty duwsStatus || duwsStatus != 'available'}">
                                                <a class="btn btn-primary btn-lg" href="./index?check=true" role="button" id="check-duws" onclick="animateLoading('check-duws');">Check</a>
                                        </c:when>
                                        <c:otherwise>
                                                <a class="btn btn-primary btn-lg" href="./index?check=true" role="button" id="check-duws-again" onclick="animateLoading('check-duws-again');">Check again</a>
                                        </c:otherwise>
                                </c:choose>
                        </div>
                </div>
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<script src="./scripts/custom.js"></script>

</html>

