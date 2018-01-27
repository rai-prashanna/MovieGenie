<%-- 
    Document   : video
    Created on : Sep 5, 2015, 9:27:29 PM
    Author     : prashanna
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.prashanna.Movie"%>
<%@page import="com.prashanna.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.prashanna.StringsTOMovies"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>MovieDetails</title>

		<link rel="stylesheet" type="text/css" href="style.css">
		<!--<script src="script.js"></script>-->
				
				
    <link rel="stylesheet"  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >
    <link rel="stylesheet" href="resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/star-rating.css" media="all"  type="text/css"/>
    <script src="resources/css/jquery.min.js"></script>
    <script src="resources/css/star-rating.js" type="text/javascript"></script>
    </head>
    <body>
        
        <div class="container">
			<div>
				<table class="table">
					<td>
                         <img src="<c:url value="${movie.poster}"/>"/>
					</td>
					<td>

					</td>
					<td>
						<table class="table table-hover">
							<tr>
								<td>
                                      <c:out value="${movie.title}" /></td>
								<td>
									<c:out value="${movie.year}" />
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input id="input-21c" value="2" type="number" class="rating" min=0 max=10 step=0.5 
									data-size="xs" data-stars="5">
								</td>
							</tr>
																	
							<tr>
								<td>Director</td>
								<td><c:out value="${movie.director}" /></td>
							</tr>
							<tr>
								<td>Actors</td>
								<td><c:out value="${movie.actors}" /></td>
							</tr>
							<tr>
								<td>Plot</td>
								<td id="MoviePlot"><c:out value="${movie.plot}" /> </td>
							 	
							</tr>
						</table>
					</td>
				</table>
			</div>
			<div>
                           
<iframe width="560" height="315" src="<c:url value="${movie.youtubeurl}"/>" frameborder="0" allowfullscreen></iframe>
			</div>
		</div>
    </body>
</html>
