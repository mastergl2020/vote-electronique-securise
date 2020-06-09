<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>VOTE:S'INSCRIRE</title>

  <!-- Favicons -->
  <link href="img/logo.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Bootstrap core CSS -->
  <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!--external css-->
  <link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-fileupload/bootstrap-fileupload.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-datepicker/css/datepicker.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-daterangepicker/daterangepicker.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-timepicker/compiled/timepicker.css" />
  <link rel="stylesheet" type="text/css" href="lib/bootstrap-datetimepicker/datertimepicker.css" />
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
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
  
      <section id="main-content">
           <section class="wrapper">
		    <div id="login-page">
               <div class="container">
                 <form class="form-login" action="AjouterC" method="post" enctype="multipart/form­data">
                    <h2 class="form-login-heading"><b>AJOUTER Candidat</b></h2>
                       <div class="login-wrap">
					      <input type="text" class="form-control" placeholder="Nom" name="nom_c" autofocus required><br>
                          <input type="text" class="form-control" placeholder="Prenom" name="prenom_c" required><br>
                          <input type="text" class="form-control" placeholder="Partier" name="partie_c"  required><br>
                          <label class="control-label col-md-3">Image</label>
                          <div class="col-md-9">
                              <div class="fileupload fileupload-new" data-provides="fileupload">
                                  <div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
                                      <img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" alt="" />
                                   </div>
                                   <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
                                       <div>
                                           <span class="btn btn-theme02 btn-file">
                                                <span class="fileupload-new"><i class="fa fa-paperclip"></i>Sélectionnez l'image</span>
                                                <span class="fileupload-exists"><i class="fa fa-undo"></i> Change</span>
                                                <input type="file" class="default" name="image_c"  accept=".jpg, .jpeg, .png" />
                                            </span>
                                            <!--  <a href="advanced_form_components.html#" class="btn btn-theme04 fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash-o"></i> Effacer</a>-->
                                       </div>
                               </div>
                          </div>
						  <input  class="btn btn-theme btn-block" type="submit"  value="Ajouter" name="op"> 
                         </input> <input class="btn btn-theme btn-block" type="reset" value="effacer"></input>
                          <hr>
                          <div class="registration">
           
          </div>
        </div>
      </form>
    </div>
  </div>
               
             
           
      </section>
      <!-- /wrapper -->
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
  <!--BACKSTRETCH-->
  <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->

</body>
</html>
