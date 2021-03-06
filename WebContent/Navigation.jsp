<% if (session.getAttribute("user") != null) { 
		%>
		<!-- Navigation-->
	    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
	        <div class="container">
	            <a class="navbar-brand js-scroll-trigger" href="Home.jsp#page-top"><img src="logoo.jpeg" alt="logo" height="60px;"></a><button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
	            <div class="collapse navbar-collapse" id="navbarResponsive">
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Cursos.jsp">Cursos</a></li>
	                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Home.jsp#about">Acerca de</a></li>
	                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Home.jsp#contact">Contacto</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Home.jsp#contact">Bienvenido ${sessionScope.user}</a></li>
	                    <form action="Logout" method="post">
	                    	<div class="form-group"><button class="btn btn-primary btn-xl" id="sendMessageButton" type="submit">Logout</button></div>
	                    </form>
	                </ul>
	            </div>
	        </div>
	    </nav>
		<% } else { 
		%>
		<!-- Navigation-->
	    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
	        <div class="container">
	            <a class="navbar-brand js-scroll-trigger" href="#page-top"><img src="logoo.jpeg" alt="logo" height="60px;"></a><button class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">Menu <i class="fas fa-bars"></i></button>
	            <div class="collapse navbar-collapse" id="navbarResponsive">
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Cursos.jsp">Cursos</a></li>
	                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Home.jsp#about">Acerca de</a></li>
	                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Home.jsp#contact">Contacto</a></li>
	                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="Login.html">Login</a></li>
	                </ul>
	            </div>
	        </div>
	    </nav>
	    <% }  %>