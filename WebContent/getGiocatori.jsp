<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="corsoDiLaurea" items="${corsiDiLaurea}">
	<option value="${corsoDiLaurea.codice}">${corsoDiLaurea.nome}</option>					
</c:forEach>