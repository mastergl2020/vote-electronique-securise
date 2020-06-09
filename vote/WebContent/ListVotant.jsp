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

<body>
  <section id="container">
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
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper">
        <h3></h3>
        <div class="row">
          <div class="col-md-12">
            <div class="content-panel">
              <h4><i class="fa fa-angle-right"></i> Listes Votants</h4>
              <hr>
<% String url="jdbc:mysql://localhost/vote";
String driver = "com.mysql.jdbc.Driver";
Class.forName(driver).newInstance();
PreparedStatement stmt;
Connection con;
ResultSet rs;
con=DriverManager.getConnection(url,"root","");
stmt=con.prepareStatement("select *  from votant");
rs = stmt.executeQuery();
%>
              <table class="table">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Email</th>
                    <th>Mtp</th>
                    <th>Statue</th>
                    <th>image</th>
                    <th>Options</th>
                  </tr>
                </thead>
<%boolean encore = rs.next();
    while (encore) { 
%>              
                <tr>
<td ><%=rs.getInt(1)%></td>
<td ><%=rs.getString(2)%></td>
<td > <%=rs.getString(3)%></td>
<td ><%=rs.getString(4)%></td>
<td ><%=rs.getString(5)%></td>
<td ><%=rs.getString(6)%></td>
<td ><%
                Blob bl=rs.getBlob(7);
                byte[] image=bl.getBytes(1, (int)bl.length());
                %>
                <img src="data:image/jpeg;base64, <%=javax.xml.bind.DatatypeConverter.printBase64Binary(image)%>
            " height="100" width="100" > </td>
<td><a href="updateV.jsp?id=<%= rs.getString(1) %> "class="btn btn-success btn-xs"><i class="fa fa-check"></i></a>&nbsp;&nbsp;&nbsp;
<a href="updateV.jsp?id=<%=rs.getString(1)%>"  class="btn btn-primary btn-xs"><i class="fa fa-pencil"></i></a> &nbsp;&nbsp;&nbsp;
<a href="deleteV.jsp?id=<%=rs.getString(1)%>"  class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></a></td> 
</tr>
<% 
   encore = rs.next(); } 
 
rs.close(); 
stmt.close();
con.close();
%>
              
              </table>
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
  <!--common script for all pages-->
  <script src="lib/common-scripts.js"></script>
  <!--script for this page-->
  
</body>

</html>
