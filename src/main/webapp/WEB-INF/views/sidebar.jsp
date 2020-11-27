<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 05/11/2020
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>

<!--<header>-->
<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
    <div class="sidebar-sticky pt-3">

        <form class="nav flex-column" action="./${currentPage}" method="post" >
            <h2>Context</h2>
            <c:set var="idx" value="0" />
            <c:forEach var="item" items="${nodesList}" varStatus="status">
                <c:choose>
                    <c:when test="${item.get('status') == 'CONNECTED'}"><c:set var="activation" value="" /></c:when>
                    <c:otherwise>
                        <c:set var="activation" value="disabled" />
                        <c:set var="classattr" value="text-secondary" />
                    </c:otherwise>
                </c:choose>
                <%-- handle selectedContext if not empty to check box for already selected nodes --%>
                <c:set var="current" value="${status.index}" />
                <c:set var="checkedattr" value="" />
                <c:set var="classattr" value="" />
                <c:if test="${sessionScope.selectedContext[idx] == current && activation != 'disabled'}">
                    <c:set var="checkedattr" value="checked" />
                    <c:set var="classattr" value="font-weight-bold"/>
                    <c:set var="idx" value="${idx + 1}" />
                </c:if>
                <div class="${selectedContextType} ${activation}">
                    <label for="${current}" class="nav-item ${activation} ${classattr}">
                        <input id="${current}" value="${current}" class="nav-item ${activation} ${classattr}" type="${selectedContextType}" name="selectedNodes" ${activation} ${checkedattr} >
                            ${item.get("company")}:${item.get("node")}:${item.get("area")}
                        </input>
                    </label>
                </div>
            </c:forEach>
            <button class="btn btn-sm btn-default btn-block btn-outline-secondary" id="btn-select-context" type="submit" onclick="animateLoading('btn-select-context')">Select</button>
            <p></p>
        </form>
    </div>
</nav>
