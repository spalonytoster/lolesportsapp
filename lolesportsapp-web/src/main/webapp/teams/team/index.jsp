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
			
				<table class="center table text-center">
					<tbody>
						<tr>
							<th>Nazwa</th>
							<th>Region</th>
							<th>Data utworzenia</th>
						</tr>
						
						<c:set var="team" value="${team}" />
						<tr>
							<td>${team.name}</td>
							<td>${team.region}</td>
							<td>${team.dateOfEstablishment}</td>
						</tr>
					</tbody>
				</table>
				<table class="center table text-center" style="margin-top: 20px;">
					<tbody>
						<tr>
							<th>Lp.</th>
							<th>Imie</th>
							<th>IGN</th>
							<th>Nazwisko</th>
							<th>Pozycja</th>
							<th>Retired</th>
						</tr>
						
						<c:forEach var="player" items="${team.players}" varStatus="row">
							<tr>
								<td>${row.index+1}</td>
								<td>${player.name}</td>
								<td>${player.ign}</td>
								<td>${player.surname}</td>
								<td>${player.role}</td>
								<td style="text-align: center;">
									<c:if test="${player.retired}">
										<i class="fa fa-check"></i>
									</c:if>
									<c:if test="${!player.retired}">
										<i class="fa fa-close"></i>
									</c:if>
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
