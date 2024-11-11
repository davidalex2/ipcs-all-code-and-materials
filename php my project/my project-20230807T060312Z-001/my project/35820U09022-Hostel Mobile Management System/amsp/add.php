<?php
session_start();
$uname=$_SESSION['username'];
$name="";
$pwd="";
$mess="";
$status="";
$conn = mysqli_connect("localhost", "root", "", "login");
     
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
else{
if($_POST)
{
    $name=$_POST['uname'];
    $pwd=$_POST['pwd'];
    $status=$_POST['status'];
    $year=$_POST['year'];
    $sql="INSERT into login(uname,pwd,status,year) 
    values('".$name."','".$pwd."','".$status."','".$year."')";
    $result=mysqli_query($conn,$sql);
    if($result===true)
    {
       $mess="added";

    }
    else
    {
        $mess="not added";
    }
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
  
  
  <title>Add</title>
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
  
  <section data-bs-version="5.1" class="menu menu1 cid-tDanUc8mBK" once="menu" id="menu1-2a">
    

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

<section data-bs-version="5.1" style="height: 100vh;"class="form5 cid-tD7ziM5ucR" id="form5-w">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2"><strong>Add a Student</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form  method="POST" class="mbr-form form-with-styler" data-form-title="Form Name"><input type="hidden" name="email" data-form-email="true" value="cJTwJKYYmsUtEmMWyGKD3wGRgBEOw7XFlfMrv+a/WSzbez5i+MuApKIEi+20hPhLW5pgvfDGAD5LxLLyHL9xi9KaQFos2nSCHdhbckz7FYD4Ht7AczWwpy0sl1zGEbfY">
                    
                    <div class="dragArea row">
                        <div class="col-md col-sm-12 form-group mb-3" data-for="name">
                        <table class="table">
                       <label style="background-color: aquamarine;"> <?php echo " ".$name?>


    
   <?php echo " ".$pwd?>
   <?php echo " ".$status?>
<?php echo " ".$mess?>
</label>
            <tr><td><label for="uname">Enter user roll no:</label></td>
                <td><input type="text" class="form-control" name="uname"/></td>
            </tr>
            <tr>
                <td>
<label for="pwd">Enter the password</label>
</td>
<td>
    <input type="text" class="form-control" name="pwd"/>
</td>
</tr>
<tr>
    <td><label for="status">Select the position:</label></td>
<td>
    <select name="status" class="form-control">
    <option value="admin">Admin
</option>
        <option value="student">Student
</option>
               

</select>
</td>
<tr><td>
    <label for="year">Select the student year(only for students)</label></td>
    <td>
    <select name="year" class="form-control">
        <option value="">None</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
</td></tr>
            </tr>
            <center>
            <tr ><td colspan="2" align="center" ><input type="submit"  class="btn btn-primary" value="Add a person"></td></tr>
</center>
</table>
  </div>
                        
                        
                        
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxGiVrvjL" once="footers" id="footer7-3h">

    

    

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
<?php mysqli_close($conn); ?>