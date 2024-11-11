<?php
session_start();
if(!$_SESSION['login']){
    header("Location: index.php",true);
    exit();
}
$result="";
$uname=$_SESSION['username'];
$conn = mysqli_connect("localhost", "root", "", "login");   
    if(!$conn) {
        echo "Connection faild!!";
    } 
    $sql="SELECT rollno,name,year,reason,explain1 from info where request1='requested'";
    $result=mysqli_query($conn, $sql);

if(isset($_POST['submit'])) {
    if(!empty($_POST['att'])) {
        foreach($_POST['att'] as $id) {
            $sql3 = "UPDATE info SET request1='approved' where rollno='".$id."'";
            echo "query created";
            if ($conn->query($sql3) === true) {
                echo "Attendance marked successfully";
                header("Location:admin.php");
            } else {
                echo "Error: " . $sql . "<br>" . $conn->error;
            }
        }
    }
    else{
        echo "no details to show";
    
    }
}
?>
<!DOCTYPE html>
<html  >
<head>
    <style>
      @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,700;1,300&display=swap');
      *{
        font-family: 'Poppins', sans-serif;
      }  
      </style> 
  <!-- Site made with Mobirise Website Builder v5.8.9, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.8.9, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>request</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap"></noscript>
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">

  
  
  
</head>
<body>
  
  <section data-bs-version="5.1" class="menu menu1 cid-tDxFOGNjPi" once="menu" id="menu1-3b">
    

    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container-fluid">
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
                <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="admin.php">Home</a></li>
                <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="post.php">Post</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="add.php">Add</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="receive.php">Requested</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="approved.php">Approved</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="attendance.php">Attendance</a>
                    </li><li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="all.php">All</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="sub.php">Submitted</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="nsub.php">Not-submitted</a></li>

                     <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="delete.php">Delete</a></li>
                        <li class="nav-item"><a class="nav-link link text-black display-4" href="index.php">Logout</a></li></ul>
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

<section data-bs-version="5.1"  style="height: 100vh;" class="form8 cid-tD7LROJPxJ" id="form8-1l">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Requested</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form  method="POST" class="mbr-form form-with-styler mx-auto" data-form-title="Form Name"><input type="hidden" name="email" data-form-email="true" value="wOqTGIx107UcfXDiC1BAVPvwmtrRyYsZ6ALlR2mj1oALn7gPKzXtPlz4KiYCiMKDotWaoGDSeMnqgBV4PXcv8GHGx3rRihxJB69mUw3wVUbZvng2WB06liDbNzCmO73C">
                   <table class="table table-bordered table-hover">
                   <?php

echo"    <tr>
  <th>Roll no</th>
  <th>Name</th>
  
  <th>Year</th>

  <th>Reason</th>
  <th>Explanation</th>
  <th>Approve</th>
</tr>";

if (!empty($result) && $result==$result) {
while($data = mysqli_fetch_assoc($result)) {

    echo"<tr><td>".$data['rollno']."</td>";
    echo " <td>".$data['name']."</td>";
    echo " <td>".$data['year']."</td>";
    echo " <td>".$data['reason']."</td>";
    echo " <td>".$data['explain1']."</td>";
    
    echo "<td><input type='checkbox' name='att[]' value='".$data['rollno']."' ></td></tr>";    
}   
}
mysqli_close($conn);
?>
<tr><td colspan="6" align="center">
<input type="submit" align="center" name="submit" class="btn btn-primary display-4">
</td></tr>             
</table><center>

          </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxG7LS7C8" once="footers" id="footer7-3e">

    

    

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