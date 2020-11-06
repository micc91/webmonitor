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

        <title>Main page</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="./styles/bootstrap.min.css" crossorigin="anonymous" type="text/css" >

        <!-- Custom styles for this template -->
        <style>
                html,
                body {
                        height: 100%;
                }
                .bd-placeholder-img {
                        font-size: 1.125rem;
                        text-anchor: middle;
                        -webkit-uvmsConnection-select: none;
                        -moz-uvmsConnection-select: none;
                        -ms-uvmsConnection-select: none;
                        uvmsConnection-select: none;
                }

                @media (min-width: 768px) {
                        .bd-placeholder-img-lg {
                                font-size: 3.5rem;
                        }
                }
                body {
                        display: -ms-flexbox;
                        display: flex;
                        -ms-flex-align: center;
                        align-items: center;
                        padding-top: 10px;
                        padding-bottom: 10px;
                        background-color: #f5f5f5;
                }
                .bg {
                        background-image: url("./media/nuages.jpg");
                        height: 90%;
                        background-position: center;
                        background-repeat: no-repeat;
                        background-size: cover;
                }
                .bg2 {
                        background-image: url("./media/Vue_du_mont_ventoux.jpg");
                        height: 90%;
                        background-position: center;
                        background-repeat: no-repeat;
                        background-size: cover;
                }
                .bg3 {
                        background-image: url("./media/Massif_Mont_Blanc.jpg");
                        height: 90%;
                        background-position: center;
                        background-repeat: no-repeat;
                        background-size: cover;
                }

        </style>
</head>
<body>
<header>
        <%@ include file="/WEB-INF/views/menu.jsp" %>
</header>
<main role="main" class="container-fluid text-center bg3">
        <h2>Hello World!</h2>
</main>
<footer class="fixed-bottom bg-dark footer mt-auto py-3">
        <div class="container">
                <span class="text-muted">Place sticky footer content here.</span>
        </div>
</footer>
</body>
<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="./scripts/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</html>

