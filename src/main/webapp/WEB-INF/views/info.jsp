<%@ page pageEncoding="UTF-8" isELIgnored ="false" %>
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

        <title>Job Information</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>" crossorigin="anonymous" type="text/css" >

        <!-- Custom styles for this template -->
        <link href="<c:url value='/styles/signin.css'/>" rel="stylesheet" type="text/css">
        <link href="<c:url value='/styles/custom.css'/>" rel="stylesheet" type="text/css">
    </head>
	<body>
        <header>
            <c:set var="currentPage" value="info"/>
            <%@ include file="menu.jsp" %>
        </header>
        <main role="main">
            <div class="container px-lg-5">
    		<h1>Job Information</h1>
                <c:if test="${! empty returnCode && returnCode != '0'}">
                    <div class="alert alert-danger" role="alert">
                        Something went wrong!
                        <p>${lastresult} (${returnCode})</p>
                    </div>
                </c:if>

                <%-- START ACCORDION --%>
                <div class="accordion" id="accordionJobInfo">
                    <div class="card">
                        <div class="card-header" id="headingOne">
                            <h2 class="mb-0">
                                <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Location</button>
                            </h2>
                        </div>
                        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionJobInfo">
                            <div class="card-body">
                                <div class="row mb-3 justify-content-center">
                                    <div class="col-4 themed-grid-col px-lg-5">${param.company}</div>
                                    <div class="col-4 themed-grid-col px-lg-5">${param.node}</div>
                                    <div class="col-4 themed-grid-col px-lg-5">${param.area}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">General</button>
                        </h2>
                    </div>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionJobInfo">
                        <div class="card-body">
                            <%-- task, session, uproc, mu --%>
                            <%-- numlanc, numproc, numsess --%>
                            <div class="row mb-3 justify-content-center">
                                <div class="col-md-8 themed-grid-col">
                                    <div class="pb-3">
                                        <h3>Identification</h3>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Task</div>
                                        <div class="col-md-6 themed-grid-col">${param.task}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Session</div>
                                        <div class="col-md-6 themed-grid-col">${param.session}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Uproc</div>
                                        <div class="col-md-6 themed-grid-col">${param.uproc}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">MU</div>
                                        <div class="col-md-6 themed-grid-col">${param.mu}</div>
                                    </div>
                                </div>
                                <div class="col-md-4 themed-grid-col">
                                    <div class="pb-3">
                                        <h3>Internal IDs</h3>
                                    </div>
                                    <div class="row ">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Num Lanc</div>
                                        <div class="col-md-6 themed-grid-col">${param.numlanc}</div>
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Num Sess</div>
                                        <div class="col-md-6 themed-grid-col">${param.numsess}</div>
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Num Proc</div>
                                        <div class="col-md-6 themed-grid-col">${param.numproc}</div>
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Num Entry</div>
                                        <div class="col-md-6 themed-grid-col">${param.numentry}</div>
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
                        </div>
                    </div>
                </div>

<%--                <hr class="my-4">--%>
                <div class="card">
                    <div class="card-header" id="headingThree">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">Context Info
                            </button>
                        </h2>
                    </div>
                    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionJobInfo">
                        <div class="card-body">

                            <%-- queue, priority, account, information, step --%>
                            <div class="row mb-3 justify-content-center">
                                <div class="col-md-8 themed-grid-col">
                                    <div class="pb-3">
                                        <h3>Technical Data</h3>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Batch Queue</div>
                                        <div class="col-md-6 themed-grid-col">${param.queue}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Submission Account</div>
                                        <div class="col-md-6 themed-grid-col">${param.user}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Priority</div>
                                        <div class="col-md-6 themed-grid-col">${param.priority}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Step</div>
                                        <div class="col-md-6 themed-grid-col">${param.step}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Information</div>
                                        <div class="col-md-6 themed-grid-col">${param.information}</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Severity</div>
                                        <div class="col-md-6 themed-grid-col">${param.severity}</div>
                                    </div>
                                </div>
                                <%-- begin, end, processing date --%>
                                <div class="col-md-4 themed-grid-col">
                                    <div class="pb-3">
                                        <h3>Dates and times</h3>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Begin date/time</div>
                                        <div class="col-md-6 themed-grid-col">${param.begin}</div>
                                        <div class="col-md-6 themed-grid-col font-weight-bold">End date/time</div>
                                        <div class="col-md-6 themed-grid-col">${param.end}</div>
                                        <div class="col-md-6 themed-grid-col font-weight-bold">Processing date</div>
                                        <div class="col-md-6 themed-grid-col">${param.pdate}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header" id="headingFour">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">Variables</button>
                        </h2>
                    </div>
                    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionJobInfo">
                        <div class="card-body">
                            <div class="row mb-3 justify-content-center">
                            <div class="col-md-3 themed-grid-col font-weight-bold">Name</div>
                            <div class="col-md-3 themed-grid-col font-weight-bold">Type</div>
                            <div class="col-md-3 themed-grid-col font-weight-bold">Value</div>
                            <div class="col-md-3 themed-grid-col font-weight-bold">Origin</div>
                            <c:forEach var="idx" begin="${varbegin}" end="${varend - 1}" step="1">
                                <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('varname')}</div>
                                <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('vartype')}</div>
                                <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('varvalue')}</div>
                                <div class="col-md-3 themed-grid-col">${jobInfo[idx].get('varorigin')}</div>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header" id="headingFive">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">History Trace</button>
                        </h2>
                    </div>
                    <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionJobInfo">
                        <div class="card-body">
                            <%-- --%>
                            <div class="container-xl themed-container">
                                <code>
                                    <c:forEach var="line" items="${historyTrace}" varStatus="status">
                                        <span id="htrace-${status.index}" >${status.index} ${line}<br></span>
                                    </c:forEach>
                                </code>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header" id="headingSix">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">Job Log</button>
                        </h2>
                    </div>
                    <div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordionJobInfo">
                        <div class="card-body">
                            <div class="container-xl themed-container">
                                <code>
                                    <c:forEach var="line" items="${jobLog}" varStatus="status">
                                        <span  id="joblog-${status.index}" >${status.index} ${line}<br></span>
                                    </c:forEach>
                                </code>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header" id="headingSeven">
                        <h2 class="mb-0">
                            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">Resource Log</button>
                        </h2>
                    </div>
                    <div id="collapseSeven" class="collapse" aria-labelledby="headingSeven" data-parent="#accordionJobInfo">
                        <div class="card-body">
                            <div class="container-xl themed-container">
                                <code>
                                    <c:forEach var="line" items="${resLog}" varStatus="status">
                                        <span  id="reslog-${status.index}" >${status.index} ${line}<br></span>
                                    </c:forEach>
                                </code>
                            </div>
                        </div>
                    </div>
                </div>
                <%-- --%>
            </div>
        </main>
        <%@ include file="footer.jsp" %>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <script src="<c:url value='/scripts/custom.js'/>"></script>
    <script>$('.collapse').collapse()</script>
</html>