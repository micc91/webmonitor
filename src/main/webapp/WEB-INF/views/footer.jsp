<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 05/11/2020
  Time: 23:53
--%>
<footer class="fixed-bottom bg-dark footer mt-auto py-3">
    <div class="container">
        <span class="text-muted">
            <c:if test="${ !empty sessionScope.uvmsConnection.login }"><c:out value="Connection string:${uvmsConnection.login}:####@${uvmsConnection.uvmsHost}:${uvmsConnection.uvmsPort} => ${uvmsConnection.token}" /></c:if>
            <br>
            <span class="mt-5 mb-3">Dollar Universe Web Ops 1.0 - 11/2020</span>
        </span>
    </div>
</footer>
