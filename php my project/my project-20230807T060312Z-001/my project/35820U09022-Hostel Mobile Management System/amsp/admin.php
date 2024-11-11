<?php
session_start();
 if(!$_SESSION['login']){
     header("Location: index.php",true);
     exit();
 }
 $result="";
 $mess="";
 $_SESSION['username'];
 $uname=$_SESSION['username'];
 

 $conn = mysqli_connect("localhost", "root", "", "login");   
     if(!$conn) {
         echo "Connection faild!!";
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
  
  
  <title>Home</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons2/mobirise2.css">
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
  
  <section data-bs-version="5.1" class="menu menu1 cid-tD7N05kG5f" once="menu" id="menu1-1p">
    

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

<section data-bs-version="5.1" class="header13 cid-tD7GCAtbBK mbr-fullscreen" id="header13-10">

    

    
    <div class="mbr-overlay" style="opacity: 0.2; background-color: rgb(255, 255, 255);"></div>
    <div class="align-center container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-10">
                <h1 class="mbr-section-title mbr-fonts-style mb-3 display-1"><strong>Hostel Mobile Management System(PDH)</strong></h1>   
                <p class="mbr-text mbr-fonts-style mb-3 display-7">
                    This is platform in which you can keep the record of your mobile</p>
                    <p>
                        <?php $sql123="select uname,date1,post1 from post1";
 $result123=mysqli_query($conn,$sql123);
 $row=mysqli_fetch_assoc($result123);
 ?>
 <label style="background-color:greenyellow">Message<br>  <?php echo $row['date1']," ".$row['uname'] ?><br>
 <?php echo $row['post1'] ?></label>
</div></p>
                
                
        </div>
    </div>
</section>



<section data-bs-version="5.1" class="content1 cid-s48udlf8KU" id="content1-8">
    
    <div class="container">
        <div class="row justify-content-center">
            <div class="title col-12 col-md-9">
                <h3 class="mbr-section-title mbr-fonts-style align-center mb-4 display-2"><strong>About The Hostel</strong></h3>
                <h4 class="mbr-section-subtitle align-center mbr-fonts-style mb-4 display-7">The PDH is the short form of Papa Dhayon Hostel. Papa Dhayon is name of a person who sold his own belongings and gave money to build the hostel</h4>
                
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="image3 cid-s48upRUlSD" id="image3-9">
    

    

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-lg-9">
                <div class="image-wrapper">
                    <img src="assets/images/mbr-1916x1277.jpg" alt="Mobirise Website Builder">
                    <p class="mbr-description mbr-fonts-style mt-2 align-center display-4">
                        </p>
                </div>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="content1 cid-s48vaXqeL6" id="content1-b">
    
    <div class="container">
        <div class="row justify-content-center">
            <div class="title col-12 col-md-9">
                <h3 class="mbr-section-title mbr-fonts-style align-center mb-4 display-2"><strong>Rules</strong></h3>
                <h4 class="mbr-section-subtitle align-center mbr-fonts-style mb-4 display-7">1. Mobile should be submitted everyday.<br>2. Mobile will be given to the students after 4pm. <br>3. If you in need of mobile ,get proper permission from concern person</h4>
                
            </div>
        </div>
    </div>
</section>




<section data-bs-version="5.1" class="share3 cid-tD7JwHbE6g" id="share3-17">
    
     
    
    
    

    <div class="container">
        <div class="media-container-row">
            <div class="col-12">
                <h3 class="mbr-section-title align-center mb-3 mbr-fonts-style display-2">
                    <strong>Follow Us!</strong>
                </h3>
                <div class="social-list align-center">
                   
                    <a class="iconfont-wrapper bg-facebook m-2 " target="_blank" href="https://m.facebook.com/david.s.alex.94/">
                            <span class="socicon-facebook socicon"></span>
                        </a>
                        <a class="iconfont-wrapper bg-twitter m-2" href="https://twitter.com/home" target="_blank">
                            <span class="socicon-twitter socicon"></span>
                        </a>
                        <a class="iconfont-wrapper bg-instagram m-2" href="https://www.instagram.com/___davidalex___/?hl=en" target="_blank">
                            <span class="socicon-instagram socicon"></span>
                        </a>
                        
                        
                        
                        
                        
                        
                        
                        
                </div>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxCQfkFzr" once="footers" id="footer7-32">

    

    

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