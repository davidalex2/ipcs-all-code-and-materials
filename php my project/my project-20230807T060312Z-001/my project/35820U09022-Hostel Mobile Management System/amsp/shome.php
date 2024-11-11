<?php
  session_start();
  
      
  $mess="";
  $uname=$_SESSION['username'];
 
  if(!$_SESSION['login']){
      header("Location: index.php",true);
      exit();
  }$conn = mysqli_connect("localhost", "root", "", "login"); 
      if(!$conn) {
          echo "Connection faild!!";
      }
$sql123="select post1 from post1";
$result123=mysqli_query($conn,$sql123);
$row=mysqli_fetch_assoc($result123);
$sql11="select reason,explain1,request1 from info where rollno='$uname'";
$result321=mysqli_query($conn,$sql11);
$r=mysqli_fetch_assoc($result321);




if(count($_POST)>0){
   
date_default_timezone_set('Asia/Kolkata');


  $date1=date("Y-m-d h:i:s",time());
    $sql2="update info set status='submitted',date1='$date1' where rollno='$uname' ";
    $re=mysqli_query($conn,$sql2);
    if ($re === TRUE) {
       header("Location:shome.php");
        $mess="Submitted successfully";
        exit();
      } else {
        $mess="Error";
      }

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
  
  
  <title>SHome</title>
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
  
  <section data-bs-version="5.1" class="menu menu3 cid-tDap51qWWn" once="menu" id="menu3-2f">
    
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

<section data-bs-version="5.1" class="header3 cid-tDapcwhsxD mbr-fullscreen" id="header3-2g">

    

    
    <div class="mbr-overlay" style="opacity: 0.2; background-color: rgb(255, 255, 255);"></div>

    <div class="align-center container">
        <div class="row justify-content-end">
            <div class="col-12 col-lg-6">
                <h1 class="mbr-section-title mbr-fonts-style mb-3 display-1">Hostel Mobile Management System(PDH)</h1>
                <h4 class="card-title" >Message</h4>
    <p class="card-text"><?php $sql123="select uname,date1,post1 from post1";
 $result123=mysqli_query($conn,$sql123);
 $row=mysqli_fetch_assoc($result123);
 ?>
 <label style="background-color:greenyellow">  <?php echo $row['date1']," ".$row['uname'] ?><br>
 <?php echo $row['post1'] ?></label></p>
                
                <p class="mbr-text mbr-fonts-style display-7"></p>
                
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="content4 cid-tDb0C23BZx" id="content4-2u">
    

    
    
    <div class="container">
        <div class="row justify-content-center">
            <div class="title col-md-12 col-lg-10">
                <h3 class="mbr-section-title mbr-fonts-style align-center mb-4 display-2"><strong>Information</strong></h3>
                <h4 class="mbr-section-subtitle align-center mbr-fonts-style mb-4 display-5">
      
  <label style="background-color: violet;"><br></label>
  <div class="card border-info">
 
    <div class="card-body">
    
    <div align="left" text-align="left">
      <h4 class="card-title">Your Request</h4>
      <p class="card-text">Reason::<?php echo $r['reason']; ?><br>Explaination::<?php echo $r['explain1']; ?></p>
      <p class="card-text" style="color:crimson"> You are <?php echo $r['request1']; ?></p>
    </div>
    </div>
  </div>
 
</div>
<div align="right" class="table-responsive">
       <table align="center" style="background-color: azure;">

            <?php

if($uname) {
    $sql="select rollno,name,name,mail,year,phone,color,address ,mname,model,price,imei,status,date1 from info where rollno='$uname'";
    $result=mysqli_query($conn, $sql);
    if (mysqli_num_rows($result) > 0) {

        while($data = mysqli_fetch_assoc($result)) { ?>
                    <tr><th>Roll no</th><td><?php echo $data['rollno'] ?></td></tr>
                    <tr><th>Name</th><td><?php echo $data['name'] ?></td></tr>
                    <tr><th>Mail_Id</th><td><?php echo $data['mail']?></td></tr>
                   <tr><th>Year</th><td><?php echo $data['year'] ?></td></tr>
                  <tr><th>Phone Number</th><td><?php echo $data['phone']?></td></tr>
                    <tr><th>Address</th><td><?php echo $data['address']?></td></tr>
                    <tr><th>Mobile Name</th><td><?php echo $data['mname']?></td></tr>
                    <tr><th>Color</th><td><?php echo $data['color'] ?></td></tr>
                    <tr><th>Model</th><td><?php echo $data['model']?></td></tr>
                    <tr><th>Price</th><td><?php echo $data['price']?></td></tr>
                    <tr><th>IMEI</th><td><?php echo $data['imei']?></td></tr>  
                    <tr><th>Mobile status</th><td><?php echo $data['status']?></td></tr>
                    <tr><th>Date of submission</th><td><?php echo $data['date1']?></td></tr>
            <?php
        }
    }
}
mysqli_close($conn);
            ?>                
       </table>   
       <form method="post" action="">  
        <center> 
            <label><?php $mess ?></label>
        <input type="submit" name="status" class="btn btn-primary" value="Submit" />
            </h4>              
            </div>
        </div>
    </div>
</section>   
<section data-bs-version="5.1" class="footer7 cid-tDxDnIyJ4v" once="footers" id="footer7-36">
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