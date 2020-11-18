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

</head>
<body>
<header>
        <%@ include file="/WEB-INF/views/static-menu.jsp" %>
</header>
<main role="main" class="container-fluid text-center bg-welcome" style="padding-top: 60px;">
        <h1>Please log in to Management Server to start</h1>
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

