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

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <div class="list-group">
                    <a href="#" class="list-group-item active" onclick="company.list()">Companies</a>
                    <a href="#" class="list-group-item" onclick="route.list()">Routes</a>
                    <a href="#" class="list-group-item" onclick="ticket.list()">Ticket</a>
                    <a href="#" class="list-group-item " onclick="trip.list()">Trip</a>
                    <a href="#" class="list-group-item " onclick="tripLocation.list()">Locations</a>
                    <a href="#" class="list-group-item " onclick="passenger.list()">Passenger</a>
                    <a href="#" class="list-group-item " onclick="vehicle.list()">Vehicle</a>
                </div>
            </div>

            <div class="col-md-9">
            
                <div class="well" id="ajax-content">

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; 2016</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <script src="js/app/company.js"></script>
    <script src="js/app/ticket.js"></script>
    <script src="js/app/location.js"></script>
    <script src="js/app/vehicle.js"></script>
    <script src="js/app/route.js"></script>
    <script src="js/app/trip.js"></script>
    <script src="js/app/passenger.js"></script>
    
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
