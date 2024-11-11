<?php
session_start();
$_SESSION['username'];
$uname=$_SESSION['username'];
$conn = mysqli_connect("localhost", "root", "", "login");    
if(!$conn)
{
echo "Connection error";
}
else
{
  if($_POST)
  {
    $date1=date("Y/m/d");
    // $date1=date("Y/m/d h:i:sa");
    $post1=$_POST['post1'];
    $sql="UPDATE post1 set post1='$post1',date1='$date1' where uname='admin'";
    $result=mysqli_query($conn,$sql);
    if($result== true)
    {
      echo "updated";
      header("Location: admin.php");
      exit();
    }
    else
    {
        echo "error";
    }
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
  
  
  <title>Post</title>
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
  
  <section data-bs-version="5.1" class="menu menu1 cid-tDanJNxD9e" once="menu" id="menu1-29">
    

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

<section data-bs-version="5.1" style="height: 100vh;" class="form5 cid-tD7Kds32Gx" id="form5-19">
    <form method="post">
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2"><strong>Post a message</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form action="" method="POST" class="mbr-form form-with-styler" data-form-title="Form Name"><input type="hidden" name="email" data-form-email="true" value="lJ96feNlKDdT33KWKnTRcuSCqRVnNsyPYt0NMEHuOpLlGmwgN45zyX/qwqA0EvTT/YJc9+MIIv+GtyptgzCEoZnSv0c6auGLWJMAyIT+uJw5TJSUoD29vvZ71LbTw+Z9">
                    <div class="row">
                        <div hidden="hidden" data-form-alert="" class="alert alert-success col-12">Thanks for filling out the form!</div>
                        <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                            Oops...! some problem!
                        </div>
                    </div>
                    <div class="dragArea row">
  

        <div class="form-group">
            <label  for="exampleFormControlTextarea1">
                Enter the message with date:
            </label>
            <textarea name="post1" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
          

     
 <button type="submit" class="btn btn-primary display-4" value="Post">Send message</button>
                        </div>
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxGg1T8vO" once="footers" id="footer7-3g">

    

    

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