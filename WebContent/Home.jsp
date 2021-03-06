<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
        
	<!-- Titol de la pàgina -->
    <title>Sudoers - Home</title>
    
  </head>
  
  <body id="page-top">
      
   <jsp:include page="Navigation.jsp" /> 
    
   <br/><br/>
   <!-- Masthead-->
   <header class="masthead bg-primary text-white text-center">
       <div class="container d-flex align-items-center flex-column">
           <h1 class="masthead-heading text-uppercase mb-0">Learn to code</h1>
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
           <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Cursos</h2>
           <!-- Icon Divider-->
           <div class="divider-custom">
               <div class="divider-custom-line"></div>
               <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
               <div class="divider-custom-line"></div>
           </div>
           <!-- Cursos Grid Items-->
           <div class="row">
               <!-- Cursos Item 1-->
               <div class="col-md-6 col-lg-4 mb-5">
                   <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal1">
                       <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                           <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                       </div>
                       <img class="img-fluid" src="python.png" alt="" />
                   </div>
               </div>
               <!-- Cursos Item 2-->
               <div class="col-md-6 col-lg-4 mb-5">
                   <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal2">
                       <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                           <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                       </div>
                       <img class="img-fluid" src="Curso-javascript.jpg" alt="" />
                   </div>
               </div>
               <!-- Cursos Item 3-->
               <div class="col-md-6 col-lg-4 mb-5">
                   <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal3">
                       <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                           <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                       </div>
                       <img class="img-fluid" src="Curso-react.png" alt="" />
                   </div>
               </div>
               <!-- Cursos Item 4-->
               <div class="col-md-6 col-lg-4 mb-5 mb-lg-0">
                   <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal4">
                       <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                           <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                       </div>
                       <img class="img-fluid" src="Curso-laravel.png" alt="" />
                   </div>
               </div>
               <!-- Cursos Item 5-->
               <div class="col-md-6 col-lg-4 mb-5 mb-md-0">
                   <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal5">
                       <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                           <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                       </div>
                       <img class="img-fluid" src="Curso-maven.png" alt="" />
                   </div>
               </div>
               <!-- Cursos Item 6-->
               <div class="col-md-6 col-lg-4">
                   <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal6">
                       <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                           <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                       </div>
                       <img class="img-fluid" src="Curso-mongodb.png" alt="" />
                   </div>
               </div>
           </div>
       </div>
   </section>

	<!-- About Section-->
    <section class="page-section bg-primary text-white mb-0" id="about">
        <div class="container">
            <!-- About Section Heading-->
            <h2 class="page-section-heading text-center text-uppercase text-white">Acerca de</h2>
            <!-- Icon Divider-->
            <div class="divider-custom divider-light">
                <div class="divider-custom-line"></div>
                <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                <div class="divider-custom-line"></div>
            </div>
            <!-- About Section Content-->
            <div class="row">
                <div class="col-lg-4 ml-auto"><p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper mollis euismod. Vestibulum sed tellus blandit, accumsan augue ac, pharetra lorem. Nullam malesuada tristique aliquam.</p></div>
                <div class="col-lg-4 mr-auto"><p class="lead">Vivamus pharetra felis lectus, ac pharetra dolor finibus id. Proin ac convallis eros. Aliquam ac malesuada purus.</p></div>
            </div>
        </div>
    </section>
    
    
    <!-- Contact Section-->
     <section class="page-section" id="contact">
         <div class="container">
             <!-- Contact Section Heading-->
             <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Contacto</h2>
             <!-- Icon Divider-->
             <div class="divider-custom">
                 <div class="divider-custom-line"></div>
                 <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                 <div class="divider-custom-line"></div>
             </div>
             <!-- Contact Section Form-->
             <div class="row">
                 <div class="col-lg-8 mx-auto">
                     <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19.-->
                     <form id="contactForm" name="sentMessage" novalidate="novalidate">
                         <div class="control-group">
                             <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                 <label>Name</label><input class="form-control" id="name" type="text" placeholder="Name" required="required" data-validation-required-message="Please enter your name." />
                                 <p class="help-block text-danger"></p>
                             </div>
                         </div>
                         <div class="control-group">
                             <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                 <label>Email Address</label><input class="form-control" id="email" type="email" placeholder="Email Address" required="required" data-validation-required-message="Please enter your email address." />
                                 <p class="help-block text-danger"></p>
                             </div>
                         </div>
                         <div class="control-group">
                             <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                 <label>Phone Number</label><input class="form-control" id="phone" type="tel" placeholder="Phone Number" required="required" data-validation-required-message="Please enter your phone number." />
                                 <p class="help-block text-danger"></p>
                             </div>
                         </div>
                         <div class="control-group">
                             <div class="form-group floating-label-form-group controls mb-0 pb-2">
                                 <label>Message</label><textarea class="form-control" id="message" rows="5" placeholder="Message" required="required" data-validation-required-message="Please enter a message."></textarea>
                                 <p class="help-block text-danger"></p>
                             </div>
                         </div>
                         <br />
                         <div id="success"></div>
                         <div class="form-group"><button class="btn btn-primary btn-xl" id="sendMessageButton" type="submit">Send</button></div>
                     </form>
                 </div>
             </div>
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
        <div class="container"><small>© 2020 Copyright: Patricia Lamadrid</small></div>
    </section>
    
    
   <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes)-->
   <div class="scroll-to-top d-lg-none position-fixed">
       <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top"><i class="fa fa-chevron-up"></i></a>
   </div>
   
	
	<!-- Bootstrap core JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <!-- Third party plugin JS-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
    <!-- Contact form JS-->
    <script src="assets/mail/jqBootstrapValidation.js"></script>
    <script src="assets/mail/contact_me.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
  </body>
  
</html>
