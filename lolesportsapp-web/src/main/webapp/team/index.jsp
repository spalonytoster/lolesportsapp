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
	<jsp:useBean id="modelBean" class="com.mposluszny.lolesportsapp.web.teams.ModelBean" scope="request" />
	
	<!-- Primary Page Layout -->
	<div class="container wrapper title">
		<div class="row">
			<div class="one column">
				<h2>Teams</h2>
			</div>
		</div>
		<div class="row">
			<div class="twelve columns">
				<table class="center table text-center">
					<tbody>
						<tr>
							<th>Lp.</th>
							<th>Nazwa</th>
							<th>Region</th>
							<th>Data utworzenia</th>
							<th>Akcja</th>
						</tr>
						
						<c:forEach var="team" items="${modelBean.teams}" varStatus="row">
							<tr>
								<td>${row.index+1}</td>
								<td>${team.name}</td>
								<td>${team.region}</td>
								<td>${team.dateOfEstablishment}</td>
								<td>
									<form class="actionForm" action="team" method="get">
										<button class="actionButton" type="submit" name="view" value="${team.idTeam}">
											<i class="fa fa-eye"></i>
										</button>
										<button class="actionButton" type="submit" name="edit" value="${team.idTeam}">
											<i class="fa fa-edit"></i>
										</button>
										<button class="actionButton" type="submit" name="delete" value="${team.idTeam}">
											<i class="fa fa-close"></i>
										</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="/WEB-INF/jsp/includes/footer.jspf" />
</body>
</html>
