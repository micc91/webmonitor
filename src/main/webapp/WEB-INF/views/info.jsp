<%@ page pageEncoding="UTF-8" isELIgnored ="false" %>
<jsp:useBean id="uvmsConnection" scope="request" type="com.example.duas.UvmsConnection"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <link href="./styles/signin.css" rel="stylesheet" type="text/css">
        <link href="./styles/custom.css" rel="stylesheet" type="text/css">
    </head>
	<body>
        <header>
            <%@ include file="menu.jsp" %>
        </header>
        <main role="main" class="container-fluid text-center bg2">
    		<h1>Welcome on board !</h1>
        </main>
        <%@ include file="footer.jsp" %>
    </body>
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="./scripts/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</html>