<?php
session_start();
$err="";
$_SESSION['username']="";
$_SESSION['login'] = false;
$conn = mysqli_connect("localhost", "root", "", "login");   
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
if(isset($_POST['submit'])) {
    // Process login formj
    if (count($_POST)>0) {
        $username = $_POST["username"];
        $password = $_POST["password"];
		$_SESSION['username']=$username;
//$status=$_POST["status"];
        $sql = "SELECT * FROM login WHERE uname='$username' AND pwd='$password'";
        $result = mysqli_query($conn, $sql);
		$resval = $result->fetch_assoc();
       
		$sql1="SELECT * from info where rollno='$username'";
		$result1=mysqli_query($conn,$sql1);

if(mysqli_num_rows($result) == 1 && $resval["status"] == "admin") 
{
        $_SESSION['login'] = true;
        header("Location: admin.php");
        exit();
    }

	else if(mysqli_num_rows($result) == 1 && $resval["status"] == "student"){
			$rs = mysqli_query($conn,"select * from info");
			if(mysqli_num_rows($result1)==0){
				header("Location: sregister.php");
				exit();	
		}	
			else if(mysqli_num_rows($result1)==1){
				$_SESSION['login'] = true;
				header("Location: shome.php");
            	exit();
			}
			
			
		}
		
		else {      
            $err="Invalid username or password!!";
        }
    }
		
		
    
}
?>  
<!DOCTYPE html>
<html>
<head>
	<title>Login Form</title>
	<style>
		 @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,700;1,300&display=swap');
      *{
        font-family: 'Poppins', sans-serif;
      } 
		body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background-image: url("PhoneIndex.jpg");
			background-color: bisque;
	background-size: cover;


	
}
fieldset{
	        border-radius:25px;
	        background-color:silver;
	    }
.login-box {
	width: 280px;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%,-50%);
	color: white;
}
.login-box h2 {
	text-align: center;
	margin-bottom: 40px;
}
.login-box .user-box {
	position: relative;
}
.login-box .user-box input {
	width: 100%;
	padding: 10px 0;
	font-size: 16px;
	color: black;
	margin-bottom: 30px;
	border: none;
	border-bottom: 1px solid blue;
	outline: none;
	background: transparent;
}
.login-box .user-box label {
	position: absolute;
	top: 0;
	left: 0;
	padding: 10px 0;
	font-size: 16px;
	color: black;
	pointer-events: none;
	transition: .5s;
}
.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
	top: -20px;
	left: 0;
	color: #03a9f4;
	font-size: 12px;
}
.login-box .err-box input[type="text"] {
	color:silver;
	border:none;
	background-color: silver;

}

.login-box input[type="submit"] {
	background: transparent;
	border: none;
	outline: none;
	color: black;
	background: #03a9f4;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
	margin-bottom: 30px;
}
input:invalid{
	border: 2px solid red;
	animation: shake 0.2s 2;
	color: red;
}
@keyframes shake{
	25%
	{
		translate: 6px 0;

	}
	50%{
		translate: -6px 0;
	}
	75%
	{
		translate: 6px 0;
	}
}

	</style>
	
</head>
<body><center>
	<h1 style="background-color: pink;font-size: 30px;">Hostel Mobile Management System(PDH)</h1>
	<div class="login-box">
		<fieldset>
		<h2>Login Form</h2>
		<form action="" method="post" onsubmit="">
			<div class="user-box">
				<input type="text" name="username" pattern="[A-Za-z1-0]*" required="">
				<label>Username</label>
			</div>
			<div class="user-box">
				<input type="password" name="password" required="">
				<label>Password</label>
			</div> 
			<div class="err-box">
				<label >
					<?php
						echo "<p style=color:black>$err</p>";
					?>				
				</label>
			</div>
			<input type="submit" name="submit" value="Submit">
		</form>
	</fieldset>
	</div>
</center>
</body>
</html>