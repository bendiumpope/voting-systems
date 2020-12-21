<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

		<title>Saint Dominics</title>

		<!-- Loading third party fonts -->
		<link href="static/result/fonts/novecento-font/novecento-font.css" rel="stylesheet" type="text/css">
		<link href="static/result/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <!--===============================================================================================-->

		<!-- Loading main css file -->
		<link rel="stylesheet" href="static/result/css/style.css">

		<!--[if lt IE 9]>
		<script src="static/result/js/ie-support/html5.js"></script>
		<script src="static/result/js/ie-support/respond.js"></script>
		<![endif]-->

	</head>


	<body>
		<div class="site-content">
			<header class="site-header">
				<div class="container">
					<div class="main-navigation">

					</div>

					<div class="mobile-navigation"></div>
				</div>
			</header> <!-- .site-header -->

			<div class="page-head" data-bg-image="static/result/images/page-head-1.jpg">
				<div class="container">
					<h2 class="page-title">ELECTION RESULTS</h2>
				</div>
			</div>

			<main class="main-content">
				<div class="fullwidth-block">
					<div class="container">
						<div class="row d-flex flex-column justify-content-center align-items-center">
							<div class="content col-md-8">
								<h2 class="section-title"></h2>
								<div class="row">

								<#list electionResults as election>
									<div class="family">
										<h2 class="family-name2">OFFICE: ${election.office}</h2>
										<h3 class="family-name">NAME: ${election.name}</h3>
										<h3 class="family-name">VOTES GOTTEN: ${election.votes_gotten}</h3>
										<h3 class="family-name">TOTAL VOTERS: ${election.total_voters}</h3>
										<h3 class="family-name">DID NOT VOTE: ${election.total_non_voters}</h3>
								    </div>
								</#list>

								</div>

							</div>
                            <button class="btn btn-warning">
                            </h4><a href="/logout">Signout</a></h4>
                            </button>
				        </div>
						</div>
					</div>
				</div>
			</main> <!-- .main-content -->
		</div>


		<script src="static/result/js/jquery-1.11.1.min.js"></script>
		<script src="static/result/js/plugins.js"></script>
		<script src="static/result/js/app.js"></script>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

	</body>

</html>