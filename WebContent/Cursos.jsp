<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<!doctype html>
<html lang="es">
  <head>
   	 <!-- Required meta tags -->
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Icono -->
	<link rel="shortcut icon" type="image/x-icon" href="media/icono.ico" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	<!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.12.1/js/all.js" crossorigin="anonymous"></script>
    
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    
    <!-- Enllaç a l'arxiu CSS Extern -->
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<!-- Bootstrap core JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <!-- Third party plugin JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <!-- Contact form JS-->
    <script src="assets/mail/jqBootstrapValidation.js"></script>
    <script src="assets/mail/contact_me.js"></script>
    <!-- Core theme JS-->
    <script src="scripts.js"></script>
        
	<!-- Titol de la página -->
    <title>Sudoers - Cursos</title>
    
  </head>
  
  <body id="page-top">
  	
  	<jsp:include page="Navigation.jsp" />
  	
   <br/><br/>
   <!-- Masthead-->
   <header class="masthead bg-primary text-white text-center">
       <div class="container d-flex align-items-center flex-column">
           <h1 class="masthead-heading text-uppercase mb-0">Inscribete</h1>
           <!-- Icon Divider-->
           <div class="divider-custom divider-light">
               <div class="divider-custom-line"></div>
               <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
               <div class="divider-custom-line"></div>
           </div>
           <!-- Masthead Subheading-->
           <p class="masthead-subheading font-weight-light mb-0">Frontend - Backend - Bases de datos - y mas!</p>
       </div>
   </header>

	<!-- Cursos Section-->
   <section class="page-section cursos" id="cursos">
       <div class="container">
           <!-- Cursos Section Heading-->
           <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Cursos disponibles</h2>
           <!-- Icon Divider-->
           <div class="divider-custom">
               <div class="divider-custom-line"></div>
               <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
               <div class="divider-custom-line"></div>
           </div>
           <!-- Cursos Reserva Form-->
	                   <form action="Cursos" method="post" name="cursos">
	                   <h3>Selecciona tus cursos</h3>
	                   <div class="row">
	                   <div class="col-md-6 col-lg-4 mb-5 nopad text-center">	
		                       <label class="image-checkbox">
							      <img class="img-responsive h-100 w-100 p-4" src="python.png" />
							      <input type="checkbox" name="image[]" value="python" />
							      <i class="fa fa-check hidden"></i>
							    </label>
		               </div>

		               <div class="col-md-6 col-lg-4 nopad text-center">
		                       <label class="image-checkbox">
							      <img class="img-responsive h-100 w-100 p-4" src="Curso-maven.png" />
							      <input type="checkbox" name="image[]" value="maven" />
							      <i class="fa fa-check hidden"></i>
							    </label>
		               </div>
		               
		               <div class="col-md-6 col-lg-4 nopad text-center">		
		                       <label class="image-checkbox">
							      <img class="img-responsive h-100 w-100 p-4" src="Curso-javascript.jpg" />
							      <input type="checkbox" name="image[]" value="javascript" />
							      <i class="fa fa-check hidden"></i>
							    </label>
		               </div>
		               
		               <div class="col-md-6 col-lg-4 nopad text-center">		
		                       <label class="image-checkbox">
							      <img class="img-responsive h-100 w-100 p-4" src="Curso-laravel.png" />
							      <input type="checkbox" name="image[]" value="laravel" />
							      <i class="fa fa-check hidden"></i>
							    </label>
		               </div>
		               
		               <div class="col-md-6 col-lg-4 nopad text-center">		
		                       <label class="image-checkbox">
							      <img class="img-responsive h-100 w-100 p-4" src="Curso-react.png" />
							      <input type="checkbox" name="image[]" value="react" />
							      <i class="fa fa-check hidden"></i>
							    </label>
		               </div>
               
		               <div class="col-md-6 col-lg-4 nopad text-center">
		                       <label class="image-checkbox">
							      <img class="img-responsive h-100 w-100 p-4" src="Curso-mongodb.png" />
							      <input type="checkbox" name="image[]" value="mongodb" />
							      <i class="fa fa-check hidden"></i>
							    </label>
							    <br><br><br><br>
		               </div>
		               
		               <h3>Selecciona un metodo de pago</h3>
		               <div id="metodopago" class="col-md-12 col-lg-12 nopad text-center">
							 <label class="radio-inline p-4"><input type="radio" name="payment" value="cash" checked><h1>Cash</h1></label>
							<label class="radio-inline p-4"><input type="radio" name="payment" value="credit" ><h1>Credit card</h1></label>
							<label class="radio-inline p-4"><input type="radio" name="payment" value="paypal" ><h1>PayPal</h1></label> 
		               </div>
		               
		               <% if (session.getAttribute("user") != null) { 
		%>
		               
                       
                       <div class="col-md-12 col-lg-12">
		               			<br><br><br><br>
                              <label><h3>Nickname*</h3></label>
                             <input type="text"  name="nickname" maxlength="10"  minlength="3" class="form-control" id="nickname"  value=${sessionScope.user}></br>
                       </div>
                       
                       <% } else { 
		%>
						<div class="col-md-12 col-lg-12">
		               			<br><br><br><br>
                              <label><h3>Nickname*</h3></label>
                              <input type="text"  name="nickname" maxlength="10"  minlength="3" class="form-control" id="nickname" ></br>
                       </div>
		
		
		<% }  %>
      
      
      					<div class="col-md-12 col-lg-12">
                              <label ><h3>Grade*</h3></label>
                               <select name="grade" class="browser-default custom-select">
								  <option selected value="1">Basic</option>
								  <option value="2">Medium</option>
								  <option value="3">High</option>
							   </select>
							   <br><br><br>
                       </div>
      					
      					<div class="col-lg-6 text-center offset-3">
      					
                              <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm ">Send</button>
                              <br><br><br><br>
                        </div>

					    </div>
	                   </form>
	                   
	                   
	         <!-- Cursos Comment Form-->
                <form action="Cursos" method="get" name="comment">
	                <h3>Escribe un comentario</h3>
	                <div class="row">
	                	
	                			               <% if (session.getAttribute("user") != null) { 
		%>
		               
                       
                       <div class="col-md-12 col-lg-12">
		               			<br><br><br><br>
                              <label><h3>Nickname*</h3></label>
                              <input type="text"  name="nicknameComment" maxlength="10"  minlength="3" class="form-control" id="nickname"  value=${sessionScope.user}></br>
                       </div>
                       
                       <% } else { 
		%>
						<div class="col-md-12 col-lg-12">
		               			<br><br><br><br>
                              <label><h3>Nickname*</h3></label>
                              <input type="text"  name="nicknameComment" maxlength="10"  minlength="3" class="form-control" id="nickname" ></br>
                       </div>
		
		
		<% }  %>	
                        <div class="col-md-12 col-lg-12">
						  <label for="comment"><h3>Comment*</h3></label>
						  <textarea class="form-control" maxlength="200" rows="5" id="comment" name="comment"></textarea>
						  <br><br><br>
						</div> 
						<div class="col-lg-6 text-center offset-3">		
                           <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm ">Send Comment</button>
                        </div>
	                </div>
                </form>
	   		</div> 
   </section>
   
  

  	<!-- Footer-->
    <footer class="footer text-center">
        <div class="container">
            <div class="row">
                <!-- Footer Location-->
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <p class="lead mb-0">Carrer de la Selva de Mar, 211 <br />08020 Barcelona</p>
                </div>
                <!-- Footer Social Icons-->
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-facebook-f"></i></a>
                    <a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-twitter"></i></a>
                    <a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-linkedin-in"></i></a>
                    <a class="btn btn-outline-light btn-social mx-1" href="#"><i class="fab fa-fw fa-github"></i></a>
                </div>
            </div>
        </div>
    </footer>

	<!-- Copyright Section-->
    <section class="copyright py-4 text-center text-white">
        <div class="container"><small>2020 Copyright: Patricia Lamadrid</small></div>
    </section>
    
    
   <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
   <div class="scroll-to-top d-lg-none position-fixed">
       <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top"><i class="fa fa-chevron-up"></i></a>
   </div>
   
	
	
  </body>
  
</html>