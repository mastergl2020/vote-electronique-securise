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
  </section>
  <section id="container">

   
 
    <section id="main-content">
      <section class="wrapper">

 
 
 
 
  <h3><i class="fa fa-angle-right"></i> Ajouter Date Vote</h3>
        <div class="row mt">
          <!--  DATE PICKERS -->
          <div class="col-lg-12">
            <div class="form-panel">
              <form  class="form-horizontal style-form" action="DateServlet" method="post">
                <div class="form-group">
                  <label class="control-label col-md-3">Plage de dates</label>
                  <div class="col-md-4">
                   <div class="input-group input-large" >
                      <input type="text" class="form-control dpd1" name="debut">
                      <span class="input-group-addon">À</span>
                      <input type="text" class="form-control dpd2" name="fin">
                      
                    </div> 
                   
                    <span class="help-block">Sélectionnez une plage de dates</span>
                  </div>
                   <div class="col-md-4" >
                    <div class="input-group input-large"  >
                      <input type="submit" class="btn btn-theme start" name="op" value="Ajouter">
                    
                    </div>
                    
                    
                  </div>
                  
                </div>
               
              </form>
            </div>
            <!-- /form-panel -->
          </div>
          <!-- /col-lg-12 -->
        </div>
 <% String url="jdbc:mysql://localhost/vote";
String driver = "com.mysql.jdbc.Driver";
Class.forName(driver).newInstance();
PreparedStatement stmt;
Connection con;
ResultSet rs;
con=DriverManager.getConnection(url,"root","");
stmt=con.prepareStatement("select *  from datevote");
rs = stmt.executeQuery();
%>       
        
         <h3><i class="fa fa-angle-right"></i> LES DATES</h3>
          <div class="form-panel">
        <div class="row mt">
          <!--  DATE PICKERS -->
          <div class="col-lg-12">
          <from action="DateServlet" method="post">
          <table class="table">
                <thead>

                  <tr>
                    <th>#</th>
                    <th>Date debut de vote</th>
                    <th>Date fin de vote</th>
                     <th>Option</th>
                    
                  </tr>
                </thead>  
<%boolean encore = rs.next();
    while (encore) { 
%>                                
                <tr>
<td ><%=rs.getInt(1)%></td>
<td ><%=rs.getString(2)%></td>
<td ><%=rs.getString(3)%></td>



<td>
<!--<input type="submit" value="Supprimer" name="op"/>  -->


<a href="deletedate.jsp?id_d=<%=rs.getInt(1)%>"  class="btn btn-danger btn-xs"><i class="fa fa-trash-o "></i></a></td> 

</tr>
<% 
   encore = rs.next(); } 
 
rs.close(); 
stmt.close();
con.close();
%>
</table>
</from>
          
           
             </div>
            <!-- /form-panel -->
          </div>
          <!-- /col-lg-12 -->
        </div>
 
 
 
 
 
 
 
 
      </section>
    </section>
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
  <script src="lib/jquery-ui-1.9.2.custom.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-fileupload/bootstrap-fileupload.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-daterangepicker/date.js"></script>
  <script type="text/javascript" src="lib/bootstrap-daterangepicker/daterangepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
  <script type="text/javascript" src="lib/bootstrap-daterangepicker/moment.min.js"></script>
  <script type="text/javascript" src="lib/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
  <script src="lib/advanced-form-components.js"></script>
  
</body>

</html>
