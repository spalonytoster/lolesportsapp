<%@page contentType="text/html"%>
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
	<div class="container wrapper">
		<div class="row">
			<div class="twelve columns jumbotron">
				<h2>About</h2>
				<h5><b>Lolification</b> is a simple App to present JSP and Servlets.</h5>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="/WEB-INF/jsp/includes/footer.jspf" />
</body>
</html>
