<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="com.prashanna.mahout_webservice.RatingModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>

<%--
  Created by IntelliJ IDEA.
  User: subash
  Date: 8/24/15
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">
        <link rel="stylesheet"  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >
        <link rel="stylesheet" href="resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources/css/star-rating.css" media="all"  type="text/css"/>
        <script src="resources/css/jquery.min.js"></script>
        <script src="resources/css/star-rating.js" type="text/javascript"></script>
    </head>
    <%--<script >--%>
        <%--$("#input-21c").click(function () {--%>
            <%--$("#submit").click();--%>
        <%--});--%>
    <%--</script>	--%>



</header>
<body>

    <div class="container">
        <div>
            <table class="table">
                <td>
                    <img src="<c:url value="${movieobj.poster}"/>"/>
                </td>
                <td></td>
                <td>
                    <table class="table table-hover">
                        <tr>
                            <td><h3><c:out value="${movieobj.title}" /></h3></td>
                            <td>
                                <c:out value="${movieobj.year}" /></td>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <form name="rate" method ="get" action="/rate">
                                    <input id="input-21c" value="5" type="number" class="rating" min=0 max=5 step=0.5 
                                           data-size="xs" data-stars="5" name="rating">

                                    <input name="movieid" class="pras" value="<c:out value="${moviedto.movieID}" />"/>
                                    <input type="submit" id="submit"> 

                                </form>


                            </td>
                        </tr>

                        <tr>
                            <td>Director</td>
                            <td><c:out value="${movieobj.director}" /></td></td>
                        </tr>
                        <tr>
                            <td>Actors</td>
                            <td><c:out value="${movieobj.actors}" /></td></td>
                        </tr>
                        <tr>
                            <td>Plot</td>
                            <td id="MoviePlot"><c:out value="${movieobj.plot}" />
                            </td>
                        </tr>
                        <tr>
                        <form name="rate" method ="get" action="/rate">
                            <input name="action" class="pras" value="rec" />
                            <input name="movieid" class="pras" value="<c:out value="${moviedto.movieID}" />"/>
                            <input type="submit" id="submit" value="recomm"> 

                        </form>
                        </tr>
                        <form name="rate" method ="get" action="/rate">
                            <input name="action" class="pras" value="skip" />
                            <input name="movieid" class="pras" value="<c:out value="${moviedto.movieID}" />"/>
                            <input type="submit" id="submit" value="skip"> 
                        </form>
                    </table>
                </td>
            </table>
        </div>
        <!--			<div>
                                        <iframe width="560" height="315" src="https://www.youtube.com/embed/5PSNL1qE6VY" frameborder="0" allowfullscreen></iframe>
                                </div>-->
    </div>

</body>
</html>
