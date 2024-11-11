
<?php
session_start();

$miss="";
$uname=$_SESSION['username'];
$mess="";
$result="";
$conn = mysqli_connect("localhost", "root", "", "login");    
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}


if (count($_POST)>0)
 {
	$dpt=$_POST['dpt'];
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

    $ab123="select uname from login where uname>0";
    $result1=mysqli_query($conn, $ab123);
    $asklog=mysqli_fetch_array($result1);

	$sql1="select * from info";
    $result2=mysqli_query($conn, $sql1);
	$askk=mysqli_fetch_array($result2);


        $sql = "INSERT INTO info(rollno, name, mail, year,dpt, phone, color, address, mname, model, price, imei) VALUES('".$rollno."','$name','".$mail."','".$year."','".$dpt."','$phone','".$color."','".$address."','".$mname."','".$model."','".$price."','".$imei."')";
        $result = mysqli_query($conn, $sql);
		if(!$asklog=$askk)
		{
			$miss="Login and Roll no mismatch";

		}
		else
		{
    if ($result === true) {
        $mess="New record created successfully";
		header("Location:shome.php");
    } else {
        $mess="Not Inserted";
    }
}
	
}

mysqli_close($conn);
?>    <!DOCTYPE html>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v5.8.9, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.8.9, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>Sregister</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap"></noscript>
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">

  
  
  
  <script>
			function validate(){
				var email = ValidateEmail(document.getElementById("email"));
				var phone = phonenumber(document.getElementById("phone")); 
				var price = phonenumber(document.getElementById("price")); 
				var name = name( document.getElementById("name"));
				if(!name){
					document.getElementById("name").focus();
					var alert_v = alert("Invaid Name");
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
					alert("Please enter below 7 digits");
					document.getElementById("price").focus();
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
		  
		  <style>
      @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,700;1,300&display=swap');
      *{
        font-family: 'Poppins', sans-serif;
      }  
      </style> 
</head>
<body>
  
  <section data-bs-version="5.1" class="menu menu3 cid-tDap51qWWn" once="menu" id="menu3-2n">
    
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

<section data-bs-version="5.1" class="form6 cid-tDas6QtE0j" id="form6-2p">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Enter Your Mobile Details</strong>
            </h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" style="background-color: azure;" data-form-type="formoid">
                <form  method="POST" class="mbr-form form-with-styler mx-auto" onsubmit="return validate()"  data-form-title="Form Name"><input type="hidden" name="email" data-form-email="true" value="JlCM9ee2JGarfxFz0kNF6D9l+lTdIND1Hx1mY9JexLbRfODjxlbkCDbPDmYbS2rX1iknrGoVq+bxR9OhMc3AQkmI0B0nMGxvv0aSCQcr+QU2ILJzOKKBJE32T+xQ6eiu">
                    <div class="row">
                        <div hidden="hidden" data-form-alert="" class="alert alert-success col-12">Thanks for filling out the form!</div>
                        <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                            Oops...! some problem!
                        </div>
                    </div>
                    <div class="dragArea row">
                        <div class="col-lg-12 col-md-12 col-sm-12 form-group mb-3" data-for="name">
                        <label style="color:#f40a0a">
				<?php
				echo $miss;
				echo $mess;
				?>
			</label><br>
			
		
				<label for="name">Name:</label><br>
					<input type="text" class="form-control" name="name" placeholder="Alex" required><br>
					<label for="rollno">RollNo:</label><br>
					<input type="text" class="form-control" name="rollno" readonly placeholder="<?php echo $uname ?>"><br>
			<label for="year">Year:</label><br>
		<select name="year" class="form-control">
			<option value="1st Year">1st year</option>
			<option value="2nd Year">2nd year</option>
			<option value="3rd Year">3rd year</option>
		</select><br>
		<label for="dpt">Department:</label><br>
		<input type="text"placeholder="CA"  class="form-control" name="dpt"></br>
			<label for="email">Email:</label><br>
				<input type="email" class="form-control" name="email" placeholder="abcd123@gmail.com" required><br>
			<label for="phone">Phone:</label><br>
				<input type="number" class="form-control" name="phone" maxlength="10" minlength="10"  placeholder="1234567890">	<br>
		<label for="address">Address:</label><br>
		<input type="text" class="form-control" name="address" required placeholder="village ,district"><br>
	<label for="mname">Mobile Name:</label><br>
		<select name="mname" class="form-control" required><br>
			<option value="Vivo">Vivo</option><br>
			<option value="Samsung">Samsung</option>
			<option value="Realme">Realme</option>
			<option value="Redmi">Redmi</option>
			<option value="Moto">Moto</option>
			<option value="Iqoo">Iqoo</option>
			<option value="Apple">Apple</option>

		</select><br>
		 <label for="color">Color </label><br>
			<select name="color" class="form-control"><br>
				<option value="Black">Black</option>
				<option value="White">White</option>
				<option value="Blue">Blue</option>
				<option value="Green">Green</option>
				<option value="Rainbow">Rainbow</option>
				<option value="Red">Red</option>
				<option value="Violet">Violet</option>
				<option value="Grey">Grey</option>
			</select><br>
		<label for="model">Model Name</label><br>
		<input type="text" class="form-control" name="model" placeholder="x80"/><br>
		<label for="price">Price</label><br>
		<input type="number" class="form-control" maxlength="7" minlength="4"  name="price" placeholder="Below 7 Numbers"/><br>
		<label for="imei">IMEI Number:</label><br>
		<input type="text" class="form-control" name="imei"  maxlength="15" minlength="15" required><br>
		
	</div> 
	 

 </div>
			
		
                        </div>
					
                    </div><center>
					<input type="submit" class="btn btn-primary" value="Submit"> 
	<input type="reset" class="btn btn-primary" value="Clear">
	</center>
                </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxD7l0vaG" once="footers" id="footer7-34">

    

    

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