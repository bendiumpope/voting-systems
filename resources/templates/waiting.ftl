<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SIGNUP Form</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/css/util.css">
	<link rel="stylesheet" type="text/css" href="static/form/css/main.css">
	<link rel="stylesheet" type="text/css" href="static/form/css/table.css">
	<link rel="stylesheet" type="text/css" href="static/timer/timer.css">
<!--===============================================================================================-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!--===============================================================================================-->
</head>
<body>
    <div class="container-contact100 d-flex flex-column justify-center align-items-center">
        <div class="contact100-form2">
			<span class="contact100-form-title">
				THANKS FOR VOTING, RESULTS WILL BE OUT SOON!!!
			</span>
			<p>Please note that you can only vote once. If you vote more than once only your first vote is counted</p>

            <p id="days"></p>
            <p id="hours"></p>
            <p id="mins"></p>
            <p id="secs"></p>
            <h2 id="end"></h2>
		</div>
        <div class="contact100-form2 d-flex flex-column justify-center align-items-center">
			<span class="contact100-form-title">
				Please Refresh Your browser at the end
				of the count down and click on the RESULT button
         		</div>
		<div class="d-flex flex-row justify-center align-items-center">
		    <button class="btn btn-warning">
               </h4><a href="/finishedresult">RESULT</a></h4>
            </button>
            <button class="btn btn-warning ml-3">
               </h4><a href="/logout">Signout</a></h4>
            </button>
        </div>
    </div>
    <script src="static/timer/timerwaiting.js">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
