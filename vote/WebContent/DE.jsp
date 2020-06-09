<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session = "true"  import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>VOTE</title>

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  
  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body onload="getTime()">
  <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
  <div class="container">
    <div id="showtime"></div>
    <div class="col-lg-4 col-lg-offset-4">
      <div class="lock-screen">
        <h2><a data-toggle="modal" href="#myModal"><i class="fa fa-lock"></i></a></h2>
        <p>OUVRIR</p>
        <!-- Modal -->
        <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Nous saluons le retour</h4>
               
              </div>
              <div class="modal-body">
                <p class="centered"><img class="img-circle" width="80" src="img/im.jpg"></p>
                <h4 >Le vote est validé par DE<br>Vous n'avez pas le droit de voter à nouveau !<br>
                <% String url="jdbc:mysql://localhost/vote";
String driver = "com.mysql.jdbc.Driver";
Class.forName(driver).newInstance();
PreparedStatement stmt;
Connection con;
ResultSet rs;
con=DriverManager.getConnection(url,"root","");
stmt=con.prepareStatement("select *  from datevote");
rs = stmt.executeQuery();
boolean encore = rs.next();
while (encore) { 
%>
                Veuillez patienter pendant que les résultats sont affichés après la fin de la période du <%=rs.getDate(3)%> :)</h4>
<% 
   encore = rs.next(); } 
 
rs.close(); 
stmt.close();
con.close();
%>
              </div>
              <div class="modal-footer centered">
                <button data-dismiss="modal" class="btn btn-theme04" type="button">Cancel</button>
                <a href="index.jsp" class="btn btn-theme03">Email</a>
              </div>
            </div>
          </div>
        </div>
        <!-- modal -->
      </div>
      <!-- /lock-screen -->
    </div>
    <!-- /col-lg-4 -->
  </div>
  <!-- /container -->
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>
  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <!--BACKSTRETCH-->
  <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
  <script type="text/javascript" src="lib/jquery.backstretch.min.js"></script>
  <script>
    $.backstretch("img/login-bg.jpg", {
      speed: 500
    });
  </script>
  <script>
    function getTime() {
      var today = new Date();
      var h = today.getHours();
      var m = today.getMinutes();
      var s = today.getSeconds();
      // add a zero in front of numbers<10
      m = checkTime(m);
      s = checkTime(s);
      document.getElementById('showtime').innerHTML = h + ":" + m + ":" + s;
      t = setTimeout(function() {
        getTime()
      }, 500);
    }

    function checkTime(i) {
      if (i < 10) {
        i = "0" + i;
      }
      return i;
    }
  </script>
</body>

</html>
