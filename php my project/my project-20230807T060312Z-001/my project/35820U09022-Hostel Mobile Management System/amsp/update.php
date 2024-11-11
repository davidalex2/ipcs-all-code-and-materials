
<?php
session_start();

$uname=$_SESSION['username'];

$mess="";
$conn = mysqli_connect("localhost", "root", "", "login");
if (!$conn) {
    $mess="Connection error";
	exit();
}

if(!$r=0){
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $rollno = $uname;
        $name = $_POST["name"];
        $mail=$_POST["email"];
        $year = $_POST["year"];
        $phone = $_POST["phone"];
        $address = $_POST["address"];
        $mname = $_POST["mname"];
        $color=$_POST["color"];
        $model = $_POST["model"];
        $price = $_POST["price"];
        $imei = $_POST["imei"];
    
        $sql = "UPDATE info set rollno='$rollno' , name='$name', mail='$mail',year='$year', phone='$phone', color='$color', address='$address', mname='$mname', model='$model', price='$price', imei='$imei' where rollno='$uname'";
        $result = mysqli_query($conn, $sql);
    
        if ($result === TRUE) {
            $mess="Record updated successfully";
			
          } else {
            $mess="Error";
          }

}

mysqli_close($conn);
    }
 ?>   
<!DOCTYPE html>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v5.8.9, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.8.9, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>Supdate</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap"></noscript>
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">

    
  <style>
      @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,700;1,300&display=swap');
      *{
        font-family: 'Poppins', sans-serif;
      }  
      </style> 
  <script>
			function validate(){
				var email = ValidateEmail(document.getElementById("email"));
				var phone = phonenumber(document.getElementById("phone")); 
				var name = name( document.getElementById("name"));
				if(!name){
					document.getElementById("name").focus();
					var alert_v = alert("Invaid First Name");
					return false;
					
				}
				
				else if(!email){
					alert("Invalid Email");
					document.getElementById("email").focus();
					return false;
				}
				else if(!phone){
					alert("Invalid Phone Number");
					document.getElementById("phone").focus();
					return false;
				}
				else if(!price){
					alert("Invalid Phone Number");
					document.getElementById("phone").focus();
					return false;
				}
				else{
					if(email && phone && name && price){
						alert("Message Sent");
						return true;
					}
					else{
						return false;
				}
			}
				
			}
			function phonenumber(inputtxt)
				{
				var phoneno = /^\d{10}$/;
				if(inputtxt.value.match(phoneno))
					{
					return true;
					}
					else
						{
						return false;
						}
				}
				function price(inputtxt)
				{
				var phoneno = /^\d{7}$/;
				if(inputtxt.value.match(phoneno))
					{
					return true;
					}
					else
						{
						return false;
						}
				}
			function name(inputtxt){
				var regName = /^[a-zA-Z]+$/;
				if(inputtxt.value.match(regName)){
					return true;
				}else{
					return false; 
				}
			}
			function ValidateEmail(inputText)
						{
						var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
						if(inputText.value.match(mailformat))
						{
								return true;
						}
						else
						{
								return false;
						}
						}
		</script>
  
</head>
<body>
  
  <section data-bs-version="5.1" class="menu menu3 cid-tDap51qWWn" once="menu" id="menu3-2q">
    
    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container">
		<div class="navbar-brand">
               
               <span class="navbar-caption-wrap"><a class="navbar-caption text-black display-7"><?php echo $uname ?></a></span>
           </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-bs-toggle="collapse" data-target="#navbarSupportedContent" data-bs-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <div class="hamburger">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true">
                <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="shome.php">Home</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="sregister.php">Register</a></li>
                <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="update.php">Update</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="srequest.php">Request</a>
                    </li><li class="nav-item"><a class="nav-link link text-black display-4" href="index.php">Logout</a></li></ul>
               <div class="icons-menu">
                    <a class="iconfont-wrapper" href="https://www.facebook.com/login/" target="_blank">
                        <span class="p-2 mbr-iconfont socicon-facebook socicon"></span>
                    </a>
                    <a class="iconfont-wrapper" href="https://twitter.com/i/flow/login" target="_blank">
                        <span class="p-2 mbr-iconfont socicon-twitter socicon"></span>
                    </a>
                    <a class="iconfont-wrapper" href="https://www.instagram.com/" target="_blank">
                        <span class="p-2 mbr-iconfont socicon-instagram socicon"></span>
                    </a>
                    
                </div>
                
            </div>
        </div>
    </nav>
</section>

<section data-bs-version="5.1" class="form7 cid-tDauEAe4er" id="form7-2t">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Update your details</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" style="background-color: azure;" data-form-type="formoid">
                <form  method="POST" onsubmit="return validate()" class="mbr-form form-with-styler mx-auto" data-form-title="Form Name" style="background-color: azure;" onsubmit="return validate()"><input type="hidden" name="email" data-form-email="true" value="7tQsm9Je/5StDDznseIhzbNE5mbdr7gyN2PVYYgxp/FjPjRg9I9yngGCAwSTZRmOmWisonVewDRX0uqvvFahkYa7jKVrcPaBUplGkFM14XHaJAZMbTAOmokZsvACfkZn">
              
                    <div class="row">
                        <div hidden="hidden" data-form-alert="" class="alert alert-success col-12">Thanks for filling out the form!</div>
                        <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                            Oops...! some problem!
                        </div>
                    </div>
                    <div class="dragArea row">
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group mb-3" data-for="name">
                        <label><?php echo $mess ?></label><br>
				<label for="name">Name:</label><br>
					<input type="text"  name="name" class="form-control" required placeholder="Alex" required><br>
					<label for="rollno">RollNo:</label><br>
					<input type="" class="form-control" name="rollno" readonly placeholder="<?php echo $uname ?>"><br>
			<label for="year">Year:</label><br>
		<select name="year"class="form-control" required>
			<option value="1st Year">1st year</option>
			<option value="2nd Year">2nd year</option>
			<option value="3rd Year">3rd year</option>
		</select><br>
		<label for="dpt">Department</label>
		<input type="text" name="dpt" placeholder="CA" class="form-control" required><br>
			<label for="email" >Email:</label><br>
				<input type="email" class="form-control" name="email" placeholder="abcd123@gmail.com" required><br>
			<label for="phone" >Phone:</label><br>
				<input type="text" class="form-control" name="phone" maxlength="10" minlength="10" required placeholder="1234567890">	<br>
		<label for="address" >Address:</label><br>
		<input type="text" class="form-control" name="address" required placeholder="village ,district"><br>
	<label for="mname" >Mobile Name:</label><br>
		<select name="mname" class="form-control" required><br>
			<option value="Vivo">Vivo</option><br>
			<option value="Samsung">Samsung</option>
			<option value="Realme">Realme</option>
			<option value="Redmi">Redmi</option>
			<option value="Moto">Moto</option>
			<option value="Iqoo">Iqoo</option>
			<option value="Apple">Apple</option>
		</select><br>
		 <label for="color" >Color </label><br>
			<select name="color" class="form-control" required><br>
				<option value="Black">Black</option>
				<option value="White">White</option>
				<option value="Blue">Blue</option>
				<option value="Green">Green</option>
				<option value="Rainbow">Rainbow</option>
				<option value="Red">Red</option>
				<option value="Violet">Violet</option>
				<option value="Grey">Grey</option>
			</select><br>
		<label for="model" >Model Name</label><br>
		<input type="text" class="form-control" name="model" placeholder="x80" required/><br>
		<label for="price">Price</label><br>
		<input type="number" class="form-control" maxlength="7" name="price" required/><br>
		<label for="imei">IMEI Number:</label><br>
		<input type="text" class="form-control" name="imei"  maxlength="15" minlength="15" required><br>
		
		
	
	</div>
	

</div>
					</div>
		</div>
		<center>
		<input type="submit" class="btn btn-primary"  value="Update"> 
		<input type="reset"  class="btn btn-primary"  value="Clear">
					</center>					 

                </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxD0QrFSF" once="footers" id="footer7-33">

    

    

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="col-12">
                <p class="mbr-text mb-0 mbr-fonts-style display-7">
                    © Copyright 2023 David Alex - All Rights Reserved
                </p>
            </div>
        </div>
    </div>
</section>
  
</body>
</html>