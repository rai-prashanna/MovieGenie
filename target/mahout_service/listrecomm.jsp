<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.prashanna.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.prashanna.StringsTOMovies"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>movieGenie</title>
        <link href="assets/css/slider.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="assets/js/jquery.flexisel.js"></script>
    </head>
    <body>
        <h1>Recommended Movies</h1>

<!--        <p>Including any heading text that is required.</p>-->



        <!-- Fetch the images into this list using loop --> 

                <%--<tr>--%>
                                <%--<td> <img src="<c:url value="${movie.poster}"/>"/>--%>
                                <%--<td><h3><c:out value="${movie.title}"/> </h3> </td>--%>


                                <%--<td><a href="se?getdetails=<c:out value="${movie.imdbID}"/>">GO</a>--%>
                            <%--</tr>-->--%>

        <%--<div class="clearout"></div>--%>


        <ul id="flexiselDemo3">
            <c:forEach items="${movielist}" var="movie">
                <li><img src="<c:url value="${movie.poster}"/>"/>

                    <p>Movie Title :<c:out value="${movie.title}"/> </p>
                    <p>Director :<c:out value="${movie.director}"/> </p>
                    <p>Actor :<c:out value="${movie.actors}"/> </p>
                    <p>Movie Plot :<c:out value="${movie.plot}"/>  </p>

<!--                    <p><a href="se?getdetail=<c:out value="${movie.imdbID}"/>">Check Details</a></p> <c:out value="${user.uname}"/>"-->
                   <p><a href="se?getdetail=<c:out value="${movie.imdbID}"/>">Check Details</a></p>
                </li>
            </c:forEach>
        </ul>   

        <script type="text/javascript">

            $(window).load(function () {


                $("#flexiselDemo3").flexisel({
                    visibleItems: 5,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 1
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 2
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                    }
                });

            });
        </script>
    </body>
</html>
