<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 24/11/2020
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:useBean id="nodesList" scope="request" type="java.util.List"/>
<jsp:useBean id="taskList" scope="request" type="java.util.List"/>
<jsp:useBean id="sessionList" scope="request" type="java.util.List"/>
<jsp:useBean id="uprocList" scope="request" type="java.util.List"/>
<jsp:useBean id="muList" scope="request" type="java.util.List"/>
<%-- TODO: add useBean audit --%>
<jsp:useBean id="settings" scope="session" type="java.util.Map"/>
<jsp:useBean id="selectedContext" scope="session" type="java.util.List"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Michael Checler, adapted from Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">

    <title>New Run</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>" crossorigin="anonymous" type="text/css">

    <!-- Custom styles for this template -->
    <!--    <link href="./styles/signin.css" rel="stylesheet" type="text/css">
    -->
    <link href="<c:url value='/styles/custom.css'/>" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="<c:url value='/styles/dashboard.css'/>" rel="stylesheet">
</head>
<body onload="updateDatesInNewRunForm(${sessionScope.settings.launchWindowSize});" class="bg-other">
<c:set var="currentPage" value="new"/>
<%@ include file="menu.jsp" %>
<div class="container-fluid">
    <c:set var="selectedContextType" value="radio" />

    <div class="row">
        <%@ include file="sidebar.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 ">
            <div class="jumbotron container-lg ">
            <h1>New Run</h1>
            <c:if test="${! empty numlanc}">
                <div class="alert alert-success" role="alert">
                    Launch successful ! (#Launch : ${numlanc})
                </div>
            </c:if>
            <c:if test="${! empty returnCode && returnCode != '0'}">
                <div class="alert alert-danger" role="alert">
                    Something went wrong!
                    <p>${lastResult} (${returnCode})</p>
                </div>
            </c:if>
                <form class="form-signin" action="./new" method="post" >
                    <h2>General</h2>
                    <div class="row mb-3">
                        <div class="col-md-4 themed-grid-col">
                            <label for="inputTask" >Task</label>
                        </div>
                        <div class="col-md-8 themed-grid-col">
                            <select class="btn btn-outline-secondary dropdown-toggle" id="inputTask" name="inputTask" placeholder="Task name" onchange="updateNewRunForm('inputTask')">
                                <option value="none"></option>
                                <c:forEach var="item" items="${taskList}" varStatus="status">
                                    <option value="${item.get('task')}|${item.get('session')}|${item.get('uproc')}|${item.get('mu')}|${item.get('queue')}|${item.get('user')}">${item.get('task')}</option>
                                </c:forEach>
                            </select>
                            <span class="error-msg">${errors['inputTask']}</span>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-4 themed-grid-col">
                            <label for="inputMu" >Management Unit</label>
                        </div>
                        <div class="col-md-8 themed-grid-col">
                            <select class="btn btn-outline-secondary dropdown-toggle" id="inputMu" name="inputMu" placeholder="Management Unit" onchange="updateNewRunForm('inputMu')">
                                <c:forEach var="item" items="${muList}" varStatus="status">
                                    <option value="${item.get('mu')}">${item.get('mu')}</option>
                                </c:forEach>
                            </select>
                            <span class="error-msg">${errors['inputMu']}</span>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-4 themed-grid-col">
                            <label for="inputSession" >Session</label>
                        </div>
                        <div class="col-md-8 themed-grid-col">
                            <select class="btn btn-outline-secondary dropdown-toggle" id="inputSession" name="inputSession" placeholder="Session name" onchange="updateNewRunForm('inputSession')">
                                <option value="none"></option>
                                <c:forEach var="item" items="${sessionList}" varStatus="status">
                                    <option value="${item.get('session')}|${item.get('uproc')}">${item.get('session')}</option>
                                </c:forEach>
                            </select>
                            <span class="error-msg">${errors['inputSession']}</span>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-4 themed-grid-col">
                            <label for="inputUproc" >Uproc</label>
                        </div>
                        <div class="col-md-8 themed-grid-col">
                            <select class="btn btn-outline-secondary dropdown-toggle" id="inputUproc" name="inputUproc" placeholder="Uproc name" onchange="updateNewRunForm('inputUproc')">
                                <option value="none"></option>
                                <c:forEach var="item" items="${uprocList}" varStatus="status">
                                    <option value="${item.get('uproc')}">${item.get('uproc')}</option>
                                </c:forEach>
                            </select>
                            <span class="error-msg">${errors['inputUproc']}</span>
                        </div>
                    </div>
                    <hr class="my-4">
                    <h2>Context Information</h2>

                    <div class="row mb-3" >
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputQueue" >Batch Queue</label>
                            <input type="text" id="inputQueue" name="inputQueue" value="${sessionScope.settings.batchQueue}" size="20" maxlength="64" class="form-control" placeholder="Batch Queue name" required>
                            <span class="error-msg">${errors['inputQueue']}</span>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputUser" >Submission Account</label>
                            <input type="text" id="inputUser" name="inputUser" value="${sessionScope.settings.submissionAccount}" size="20" maxlength="64" class="form-control" placeholder="User name" required>
                            <span class="error-msg">${errors['inputUser']}</span>
                            <br>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputInfo" >Information</label>
                            <input type="text" id="inputInfo" name="inputInfo" value="" size="20" maxlength="64" class="form-control" placeholder="Information" >
                            <span class="error-msg">${errors['inputInfo']}</span>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputPriority" >Priority</label>
                            <input type="text" id="inputPriority" name="inputPriority" value="100" size="20" maxlength="64" class="form-control" placeholder="[1-100]" required>
                            <span class="error-msg">${errors['inputPriority']}</span>
                            <br>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputStartD" >Start Date</label>
                            <input type="text" id="inputStartD" name="inputStartD" value="" size="16" maxlength="16" class="form-control" placeholder="dd/mm/yyyy" required>
                            <span class="error-msg">${errors['inputStartD']}</span>
                            <br>
                            <label for="inputEndD" >End Date</label>
                            <input type="text" id="inputEndD" name="inputEndD" value="" size="16" maxlength="16" class="form-control" placeholder="dd/mm/yyyy" required>
                            <span class="error-msg">${errors['inputEndD']}</span>
                            <br>
                            <label for="inputPdate" >Processing Date</label>
                            <input type="text" id="inputPdate" name="inputPdate" value="" size="10" maxlength="10" class="form-control" placeholder="dd/mm/yyyy" required>
                            <span class="error-msg">${errors['inputPdate']}</span>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputStartT" >Start Time</label>
                            <input type="text" id="inputStartT" name="inputStartT" value="" size="16" maxlength="16" class="form-control" placeholder="HH:MM:SS" required>
                            <span class="error-msg">${errors['inputStartT']}</span>
                            <br>
                            <label for="inputEndT" >End Time</label>
                            <input type="text" id="inputEndT" name="inputEndT" value="" size="16" maxlength="16" class="form-control" placeholder="HH:MM:SS" required>
                            <span class="error-msg">${errors['inputEndT']}</span>
                        </div>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn-new-run" onclick="animateLoading('btn-new-run');" >Run</button>
                </form>
            </div>
        </main>
    </div>
</div>

    <%@ include file="footer.jsp" %>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/feather-icons/dist/feather.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
    <script src="<c:url value='/scripts/custom.js'/>"></script>
    <script src="<c:url value='/scripts/dashboard.js'/>"></script>

<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip({'placement': 'top'});
    })
</script>
</body>
</html>

