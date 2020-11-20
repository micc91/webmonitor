<%@ page pageEncoding="UTF-8" isELIgnored ="false" %>
<jsp:useBean id="uvmsConnection" scope="request" type="com.webops.duas.UvmsConnection"/>
<jsp:useBean id="historyTrace" scope="request" type="java.util.List"/>
<jsp:useBean id="jobLog" scope="request" type="java.util.List"/>
<jsp:useBean id="resLog" scope="request" type="java.util.List"/>
<jsp:useBean id="jobInfo" scope="request" type="java.util.List" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Michael Checler, adapted from Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">

        <title>Information</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="./styles/bootstrap.min.css" crossorigin="anonymous" type="text/css" >

        <!-- Custom styles for this template -->
        <link href="./styles/signin.css" rel="stylesheet" type="text/css">
        <link href="./styles/custom.css" rel="stylesheet" type="text/css">
        <style>
            .themed-grid-col {
                padding-top: 15px;
                padding-bottom: 15px;
                background-color: rgba(86, 61, 124, .15);
                border: 1px solid rgba(86, 61, 124, .2);
            }

            .themed-container {
                padding: 15px;
                margin-bottom: 30px;
                background-color: rgba(0, 0, 0, 1);
                border: 1px solid rgba(123, 123, 123, .4);
            }
        </style>
    </head>
	<body>
        <header>
            <%@ include file="menu.jsp" %>
        </header>
        <main role="main">
            <div class="container">
    		<h1>Job Information</h1>
                <h2 class="mt-4">Location</h2>
                <div class="row mb-3">
                    <div class="col-4 themed-grid-col">${param.company}</div>
                    <div class="col-4 themed-grid-col">${param.node}</div>
                    <div class="col-4 themed-grid-col">${param.area}</div>
                </div>

                <h2 class="mt-4">General</h2>
                <%-- task, session, uproc, mu --%>
                <%-- numlanc, numproc, numsess --%>
                <div class="row mb-3">
                    <div class="col-md-8 themed-grid-col">
                        <div class="pb-3">
                            Identification
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Task</div>
                            <div class="col-md-6 themed-grid-col">${param.task}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Session</div>
                            <div class="col-md-6 themed-grid-col">${param.session}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Uproc</div>
                            <div class="col-md-6 themed-grid-col">${param.uproc}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">MU</div>
                            <div class="col-md-6 themed-grid-col">${param.mu}</div>
                        </div>
                    </div>
                    <div class="col-md-4 themed-grid-col">
                        <div class="pb-3">
                            Internal IDs
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Num Lanc</div>
                            <div class="col-md-6 themed-grid-col">${param.numlanc}</div>
                            <div class="col-md-6 themed-grid-col">Num Sess</div>
                            <div class="col-md-6 themed-grid-col">${param.numsess}</div>
                            <div class="col-md-6 themed-grid-col">Num Proc</div>
                            <div class="col-md-6 themed-grid-col">${param.numproc}</div>
                            <div class="col-md-6 themed-grid-col">Num Entry</div>
                            <div class="col-md-6 themed-grid-col">${numentry}</div>
                        </div>
                    </div>
                </div>
                <%-- status --%>
                <%--
                alert-primary: blue
                alert-secondary: gray
                alert-danger: red
                alert-warning: yellow
                --%>
                <c:choose>
                    <c:when test="${param.status == 'COMPLETED'}"><c:set var="style" value="alert-success" /></c:when>
                    <c:when test="${param.status == 'ABORTED'}"><c:set var="style" value="alert-danger" /></c:when>
                    <c:when test="${param.status == 'REFUSED'}"><c:set var="style" value="alert-danger" /></c:when>
                    <c:when test="${param.status == 'TIME_OVERRUN'}"><c:set var="style" value="alert-danger" /></c:when>
                    <c:when test="${param.status == 'PENDING'}"><c:set var="style" value="alert-primary" /></c:when>
                    <c:when test="${param.status == 'LAUNCH_WAIT'}"><c:set var="style" value="alert-success" /></c:when>
                    <c:when test="${param.status == 'EVENT_WAIT'}"><c:set var="style" value="alert-warning" /></c:when>
                    <c:when test="${param.status == 'WATCHING'}"><c:set var="style" value="alert-primary" /></c:when>
                    <c:when test="${param.status == 'DISABLED'}"><c:set var="style" value="alert-secondary" /></c:when>
                </c:choose>
                <div class="alert ${style} text-center">
                    ${param.status}
                </div>
                <hr class="my-4">
                <h2 class="mt-4">Context Info</h2>
                <%-- queue, priority, account, information, step --%>
                <div class="row mb-3">
                    <div class="col-md-8 themed-grid-col">
                        <div class="pb-3">
                            Technical Data
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Batch Queue</div>
                            <div class="col-md-6 themed-grid-col">${param.queue}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Priority</div>
                            <div class="col-md-6 themed-grid-col">${param.priority}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Step</div>
                            <div class="col-md-6 themed-grid-col">${param.step}</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Information</div>
                            <div class="col-md-6 themed-grid-col">${param.information}</div>
                        </div>
                    </div>
                    <%-- begin, end, processing date --%>
                    <div class="col-md-4 themed-grid-col">
                        <div class="pb-3">
                            Dates and times
                        </div>
                        <div class="row">
                            <div class="col-md-6 themed-grid-col">Begin date/time</div>
                            <div class="col-md-6 themed-grid-col">${param.begin}</div>
                            <div class="col-md-6 themed-grid-col">End date/time</div>
                            <div class="col-md-6 themed-grid-col">${param.end}</div>
                            <div class="col-md-6 themed-grid-col">Processing date</div>
                            <div class="col-md-6 themed-grid-col">${param.pdate}</div>
                        </div>
                    </div>
                </div>
                <hr class="my-4">
                <h2 class="mt-4">Variables</h2>
                <div class="row mb-3">
                    <div class="col-md-3 themed-grid-col">Name</div>
                    <div class="col-md-3 themed-grid-col">Type</div>
                    <div class="col-md-3 themed-grid-col">Value</div>
                    <div class="col-md-3 themed-grid-col">Origin</div>
                    <c:forEach var="idx" begin="${varbegin}" end="${varend - 1}" step="1">
                        <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('varname')}</div>
                        <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('vartype')}</div>
                        <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('varvalue')}</div>
                        <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('varorigin')}</div>
                    </c:forEach>
                </div>
                <hr class="my-4">
                <h2 class="mt-4">History Trace</h2>
                <%-- --%>
                <div class="container-xl themed-container">
                    <code>
                        <c:forEach var="line" items="${historyTrace}" varStatus="status">
                            <span id="htrace-${status.index}" >${status.index} ${line}<br></span>
                        </c:forEach>
                    </code>
                </div>
                <hr class="my-4">
                <h2 class="mt-4">Job Log</h2>
                <div class="container-xl themed-container">
                    <code>
                        <c:forEach var="line" items="${jobLog}" varStatus="status">
                            <span  id="joblog-${status.index}" >${status.index} ${line}<br></span>
                        </c:forEach>
                    </code>
                </div>
                <hr class="my-4">
                <h2 class="mt-4">Resource Log</h2>
                <div class="container-xl themed-container">
                    <code>
                        <c:forEach var="line" items="${resLog}" varStatus="status">
                            <span  id="reslog-${status.index}" >${status.index} ${line}<br></span>
                        </c:forEach>
                    </code>
                </div>
                <%-- --%>
            </div>
        </main>
        <%@ include file="footer.jsp" %>
    </body>
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="./scripts/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="./scripts/custom.js"></script>
</html>