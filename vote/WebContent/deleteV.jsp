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
  <title>VOTE:PGD</title>

  <!-- Favicons -->
  <link href="img/logo.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="css/zabuto_calendar.css">
  <link rel="stylesheet" type="text/css" href="lib/gritter/css/jquery.gritter.css" />
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
  <script src="lib/chart-master/Chart.js"></script>

  <!-- =======================================================
    Template Name: Dashio
    Template URL: https://templatemag.com/dashio-bootstrap-admin-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
   
      <!--logo start-->
      <a href="index.html" class="logo"><b>VO<span>TE</span></b></a>
      <!--logo end-->
      <div class="nav notify-row" id="top_menu">

        </ul>
        <!--  notification end -->
      </div>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
           <a href="index.jsp" class="chat-tools btn-theme03"><i class="fa fa-key"></i> </a>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <!--   <p class="centered"><a href="profile.html"><img src="img/p.png" class="img-circle" width="80"></a></p>
          
          <h5 class="centered">NOM PRENOM</h5>-->
          <li class="sub-menu">
            
              <a href="ListVotant.jsp">Listes Votants</a></li>
        
           
          <li class="sub-menu">
          <li class="sub-menu">
            
              <a href="listCandidat.jsp">Listes Candidats</a></li>
        
           
          <li class="sub-menu">
          <li class="sub-menu">
            
              <a href="addC.jsp">Ajouter Candidat</a></li>
        
           
          <li class="sub-menu">
           <li class="sub-menu">
            
              <a href="date.jsp">Ajouter Date Vote</a></li>
        
           
          <li class="sub-menu">
           <li class="sub-menu">
            
              <a href="res.jsp">Resultat</a></li>
      </div>
    </aside>
    
   <br>
  <section id="main-content">
      <section class="wrapper">
    <br><br><br>
   <%
String url="jdbc:mysql://localhost/vote";
String driver = "com.mysql.jdbc.Driver";
Class.forName(driver).newInstance();
PreparedStatement st;
Connection con;
con=DriverManager.getConnection(url,"root","");
int id =Integer.parseInt((String)request.getParameter("id"));
String sql="delete from votant where id='"+id+"'";
st=con.prepareStatement(sql);
int rs = st.executeUpdate();
%>
<h3></h3>
        <div class="row">
          <div class="col-md-12">
            <div >
         
          
<h3>Cet candidat a �t� supprim� <a href="ListVotant.jsp">Retour � la page </a></h3>
						
<% 
st.close();
con.close();
%>
  </div>
          </div>

        </div>
       
      </section>
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->
    
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="lib/jquery/jquery.min.js"></script>

  <script src="lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="lib/jquery.scrollTo.min.js"></script>
  <script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
  <script src="lib/jquery.sparkline.js"></script>
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <script type="text/javascript" src="lib/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="lib/gritter-conf.js"></script>
  <!--script for this page-->
  <script src="lib/sparkline-chart.js"></script>
  <script src="lib/zabuto_calendar.js"></script>
  
  <script type="application/javascript">
    $(document).ready(function() {
      $("#date-popover").popover({
        html: true,
        trigger: "manual"
      });
      $("#date-popover").hide();
      $("#date-popover").click(function(e) {
        $(this).hide();
      });

      $("#my-calendar").zabuto_calendar({
        action: function() {
          return myDateFunction(this.id, false);
        },
        action_nav: function() {
          return myNavFunction(this.id);
        },
        ajax: {
          url: "show_data.php?action=1",
          modal: true
        },
        legend: [{
            type: "text",
            label: "Special event",
            badge: "00"
          },
          {
            type: "block",
            label: "Regular event",
          }
        ]
      });
    });

    function myNavFunction(id) {
      $("#date-popover").hide();
      var nav = $("#" + id).data("navigation");
      var to = $("#" + id).data("to");
      console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
  </script>
</body>

</html>
