<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<!--  Meta and CSS -->
	<jsp:include page="${request.contextPath}/WEB-INF/jsp/includes/head.jspf" />
</head>
<body>

	<!-- Navigation bar -->
	<jsp:include page="${request.contextPath}/WEB-INF/jsp/includes/navbar.jspf" />
	
	<!-- Primary Page Layout -->
	<div class="container wrapper title">
		<div class="row">
			<div class="one column">
				<h2>Team</h2>
			</div>
		</div>
		<div class="row">
			<div class="twelve columns">
				<c:if test="${modelBean.view}">
					<jsp:include page="${request.contextPath}/teams/team/viewTeam.jspf"></jsp:include>
				</c:if>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="/WEB-INF/jsp/includes/footer.jspf" />
</body>
</html>
