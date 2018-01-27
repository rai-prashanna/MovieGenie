<%--list recommend.jsp--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%--video.jsp--%>
<%@page import="com.prashanna.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.prashanna.StringsTOMovies"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>movieJINI</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="assets/css/main.css" rel="stylesheet">
<link href="assets/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/css/animate-custom.css" rel="stylesheet">
<link href="assets/css/form.css" rel="stylesheet">
<link href="assets/css/form-min.css" rel="stylesheet">
<link href="assets/css/pure.css" rel="stylesheet">
<%--rating.jsp--%>
    <%--<link rel="stylesheet" type="text/css" href="resources/css/style.css">--%>
    <%--&lt;%&ndash;<link rel="stylesheet"  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >&ndash;%&gt;--%>
    <%--&lt;%&ndash;<link rel="stylesheet" href="resources/css/font-awesome.min.css">&ndash;%&gt;--%>
    <%--<link rel="stylesheet" href="resources/css/star-rating.css" media="all"  type="text/css"/>--%>
    <%--<script src="resources/css/jquery.min.js"></script>--%>
    <%--<script src="resources/css/star-rating.js" type="text/javascript"></script>--%>
<%--listrecommend.jsp    --%>
    <%--video.jsp--%>
<!-- <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'> -->
<%--<script src="assets/js/jquery.min.js"></script>--%>
<%--<script type="text/javascript" src="assets/js/modernizr.custom.js"></script>--%>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body data-spy="scroll" data-offset="0" data-target="#navbar-main">
<div id="navbar-main"> 
  <!-- Fixed navbar -->
  <div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand" href="#home">MovieJINI</a> </div>
      <div class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#home" class="smoothScroll">Home</a></li>
          
          <li> <a href="#services" class="smoothScroll"> Recommended</a></li>
          <%--<li> <a href="#portfolio" class="smoothScroll"> Latest Releases</a></li>--%>
         
          <!-- <li> <a href="#contact" class="smoothScroll"> Contact</a></li> -->
        <li> <a href="#about" class="smoothScroll"> Register</a></li>
         <li> <a href="#team" class="smoothScroll"> About</a></li>
        </ul>
      </div>
      <!--/.nav-collapse --> 
    </div>
  </div>
</div>

<!-- ==== HEADERWRAP ==== -->
<div id="headerwrap" name="home">
 <img  src="assets/img/jini.jpg" alt="" height="300px;" width="300px;">
 <!--  <header class="clearfix"> <i class="fa fa-language icon"></i> -->
    <h1>Movie JINI </h1>
    <p>Your Ultimate Movie Partner 
      </p>
   
      <!-- signup form -->
      <form class="pure-form">
    <fieldset>
        <H3>Sign IN TO Use All Features</H3>

        <input type="email" placeholder="Email" name="signin-email">
        <input type="password" placeholder="Password" name="signin-password">

        <label for="remember">
            <input id="remember" type="checkbox"> Remember me
        </label>

        <button type="submit" class="pure-button pure-button-primary">Sign in</button></br></br>
         <label>Not Registered ! </label>&nbsp;&nbsp;<button  class="pure-button pure-button-primary"><a href="#about" class="smoothScroll">Signup </a>
         </button>
    </fieldset>
</form>
<!-- <span><p>New To movieJINI&nbsp;&nbsp;:</p> <a href="#portfolio" class="smoothScroll btn btn-lg">Register</a></span> -->
    </header>
</div>
<!-- /headerwrap -->


<!-- ==== RECOMMENDED ==== -->
<div id="services" name="services">
  <div class="container">
    <div class="row">


        <c:if test="${requestScope.recomStatus eq null}">
            <%--recommend nagara ani tei basa vaneko --%>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css">
        <link rel="stylesheet"  href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >
        <link rel="stylesheet" href="resources/css/font-awesome.min.css">
        <link rel="stylesheet" href="resources/css/star-rating.css" media="all"  type="text/css"/>
        <script src="resources/css/jquery.min.js"></script>
        <script src="resources/css/star-rating.js" type="text/javascript"></script>

        <div class="container">
            <div>
                <h2 class="centered">First Train Me Please, Master!!! </h2>
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

        </c:if>


            <c:if test="${requestScope.recomStatus eq 'recommendationDone'}">
                    <%--recommend gara vaneko --%>

                <h2 style="text-align: center">Recommended For You !</h2>
                <link href="assets/css/slider.css" rel="stylesheet" type="text/css" />
                <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
                <script type="text/javascript" src="assets/js/jquery.flexisel.js"></script>

                <ul id="flexiselDemo3">
                    <c:forEach items="${movielist}" var="movie">
                        <li><img src="<c:url value="${movie.poster}"/>"/>

                            <p style="text-align: justify" ><strong>Movie Title :</strong><c:out value="${movie.title}"/> </p>
                            <p style="text-align: justify" ><strong>Director :</strong><c:out value="${movie.director}"/> </p>
                            <p style="text-align: justify" ><strong>Actor :</strong><c:out value="${movie.actors}"/> </p>
                            <p style="text-align: justify" ><strong>Movie Plot :</strong><c:out value="${movie.plot}"/>  </p>

                            <!--                    <p><a href="se?getdetail=<c:out value="${movie.imdbID}"/>">Check Details</a></p> <c:out value="${user.uname}"/>"-->
                            <p><button  class="pure-button pure-button-primary"><a href="se?getdetail=<c:out value="${movie.imdbID}"/>">
                                Check Details</a>
                            </p>
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

            </c:if>



            <!--			<div>
                                            <iframe width="560" height="315" src="https://www.youtube.com/embed/5PSNL1qE6VY" frameborder="0" allowfullscreen></iframe>
                                    </div>-->

            <%--till here--%>
        </div>


    </div>


      </div>

    </div>

  </div>

<%--Start of the Latest Releases Section--%>

<%--<div id="portfolio" name="portfolio">--%>
  <%--<div class="container">--%>
    <%--<div class="row">--%>
      <%--<h2 class="centered">Latest Releases</h2>--%>
      <%--<hr>--%>
      <%--<div class="col-lg-8 col-lg-offset-2 centered">--%>
        <%--<p class="large">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>--%>
      <%--</div>--%>
    <%--</div>--%>
    <%--<!-- /row -->--%>
    <%--<div class="container">--%>
      <%--<div class="row"> --%>
        <%----%>
        <%--<!-- PORTFOLIO IMAGE 1 -->--%>
        <%--<div class="col-md-4 ">--%>
          <%--<div class="grid mask">--%>
            <%--<figure> <img class="img-responsive" src="assets/img/portfolio/folio01.jpg" alt="">--%>
              <%--<figcaption>--%>
                <%--<h5>UX / UI</h5>--%>
                <%--<a data-toggle="modal" href="#myModal" class="btn btn-default">More Details</a> </figcaption>--%>
              <%--<!-- /figcaption --> --%>
            <%--</figure>--%>
            <%--<!-- /figure --> --%>
          <%--</div>--%>
          <%--<!-- /grid-mask --> --%>
        <%--</div>--%>
        <%----%>
        <%--<!-- MODAL SHOW THE PORTFOLIO IMAGE. In this demo, all links point to this modal. You should create--%>
						      <%--a modal for each of your projects. -->--%>
        <%----%>
        <%--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
          <%--<div class="modal-dialog">--%>
            <%--<div class="modal-content">--%>
              <%--<div class="modal-header">--%>
                <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                <%--<h4 class="modal-title">Project Title</h4>--%>
              <%--</div>--%>
              <%--<div class="modal-body">--%>
                <%--<p><img class="img-responsive" src="assets/img/portfolio/folio01-preview.jpg" alt=""></p>--%>
                <%--<p>Lorem ipsum dolor sit amet, quo meis audire placerat eu, te eos porro veniam. An everti maiorum detracto mea. Eu eos dicam voluptaria, erant bonorum albucius et per, ei sapientem accommodare est. Saepe dolorum constituam ei vel</p>--%>
                <%--<p><b><a href="#">Visit Site</a></b></p>--%>
              <%--</div>--%>
              <%--<div class="modal-footer">--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
              <%--</div>--%>
            <%--</div>--%>
            <%--<!-- /.modal-content --> --%>
          <%--</div>--%>
          <%--<!-- /.modal-dialog --> --%>
        <%--</div>--%>
        <%--<!-- /.modal --> --%>
        <%----%>
        <%--<!-- PORTFOLIO IMAGE 2 -->--%>
        <%--<div class="col-md-4">--%>
          <%--<div class="grid mask">--%>
            <%--<figure> <img class="img-responsive" src="assets/img/portfolio/folio02.jpg" alt="">--%>
              <%--<figcaption>--%>
                <%--<h5>CONCEPT</h5>--%>
                <%--<a data-toggle="modal" href="#myModal" class="btn btn-default">More Details</a> </figcaption>--%>
              <%--/figcaption --%>
            <%--</figure>--%>
            <%--<!-- /figure --> --%>
          <%--</div>--%>
          <%--<!-- /grid-mask --> --%>
        <%--</div>--%>
        <%----%>
        <%--<!-- PORTFOLIO IMAGE 3 -->--%>
        <%--<div class="col-md-4">--%>
          <%--<div class="grid mask">--%>
            <%--<figure> <img class="img-responsive" src="assets/img/portfolio/folio03.jpg" alt="">--%>
              <%--<figcaption>--%>
                <%--<h5>UX / UI</h5>--%>
                <%--<a data-toggle="modal" href="#myModal" class="btn btn-default">More Details</a> </figcaption>--%>
              <%--<!-- /figcaption --> --%>
            <%--</figure>--%>
            <%--<!-- /figure --> --%>
          <%--</div>--%>
          <%--<!-- /grid-mask --> --%>
        <%--</div>--%>
      <%--</div>--%>
      <%--<!-- /row --> --%>
      <%----%>
        <%----%>
        <%--<!-- /col --> --%>
      <%--</div>--%>
      <%--<!-- /row --> --%>
    <%--</div>--%>
    <%--<!-- /row --> --%>
  <%--</div>--%>
<%--</div>--%>
<%--<!-- /container --> --%>

<%--latest Releases Ends Here!--%>

<!-- ==== REGISTER ==== -->
<div id="about" name="about">
  <div class="container">
    <div class="row white">
      
      <h2 class="centered">REGISTER</h2>
      <hr>
    <center>
        <form class="pure-form pure-form-aligned">
    <fieldset>
        <div class="pure-control-group">
            <label for="name">Username</label>
            <input id="name" type="text" placeholder="Username" name="signup-username">
        </div>

        <div class="pure-control-group">
            <label for="password">Password</label>
            <input id="password" type="password" placeholder="Password" name="signup-password">
        </div>

        <div class="pure-control-group">
            <label for="email">Email Address</label>
            <input id="email" type="email" placeholder="Email Address" name="signup-email">
        </div>

       

        <div class="pure-controls">
            <label for="cb" class="pure-checkbox">
                <input id="cb" type="checkbox" name="signup-terms"> I've read the terms and conditions
            </label>

            <button type="submit" class="pure-button pure-button-primary">Submit</button>
        </div>
    </fieldset>
    </center>
</form>
   
  </div>
</div>
<!-- container --> 




<!-- ==== TEAM MEMBERS ==== -->
<div id="team" name="team">
  <div class="container">
    <div class="row centered">
      <h2 class="centered">ABOUT Developers</h2>
      <hr>
      <div class="col-lg-3 centered"> <img class="img img-circle" src="assets/img/team/team01.jpg" height="120px" width="120px" alt="">
        <h4><strong>Subash</strong></h4>
        <p>Albucius consectetuer eu nam. Saepe legendos vulputate eu quo, id mea comprehensam signifer.</p>
        <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a> </div>
      <div class="col-lg-3 centered"> <img class="img img-circle" src="assets/img/team/team02.jpg" height="120px" width="120px" alt="">
        <h4><b>Laure</b></h4>
        <p>Albucius consectetuer eu nam. Saepe legendos vulputate eu quo, id mea comprehensam signifer.</p>
        <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a> </div>
      <div class="col-lg-3 centered"> <img class="img img-circle" src="assets/img/team/team03.jpg" height="120px" width="120px" alt="">
        <h4><b>Shiva</b></h4>
        <p>Albucius consectetuer eu nam. Saepe legendos vulputate eu quo, id mea comprehensam signifer.</p>
        <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a> </div>
      <div class="col-lg-3 centered"> <img class="img img-circle" src="assets/img/team/team04.jpg" height="120px" width="120px" alt="">
        <h4><b>Pidit</b></h4>
        <p>Albucius consectetuer eu nam. Saepe legendos vulputate eu quo, id mea comprehensam signifer.</p>
        <a href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a> </div>
      <!-- <div class="col-lg-8 col-lg-offset-2 centered">
        <p class="large">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
      </div> -->
    </div>
  </div>
  <!-- row --> 
</div>
<!-- container --> 

<!-- ==== CONTACT ==== -->
<!-- <div id="contact" name="contact">
  <div class="container">
    <div class="row">
      <h2 class="centered">CONTACT US</h2>
      <hr>
      <div class="col-md-4 centered"> <i class="fa fa-map-marker fa-2x"></i>
        <p>321 Awesome Street<br>
          New York, NY 17022</p>
      </div>
      <div class="col-md-4"> <i class="fa fa-envelope-o fa-2x"></i>
        <p>info@companyname.com</p>
      </div>
      <div class="col-md-4"> <i class="fa fa-phone fa-2x"></i>
        <p> +1 800 123 1234</p>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-8 col-lg-offset-2 centered">
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut eaque, laboriosam veritatis, quos non quis ad perspiciatis, totam corporis ea, alias ut unde.</p>
        <form id="contact" method="post" class="form" role="form">
          <div class="row">
            <div class="col-xs-6 col-md-6 form-group">
              <input class="form-control" id="name" name="name" placeholder="Name" type="text" required />
            </div>
            <div class="col-xs-6 col-md-6 form-group">
              <input class="form-control" id="email" name="email" placeholder="Email" type="email" required />
            </div>
          </div>
          <textarea class="form-control" id="message" name="message" placeholder="Message" rows="5"></textarea>
          <div class="row">
            <div class="col-xs-12 col-md-12">
              <button class="btn btn btn-lg" type="submit">Send Message</button>
            </div>
          </div>
        </form> -->
        <!-- form --> 
      <!-- </div>
    </div>
    <!row -->  
    
 <!--  </div>
</div> -->
<!-- container -->

<!-- <div id="footerwrap">
  <div class="container">
    <div class="row">
      <div class="col-md-8"> <span class="copyright">Copyright &copy; 2015 Your Website Name. Design by <a href="http://www.templategarden.com" rel="nofollow">TemplateGarden</a></span> </div>
      <div class="col-md-4">
        <ul class="list-inline social-buttons">
          <li><a href="#"><i class="fa fa-twitter"></i></a> </li>
          <li><a href="#"><i class="fa fa-facebook"></i></a> </li>
          <li><a href="#"><i class="fa fa-google-plus"></i></a> </li>
          <li><a href="#"><i class="fa fa-linkedin"></i></a> </li>
        </ul>
      </div>
    </div>
  </div>
</div> -->

<!-- Bootstrap core JavaScript
    ================================================== --> 
<!-- Placed at the end of the document so the pages load faster --> 

<script type="text/javascript" src="assets/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="assets/js/retina.js"></script> 
<script type="text/javascript" src="assets/js/jquery.easing.1.3.js"></script> 
<script type="text/javascript" src="assets/js/smoothscroll.js"></script> 
<script type="text/javascript" src="assets/js/jquery-func.js"></script>
</body>
</html>
