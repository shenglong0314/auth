<html>
<head>
<link rel="stylesheet" href="css/wro.css"/>
</head>
<body>
<div align="center">
	<div class="container" align="center" style="padding-top: 100px">
		<form role="form" action="login" method="post">
		  <div class="form-group">
		    <label for="username">Username:</label>
		    <input type="text" class="form-control" id="username" name="username"/>
		  </div>
		  <div class="form-group">
		    <label for="password">Password:</label>
		    <input type="password" class="form-control" id="password" name="password"/>
		  </div>
		  <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</div>
	<script src="js/wro.js" type="text/javascript"></script>
</body>
</html>