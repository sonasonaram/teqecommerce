<!DOCTYPE html>
<html>
<head>
<style>
body{
   font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
* {box-sizing: border-box}
input[type=text], input[type=password] {
   width: 100%;
   font-size: 28px;
   padding: 15px;
   margin: 5px 0 22px 0;
   display: inline-block;
   border: none;
   background: #f1f1f1;
}
label{
   font-size: 15px;
}
input[type=text]:focus, input[type=password]:focus {
   background-color: #ddd;
   outline: none;
}
hr {
   border: 1px solid #f1f1f1;
   margin-bottom: 25px;
}
button {
   font-size: 18px;
   font-weight: bold;
   background-color: rgb(10, 119, 13);
   color: white;
   padding: 14px 20px;
   margin: 8px 0;
   border: none;
   cursor: pointer;
   width: 100%;
   opacity: 0.9;
}
button:hover {
   opacity:1;
}
.cancel {
   padding: 14px 20px;
   background-color: #ff3d2f;
}
.formContainer {
   padding: 16px;
}
.formContainer p{
   font-size: 28px;
}
</style>
<body>
	<form method="post" action="signup">
		<div class="formContainer">
			<h1>Sign Up Form</h1>
			<hr>
			<label for="name"><b>Name</b></label>
			<input type="text" placeholder="Enter Name" name="name" required>
			<label for="email"><b>Email</b></label>
			<input type="text" placeholder="Enter Email" name="email" required>
			<label for="password"><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="pass" required>
			<label for="address"><b>Address</b></label>
			<input type="text" placeholder="Enter Address" name="address" required>
			<label for="isAdmin"><b>Sign Up as an Admin</b></label>
			Yes <input type="radio" name="isAdmin" value="yes">
			No <input type="radio" name="isAdmin" value="No" checked="checked">
			<button type="submit" class="signup">Sign Up</button>
		</div>
	</form>
	<br><br>
	<form method="post" action="login">
		<div class="formContainer">
			<h1>Sign In Form</h1>
			<hr>
			<label for="email"><b>Email</b></label>
			<input type="text" placeholder="Enter Email" name="email" required>
			<label for="password"><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="password" required>
			<button type="submit" class="signup">Sign In</button>
		</div>
	</form>
</body>
</html>