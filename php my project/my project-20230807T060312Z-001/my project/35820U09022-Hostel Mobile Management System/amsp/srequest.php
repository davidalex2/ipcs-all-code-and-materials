<?php
session_start();
$mess="";
$_SESSION['username'];
$uname=$_SESSION['username'];
$conn = mysqli_connect("localhost", "root", "", "login");   
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
date_default_timezone_set('Asia/Kolkata');
  $date1=date("Y-m-d h:i:s",time());
if (count($_POST)>0) {
    $reason = $_POST["reason"];
    $explain1=$_POST["explain"];
    $sql="UPDATE info set reason='$reason', explain1='".$explain1."',request1='requested' where rollno='$uname'";
    $result=mysqli_query($conn,$sql);
    if ($result === true) {
        $mess="Requested successfully";
        
    } else {
        $mess="Not Inserted";
    }
}
mysqli_close($conn);
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
  
  
  <title>Srequest</title>
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
  
  
</head>
<body>
  
  <section data-bs-version="5.1" class="menu menu3 cid-tDaryqdJiQ" once="menu" id="menu3-2l">
    
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

<section data-bs-version="5.1" style="height: 100vh;" class="form5 cid-tDarFF3f3O" id="form5-2m">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Request for mobile</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" style="background-color: azure;" data-form-type="formoid">
                 <form action="" method="post">
            <div class="w-100" >
               <label><?php echo $mess ?></label><br>
                <label>Select the Reason:</label><br>
                <select name="reason" class="form-control" required id="reason">
                    <option value="To study">To study</option>
                    <option value="For online class">For Online Class</option>
                    <option value="To prepare for interview">To prepare for interview</option>
                    <option value="To prepare for gov exams">To prepare for gov exams</option>
                    <option value="Others">Others</option>
                </select><br>
                <label for="comment">Explain</label><br>
                <textarea required name="explain" class="form-control" row="5" id="comment"  placeholder="Explain the reason clearly"></textarea>
             
                
            </div>
    </div>
        </div>
        <center>
           <input type="submit" align="left" data-inline="true" class="btn btn-primary" value="Submit" />
   
            <input type="reset" align="right" data-inline="true" class="btn btn-primary" value="Reset"/>
    </center>
        </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxDeUmWOk" once="footers" id="footer7-35">

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