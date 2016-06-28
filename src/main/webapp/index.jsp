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
	<link href="css/datepicker3.min.css" rel="stylesheet">
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
                    <a href="#" class="list-group-item" onclick="viewbookings()">Tickets</a>
                    <a href="ticket/index.jsp" target="_blank" class="list-group-item">Customer Zone</a>

                    <a href="#" class="list-group-item active" onclick="list.company()">Companies</a>
                    <a href="#" class="list-group-item" onclick="list.route()">Routes</a>
                    <a href="#" class="list-group-item" onclick="ticketCompanies()">Ticket</a>

                    <a href="#" class="list-group-item " onclick="trip.list()">Trip</a>
                    <a href="#" class="list-group-item " onclick="tripLocation.list()">Locations</a>
                    <a href="#" class="list-group-item  glyphicon glyphicon-user" onclick="passenger.list()"> Passenger</a>
                    <a href="#" class="list-group-item " onclick="vehicle.list()">Vehicle</a>
                    <a href="#" class="list-group-item " onclick="person.list()">Persons</a>
                   

                    <a href="#" class="list-group-item " onclick="parcel.list()">Parcel</a>

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

	<script src="js/app/base.app.js"></script>
    <script src="js/app/company.js"></script>
    <script src="js/app/ticket.js"></script>
    <script src="js/app/location.js"></script>
    <script src="js/app/vehicle.js"></script>
    <script src="js/app/route.js"></script>
    <script src="js/app/trip.js"></script>
    <script src="js/app/passenger.js"></script>


    <script src="js/app/person.js"></script>

    <script src="js/app/parcel.js"></script>


    <script src="js/app/person.js"></script>

    <script src="js/app/parcel.js"></script>

    
    <!-- jQuery -->
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap-datepicker.min.js"></script>
    
	
	
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
    
    <script>
		$(document).ready(function(){
			var date_input=$('input[name="dateofpayment"]'); //our date input has the name "date"
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'yyyy-mm-dd',
				container: container,
				todayHighlight: true,
				autoclose: true,
			})
		})
	</script>
	
	<script>
		$(document).ready(function(){
			var date_input=$('input[name="travelDate"]'); //our date input has the name "date"
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'yyyy-mm-dd',
				container: container,
				todayHighlight: true,
				autoclose: true,
			})
		})
	</script>

</body>

</html>
