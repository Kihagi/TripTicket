<head>
<title>TripTicket | Customer Booking</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="SEARCH ENGINE OPTIMIZATION KEYWORDS" />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery.min.js"></script>

<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="../js/app/base.app.js"></script>
<script type="text/javascript" src="../js/app/ticket.js"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
<!--start-smoth-scrolling-->
<!--script-->
	<script src="js/modernizr.custom.97074.js"></script>
<script src="js/jquery.chocolat.js"></script>
		<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
		<!--light-box-files -->
		<script type="text/javascript" charset="utf-8">
		$(function() {
			$('.gallery a').Chocolat();
		});
		</script>
		<script type="text/javascript" src="js/jquery.hoverdir.js"></script>
		
		
<!-- load companies -->
<script>
(function(){
	ticketCompanies();
})();
</script>		
</head>
<body>

	<!--start-banner-->
	<div class="banner">
		<div class="container">
			<div class="header" id="home">
					<div class="head">
						<div class="logo">
							<a href="index-2.html"><img src="images/logo.png" alt="" /></a>
						</div>
						<div class="navigation">
							<span class="menu"></span> 
							<ul class="navig">
								<li><a href="index-2.html"  class="active hvr-bounce-to-bottom scroll">Home</a></li>
								<li><a href="#about" class="hvr-bounce-to-bottom scroll">About</a></li>
								<li><a href="#gallery" class="hvr-bounce-to-bottom scroll">Book Vehicle</a></li>
								<li><a href="#contact" class="hvr-bounce-to-bottom scroll">Contact</a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div>
			</div>	
			<div class="banner-bottom">
				<h1>Welcome to TripTicket</h1>
				<p>We provide bus booking services to you on a silver plate :-)</p>
			</div>
			<div class="bnr-btm">
				<a href="#auto" class="scroll"><img src="images/d-arw.png" alt=""></a>
			</div>
		</div>	
	</div>
	<!--end-banner-->
	<!--about-starts-->
	<div class="about" id="about">
		<div class="container">
			<div class="about-top heading">
				<h3>Instructions for Booking</h3>
			</div>
			
			<div class="about-bottom">
				<div class="col-md-6 about-left">
					<h4>Okay quit playing with the scissors and sit, and cut the crap I shouldn't have to rhyme these words in the rhythm for you to know it's a rap</h4>
					<p>You said you was king, you lied through your teeth, for that suck your fillings, instead of getting crowned you're getting capped And to the fans, I'll never let you down again, I'm back</p>
				</div>	
				<div class="col-md-6 about-right">
					<div class="abt-one">
						<div class="abt-left">
							<span class="glyphicon glyphicon-gift" aria-hidden="true"></span>
						</div>	
						<div class="abt-right">
							<p>I promise to never go back on that promise, in fact Let's be honest, that last "Relapse" CD was ehhh Perhaps I ran them accents into the ground</p>
						</div>	
						<div class="clearfix"></div>	
					</div>
					<div class="abt-one">
						<div class="abt-left">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</div>	
						<div class="abt-right">
							<p>Relax, I ain't going back to that now All I'm trying to say is get back, click-clack, blow Cause I ain't playing around. It's a game called circle and I don't know how, I'm way too up to back down But I think I'm still trying to figure this crap out</p>
						</div>	
						<div class="clearfix"></div>	
					</div>					
				</div>	
				<div class="clearfix"></div>	
			</div>
		</div>
	</div>	
	<!--about-end-->
	
	<!--gallery-starts-->
	<div class="gallery" id="gallery">
			<div class="gallery-top heading">
				<h3>Book Vehicle from Your Favority Company</h3>
			</div>
			<div class="gallery-bottom" id = "customer-zone">
			<section>
				
				<ul id="da-thumbs" class="da-thumbs">
					
					<div class="clearfix"> </div>
				</ul>
			</section>
			</div>	
		<script type="text/javascript">
			$(function() {
			
				$(' #da-thumbs > li ').each( function() { $(this).hoverdir(); } );

			});
		</script>
	</div>
	<!--gallery-end-->
	
	<!--contact-starts-->
	<div class="row">
	<div class="col-md-12 col-sm-12">
	<div class="contact" id="contact">
		<div class="container">
			<div class="about-top heading">
				<h3>Contact Us</h3>
				<hr><br><br>
			</div>
			
			<div class="contact-top">
				<div class="col-md-4 contact-left">
					<div class="add1">
						<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
						<p>TripTicket, Systech Meeting Room</p>
					</div>
					<div class="add1">
						<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
						<p>+254 701 203010</p>
					</div>
					<div class="add1">
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
						<p>Email: <a href="mailto:example@email.com">contact@tripticket.co.ck</a></p>
					</div>
				</div>	
				<div class="col-md-8 contact-right">
					<input type="text" value="Your name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your name';}">
			        <input type="text" value="Your mail" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Your mail';}">
					<textarea value="Your message" onfocus="if(this.value == 'Your message') this.value='';" onblur="if(this.value == '') this.value='Your message';">Your message</textarea><br>
			     	 <div class="submit">
			     	 	<input type="submit" value="Send Message">
			     	 </div>    
				</div>	
				<div class="clearfix"></div>	
			</div>
		</div>
	</div>
	</div>
	</div>
	<!--contact-end-->
	
	<!--footer-starts-->
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<a href="#"><img src="images/logo.png" alt="" ></a>
				<ul>
					<li><a href="#"><span class="fb"></span></a></li>
					<li><a href="#"><span class="twit"></span></a></li>
					<li><a href="#"><span class="google"></span></a></li>
					<li><a href="#"><span class="pin"></span></a></li>
				</ul>
				<p>© 2016 TripTicket. All Rights Reserved</p>
			</div>
		</div>
		<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
	<!--footer-end-->
</body>

</html>