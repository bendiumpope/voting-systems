<!DOCTYPE html>
<html lang="en">
<head>
	<title>Voting Form</title>
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
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!--===============================================================================================-->
</head>
<body>
	<div class="container-contact100">
		<div class="wrap-contact100">
			<form method="post" action="/votingpage" class="contact100-form validate-form">
                    <input type="hidden" name="date" value="${date?c}" />
                    <input type="hidden" name="code" value="${code}" />
                    <input type="hidden" name="action" value="add">
				<span class="contact100-form-title">
					VOTING FORM  		<div class="">
                                             <button class="btn btn-warning">
                                                </h4><a href="/logout">Signout</a></h4>
                                             </button>
                                         </div>
				</span>
                    <#if error??>
                        <h5 class="errorColor">${error}<br><br></h5>
                    </#if>

				<div class="wrap-input100 validate-input" data-validate="President is required">
                     <select class="input100" id="president" type="text" name="president" required>
                       <option selected disabled value="">PRESIDENT</option>
                       <option value="DR-CHIYEM-ROLLINS-IYADI">DR. CHIYEM ROLLINS IYADI</option>
                       <option value="EMEKE-IJEBOR">EMEKE IJEBOR</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="General Secretary is required">
                     <select class="input100" id="generalsec" type="text" name="generalsec" required>
                       <option selected disabled value="">GENERAL SECRETARY</option>
                       <option value="LUCKY-ADAGBON">LUCKY ADAGBON</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Assistant General Secretary is required">
                     <select class="input100" id="assistgensec" type="text" name="assistgensec" required>
                       <option selected disabled value="">ASSISTANT GENERAL SECRETARY</option>
                       <option value="EYEMONU-ONYEISI">MR ENYEMONU ONYEISI</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Financial Secretary is required">
                     <select class="input100" id="financialsec" type="text" name="financialsec" required>
                       <option selected disabled value="">FINANCIAL SECRETARY</option>
                       <option value="ASUDIKE-TITUS">ASUDIKE TITUS</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Treasurer is required">
                     <select class="input100" id="treasurer" type="text" name="treasurer" required>
                       <option selected disabled value="">TREASURER</option>
                       <option value="QUEEN-ESAU-AGADAGIDI">QUEEN-ESAU-AGADAGIDI</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Social Public Secretary is required">
                     <select class="input100" id="socialpubsec" type="text" name="socialpubsec" required>
                       <option selected disabled value="">SOCIAL PUBLIC SECRETARY</option>
                       <option value="MICHAEL-UGBECHIE">MICHAEL UGBECHIE</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Provost is required">
                     <select class="input100" id="provost" type="text" name="provost" required>
                       <option selected disabled value="">PROVOST</option>
                       <option value="PRECIOUS-EBUNDON">PRECIOUS EBUNDON</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Diasporal Africa is required">
                     <select class="input100" id="diasporalafrica" type="text" name="diasporalafrica" required>
                       <option selected disabled value="">DIASPORAL AFRICA</option>
                       <option value="CLETUS-UYANWANNE">CLETUS UYANWANNE</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Diasporal Europe is required">
                     <select class="input100" id="diasporaleurop" type="text" name="diasporaleurop" required>
                       <option selected disabled value="">DIASPORAL EUROPE</option>
                       <option value="OBIAZIKWOR-EGBEDE">OBIAZIKWOR EGBEDE</option>
                     </select>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Diasporal UK is required">
                     <select class="input100" id="diasporaluk" type="text" name="diasporaluk" required>
                       <option selected disabled value="">DIASPORAL UK</option>
                       <option value="EMEKE-EMEKIHIA">EMEKE EMEKIHIA</option>
                     </select>
				</div>
				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn">
							Vote
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</htm>