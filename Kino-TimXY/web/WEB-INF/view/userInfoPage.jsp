<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head><title>${title}</title></head>
<body>
<h2>Message : ${message}</h2>

<c:if test="${pageContext.request.userPrincipal.name != null}">
  <h3>User Info : ${pageContext.request.userPrincipal.name}
    | <a href="#" style="font-size: 110%" onclick="document.getElementById('logoutForm').submit();"
         role="button">Log out</a></h3>
</c:if>

<form action="/j_spring_security_logout" method="post" id="logoutForm">
  <input type="hidden" name="${_csrf.parameterName}"
         value="${_csrf.token}"/>
</form>
</body>
</html>