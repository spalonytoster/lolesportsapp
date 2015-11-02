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
	<div class="container">
		<div class="row">
			<div class="one-half column" style="margin-top: 25%">
				<h4>About</h4>
				<p>Simple App to present JSP and Servlets.</p>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="/WEB-INF/jsp/includes/footer.jspf" />
</body>
</html>
