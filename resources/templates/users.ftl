<!DOCTYPE html>
<html lang="en">
<head>
	<title>SIGNUP Form</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="static/form/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/css/util.css">
	<link rel="stylesheet" type="text/css" href="static/form/css/main.css">
	<link rel="stylesheet" type="text/css" href="static/form/css/table.css">
<!--===============================================================================================-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!--===============================================================================================-->
</head>
<body>
	<div class="container-contact100">
		<div class="contact100-form2">
				<span class="contact100-form-title">
					ALL USERS
				</span>
        	<div class="table-header">
        		<div style="overflow-y:auto;">
            		<table class="content-table tb-color">
                		<thead>
                    		<tr class="bg-primary">
                        		<th>USERNAME</th>
                        		<th>FIRST NAME</th>
                        		<th>LAST NAME</th>
                        		<th>ADDRESS</th>
                        		<th>ROLE</th>
                        		<th>PASSWORD</th>

                    		</tr>
                		</thead>
                		<#if users??>
						<tbody>
						<#list users as users>
                    		<tr>
                        		<td>${users.userId}</td>
                        		<td>${users.firstname}</td>
                        		<td>${users.lastname}</td>
                        		<td>${users.address}</td>
                        		<td>${users.role}</td>
                        		<td>${users.password}</td>
                    		</tr>
                    	</#list>
                		</tbody>
                		</#if>
            		</table>
				</div>
        	</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
