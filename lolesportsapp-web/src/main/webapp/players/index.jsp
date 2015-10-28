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
	<jsp:useBean id="modelBean" class="com.mposluszny.lolesportsapp.web.players.ModelBean" scope="session" />
	
	<!-- Primary Page Layout -->
	<div class="container title">
		<div class="row">
			<div class="one column">
				<h2>Players</h2>
			</div>
		</div>
		<div class="row">
			<div class="twelve columns">
				<table class="center table">
					<tbody>
						<tr>
							<th>Lp.</th>
							<th>Imie</th>
							<th>IGN</th>
							<th>Nazwisko</th>
							<th>Pozycja</th>
							<th>Team</th>
							<th>Retired</th>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="/WEB-INF/jsp/includes/footer.jspf" />
</body>
</html>
