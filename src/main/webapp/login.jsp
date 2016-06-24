<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Welcome to TripTicket</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="css/shop-item.css" rel="stylesheet">
	
	<link href="css/login.css" rel="stylesheet">
</head>

<body>

   <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">TripTicket</a>
            </div>
        </div>
        <!-- /.container -->
    </nav>

<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="${pageContext.request.contextPath}/welcome" method="post" role="form" style="display: block;">
								<!-- action = ${pageContext.request.contextPath}/welcome -->
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" 
												id="login-submit" tabindex="4" class="form-control btn btn-register" value="Login">
											
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a tabindex="5" class="forgot-password">Forgot Password?</a>
													<br>
													<div id="login-ajax-content" class="well" style="background-color: #FFF; border: 0px">
										               
										
										            </div>
										            
													
												</div>
											</div>
										</div>
									</div>
								</form>
								<form id="register-form" action="#" method="post" role="form" style="display: none;">
									<div class="form-group">
										<input type="text" name="fname" required id="regfname" tabindex="1" class="form-control" placeholder="First Name" value="">
									</div>
									<div class="form-group">
										<input type="email" name="lname" required id="reglname" tabindex="1" class="form-control" placeholder="Last Name" value="">
									</div>
									<div class="form-group">
										<input type="text" name="id" required id="regid" tabindex="1" class="form-control" placeholder="ID/Passport" value="">
									</div>
									<div class="form-group">
										<input type="text" name="username" required id="regusername" tabindex="1" class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" required id="regpassword" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group">
										<input type="password" name="confpass" required id="regconfirmpass" tabindex="2" class="form-control" placeholder="Confirm Password">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<!-- <input type="submit" name="register-submit" 
												id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">-->
												<a class="form-control btn btn-register"  onclick="person.save()">Register Now</a>
											</div>
											
											<div id="register-ajax-content" class="well col-sm-6 col-sm-offset-3" style="background-color: #FFF; border: 0px">
										               
										
										    </div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
     <script src="js/app/person.js"></script>
    
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/login.js"></script>
	
</body>

</html>