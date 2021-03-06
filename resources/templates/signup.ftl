<!DOCTYPE html>
<html lang="en">
<head>
	<title>Signup Form</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="static/form/image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="static/form/css/util.css">
	<link rel="stylesheet" type="text/css" href="static/form/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<form method="post" action="/create" class="contact100-form validate-form">
				<span class="contact100-form-title">
					Signup
				</span>
                    <#if error??>
                        <h5 class="errorColor">${error}<br><br></h5>
                    </#if>

				<div class="wrap-input100 validate-input" data-validate="Username is required">
					<input class="input100" id="username" type="text" name="username" placeholder="Username: ">
				</div>

				<div class="wrap-input100 validate-input" data-validate="First Name is required">
					<input class="input100" id="firstname" type="text" name="firstname" placeholder="First Name: ">
				</div>

				<div class="wrap-input100 validate-input" data-validate="Last Name is required">
					<input class="input100" id="lastname" type="text" name="lastname" placeholder="Last Name: ">
				</div>

				<div class="wrap-input100 validate-input" data-validate="Address is required">
					<input class="input100" id="address" type="text" name="address" placeholder="Address: ">
				</div>

				<div class="wrap-input100 validate-input" data-validate="Role is required">
                     <select class="input100" id="role" type="text" name="role" required>
                       <option selected disabled value="">Select Role</option>
                       <option value="admin">Admin</option>
                       <option value="member">Member</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Password is required">
					<input class="input100" id="password" type="password" name="password" placeholder="Password">
				</div>

				<div class="wrap-input100 validate-input" data-validate = "Confirm Password is required">
					<input class="input100" id="confirmpassword" type="password" name="confirmpassword" placeholder="Confirm Password: ">
				</div>

				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							Create
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</htm>