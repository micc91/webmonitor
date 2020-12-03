<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 02/12/2020
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:useBean id="nodesList" scope="request" type="java.util.List"/>
<%-- TODO: add useBean audit --%>
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

    <title>Update</title>

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
<c:set var="currentPage" value="rerun"/>
<%@ include file="menu.jsp" %>
<div class="container-fluid">
    <c:set var="selectedContextType" value="radio"/>

    <div class="row">
        <%@ include file="sidebar.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 ">
            <div class="jumbotron container-lg ">
                <h1>Update Launch</h1>
                <c:if test="${! empty numlanc}">
                    <div class="alert alert-success" role="alert">
                        Update successful ! (#Launch : ${numlanc})
                    </div>
                </c:if>
                <c:if test="${! empty returnCode && returnCode != '0'}">
                    <div class="alert alert-danger" role="alert">
                        Something went wrong!
                        <p>${lastResult} (${returnCode})</p>
                    </div>
                </c:if>
                <form class="form-signin" action="./update" method="post">
                    <div class="row mb-3">
                        <div class="col-md-8 themed-grid-col">
                            <h2>Identification</h2>
                            <div class="row mb-3">
                                <div class="col-md-4 themed-grid-col">
                                    <label for="inputTask">Task</label>
                                </div>
                                <div class="col-md-8 themed-grid-col">
                                    <c:set var="currentTask" value="${param.task}"/>
                                    <c:if test="${empty currentTask}"><c:set var="currentTask"
                                                                             value="${requestScope.jobInfo[0].task}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputTask"
                                           name="inputTask" value="${currentTask}" readonly/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-4 themed-grid-col">
                                    <label for="inputMu">Management Unit</label>
                                </div>
                                <div class="col-md-8 themed-grid-col">
                                    <c:set var="currentMu" value="${param.mu}"/>
                                    <c:if test="${empty currentMu}"><c:set var="currentMu"
                                                                           value="${requestScope.jobInfo[0].get('mu')}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputMu" name="inputMu"
                                           value="${currentMu}" readonly/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-4 themed-grid-col">
                                    <label for="inputSession">Session</label>
                                </div>
                                <div class="col-md-8 themed-grid-col">
                                    <c:set var="currentSession" value="${param.session}"/>
                                    <c:if test="${empty currentSession}"><c:set var="currentSession"
                                                                                value="${requestScope.jobInfo[0].get('session')}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputSession"
                                           name="inputSession" value="${currentSession}" readonly/>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-4 themed-grid-col">
                                    <label for="inputUproc">Uproc</label>
                                </div>
                                <div class="col-md-8 themed-grid-col">
                                    <c:set var="currentUproc" value="${param.uproc}"/>
                                    <c:if test="${empty currentUproc}"><c:set var="currentUproc"
                                                                              value="${requestScope.jobInfo[0].get('uproc')}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputUproc"
                                           name="inputUproc" value="${currentUproc}" readonly/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4 themed-grid-col">
                            <div class="pb-3">
                                <h3>Internal IDs</h3>
                            </div>
                            <div class="row ">
                                <div class="col-md-6 themed-grid-col font-weight-bold">Num Lanc</div>
                                <div class="col-md-6 themed-grid-col">
                                    <c:set var="currentNumlanc" value="${param.numlanc}"/>
                                    <c:if test="${empty currentNumlanc}"><c:set var="currentNumlanc" value="${requestScope.jobInfo[0].numlanc}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputNumlanc" name="inputNumlanc" value="${currentNumlanc}" readonly />
                                </div>
                                <div class="col-md-6 themed-grid-col font-weight-bold">Num Sess</div>
                                <div class="col-md-6 themed-grid-col">
                                    <c:set var="currentNumsess" value="${param.numsess}"/>
                                    <c:if test="${empty currentNumsess}"><c:set var="currentNumsess" value="${requestScope.jobInfo[0].numsess}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputNumsess" name="inputNumsess" value="${currentNumsess}" readonly />
                                </div>
                                <div class="col-md-6 themed-grid-col font-weight-bold">Num Proc</div>
                                <div class="col-md-6 themed-grid-col">
                                    <c:set var="currentNumproc" value="${param.numproc}"/>
                                    <c:if test="${empty currentNumproc}"><c:set var="currentNumproc" value="${requestScope.jobInfo[0].numproc}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputNumproc" name="inputNumproc" value="${currentNumproc}" readonly />
                                </div>
                                <div class="col-md-6 themed-grid-col font-weight-bold">Num Entry</div>
                                <div class="col-md-6 themed-grid-col">
                                    <c:set var="currentNumentry" value="${param.numentry}"/>
                                    <c:if test="${empty currentNumentry}"><c:set var="currentNumentry" value="${requestScope.jobInfo[0].numentry}"/></c:if>
                                    <input type="text" size="20" maxlength="64" class="form-control" id="inputNumentry" name="inputNumentry" value="${currentNumentry}" readonly />
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr class="my-4">
                    <h2>Context Information</h2>

                    <div class="row mb-3">
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputQueue">Batch Queue</label>
                            <c:set var="currentQueue" value="${param.queue}"/>
                            <c:if test="${empty currentQueue}"><c:set var="currentQueue"
                                                                      value="${requestScope.jobInfo[0].get('queue')}"/></c:if>
                            <input type="text" id="inputQueue" name="inputQueue" value="${param.queue}" size="20"
                                   maxlength="64" class="form-control" placeholder="Batch Queue name" required/>
                            <span class="error-msg">${errors['inputQueue']}</span>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputUser">Submission Account</label>
                            <c:set var="currentUser" value="${param.user}"/>
                            <c:if test="${empty currentUser}"><c:set var="currentUser"
                                                                     value="${requestScope.jobInfo[0].get('user')}"/></c:if>
                            <c:if test="${empty currentUser}"><c:set var="currentUser"
                                                                     value="${settings.submissionAccount}"/></c:if>
                            <input type="text" id="inputUser" name="inputUser" value="${currentUser}" size="20"
                                   maxlength="64" class="form-control" placeholder="User name" required/>
                            <span class="error-msg">${errors['inputUser']}</span>
                            <br>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputInfo">Information</label>
                            <c:set var="currentInfo" value="${param.info}"/>
                            <input type="text" id="inputInfo" name="inputInfo" value="${currentInfo}" size="20" maxlength="64"
                                   class="form-control" placeholder="Information"/>
                            <span class="error-msg">${errors['inputInfo']}</span>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputPriority">Priority</label>
                            <c:set var="currentPriority" value="${param.priority}"/>
                            <c:if test="${empty currentPriority}"><c:set var="currentPriority"
                                                                         value="${requestScope.jobInfo[0].get('priority')}"/></c:if>
                            <input type="text" id="inputPriority" name="inputPriority" value="${currentPriority}"
                                   size="20" maxlength="64" class="form-control" placeholder="[1-100]" required>
                            <span class="error-msg">${errors['inputPriority']}</span>
                            <br>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputStartD">Start Date</label>
                            <input type="text" id="inputStartD" name="inputStartD" value="" size="16" maxlength="16"
                                   class="form-control" placeholder="dd/mm/yyyy" required>
                            <span class="error-msg">${errors['inputStartD']}</span>
                            <br>
                            <label for="inputEndD">End Date</label>
                            <input type="text" id="inputEndD" name="inputEndD" value="" size="16" maxlength="16"
                                   class="form-control" placeholder="dd/mm/yyyy" required>
                            <span class="error-msg">${errors['inputEndD']}</span>
                            <br>
                            <label for="inputPdate">Processing Date</label>
                            <c:set var="currentPdate" value="${param.pdate}"/>
                            <c:if test="${empty currentPdate}"><c:set var="currentPdate"
                                                                      value="${requestScope.jobInfo[0].get('pdate')}"/></c:if>
                            <input type="text" id="inputPdate" name="inputPdate" value="${currentPdate}" size="10"
                                   maxlength="10" class="form-control" placeholder="dd/mm/yyyy" required>
                            <span class="error-msg">${errors['inputPdate']}</span>
                        </div>
                        <div class="col-md-6 themed-grid-col">
                            <label for="inputStartT">Start Time</label>
                            <input type="text" id="inputStartT" name="inputStartT" value="" size="16" maxlength="16"
                                   class="form-control" placeholder="HH:MM:SS" required>
                            <span class="error-msg">${errors['inputStartT']}</span>
                            <br>
                            <label for="inputEndT">End Time</label>
                            <input type="text" id="inputEndT" name="inputEndT" value="" size="16" maxlength="16"
                                   class="form-control" placeholder="HH:MM:SS" required>
                            <span class="error-msg">${errors['inputEndT']}</span>
                        </div>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn-update"
                            onclick="animateLoading('btn-update');">Update
                    </button>
                </form>
            </div>
        </main>
    </div>
</div>

<%@ include file="footer.jsp" %>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

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